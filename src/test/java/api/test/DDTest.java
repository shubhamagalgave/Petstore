package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mongodb.diagnostics.logging.Logger;

import api.endpoint.UserEndPoints;
import api.payload.User;
import api.utilities.Dataprovider;
import io.restassured.response.Response;

public class DDTest {
	User userpayload;
	@Test(priority=1,dataProvider="getAllData",dataProviderClass=Dataprovider.class)
	public void post(String userId,String userName,String firstName,String lastName,String email,String password,String phone)
	{
		userpayload=new User();
		userpayload.setId(Integer.parseInt(userId));
		userpayload.setUsername(userName);
		userpayload.setFirstName(firstName);
		userpayload.setLastName(firstName);
		userpayload.setEmail(email);
		userpayload.setPassword(password);
		userpayload.setPhone(phone);
		
		Response res=UserEndPoints.createUser(userpayload);
		Assert.assertEquals(res.getStatusCode(),200);
	}
	
	@Test(priority=2,dataProvider="getUsername",dataProviderClass=Dataprovider.class)
	public void testDelete(String userName)
	{
		Response res=UserEndPoints.deleteUser(userName);
		Assert.assertEquals(res.getStatusCode(),200);
	}
	

}
