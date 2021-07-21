package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import enaum.AllResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Addplacebase;
import specbuilder.Specutility;
import testDatabuilder.AddPlaceApi;

public final class MultiplePlaceAdd extends Specutility {

	private RequestSpecification responce;
	private Response rec;
	AddPlaceApi ap = new AddPlaceApi();
	private static String place;
	private Addplacebase apibody;
	private static String add;
	

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name,String language,String address) throws Exception {
			apibody = ap.adplaceAPI(name,language ,address );
			responce = given().spec(specbuilder()).body(apibody);

		}

	@When("user calls {string} with {string} http request")
	public void user_calls_add_place_api_with_post_http_request(String resource,String Method) {
		AllResource ar=AllResource.valueOf(resource);
		String recpath=ar.getResource();
		if(Method.equalsIgnoreCase("POST")) 
		rec = responce.when().post(recpath);		
		else if(Method.equalsIgnoreCase("GET"))
		rec =responce.when().get(recpath);		
		else if(Method.equalsIgnoreCase("PUT"))
		rec =responce.when().put(recpath);
		rec.then().spec(specresponcebuilder(200)).extract().response();
		
	}

	@Then("verifay responce code id {int}")
	public void verifay_status_code_id(int value) {
		assertEquals(rec.getStatusCode(), value);
	}

	@Then("take all pace {string}")
	public void take_all_pace(String place_id) {
		place = getJsonPath(rec, place_id);
		System.out.println(place);
	}

	@Then("verifay the {string} is {string}")
	public void verifay_the_is(String key, String value) {
		String status = getJsonPath(rec, key);
		assertEquals(status, value);
		System.out.println(status);
	}

	@Then("verify {string} created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String place_id,String name, String api) throws Exception {
		responce=given().spec(specbuilder()).queryParam(place_id, place);
		user_calls_add_place_api_with_post_http_request(api,"GET");
		rec.then().spec(specresponcebuilder(200)).extract().response();
		String responcename=getJsonPath(rec, "name");
		assertEquals(responcename, name);
	}
	@Given("update place add new address")
	public void update_place(DataTable table) throws Exception {
		List<Map<String,String>> list=table.asMaps(String.class,String.class);
		for (Map<String, String> map : list) {
			add=map.get("address");
			responce=given().spec(specbuilder()).body(ap.updateplace(place,add));
		}
	}
	@Then("verify the success {string}")
	public void verify_the_address(String message) {
		String addres=getJsonPath(rec,message );
		String msg="Address successfully updated";
		assertEquals(msg, addres);
	}
	
	@Given("Delete place payload validation")
	public void Delete_place_payload_validation() throws Exception {
		responce=given().spec(specbuilder()).body(ap.deletedata(place));
	}


}
