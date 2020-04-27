package com.json_server.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.json_server.generics.CommonLib;
import com.json_server.generics.IAutoConstants;
import com.json_server.parser.JsonUtil;

import io.restassured.http.ContentType;

/**
 * 
 * @author Admin
 *
 */

public class GetUser extends CommonLib {

	/**
	 * to get all users Details
	 */

	@Test(priority = 0)
	public void getAllUser() {

		token = JsonUtil.getJsonString(response, "token");
		given().auth().oauth2(token).when().get(IAutoConstants.GET_ALL_USERS).then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON);

	}

	/**
	 * To get Single user by using valid Phone number
	 */

	@Test(priority = 1)

	public void getSingleUserWithValidPhoneNum() {
		token = JsonUtil.getJsonString(response, "token");
		given().auth().oauth2(token).given().pathParam("phone", 9995879555l).when().get(IAutoConstants.GET_USER_PHONE)
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				.body("first_name", equalTo("Folrunsho")).and().body("last_name", equalTo("Alakija")).and()
				.body("career", equalTo("Billionaire Oil Magnate"));

	}

	/**
	 * To get Single user by using Invalid Phone number
	 */

	@Test(priority = 2)

	public void getSingleUserWithInValidPhonenum() {
		token = JsonUtil.getJsonString(response, "token");
		given().auth().oauth2(token).given().pathParam("phone", 99958765).when().get(IAutoConstants.GET_USER_PHONE)
				.then().assertThat().statusCode(200);

	}

	/**
	 * To get Single user by using Invalid Phone number
	 */

	@Test(priority = 3)

	public void getSingleUserWithInValidPhonenum1() {
		token = JsonUtil.getJsonString(response, "token");

		given().auth().oauth2(token).given().pathParam("phone", 123.0546530).when().get(IAutoConstants.GET_USER_PHONE)
				.then().assertThat().statusCode(200);

	}
	
	
	@Test(priority = 4)

	public void getSingleUserWithInValidPhonenum2() {
		token = JsonUtil.getJsonString(response, "token");

		given().auth().oauth2(token).given().pathParam("phone", 0000000000).when().get(IAutoConstants.GET_USER_PHONE)
				.then().assertThat().statusCode(200);

	}

}