package com.json_server.generics;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.json_server.parser.JsonUtil;

import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;

/**
 * 
 * @author Admin
 *
 */
public class CommonLib {
	
	/**
	 * global variables
	 */
public static String token;
public static Response response;

/**
 * to initialize the base URI, port and authentication
 */
	@BeforeSuite
	public void config() {
		baseURI = "http://13.126.80.194";
		port = 8080;

		

	}

	@BeforeMethod

	public void authenticate() {

		try {

			FileInputStream fis = new FileInputStream(new String("./src/test/resources/Json/Create.json"));
			 response = given().contentType(ContentType.JSON).and().body(IOUtils.toByteArray(fis)).when()
					.post(IAutoConstants.CREATE_TOKEN);
			response.then().assertThat().contentType(ContentType.JSON).and().statusCode(200);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}


}
