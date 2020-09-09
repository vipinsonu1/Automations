pipeline {
    agent any
    tools {
        maven 'Maven 3.6.0
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${maven}/bin/mvn package"
                '''
            }
        }
        
          stage ('SCM checkout') {
            steps {
             git 'https://github.com/vipinsonu1/Automations.git'
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
