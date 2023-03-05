package com.bridgelabz.restassuredtest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;

public class RestAssuredAPIAutomation {
    String token = "Bearer BQCDR4WdLVH4zHSd1rvlB31W38oNSZKSmHOl6tXVxbzEUkwaWhuA0_ez3bVu4DA9OUAO5MdrkSHk7vlHJHGS1mJLTJJELLKbSZzcEmZseb_NFMIcCxqAhGvHzxJ4y8mJVi1uCsfrVp3WV3MfQcRdnMp3Zw78UmVav2u8Lzr4yiqSX-zfVNsoF-M6Sn0b-LLjqTWW2HY-O20E5MlF76AxNReX6D0jSBU9IAleCU_F3_RlSoDpe0ZOlCLA9r6oErxqc4fykK76lhhwMimRqFWXHIacWfVyyZTX4osR14DHBPHPbPSLsno-OMgebkEp_j3paGI";
//    users profile
//    @Test
//    public void getCurrentUserProfileApiExecution_Return200StatusCode(){
//        given().header("Accept","application/json")
//                .header("Content-Type","application/json")
//                .header("Authorization", "Bearer BQCVUeRJQMOr0wR8B6BhOtybHVZ-ngbWdtwm4ol3QLxU0OE0MMpBVvzpndgbPyE1vfvG5xEUUhQWZbwWwEzv4cGuqIYPeiao1wS7mq72ca1T5s_CfnA5jAsr-FG9254kKIWPLwtMdO2bEdjMltAW7Ulm1OksfCfAURq6OBkCef7T5hWZJg3PrTOqz2i4KXR0eHqNnMXS8ni7aSoeis-jU2ypjOXEDWgf22lROdXjBLdSzsPw2_gbn3RSHoaedOATno-UZjNFHfk")
//                .when()
//                .get("https://api.spotify.com/v1/me")
//                .then()
//                .log()
//                .all()
//                .statusCode(200);
//    }

        @Test
    public void getUsersProfileApiExecution_Return200StatusCode() {
        given().header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer BQCVUeRJQMOr0wR8B6BhOtybHVZ-ngbWdtwm4ol3QLxU0OE0MMpBVvzpndgbPyE1vfvG5xEUUhQWZbwWwEzv4cGuqIYPeiao1wS7mq72ca1T5s_CfnA5jAsr-FG9254kKIWPLwtMdO2bEdjMltAW7Ulm1OksfCfAURq6OBkCef7T5hWZJg3PrTOqz2i4KXR0eHqNnMXS8ni7aSoeis-jU2ypjOXEDWgf22lROdXjBLdSzsPw2_gbn3RSHoaedOATno-UZjNFHfk")
                .when()
                .get("https://api.spotify.com/v1/users/31jyu3h64mhdvjwqm3pz7lvodfty")
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void getCurrentUserProfileApiExecution_Return200StatusCode(){
        Response apiResult = given().header("Accept","application/json")
                              .header("Content-Type","application/json")
                              .header("Authorization", "Bearer BQCDR4WdLVH4zHSd1rvlB31W38oNSZKSmHOl6tXVxbzEUkwaWhuA0_ez3bVu4DA9OUAO5MdrkSHk7vlHJHGS1mJLTJJELLKbSZzcEmZseb_NFMIcCxqAhGvHzxJ4y8mJVi1uCsfrVp3WV3MfQcRdnMp3Zw78UmVav2u8Lzr4yiqSX-zfVNsoF-M6Sn0b-LLjqTWW2HY-O20E5MlF76AxNReX6D0jSBU9IAleCU_F3_RlSoDpe0ZOlCLA9r6oErxqc4fykK76lhhwMimRqFWXHIacWfVyyZTX4osR14DHBPHPbPSLsno-OMgebkEp_j3paGI")
                              .when()
                             .get("https://api.spotify.com/v1/me");
        apiResult.prettyPrint();
        String displayName = apiResult.path("display_name");
        System.out.println("Display name: " +displayName);

//        type1 assertion using : TestNG Assertion
        System.out.println("status code: "+ apiResult.getStatusCode());
        Assert.assertEquals(apiResult.getStatusCode(), 200);

//        type 2 assertion using: Response interface Assertion
        apiResult.then().statusCode(200);


//         PLAYLIST

    }

}
