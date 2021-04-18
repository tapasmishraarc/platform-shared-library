def call(String name, script){
  readProperties "${name}", script
  if(script.env.techStack == "node")
  {
    nodeBuild name: "xxx", script
  }
 // script.env.path = 
}
