// , Map config=[:], Closure body
def call(String repository) {
    node('maven') {
        stage('Scm') {
            sh "rm -r calc"
            sh "git clone " + repository
        }
        stage('Compile') {
            sh """
                cd calc
                mvn -Dmaven.test.skip=true clean install
            """            
        }
        stage('Test') {
            sh "mvn -Dmaven.test.skip=true clean install "
        }
        stage('Build') {
            sh "mvn -Dmaven.test.skip=true package "
        }        
        stage('Deploy') {
            echo 'Fazendo deploy na AWS'
        }
        // body()
    }    
}