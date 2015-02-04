/**
 * 
 */
package com.davita.demo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Provides the response for the password validation.
 * 
 * If the response is valid, then isValid will return true
 * 
 * If the response is not valid, then the detail will be provided
 * in the getDetailedResponse operation
 * 
 * @author ladobbins
 *
 */
public class PasswordValidationResponse {
	
	private Collection<String> responses = new ArrayList<String>();

	/**
	 * Returns true if the password is valid, false otherwise
	 * 
	 * @return
	 */
	public boolean isValid() {
		return responses.isEmpty();
	}
	
	/**
	 * Returns the collection of detailed responses that give details
	 * on the types of validations that the password violates
	 * 
	 * @return Collection<String>
	 */
	public Collection<String> getDetailedResponses() {
		return responses;
	}
	
	/**
	 * Adds a response to the response collection
	 * 
	 * @param response
	 */
	void addResponse(String response) {
		responses.add(response);
	}

	@Override
	public String toString() {
		if (isValid()) 
			return "IsValid";
		else {
			StringBuilder returnSb = new StringBuilder();
			for (String string : responses) {
				returnSb.append(string);
			}
			return returnSb.toString();	
		}
	}
	
}	
