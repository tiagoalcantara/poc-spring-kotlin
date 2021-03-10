package br.com.tiago.casadocodigo.compartilhado.exception

data class ErroValidacaoResponse(
    val campo: String,
    val mensagem: String
)
