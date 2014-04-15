/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.common.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sivalabs.common.model.User;

/**
 * @author K. Siva Prasad Reddy
 * Date : 04-Nov-2011
 */
@Component
public class RegistrationFormValidator  implements Validator
{

	@Override
	public boolean supports(Class<?> clazz)
	{
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required","UserName is Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", "Password is Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "firstname.required", "FirstName is Empty");
	}

}
