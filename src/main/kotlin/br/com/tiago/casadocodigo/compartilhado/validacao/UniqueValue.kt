package br.com.tiago.casadocodigo.compartilhado.validacao

import javax.validation.Constraint
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [UniqueValueValidator::class])
@Target( AnnotationTarget.FIELD )
@Retention(AnnotationRetention.RUNTIME)
annotation class UniqueValue (
    val message: String = "deve ser único",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Any>> = [],
    val field: String,
    val entity: KClass<out Any>
)