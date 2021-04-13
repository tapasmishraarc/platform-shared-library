def call(Map config=[:]) {
    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    echo "Hello ${config.name}"
    
    nodejs {
        git url: "https://github.com/tapasmishraarc/sample-nodejs"
        
        stage("Install") {
            sh "npm install"
        }
    }
}
