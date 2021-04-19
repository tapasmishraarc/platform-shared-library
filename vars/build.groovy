def call(String name, script){
  readProperties "${name}", script
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
