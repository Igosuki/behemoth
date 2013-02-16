import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.ec2.AmazonEC2
import com.amazonaws.services.ec2.AmazonEC2Client
import com.amazonaws.services.ec2.model.StartInstancesRequest
import com.amazonaws.services.ec2.model.StartInstancesResult
import com.google.common.collect.Lists

/**
 * User: charles
 * Date: 24/01/13
 * Time: 00:38
 * @author charles.blonde@gmail.com
 *
 * Start Behemot Puppet master
 */

@Grapes([
@Grab(group = 'com.amazonaws', module = 'aws-java-sdk', version = '1.3.22'),
@Grab(group = 'com.google.guava', module = 'guava', version = '13.0.1'),
]
)

def endPoint = "ec2.eu-west-1.amazonaws.com"
def accessKey = "${behemoth.accessKey}"
def secretKey = "${behemoth.secretKey}"

AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey)

AmazonEC2 ec2 = new AmazonEC2Client(credentials)
ec2.setEndpoint(endPoint)

StartInstancesRequest request = new StartInstancesRequest(Lists.newArrayList("${behemoth.instanceList}"))

StartInstancesResult instances = ec2.startInstances(request)

instances.startingInstances.each {
    println "Starting instance : ${it.instanceId}"
}
