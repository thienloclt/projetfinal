package monprojet.cheval.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import monprojet.cheval.model.Owner;

public class OwnerValidator implements Validator {
	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Owner.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "nom_rong", "Nom is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "remarque_rong", "Remarque is required");
	}
}