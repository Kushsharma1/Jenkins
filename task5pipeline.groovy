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
                    mail to: "kushsofficial@gmail.com",
                    subject: "Unit and Integration Tests Passed",
                    body: "Unit and integration tests passed successfully."
                    // Sending notification email on success with logs as attachments after the testing is complete
                }
                failure {
                    mail to: "kushsofficial@gmail.com",
                    subject: "Unit and Integration Tests Failed",
                    body: "Unit and integration tests failed. Please check the logs for details."
                    // Sending notification email on failure with logs as attachment if the testing stage fails
                }
            }
        }
        stage('Code Analysis') {
            steps {
                echo "Performing code analysis using SonarQube"
            }
        }
         stage('Code Improvement') {
            steps {
                echo "Adding a new stage for testing"
            }
        }
        stage('Security Scan') {
            steps {
                echo "Performing security scan using OWASP Dependency-Check"
            }
            post {
                success {
                    mail to: "kushsofficial@gmail.com",
                    subject: "Security Scan Passed successfully",
                    body: "Security scan passed successfully."
                    // Sending notification email on success with logs as an attachment after security scans passed successfully
                }
                failure {
                    mail to: "kushsofficial@gmail.com",
                    subject: "Security Scan failed",
                    body: "Security scan failed."
                    // Sending notification email on failure with logs as attachment if the security scans fail.
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
        stage('Complete') {
            steps {
                echo "Production Complete."
            }
        }
    }
}
