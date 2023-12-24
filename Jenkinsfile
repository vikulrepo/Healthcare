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
           sh 'docker build -t bharath0812/healthcare:1.0 .
         }
       }
    }
}
