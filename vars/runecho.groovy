def call(String arg) {
    sh script: "mvn clean", returnStdout: true
    //echo 'Wololo'
}