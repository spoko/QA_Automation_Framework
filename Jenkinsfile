pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'JDK 11'
    }

    stages {
        stage('CheckOut from Github') {
            steps {
               git 'https://github.com/spoko/QA_Automation_Framework.git'
        }
    }
        stage('Execute Automated Tests') {
            steps {
                echo 'Testing...'
                sh 'mvn clean test'
            }
        }

        stage('Echoing') {
            steps {
                echo 'Testing...'
            }
        }

        stage('Automation working') {
                    steps {
                        echo 'Automation is awesome!'
                    }
                }
    }

    post {
        always {
            step([$class: 'Publisher', reportFilenamePattern: 'target/surefire-reports/testng-results.xml'])
          }
       }
}