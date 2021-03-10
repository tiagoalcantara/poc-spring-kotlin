package br.com.tiago.casadocodigo.autor

import org.springframework.data.jpa.repository.JpaRepository

interface AutorRepository: JpaRepository<Autor, Long> {}