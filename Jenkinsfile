#!groovy​
pipeline {
    agent any 
    stages {
        stage('Checkout') { steps { checkout scm } }

        stage("Test") {
            steps {
                echo "Test"
            }
        }

        stage("Deploy") {
            when { branch 'master' }
            steps {
                echo "Deploy"
            }
        }

    }


    post {
        success {
            echo "Build succeeded."
        }

        failure {
            echo "Build failed."
        }
    }
}
