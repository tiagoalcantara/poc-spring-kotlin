package br.com.tiago.casadocodigo.autor

import br.com.tiago.casadocodigo.compartilhado.validacao.UniqueValue
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CadastrarAutorRequest(
    @field:NotBlank
    val nome: String,
    @field:NotBlank @field:Email @field:UniqueValue(field = "email", entity = Autor::class)
    val email: String,
    @field:NotBlank @field:Size(max = 200)
    val descricao: String
) {
    fun paraAutor(): Autor = Autor(nome, email, descricao)
}
