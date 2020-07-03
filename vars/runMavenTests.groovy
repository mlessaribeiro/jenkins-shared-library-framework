def call(srgs) {
    sh "mvn -Dmaven.test.skip=true clean install " + args
}