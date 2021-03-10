package br.com.tiago.casadocodigo.autor

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/autor")
class AutorController(
    private val autorRepository: AutorRepository
) {

    @PostMapping
    fun cadastrar(@RequestBody @Valid request: CadastrarAutorRequest): ResponseEntity<Any> {
        val autor = request.paraAutor()
        autorRepository.save(autor)
        return ResponseEntity.status(HttpStatus.CREATED).body(DetalhesAutorResponse(autor))
    }

    @GetMapping
    fun listar(): ResponseEntity<Any> {
        val autores = autorRepository.findAll()
        val resposta = autores.map { DetalhesAutorResponse(it) }
        return ResponseEntity.ok(resposta)
    }
}