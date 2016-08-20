package info.kapable.app.ComptesPerso.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = MaxCategoryLevelValidator.class)
@Documented
public @interface MaxCategoryLevel {

    String message() default "{info.kapable.app.ComptesPerso.max_category_level}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}