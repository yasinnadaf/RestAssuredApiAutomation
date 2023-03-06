package com.bridgelabz.restassuredtest.petstoreswaggerapis;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PetstoreSwaggerApis {
    @Test
    public void uploadFileInToPetStore_ApiExecutionReturnOk(){
        File file = new File("C:\\Users\\Yasin Nadaf\\Downloads\\gitWorking.png");
        given().accept("application/json")
                .multiPart(file)
                .when()
                .post("https://petstore.swagger.io/v2/pet/1/uploadImage")
                .then()
                .log().ifStatusCodeIsEqualTo(200);
    }

}
