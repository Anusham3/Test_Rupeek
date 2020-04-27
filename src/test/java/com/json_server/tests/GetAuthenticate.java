package com.json_server.tests;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;


import org.testng.annotations.Test;

import com.json_server.generics.CommonLib;
import com.json_server.generics.IAutoConstants;

import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;
/**
 * 
 * @author Admin
 *
 */
public class GetAuthenticate extends CommonLib {
	
	
	/**
	 * To get Authenticate by using valid Json Body
	 */
	@Test(priority = 0)
	public void getAuthenticateWithValidJson() throws IOException {
		FileInputStream fis = new FileInputStream(new String("./src/test/resources/Json/Create.json"));
		Response response = given().contentType(ContentType.JSON).and().body(IOUtils.toByteArray(fis)).when()
		.post(IAutoConstants.CREATE_TOKEN);
		response.then().assertThat().contentType(ContentType.JSON).and().statusCode(200);
	

	}
	
	/**
	 * To get Authenticate by using Only username without password
	 */
	
	@Test(priority = 1)
	public void getAuthenticateWithInValidJson1() throws IOException {
		FileInputStream fis = new FileInputStream(new String("./src/test/resources/Json/Create1.json"));
		Response response = given().contentType(ContentType.JSON).and().body(IOUtils.toByteArray(fis)).when()
		.post(IAutoConstants.CREATE_TOKEN);
		response.then().assertThat().contentType(ContentType.JSON).and().statusCode(401);

	}
	/**
	 * To get Authenticate by using Only password without username
	 */
	
	@Test(priority = 2)
	public void getAuthenticateWithValidJson2() throws IOException {
		FileInputStream fis = new FileInputStream(new String("./src/test/resources/Json/Create2.json"));
		Response response = given().contentType(ContentType.JSON).and().body(IOUtils.toByteArray(fis)).when()
		.post(IAutoConstants.CREATE_TOKEN);
		response.then().assertThat().contentType(ContentType.JSON).and().statusCode(401);

	}
	
	/**
	 * To get Authenticate by using invalid username and valid password
	 */
	@Test(priority = 3)
	public void getAuthenticateWithInValidJson3() throws IOException {
		FileInputStream fis = new FileInputStream(new String("./src/test/resources/Json/Create3.json"));
		Response response = given().contentType(ContentType.JSON).and().body(IOUtils.toByteArray(fis)).when()
		.post(IAutoConstants.CREATE_TOKEN);
		response.then().assertThat().contentType(ContentType.JSON).and().statusCode(401);

	}
	
	/**
	 * To get Authenticate by using invalid password  and valid username
	 */
	@Test(priority = 4)
	
	public void getAuthenticateWithInValidJson4() throws IOException {
		FileInputStream fis = new FileInputStream(new String("./src/test/resources/Json/Create4.json"));
		Response response = given().contentType(ContentType.JSON).and().body(IOUtils.toByteArray(fis)).when()
		.post(IAutoConstants.CREATE_TOKEN);
		response.then().assertThat().contentType(ContentType.JSON).and().statusCode(401);

	}
	
	
	/**
	 * To get Authenticate by using invalid username and password 
	 */
	@Test(priority = 5)
	public void getAuthenticateWithInValidJson5() throws IOException {
		FileInputStream fis = new FileInputStream(new String("./src/test/resources/Json/Create5.json"));
		Response response = given().contentType(ContentType.JSON).and().body(IOUtils.toByteArray(fis)).when()
		.post(IAutoConstants.CREATE_TOKEN);
		response.then().assertThat().contentType(ContentType.JSON).and().statusCode(401);

	}
	
	
}

