pipeline{
	agent any 
	environment{
		registry = "gmu645/surveyhw3"
		DOCKERHUB_PASS = "soulmate.com"
		 unique_Id = UUID.randomUUID().toString()
		GOOGLE_APPLICATION_CREDENTIALS    = 'gsa-key.json'
		
		
	}
	stages{
		stage("Building jar"){
			steps{
				script{
					
					checkout scm
					sh 'rm -rf *.war'
					sh 'mvn clean package'
					sh 'mvn clean install'
					sh 'echo ${BUILD_TIMESTAMP}'
					sh 'docker login  -u gmu645 --password-stdin < ~/my_password '
					def customimage=docker.build("gmu645/surveyhw3:${BUILD_ID}")
					sh 'pwd'

					
			}

		}

	}
	stage("Pushing image to DockerHub"){
		steps{
			script{
				sh 'docker push gmu645/surveyhw3:${BUILD_ID}'
			}
		}
	}
		
	stage(' Deploying to GKE as single pod'){
		steps{
			sh ' kubectl set image  deployment/swe645final student=gmu645/surveyhw3:${BUILD_ID}'
			
		}

	}
		/*
	stage(' Deploying to GKE as with Load balancer'){
		steps{
			sh 'kubectl set image deployment/studentsurvey645-lb studentsurvey645-lb=hekme5/surveyhw3:${BUILD_TIMESTAMP} -n jenkins-pipeline'
		}
	}
*/
}




}
