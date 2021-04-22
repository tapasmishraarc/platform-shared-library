def call(String url, script){
  readProperties "${url}", script
  echo "${script.env.techStack}"
  if(script.env.techStack == "node")
  {
    nodeBuild name: "xxx", script
  }
  if(script.env.techStack == "java")
  {
    echo "Maven Build Starts ........."
    mvnBuild script
  }
  if(script.env.techStack == "docker")
  {
    echo "Docker Build Starts ........."
    dockerBuild script
  }
 // script.env.path = 
}
