package stepDefinition;

import POJO.CreateUserPOJO;
import POJO.Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.Arrays;

import static Util.SpecObjects.getRequestSpecObject;
import static io.restassured.RestAssured.given;

public class JobPortalSD {
    RequestSpecification requestSpec;
    RequestSpecification request ;
    Response response ;
    ResponseSpecification responseSpec;


    @Given("Get All Jobs Payload is created")
    public void get_all_jobs_payload_is_created() {

         /*requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:9897/")
                .setContentType("application/json")
                .setAccept("application/json")
                .build();*/
         request = given().log().all().spec(getRequestSpecObject()) ;
    }


    @When("I Call GetAllJobs resource with GET Request")
    public void i_call_get_all_jobs_resource_with_get_request() {
         response = request.when().get("/normal/webapi/all");

         responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
    }

    @Then("Then i got success status code as {int}")
    public void then_i_got_success_status_code_as(Integer int1) {

        String respStr = response.then().log().all().spec(responseSpec).extract().asString();
        System.out.println(respStr);


    }

    @Given("Create Job payload is created")
    public void createJobPayload() {


        CreateUserPOJO ob = new CreateUserPOJO();

/*
*
* "jobId": 2,
  "jobTitle": "Data Analyst",
  "jobDescription": "Analyze business data and generate insights for decision-making",*/

        ob.setJobId(2);
        ob.setJobTitle("Data Analyst");
        ob.setJobDescription("Analyze business data and generate insights for decision-makin");

        ArrayList<String> exp = new ArrayList<>();
        exp.add("Amazon");
        exp.add("Microsoft");
        exp.add("Infosys");

        ob.setExperience(exp);

        Project project1 = new Project();
        project1.setProjectName("Sales Dashboard");

        ArrayList<String> tech = new ArrayList<>();
        tech.add("python");
        tech.add("pandas");
        tech.add("Power BI");

        project1.setTechnology(tech);

        Project project2 = new Project();
        project2.setProjectName("Stock Dashboard");

        ArrayList<String> tech2 = new ArrayList<>();
        tech2.add("selenium");
        tech2.add("java");
        tech2.add("Power BI");

        project2.setTechnology(tech2);

        ArrayList<Project> proj = new ArrayList<>();
        proj.add(project1);
        proj.add(project2);

        ob.setProject(proj);




        // ob.setExperience((ArrayList<String>) Arrays.asList("Google", "Apple", "Mobile Iron"));


        request = given().log().all().spec(getRequestSpecObject())
                .body(ob);
    }

    @When("I call CreateJob resource with POST request")
    public void callCreateJobPostRequest() {
        response = request.when().post("/normal/webapi/add");

        responseSpec = new ResponseSpecBuilder().build();
      }

    @Then("I get success status code as {int}")
    public void verifySuccessStatusCode(int expectedStatusCode) {

        String responseStr = response.then().log().all()
                .spec(responseSpec)
                .assertThat()
                .statusCode(expectedStatusCode)
                .extract().asString();

        System.out.println(responseStr);

    }

    @Given("Update Job payload is created")
    public void update_job_payload_is_created() {
        request = given().log().all().spec(getRequestSpecObject())
                .body("{\n" +
                        "    \"jobId\": 10123,\n" +
                        "    \"jobTitle\": \"AI Automation Engineer\",\n" +
                        "    \"jobDescription\": \"Responsible for designing, developing, and maintaining automated test scripts. Performing API testing, regression testing, and collaborating with development teams to ensure product quality.\",\n" +
                        "    \"experience\": [\n" +
                        "        \"3 years in Manual Testing\",\n" +
                        "        \"2 years in Automation Testing using Selenium\",\n" +
                        "        \"Experience with API Testing using Postman and Rest Assured\"\n" +
                        "    ],\n" +
                        "    \"project\": [\n" +
                        "        {\n" +
                        "            \"projectName\": \"E-commerce Web Application\",\n" +
                        "            \"technology\": [\n" +
                        "                \"Selenium\",\n" +
                        "                \"Java\",\n" +
                        "                \"AI\",\n" +
                        "                \"Maven\"\n" +
                        "            ]\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"projectName\": \"Payment Gateway API Testing\",\n" +
                        "            \"technology\": [\n" +
                        "                \"Postman\",\n" +
                        "                \"Rest Assured\",\n" +
                        "                \"JMeter\"\n" +
                        "            ]\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}");
    }

    @When("I call UpdateJob resource with PUT request")
    public void i_call_update_job_resource_with_put_request() {
        response = request.when().put("/normal/webapi/update");

        responseSpec = new ResponseSpecBuilder().build();
    }

    @Then("I get successful update status code as {int}")
    public void i_get_successful_update_status_code_as(Integer statusCode) {
        String responseStr = response.then().log().all()
                .spec(responseSpec)
                .assertThat()
                .statusCode(statusCode)
                .extract().asString();

        System.out.println(responseStr);
    }

    @Given("Delete Job payload is created")
    public void delete_job_payload_is_created() {
        request = given().log().all().spec(getRequestSpecObject());
    }

    @When("I call DeleteJob resource with DELETE request")
    public void i_call_delete_job_resource_with_delete_request() {
        response = request.when().delete("/normal/webapi/remove/10123");

        responseSpec = new ResponseSpecBuilder().build();
    }

    @Then("I get successful Delete status code as {int}")
    public void i_get_successful_delete_status_code_as(Integer statusCode) {
        // TODO: Validate delete status code

        String responseStr = response.then().log().all()
                .spec(responseSpec)
                .assertThat()
                .statusCode(statusCode)
                .extract().asString();

        System.out.println(responseStr);
    }

}
