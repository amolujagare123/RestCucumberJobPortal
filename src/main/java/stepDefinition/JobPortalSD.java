package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class JobPortalSD {
    RequestSpecification requestSpec;
    RequestSpecification request ;
    Response response ;
    ResponseSpecification responseSpec;


    @Given("Get All Jobs Payload is created")
    public void get_all_jobs_payload_is_created() {

         requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:9897/")
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
         request = given().log().all().spec(requestSpec) ;
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

}
