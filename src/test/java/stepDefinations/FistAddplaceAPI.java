package stepDefinations;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import config.AllUri;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import specbuilder.Specutility;
import testDatabuilder.addplace;

public final class FistAddplaceAPI extends Specutility {

	private RequestSpecification responce;
	private Response rec;
	private addplace ad = new addplace();

	@Given("Add api payload")
	public void add_api_payload() throws Exception {
		responce = given().spec(specbuilder()).body(ad.addplaceTestdata());
	}

	@When("User call {string} with post http request")
	public void user_call_with_post_http_request(String string) {
		rec = responce.when().post(AllUri.getADDPLACEPOSTRESOURCE()).then().spec(specresponcebuilder(200)).extract()
				.response();
	}
	@Then("API call stass code success {int}")
	public void api_call_stass_code_success(int statuscode) {
		assertEquals(rec.getStatusCode(), statuscode);
	}

	@Then("{string} is responce body is {string}")
	public void status_is_responce_body_is(String key, String value) {
		String stat=getJsonPath(rec, key);
		assertEquals(stat, value);
	}

	@Then("{string} is responce body {string}")
	public void responce(String key, String value) {
		String source=getJsonPath(rec, key);
		assertEquals(source, value);

	}

}
