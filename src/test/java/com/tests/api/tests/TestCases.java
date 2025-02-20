package com.tests.api.tests;

import com.tests.api.endpoints.Routes;
import com.tests.api.endpoints.allEndPoints;
import com.tests.api.payload.Data_Root;
import com.tests.api.payload.User_Root;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.given;

@Listeners(com.listeners.ExtentReportManager.class)
public class TestCases {

    @Test
    public void getUsersTestSchemaValidation(){
        given()
                .when()
                    .get(Routes.getURL)
                .then()
                    .statusCode(200)
                    .contentType("application/json")
                    .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("getUsers_Schema.json"));
    }

    @Test
    public void getUsersTest(){
        Data_Root response= allEndPoints.getUsers();

        Assert.assertEquals(response.getData().getId(),2);
        Assert.assertEquals(response.getData().getEmail(),"janet.weaver@reqres.in");
        Assert.assertEquals(response.getData().getFirst_name(),"Janet");
        Assert.assertEquals(response.getData().getLast_name(),"Weaver");
        Assert.assertEquals(response.getData().getAvatar(),"https://reqres.in/img/faces/2-image.jpg");

        Assert.assertEquals(response.getSupport().getUrl(),"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral");
        Assert.assertEquals(response.getSupport().getText(),"Tired of writing endless social media content? Let Content Caddy generate it for you.");
    }

    @Test
    public void createUserTestDataValidation(){
        User_Root user = new User_Root("morpheus","leader");

        Response response= allEndPoints.createUser(user);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().get("name"),"morpheus");
        Assert.assertNotNull(response.jsonPath().get("id"),"id is not populated => " + response.jsonPath().get("id"));
        Assert.assertEquals(response.jsonPath().get("job"),"leader");
        Assert.assertNotNull(response.jsonPath().get("createdAt"));
    }

    @Test
    public void createUserTestSchemaValidation(){
        User_Root user = new User_Root("morpheus","leader");
        allEndPoints
                    .createUser(user)
                .then()
                    .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("createUser_Schema.json"));
    }

}
