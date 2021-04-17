def call(Map config=[:]) {
    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    echo "Hello ${config.name}"
    tools { nodejs "nodejs"}
    node {
        git url: "https://github.com/tapasmishraarc/sample-nodejs"
        
        stage("Install") {
            sh "npm install"
        }
        stage("Test") {
            sh "npm test"
        }

        stage("Deploy") {
            if (config.name == "tapas") {
                sh "npm publish"
            }
        }
    }
}
