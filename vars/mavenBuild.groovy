def call(String script) {
      echo "Hello Vanshika welcome to MavenBuild shared library"
   
       node {
           stage("Tools initialization") {
                   sh "mvn --version"
                   sh "java -version"
           }
           stage("Checkout Code") {
                   git branch: 'master',
                       url: script.env.GIT_SOURCE_URL
           }
	   stage("Cleaning workspace") {
                   sh "mvn clean"
           }
	   stage("Compling") {
                   sh "mvn compile"
           }
           stage("Running Testcase") {
                   sh "mvn test"
           }
           stage("Packing Application") {
                   sh "mvn package -DskipTests"
           }
       }
   }
