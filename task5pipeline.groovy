pipeline {
    agent any

    options {
        quietPeriod(2) // Setting up the delay of 2 seconds
    }
    
    stages {
        stage('Build') {
            steps {
                echo "Building the code using Maven"
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo "Running unit tests using Selenium"
                echo "Running integration tests using Selenium"
                            }
            post {
                success {
                    emailext subject: "Unit and Integration Tests Passed",
                             body: "Unit and integration tests passed successfully.",
                             to: "kushsofficial@gmail.com",
                             attachmentsPattern: "**/*.log"
                    // Sending notification email on success with logs as attachment after the testing is complete
                }
                failure {
                    emailext subject: "Unit and Integration Tests Failed",
                             body: "Unit and integration tests failed. Please check the logs for details.",
                             to: "your_email@example.com",
                             attachmentsPattern: "**/*.log"
                    // Sending notification email on failure with logs as attachment if the testing stage fails
                }
            }
        }
        stage('Code Analysis') {
            steps {
                echo "Performing code analysis using SonarQube"
            }
        }
        stage('Security Scan') {
            steps {
                echo "Performing security scan using OWASP Dependency-Check"
            }
            post {
                success {
                    emailext subject: "Security Scan Passed successfully",
                             body: "Security scan passed successfully.",
                             to: "your_email@example.com",
                             attachmentsPattern: "**/*.log"
                    // Sending notification email on success with logs as attachment after security scans passed successfully
                }
                failure {
                    emailext subject: "Security Scan Failed",
                             body: "Security scan failed. Please check the logs for details.",
                             to: "your_email@example.com",
                             attachmentsPattern: "**/*.log"
                    // Sending notification email on failure with logs as attachment if the security scans fails.
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo "Deploying the application to the staging server in AWS with EC2 instance"
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo "Running integration tests on the staging environment"
            }
        }
        stage('Deploy to Production') {
            steps {
                echo "Deploying the application to the production server AWS EC2 instance"
            }
        }
    }
}
