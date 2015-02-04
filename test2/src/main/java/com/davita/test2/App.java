package com.davita.test2;

import javax.inject.Inject;
import javax.inject.Named;

import com.davita.demo.PasswordValidationResponse;
import com.davita.demo.PasswordValidationService;

/**
 * Hello world!
 *
 */
@Named
public class App 
{
	@Inject
	private PasswordValidationService passwordValidationService;
	
	public PasswordValidationResponse testPasswordValidation(String password) {
		
		return passwordValidationService.validatePassword(password);
		
	}
}
