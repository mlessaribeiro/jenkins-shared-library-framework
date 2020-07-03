def call(String repositorio) {
    sh "git clone " + repositorio
}
