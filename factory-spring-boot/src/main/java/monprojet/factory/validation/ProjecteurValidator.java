package monprojet.factory.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import monprojet.factory.entity.Projecteur;

public class ProjecteurValidator implements Validator {
	@Override
	public boolean supports(Class<?> paramClass) {
		return Projecteur.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "nom_rong", "Nom is required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remarque", "remarque_rong", "Remarque is required");
	}
}