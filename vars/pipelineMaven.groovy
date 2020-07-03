// , Map config=[:], Closure body
def call(String repository) {
    node {
        stage('Scm') {
            sh "git clone " + repository
        }
        stage('Compile') {
            steps {
                sh "mvn -Dmaven.test.skip=true clean install "
            }
        }
        stage('Test') {
            steps {
                mavenTests ""
            }
        }
        stage('Build') {
            steps {
                mavenBuild ""
            }
        }        
        stage('Deploy') {
            steps {
                deploy ""
            }
        }
        // body()
    }    
}