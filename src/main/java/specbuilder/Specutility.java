package specbuilder;

import java.io.FileOutputStream;
import java.io.PrintStream;

import enaum.Catagory;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import propertyfile.PropertyFile;

public class Specutility {

	public static RequestSpecification req;
	public RequestSpecification specbuilder() throws Exception {
		
	if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("Logs/logging.txt")); 
			req =new RequestSpecBuilder().setBaseUri(PropertyFile.get(Catagory.ADDPLACEBASEURI))
					.addQueryParam("key", "qaclick123")
					 .addFilter(RequestLoggingFilter.logRequestTo(log))
					 .addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
		return req;
	}
	return req;
	}
	public  ResponseSpecification specresponcebuilder(int statuscode) {
		ResponseSpecification resspec =new ResponseSpecBuilder().expectStatusCode(statuscode)
				.expectContentType(ContentType.JSON).build();
		return resspec;
	}
	public String getJsonPath(Response response,String key) {
		  String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
