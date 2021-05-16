pipeline {
    agent any 
    
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Compile and Clean') { 
            steps {
                bat "mvn clean compile"
            }
        }        
        stage('Test') { 
            steps {
                bat "mvn test"
            }     
                
        }
        stage('Code Analysis'){
        	steps{
        		bat "mvn sonar:sonar"
        		}
        	}
        stage('Deploy') { 
            steps {
                bat "mvn package"
            }
        }      
        stage('Archiving') { 
            steps {
                 archiveArtifacts '**/target/*.war'
                 
            }
        }
       stage('Deploy on Tomcat'){
       		steps{
        echo "mvn spring-boot:run" | at now + 1 minutes       		}
       }
    
    }
}