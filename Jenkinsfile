pipeline {
    agent { label 'ubuntu' }

    options {
        skipDefaultCheckout(true)
    }

    stages {

        stage('Checkout') {
            steps {
                deleteDir()

                sh '''
                    git clone --branch main \
                    https://github.com/kavindugeethshan/CodeAlpha_Complete-_Jenkins_Project-Task-3.git .
                '''
            }
        }

        stage('Build & Test') {
            steps {
                sh '''
                    chmod +x gradlew
                    ./gradlew clean build
                '''
            }
        }

        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'build/libs/java-gradle-devops-app-1.0.0.jar',
                                  fingerprint: true
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    pkill -f 'java-gradle-devops-app-1.0.0.jar' || true

                    nohup java -jar \
                    build/libs/java-gradle-devops-app-1.0.0.jar \
                    > app.log 2>&1 < /dev/null &

                    sleep 10

                    curl -f http://localhost:8085/api/hello
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