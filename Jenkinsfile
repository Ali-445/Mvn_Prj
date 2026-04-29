pipeline {
    agent {
        docker {
            image 'my-maven-git:latest'
            args '-v /root/.m2:/root/.m2'
        }
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 30, unit: 'MINUTES')
        timestamps()
    }

    environment {
        MAVEN_OPTS = '-Dmaven.repo.local=/root/.m2/repository'
    }

    stages {
        stage('Checkout') {
            steps {
                echo '=============== Récupération du code source ==============='
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo '=============== Compilation du projet Maven ==============='
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo '=============== Exécution des tests unitaires ==============='
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo '=============== Empaquetage du projet ==============='
                sh 'mvn package -DskipTests'
            }
        }

        stage('Archive') {
            steps {
                echo '=============== Archivage des artefacts ==============='
                archiveArtifacts artifacts: 'target/*.jar', 
                                   allowEmptyArchive: false,
                                   fingerprint: true
            }
        }
    }
post {
        always {
            echo '=============== Rapport des tests et Nettoyage ==============='
            // On génère le rapport JUnit s'il existe
            junit testResults: 'target/surefire-reports/**/*.xml', allowEmptyResults: true
            // On nettoie l'espace de travail pour ne pas encombrer le serveur
            cleanWs()
        }

        success {
            echo '✅ Pipeline exécuté avec succès!'
        }

        failure {
            echo '❌ Pipeline échoué!'
        }

        unstable {
            echo '⚠️ Pipeline instable (certains tests ont échoué)'
        }
    }
}
