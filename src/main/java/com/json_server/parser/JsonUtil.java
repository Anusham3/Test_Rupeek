package com.json_server.parser;

import java.util.List;
import io.restassured.response.Response;

/**
 * 
 * @author Admin
 *
 */

public class JsonUtil {
	/**
	 * getJsonString returns the json value from the specified jsonpath  
	 * @param response
	 * @param key
	 * @return
	 */
	
	
	public static String getJsonString(Response response, String jsonpath) {
		return response.getBody().jsonPath().get(jsonpath).toString();
	}


	

}
