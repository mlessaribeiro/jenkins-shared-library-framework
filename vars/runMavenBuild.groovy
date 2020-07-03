def call() {
    sh "mvn -Dmaven.test.skip=true package"
}