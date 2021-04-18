def call(Straing name, script){
  readProperties "${name}", script
  if(script.env.techStack == "node")
  {
    nodeBuild name: "xxx"
  }
 // script.env.path = 
}
