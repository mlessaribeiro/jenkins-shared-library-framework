def call(args) {
    sh "mvn -Dmaven.test.skip=true clean install"
}