def call(script) {
  def properties_file_path = "${workspace}/" + "sample_nodejs/properties.yaml"
def property = readYaml file: properties_file_path
script.env.APP_NAME = property.APP_NAME
script.env.MS_NAME = property.MS_NAME
script.env.BRANCH = property.BRANCH
script.env.GIT_SOURCE_URL = property.GIT_SOURCE_URL
script.env.GIT_CREDENTIALS = property.GIT_CREDENTIALS
script.env.SONAR_HOST_URL = property.SONAR_HOST_URL
script.env.CODE_QUALITY = property.CODE_QUALITY
script.env.UNIT_TESTING = property.UNIT_TESTING
script.env.CODE_COVERAGE = property.CODE_COVERAGE
script.env.FUNCTIONAL_TESTING = property.FUNCTIONAL_TESTING
script.env.SECURITY_TESTING = property.SECURITY_TESTING
script.env.PERFORMANCE_TESTING = property.PERFORMANCE_TESTING
script.env.DOCKER_REGISTRY = property.DOCKER_REGISTRY
script.env.DOCKER_REPO = property.DOCKER_REPO
script.env.mailrecipient = property.mailrecipient
script.env.EXPECTED_COVERAGE = property.EXPECTED_ COVERAGE
script.env.techStack = property.techStack
script.env.FAILED_STAGE = ""  
script.env.IMAGE_TAG = (new Date()).format("yyMMddHHmm",TimeZone.getTimeZone('UTC'))
}
