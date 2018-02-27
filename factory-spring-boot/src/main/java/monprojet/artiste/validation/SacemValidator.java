package monprojet.artiste.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import monprojet.artiste.entity.Sacem;

public class SacemValidator implements Validator {
	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Sacem.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "nom_rong", "Nom is required");
		// search ten_rong in properties files, if not will show string """
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remarque", "remarque_rong", "Remarque is required");
	}
}