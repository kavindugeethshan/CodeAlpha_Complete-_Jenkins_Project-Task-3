pipeline {
    agent { label 'ubuntu' }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar',
                              fingerprint: true
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    pkill -f 'java-gradle-devops-app-1.0.0.jar' || true

                    nohup java -jar \
                    build/libs/java-gradle-devops-app-1.0.0.jar \
                    > app.log 2>&1 &
                '''
            }
        }
    }

    post {
        success {
            echo 'Java Gradle CI/CD pipeline completed successfully.'
        }

        failure {
            echo 'Java Gradle CI/CD pipeline failed.'
        }
    }
}