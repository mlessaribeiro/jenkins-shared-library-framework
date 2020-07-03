def call(args) {
    sh "mvn -Dmaven.test.skip=true package " + args
}