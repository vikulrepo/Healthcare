pipeline{
    agent any
     tools{
         maven 'maven'
     }
     
    stages{
     stage('checkout')   {
         steps{
             git branch: 'dev', url: 'https://github.com/bharah08/Healthcare.git'
         }
     }
       stage('unit-testing'){
           steps{
               sh 'mvn test'
           }
       } 
        
       stage('build'){
           steps{
               sh 'mvn clean install'
           }
       } 
       stage('docker-mage build'){
         steps{
           sh 'docker build -t bharath0812/healthcare:1.0 .'
         }
       }
         stage('deploy'){
         steps{
           sshagent(['docker-test-server']) {
    sh 'ssh -o StrictHostKeyChecking=no ubuntu@3.7.253.199 sudo docker run -d --name test1 -p 8082:8082  bharath0812/healthcare 
}
         }
       }
        
    }
}
