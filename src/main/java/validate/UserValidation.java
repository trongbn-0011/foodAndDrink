package validate;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import app.bean.UserInfo;
import app.model.User;

public class UserValidation implements Validator {
	
	@Override
	public boolean supports(Class<?> type) {
		return User.class.isAssignableFrom(type);
	}

	@Override
	public void validate(Object object, Errors errors) {
		UserInfo user = (UserInfo) object;

		if (user.getName().length() == 0) {
			errors.rejectValue("name", "NotEmpty");
		}
		
		if (user.getAddress().length() == 0) {
			errors.rejectValue("address", "NotEmpty");
		}

		if (user.getEmail().length() == 0) {
			errors.rejectValue("email", "NotEmpty");
		} else if (new EmailValidator().isValid(user.getEmail(), null) == false) {
			errors.rejectValue("email", "Error.Email.Format");
		}
		
		if (user.getPassword().length() == 0) {
			errors.rejectValue("password", "NotEmpty");
		} else if (user.getPassword().length() < 5 || user.getPassword().length() > 20) {
			errors.rejectValue("password", "Error.Pass.Size");
		}
		else if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Error.Pass.Incorrect");
		}
		
	}

}