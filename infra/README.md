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
         * Un job qui se connecte au repo git et lance un "gradle grails-war" => OK
    * Nexus : http://behemot-ci.aws.xebiatechevent.info:8081/nexus
         * Non configuré/ non utilisé pour le moment
         * Comptes par defaut (admin/admin123)
    * Rundeck : http://behemot-ci.aws.xebiatechevent.info:4440
         * Configuration en cours (jobs/clefs/etc...)
         * Compte par defaut (admin/admin)
    * Gradle : 
         * installé dans /opt/gradle
         * Pas de Maven installé (à faire ?)
* behemot-tomcat-dev-1.xebiatechevent.info :
    * Possibilité de lancé plusieurs instances de ce type (dev-2...dev-X)
    * Installation par défaut, configuration en cours. Pas de war déployés auter que ceux par défaut

## TODO

Liste des choses à faire

* [URGENT] Le script startInstances.groovy est buggué à cause de la gestion des dépendances :
    * Le SDK AWS tire commons-codec 1.3
    * Le script à besoin de commons-codec 1.7 (pour la gestion des binaires en Base64 du fichier cloud-init)
    * GrabExclude ne fonctionne comme souhaité à l'heure actuelle
    * Fonctionne dans IntelliJ en forçant le chargement de toutes les lib (grab artifact, donc commons-codec 1.3 et 1.7) et en supprimant manuellement commons-codec 1.3 dans les propriétés du projet
* [HIGH] Créer un Job pour builder le WAR et le déployer dans le Nexus
* Relier toutes les briques entre elles : Jenkins => Nexus => Rundeck => Tomcat(s). Une grande partie du travail est déjà fait
* Serveurs MongoDB : fait en grande partie mais non déployé
* Serveurs ElasticSearch : connaissances proche de zéro
* Autre ?


