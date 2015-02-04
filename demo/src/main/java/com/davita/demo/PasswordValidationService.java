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
	private ValidatorUtils utils;
	
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
		String numCharsResult = utils.validateNumCharacters(password);
		if (!StringUtils.isEmpty(numCharsResult)) {
			response.addResponse(numCharsResult);
		}
		String lettersDigitsResult = utils.validateLettersDigits(password);
		if (!StringUtils.isEmpty(lettersDigitsResult)) {
			response.addResponse(lettersDigitsResult);
		}
		String repeatSeqResult = utils.validateRepeatingSequence(password);
		if (!StringUtils.isEmpty(repeatSeqResult)) {
			response.addResponse(repeatSeqResult);
		}
		return response;
	}

}
