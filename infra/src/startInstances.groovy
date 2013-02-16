i#!/usr/bin/env /opt/java/lib/groovy/bin/groovy

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.ec2.AmazonEC2
import com.amazonaws.services.ec2.AmazonEC2Client
import com.amazonaws.services.ec2.model.BlockDeviceMapping
import com.amazonaws.services.ec2.model.EbsBlockDevice
import com.amazonaws.services.ec2.model.RunInstancesRequest
import com.amazonaws.services.ec2.model.RunInstancesResult
import com.amazonaws.services.ec2.model.CreateTagsRequest
import com.amazonaws.services.ec2.model.Tag
import org.apache.commons.codec.binary.Base64

/**
 * User: charles
 * Date: 03/11/12
 * Time: 10:24
 * @author charles.blonde@gmail.com
 * @author igosuki@gmail.com
 */

@Grapes([
@Grab(group = 'commons-codec', module = 'commons-codec', version = '1.7', force = true),
@Grab(group = 'com.amazonaws', module = 'aws-java-sdk', version = '1.3.22'),
@Grab(group = 'com.google.guava', module = 'guava', version = '13.0.1')
]
) def instances = [

        [type: "t1.micro", size: 8]: [

        ],
        [type: "c1.medium", size: 8]: [
                [
                        Name: "behemot-ci",
                        Dns: "behemot-ci",
                        Classes: "jenkins;rundeck;nexus;gradle;grails",
                        Puppet_rundeck_projects: "TEST;PROD;MONGODB"
                ]

        ],
        [type: "m1.small", size: 8]: [
                [
                        Name: "behemoth-tomcat-dev-1",
                        Dns: "behemoth-tomcat-dev-1",
                        Classes: "tomcat7;rundeck::node",
                        Puppet_rundeck_user: "root",
                        Puppet_rundeck_project: "TEST",
                        Puppet_rundeck_tags: "ec2;tomcat"
                ],
                [
                        Name: "behemoth-tomcat-prod-1",
                        Dns: "behemoth-tomcat-prod-1",
                        Classes: "tomcat7;rundeck::node",
                        Puppet_rundeck_user: "root",
                        Puppet_rundeck_project: "PROD",
                        Puppet_rundeck_tags: "ec2;tomcat"
                ]
        ],
        [type: "m1.large", size: 50]: [
                [
                        Name: "behemoth-db",
                        Dns: "behemoth-db",
                        Classes: "mongodb;rundeck::node;elasticsearch",
                        Puppet_rundeck_user: "root",
                        Puppet_rundeck_project: "MONGODB",
                        Puppet_rundeck_tags: "ec2;mongodb"
                ]
        ]

]

def endPoint = "ec2.eu-west-1.amazonaws.com"
def accessKey = "${behemoth.accessKey}"
def secretKey = "${behemoth.secretKey}"

AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey)

AmazonEC2 ec2 = new AmazonEC2Client(credentials)
ec2.setEndpoint(endPoint)

String cloudInit = new File("cloud-init.yaml").getText()

instances.each {
    if (it.value.size() > 0) {
        RunInstancesRequest request = new RunInstancesRequest()
        request.withImageId("${behemoth.imageId}")
                .withInstanceType(it.key.type)
                .withSecurityGroupIds("accept-all")
                .withKeyName("behemoth")
                .withMinCount(it.value.size())
                .withMaxCount(it.value.size())
                .withUserData(Base64.encodeBase64String(cloudInit.bytes))
        BlockDeviceMapping deviceMapping = new BlockDeviceMapping()
                .withEbs(new EbsBlockDevice().withVolumeSize(it.key.size).withDeleteOnTermination(true))
                .withDeviceName("/dev/sda1")
        request.withBlockDeviceMappings(deviceMapping)

        RunInstancesResult result = ec2.runInstances(request)
        Thread.sleep(2000)
        //Tags
        result.getReservation().getInstances().eachWithIndex { instance, idx ->
            CreateTagsRequest tagsRequest = new CreateTagsRequest()
                    .withResources(instance.instanceId)
            def awsTags = []
            it.value[idx].each {
                awsTags << new Tag(it.key, it.value)
            }
            tagsRequest.setTags(awsTags)

            ec2.createTags(tagsRequest)
        }
    }
}
