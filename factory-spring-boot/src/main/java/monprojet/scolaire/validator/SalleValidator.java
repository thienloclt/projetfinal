package monprojet.scolaire.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import monprojet.scolaire.entity.Salle;

public class SalleValidator implements Validator {
	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Salle.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "nom_rong", "Nom is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "capacite", "capacite_rong", "Capacite is required");

		// search ten_rong in properties files, if not will show string """
	}
}