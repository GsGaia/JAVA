package br.com.fiap.Gs.Gaia.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateValidationNow.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateValidation {
    String message() default "A data deve ser hoje ou no futuro";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
