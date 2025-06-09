@LoginAndSignUp
Feature: To validate the login flow and Signup flow for the user for Employee management System

  #Employee NewSignup
  @NewSignUp @Sanity @All
  Scenario:To Signup to the employee management system by creating account with new email and password
  Given Signup employee Management system with new email and password
  When user tries to signup the store with new credentials
    Then validate whether a new user is created with response code 200 and response message User created successfully after signup


  @EndToEndCRUDflow @Sanity @All
  Scenario:To Signup to the employee management system by creating account with new email and password
    Given generate a four digit random employee id
    When  Add an employee for a given employee ID
    Then Verify that status code is 201
    And  I update employee details using put api call
    Then Verify that status code is 200
    And Get employee by id in flow
    When  I delete same employee
    Then Verify that status code is 200
