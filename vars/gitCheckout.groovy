def call(String repositorio, String dir) {
    sh "rm -r $dir"
    sh "git clone $repositorio"
}
