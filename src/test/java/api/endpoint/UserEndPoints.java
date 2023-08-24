package api.endpoint;


//created for perform create,read,update,delete request the API.


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;

public class UserEndPoints {
	
	public static Response createUser(User payload)
	{
		   Response response=
				given()
				.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(payload)
				.when().post(Routs.post_Url);
		   return response;
	}
	
	public static Response readUser(String userName)
	{
		   Response response=
				given()
				.pathParam("username",userName)
				.when().get(Routs.get_Url);
		   return response;
	}
	
	public static Response updateUser(User payload,String userName)
	{
		   Response response=
				given()
				.contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
				.when().put(Routs.update_Url);
		   return response;
	}
	
	public static Response deleteUser(String userName)
	{
		   Response response=
				given()
				.pathParam("username",userName)
				.when().delete(Routs.delete_Url);
		   return response;
	}


}
