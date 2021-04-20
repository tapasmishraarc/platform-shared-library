def call(script) {
      
      echo "Hello welcome to dockerBuild shared library"
   
       node {

             stage("Checkout Code") {
                   git branch: 'master',
                       url: script.env.GIT_SOURCE_URL
           }
             stage('Docker Build') {
                   echo "In docker build stage"
                   sh "docker build -t  ${script.env.DOCKER_REGISTRY}/${script.env.DOCKER_REPO}:latest ."
    }
    
             stage('Docker Push') 
             {
         withCredentials([usernamePassword(credentialsId: 'ACR_cred', passwordVariable: 'pswrd', usernameVariable: 'user')]) {
                  // some block
                  echo "In docker push stage"
               sh "docker login -u ${env.user} -p ${env.pswrd} ${script.env.DOCKER_REGISTRY} "
               sh "docker push ${script.env.DOCKER_REGISTRY}/${script.env.DOCKER_REPO}:latest"  
              }
             }              
    }
  }
