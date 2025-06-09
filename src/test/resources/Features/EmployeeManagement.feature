@EmpManagement
Feature: To validate the bookstore by adding , updating, fetching all employees and deleting them from the store with the help of user authentication

  @CRUDOperations @Sanity @SmokeTest123 @All
  Scenario:To create,update ,fetch book by id and finally delete the employee in the list of employees of a company
    Given Adding the new employee into the store after successful login of user into the system

  @getAllEmployees @All
  Scenario: Get all the employees list and verify that status code is 200
    Given Get all employee list from get api call
    Then Verify that status code is 200

  @getAllEmployeeByID @All
  Scenario: get employee by id and verify the status code of it
    Given Get employee by id
    Then Verify that status code is 200

# Delete employee for different cases
  @deleteEmployeeByID @All
  Scenario: Delete an employee for given empID
    Given generate a four digit random employee id
    Given Add an employee for a given employee ID
    When  I delete same employee
    Then Verify that status code is 200

    #  test case when user try to delete for non existing employee id's
  @deleteNonExistingEmployeeByID @All
  Scenario: Delete an employee for given empID
    Given generate a four digit random employee id
    When  I delete same employee
    Then Verify that status code is 404

  @updateEmployeeDetails @All
  Scenario: update employee details and verify that employee details has been updated successfully
    Given generate a four digit random employee id
    When  Add an employee for a given employee ID
    And I update employee details using put api call
    Then Verify that status code is 200