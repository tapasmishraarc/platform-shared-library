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
    mavenBuild script
  }
 // script.env.path = 
}
