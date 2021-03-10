package br.com.tiago.casadocodigo.autor

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Autor(
    val nome: String,
    @Column(unique = true)
    val email: String,
    val descricao: String
) {
    @Id @GeneratedValue
    var id: Long? = null

    override fun toString(): String {
        return "Autor(nome='$nome', email='$email', descricao='$descricao', id=$id)"
    }
}