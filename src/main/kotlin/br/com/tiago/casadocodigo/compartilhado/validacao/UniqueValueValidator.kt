package br.com.tiago.casadocodigo.compartilhado.validacao

import javax.persistence.EntityManager
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

class UniqueValueValidator(
    private val manager: EntityManager
): ConstraintValidator<UniqueValue, Any>{
    private var field: String? = null
    private var entity: KClass<out Any>? = null

    override fun initialize(constraintAnnotation: UniqueValue?) {
        field = constraintAnnotation?.field
        entity = constraintAnnotation?.entity
    }

    override fun isValid(value: Any?, constraintValidatorContext: ConstraintValidatorContext?): Boolean {
        val query = manager.createQuery("SELECT 1 FROM ${entity?.simpleName} WHERE $field = :value")
        query.setParameter("value", value)
        val resultado = query.resultList

        return resultado.isEmpty()
    }

}
