package Demonstration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.JsonPathException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Restassureddemo {

	public static void main(String[] args) throws IOException {

//		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login";
		
//		Hamcrest library -> 
//		
		JsonObject userCreds = new JsonObject();
		userCreds.addProperty("username", "mithun@ta.com");
		userCreds.addProperty("password", "mithun");
		Response res = RestAssured.given().contentType("application/json").when().body(userCreds).post().then().assertThat().statusCode(200).extract().response();
//		System.out.println(res.jsonPath().getString("token[0]"));
		
		
		RestAssured.baseURI ="https://reqres.in/api/users";
		
		Response res1 = RestAssured.given().contentType("application/json").queryParams("page", 2).get();
		
//		System.out.println(res1.asPrettyString());
		
		System.out.println(res1.jsonPath().get("data[0].email").toString());
		
		String jsonData = res1.toString();
		
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Demonstration//Samplejson.json");
				
		System.out.println(JsonPath.read(jsonData, "$.data[0].email").toString());
		
		
//			String sURI_getdata = "/getdata";
//			String sURI_adddata = "/addData";
//			String  sURI_deleteData = "/deleteData";
//			
//			String sURL = null;
//			String sToken = null;
//			
			
			
			
	}

}
