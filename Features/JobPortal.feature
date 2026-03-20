Feature: all Job portal related scenarios

  Scenario: To test Successful Get all job Request
    Given Get All Jobs Payload is created
    When I Call GetAllJobs resource with GET Request
    Then Then i got success status code as 200