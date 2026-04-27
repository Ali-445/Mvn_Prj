pipeline {
    agent {
        docker {
            image 'maven:3.9.15-eclipse-temurin-11'
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
            echo '=============== Rapport des tests ==============='
            junit 'target/surefire-reports/**/*.xml'
        }

        success {
            echo '✅ Pipeline exécuté avec succès!'
            // Ajouter ici des notifications de succès (email, Slack, etc.)
        }

        failure {
            echo '❌ Pipeline échoué!'
            // Ajouter ici des notifications d'erreur (email, Slack, etc.)
        }

        unstable {
            echo '⚠️ Pipeline instable (tests échoués)'
        }

        always {
            cleanWs()
        }
    }
}
