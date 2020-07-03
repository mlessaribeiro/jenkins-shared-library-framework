// , Map config=[:], Closure body
def call(String repository, String dir) {
    node('maven') {
        stage('Scm') {
            sh "rm -r " + dir
            sh "git clone " + repository
        }
        stage('Compile') {
            sh """
                cd $dir
                mvn -Dmaven.test.skip=true clean install
            """            
        }
        stage('Test') {
            sh """
                cd $dir
                mvn test
            """
        }
        stage('Build') {
            sh """
                cd $dir
                mvn -Dmaven.test.skip=true package
            """
        }        
        stage('Deploy') {
            echo 'Fazendo deploy na AWS'
        }
        // body()
    }    
}