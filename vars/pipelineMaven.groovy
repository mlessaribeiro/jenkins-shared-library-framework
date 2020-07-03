// , Map config=[:], Closure body
def call(String repository) {
    node {
        stage('Scm') {
            steps {
                gitCheckout repository            
            }
        }
        stage('Compile') {
            steps {
                mavenCompile ""
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