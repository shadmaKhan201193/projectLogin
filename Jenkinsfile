@Library('sharedlibrary') _
pipeline {
    agent any
    tools {
        gradle "7.4.2"
        jdk "JDK17"
        dockerTool "docker"
    }
    stages {
        stage("Build") {
            steps {
                script{
                    build()
                }
            }
        }
        stage("standalone-deploy") {
            when { branch 'main' }
            steps {
                script {
                    standaloneDeployment("172.21.0.65",["9195:9195"])
                }
            }
        }
    }
}