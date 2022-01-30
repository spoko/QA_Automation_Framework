pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'Java8'
    }
     parameters {
        //string(name: 'APP_VERSION', defaultValue: '1.0.0', description: 'select application version for deployment')
        choice(name: 'APP_VERSION', choices: ['1.0.0', '1.1.0', '2.0.1'], description: 'select application version for deployment')
     }

    stages {
        stage('Deploy Application') {
            steps {
               echo 'Deploying.... ${APP_VERSION}'
        }
    }
         stage('CheckOut from Github') {
            steps {
               git 'https://github.com/Dermenji/SeleniumCourse.git'
        }
    }
        stage('Execute Automated Tests') {
            steps {
                echo 'Testing..'
                sh 'mvn clean test'
            }
        }
    }
    post {
        always {
            step([$class: 'Publisher', reportFilenamePattern: 'target/surefire-reports/testng-results.xml'])
          }
       }
}