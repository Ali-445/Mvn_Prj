pipeline {
    agent {
        docker {
            // Image contenant Maven et Git
            image 'my-maven-git:latest'
            // Pour réutiliser le cache Maven local entre builds
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Setup') {
            steps {
                sh 'mkdir -p /home/jenkins/.m2/repository'
            }
        }
        stage('Checkout') {
            steps {
                // Checkout the Git repository
                sh 'git clone https://github.com/simoks/java-maven.git'
            }
        }
        stage('Build') {
            steps {
                // Navigate to the directory containing the Maven project
                dir('java-maven/maven') {
                    // Run Maven commands
                    sh 'mvn clean test package'
                }
            }
        }
        stage('Verify Artifact') {
            steps {
                dir('java-maven/maven') {
                    sh 'ls -l target'
                }
            }
        }
        stage('Run') {
            steps {
                dir('java-maven/maven') {
                    sh 'java -jar target/maven-0.0.1-SNAPSHOT.jar'
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
