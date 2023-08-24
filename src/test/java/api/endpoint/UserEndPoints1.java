package api.endpoint;


//created for perform create,read,update,delete request the API.


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;

public class UserEndPoints1 {
	
	
	public static ResourceBundle getUrl()
	{
		ResourceBundle routes=ResourceBundle.getBundle("configuer");
		return routes;
	}
	
	
	
	
	
	
	public static Response createUser(User payload)
	{
		String postUrl=getUrl().getString("post_Url");
		
		
		   Response response=
				given()
				.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(payload)
				.when().post(postUrl);
		   return response;
	}
	
	public static Response readUser(String userName){
		
		String gettUrl=getUrl().getString("get_Url");
		
		
		   Response response=
				given()
				.pathParam("username",userName)
				.when().get(gettUrl);
		   return response;
	}
	
	public static Response updateUser(User payload,String userName){
		
		String updateUrl=getUrl().getString("update_Url");
		
		
		   Response response=
				given()
				.contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
				.when().put(updateUrl);
		   return response;
	}
	
	public static Response deleteUser(String userName){
		
		String deleteUrl=getUrl().getString("delete_Url");
		
		   Response response=
				given()
				.pathParam("username",userName)
				.when().delete(deleteUrl);
		   return response;
	}


}
