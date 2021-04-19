def call(script) {
      
      echo "Hello welcome to dockerBuild shared library"
   
       node {
             
             stage("Checkout Code") {
                   git branch: 'master',
                       url: script.env.GIT_SOURCE_URL
           }
         
             stage('Docker Build') {
                  sh 'docker build -t shanem/kubeapp:latest .'
    }
    
             stage('Docker Push') 
             {
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push shanem/spring-petclinic:latest'
              }
             }              
    }
  }
