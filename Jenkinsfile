pipeline {

    agent any

    tools {
        maven 'Maven-3.9'
        jdk 'JDK17'
    }

    environment {
        MAVEN_OPTS = "-Xmx1024m"
    }

    stages {

        stage('Checkout from GitHub') {
            steps {
                echo "Cloning repository from GitHub"
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[
                        url: 'https://github.com/sac090909/seleniumjavareview1.git'
                    ]]
                ])
            }
        }

        stage('Execute TestNG Suite') {
            steps {
                echo "Running TestNG tests"
                sh 'mvn clean test'
            }
        }

        stage('Publish TestNG Results') {
            steps {
                echo "Publishing TestNG XML reports"
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo "Archiving reports and screenshots"
                archiveArtifacts artifacts: 'target/surefire-reports/**', fingerprint: true
                archiveArtifacts artifacts: 'screenshots/**', fingerprint: true
            }
        }
    }

    post {
        always {
            echo "Cleaning workspace"
            cleanWs()
        }
    }
}
