def call(script) {
      
      echo "Hello welcome to dockerBuild shared library"
   
       node {
             
             stage("Checkout Code") {
                   git branch: 'master',
                       url: 'https://github.com/lgoyal8497/KubeApp.git'
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
                  sh "docker login -u ${env.user} -p ${env.pswrd}"
                  sh 'docker push admcoeacr.azurecr.io/kubeapp:latest'
              }
             }              
    }
  }
