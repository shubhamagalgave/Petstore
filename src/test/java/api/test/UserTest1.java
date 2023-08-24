package api.test;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoint.UserEndPoints;
import api.endpoint.UserEndPoints1;
import api.payload.User;
import io.restassured.response.Response;
public class UserTest1 {
	public  Logger Logger;
	User userPayload;
	Faker f;
	
	
	@BeforeClass
	public void setUpData()
	{
		f=new Faker();
		userPayload=new User();
		
		
		userPayload.setFirstName(f.name().firstName());
		userPayload.setUsername(f.name().username());
		userPayload.setLastName(f.name().lastName());
		userPayload.setEmail(f.internet().safeEmailAddress());
		userPayload.setPassword(f.internet().password(5,10));
		userPayload.setPhone(f.phoneNumber().cellPhone());
		userPayload.setId(f.idNumber().hashCode());
		
		     Logger=Logger.getLogger("api.framework");
			//PropertyConfigurator.configure("Log4j.properties");
			DOMConfigurator.configure("Log4j.xml");
			
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		Logger.info("****************************user is created*******************************************************");
		Response res=UserEndPoints1.createUser(userPayload);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);
		Logger.info("******************************user is created******************************************************");
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		Logger.info("****************************reading user info*******************************************************");
		Response res=UserEndPoints1.readUser(this.userPayload.getUsername());
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);
		Logger.info("****************************user is read successfull*******************************************************");
	}
	
	@Test(priority=3)
	public void testupdateUserByName()
	{
		userPayload.setFirstName(f.name().firstName());
		userPayload.setLastName(f.name().lastName());
		userPayload.setEmail(f.internet().safeEmailAddress());
		
		
		Response res=UserEndPoints.updateUser(userPayload, this.userPayload.getUsername());
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);
		Logger.info("Post Success");
		
		//checking the data after updating
		Response res1=UserEndPoints1.readUser(this.userPayload.getUsername());
		res1.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
		
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		Response res=UserEndPoints1.deleteUser(this.userPayload.getUsername());
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);
	}


}
