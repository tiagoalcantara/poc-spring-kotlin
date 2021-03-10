package br.com.tiago.casadocodigo.compartilhado.exception

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler(
    private val messageSource: MessageSource
) {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleErroValidacao(exception: MethodArgumentNotValidException): List<ErroValidacaoResponse>{
        val fieldErrors = exception.bindingResult.fieldErrors
        val resposta = fieldErrors.map {
            val mensagem = messageSource.getMessage(it, LocaleContextHolder.getLocale())
            ErroValidacaoResponse(it.field, mensagem)
        }

        return resposta
    }
}