# Indus

## Contenu

Ce repertoire contient les éléments suivants :

* bootPuppetMaster.groovy : Script à lancer pour démarrer le master Puppet. Nécessite 4-5 avant qu'il ne soit opérationnel.
* startInstances.groovy : Script à lancer, une fois que le master Puppet est UP, pour démarrer les autres serveurs. Les instances à lancer se configure dans le tableau "instances" (voir les configurations en commentaire). Nécéssite le fichier coud-init.yaml dans le même répertoire.
* cloud-init.yaml : Script d'initialisation qui a la responsabilité d'installer l'agent Puppet, de la configurer et de le lancer.
* behemot.credentials : Contient les credentials de l'utilisateur "behemot". Cet utilisateur a tout les droits sur le compte AWS Webia-france (non prod) et est utilisé dans tous les scripts.
* behemot.pem : Clef privé de l'utilisateur "behemot". Nécéssaire pour se connecter en SSH sur les différents serveurs

## Statut

Voici la liste des différents serveurs et ce qu'ils contiennent à l'heure actuelle :

* puppet-behemot.aws.xebiatechevent.info : Master Puppet, responsable de l'initialisation des autres serveurs
* behemot-ci.aws.xebiatechevent.info : Usine de dev. Contient :
    * Jenkins : http://behemot-ci.aws.xebiatechevent.info:8080
         * Pas d'authentification
         * Deux jobs pour deployer en dev/prod. Le deploiement en dev se fait à chaque commit. Prod manuel
    * Nexus : http://behemot-ci.aws.xebiatechevent.info:8081/nexus
         * Configuré mais non utilisé au final
         * Comptes par defaut (admin/admin123)
    * Rundeck : http://behemot-ci.aws.xebiatechevent.info:4440
         * Configuration Ok des comptes
         * Compte par defaut (admin/admin)
         * Aucun jobs. Inutile ?
    * Gradle : 
         * installé dans /opt/gradle
         * Utile ?
* behemoth-tomcat-dev-1.aws.xebiatechevent.info :
    * Possibilité de lancé plusieurs instances de ce type (dev-2...dev-X)
    * Installation par défaut (Tomcat7/OpenJDK7). Deploiement à partir du manager
* behemoth-tomcat-prod-1.aws.xebiatechevent.info :
    * Idem instance de Dev
* behemoth-db.aws.xebiatechevent.info:
    * MongoDB installé et configuré
    * ElasticSearch installé et configuré

## TODO

Liste des choses à faire



