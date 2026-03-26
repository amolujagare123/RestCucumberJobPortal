Feature: all Job portal related scenarios

  @GetAllJobs
  Scenario: To test Successful Get all job Request
    Given Get All Jobs Payload is created
    When I Call GetAllJobs resource with GET Request
    Then Then i got success status code as 200


    @CreateJob
  Scenario: To test Successful Post Request to create job
    Given Create Job payload is created
    When I call CreateJob resource with POST request
    Then I get success status code as 200


  @UpdateJob
  Scenario: To test Successful PUT Request to update job
    Given Update Job payload is created
    When I call UpdateJob resource with PUT request
    Then I get successful update status code as 200

  @DeleteJob
  Scenario: To test Successful DELETE Request to delete job
    Given Delete Job payload is created
    When I call DeleteJob resource with DELETE request
    Then I get successful Delete status code as 200
