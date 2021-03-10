package br.com.tiago.casadocodigo.autor

data class DetalhesAutorResponse(
    val nome: String,
    val email: String,
    val descricao: String
) {
    constructor(autor: Autor) : this(autor.nome, autor.email, autor.descricao)
}