// , Map config=[:], Closure body
def call(String repository) {
    node {
        stage('Scm') {
            sh "rm -r job"
            sh "mkdir job"
            sh "cd job"
            sh "git clone " + repository
        }
        stage('Compile') {
            sh "mvn -Dmaven.test.skip=true clean install "
        }
        // stage('Test') {
        //     sh "mvn -Dmaven.test.skip=true clean install "
        // }
        // stage('Build') {
        //     sh "mvn -Dmaven.test.skip=true package "
        // }        
        // stage('Deploy') {
        //     echo 'Fazendo deploy na AWS'
        // }
        // body()
    }    
}