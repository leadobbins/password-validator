/**
 * 
 */
package com.davita.demo;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

/**
 * Provides operation to validate that a password
 * conforms to certain rules.  Current rules are:
 * 
 * - Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
 * - Must be between 5 and 12 characters in length.
 * - Must not contain any sequence of characters immediately followed by the same sequence.
 * 
 * @author ladobbins
 *
 */
@Named
public class PasswordValidationService {
	
	@Inject
	private ValidatorInterface validateLettersDigits;
	
	@Inject
	private ValidatorInterface validateNumChars;
	
	@Inject
	private ValidatorInterface validateRepeatingSequence;
	
	/**
	 * Validates that the password meets the current rules.  Returns the
	 * response as a PasswordValidationResponse to give more details about
	 * any validation failures.
	 * 
	 * @param password
	 * @return
	 */
	public PasswordValidationResponse validatePassword(String password) {
		PasswordValidationResponse response = new PasswordValidationResponse();
		String numCharsResult = validateNumChars.validate(password);
		if (!StringUtils.isEmpty(numCharsResult)) {
			response.addResponse(numCharsResult);
		}
		String lettersDigitsResult = validateLettersDigits.validate(password);
		if (!StringUtils.isEmpty(lettersDigitsResult)) {
			response.addResponse(lettersDigitsResult);
		}
		String repeatSeqResult = validateRepeatingSequence.validate(password);
		if (!StringUtils.isEmpty(repeatSeqResult)) {
			response.addResponse(repeatSeqResult);
		}
		return response;
	}

}
