package br.com.fiap.Gs.Gaia.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DateValidationNow implements ConstraintValidator<DateValidation, LocalDate> {

    public void initialize(DateValidationNow constraintAnnotation) {
        // Pode usar para configurar se precisar
    }

    @Override
    public boolean isValid(LocalDate data, ConstraintValidatorContext context) {
        if (data == null) {
            return true; // normalmente validações @NotNull são feitas separadamente
        }
        LocalDate hoje = LocalDate.now();
        // Retorna true se data for igual ou depois da data atual
        return !data.isBefore(hoje);
    }
}
