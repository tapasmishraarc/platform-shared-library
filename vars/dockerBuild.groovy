def call(script) {
      
      echo "Hello welcome to dockerBuild shared library"
   
       node {
             
             stage("Checkout Code") {
                   echo script.env.GIT_SOURCE_URL
                  git url: script.env.GIT_SOURCE_URL
           }
         
             stage('Docker Build') {
                   echo "In docker build stage"
                  sh 'docker build -t admcoeacr.azurecr.io/kubeapp:latest .'
    }
    
             stage('Docker Push') 
             {
         withCredentials([usernamePassword(credentialsId: 'ACR_cred', passwordVariable: 'pswrd', usernameVariable: 'user')]) {
                  // some block
                  echo "In docker push stage"
                  sh "docker login -u ${env.user} -p ${env.pswrd} admcoeacr.azurecr.io "
                  sh 'docker push admcoeacr.azurecr.io/kubeapp:latest'
              }
             }              
    }
  }
