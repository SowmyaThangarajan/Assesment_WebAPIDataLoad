package com.tests.api.endpoints;

import com.tests.api.payload.Data_Root;
import com.tests.api.payload.User_Root;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class allEndPoints {

    public static Data_Root getUsers(){
        return given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                .when()
                    .get(Routes.getURL)
                .then()
                    .statusCode(200)
                    .extract()
                .as(Data_Root.class);
    }

    public static Response createUser(User_Root payload){
        return RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)
                .when()
                    .post(Routes.postURL);
    }
}
