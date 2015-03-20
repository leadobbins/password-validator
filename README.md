# password-validator

This code was created as a demonstration of using Dependency Injection and Inversion of Control using Spring. The latest version of Spring was used, along with annotated configuration.

The password validator is a Spring service that performs 3 types of password validation. The validations are:

Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
Must be between 5 and 12 characters in length.
Must not contain any sequence of characters immediately followed by the same sequence.
The service method validates that the password meets the current rules. It returns the response as a PasswordValidationResponse to give more details about any validation failures. The service looks like this:

public PasswordValidationResponse validatePassword(String password)
To use, call validatePassword, pass in the password, and a PasswordValidationResponse will be returned. The PasswordValidationResponse contains an isValid() method that returns true if the password is valid, false otherwise. Another method called getDetailedResponses() returns a collection of String which will contain a reason response for each invalid case. All are checked.

To build, use "mvn clean install" in the demo project. It will build a jar file called password-validation.jar.

Once the password-validation.jar is built, put it into a maven repository (the jar file contains a pom.xml which can be used to install it into a maven repository).

To use in eclipse, import the maven project file included in the zip file into Maven via the Import option on your eclipse ide.

An example usage is demonstrated in the test2 project. The App.java and AppConfig.java demonstrate usage.
