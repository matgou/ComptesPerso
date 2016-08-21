package info.kapable.app.ComptesPerso.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import info.kapable.app.ComptesPerso.pojo.Category;

public class MaxCategoryLevelValidator implements ConstraintValidator<MaxCategoryLevel, Category> {
	
	/* STATIC PARAM */
	public Integer MAX_DEPTH = 3;

	@Override
	public void initialize(MaxCategoryLevel constraintAnnotation) {
	}

	@Override
	public boolean isValid(Category c, ConstraintValidatorContext arg1) {
		if(c == null) return true;
        int size = 1;
        for(int i=0; i < MAX_DEPTH; i++) {
        	if (c.getParent() != null) {
            	c = c.getParent();
            	size++;
        	}
        }
        if(size >= MAX_DEPTH) {
            return false;
        }
        return true;
	}

}
