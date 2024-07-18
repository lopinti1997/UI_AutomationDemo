Feature: Verify Login Madule.

Background:
	Given user launched blowser and entered url.

@Valid
Scenario: TC01_Verify_login_Function_with_valid_Credentials.
	When user entered id as "userEmail" from Test Case "TC01".
	And user entered password as "userPassword" from Test Case "TC01".
	And  user clicked on "login".
	And user clicked on signOut "Sign Out".
	

@InValid
Scenario: TC01_Verify_login_Function_with_Invalid_Credentials.
	When user entered id as "userEmail" from Test Case "TC04".
	And user entered password as "userPassword" from Test Case "TC04".
	And  user clicked on "login".
	And user clicked on signOut "Sign Out".
	
@Forgot
Scenario:TC03_Verrify_forgot_password.
	When user clicked on forgot as "forgot-password-link".
	And user enterd "email".
	And user entered pwd as "userPassword".
	And user entered confpwd as "confirmPassword".
	And user clicked on buuton "submit". 
	
	