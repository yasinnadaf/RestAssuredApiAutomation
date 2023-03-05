package com.bridgelabz.restassuredtest.jsonserver;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonServerApis {
    @Test
        public void createPost_ReturnOkStatus(){
            Response result = given().contentType("application/json")
                                     .accept("application/json")
                                     .body("{\n" +
                                            "      \"id\": 12,\n" +
                                            "      \"title\": \"json-server\",\n" +
                                            "      \"author\": \"typicode\"\n" +
                                            "    }")
                                     .when()
                                     .post("http://localhost:3000/posts");
            result.prettyPrint();
            result.then().statusCode(201);
        }

    @Test
    public void getPost_ReturnOkStatus(){
        Response result = given().contentType("application/json")
                                 .accept("application/json")
                                 .when()
                                 .get("http://localhost:3000/posts");
        result.prettyPrint();
        result.then().statusCode(200);
    }

    @Test
    public void updatePost_ReturnOkStatus(){
        Response result = given().accept("application/json")
                                 .contentType("application/json")
                                 .body("{\n" +
                                        "      \"id\": 12,\n" +
                                        "      \"title\": \"json-server12\",\n" +
                                        "      \"author\": \"typicode12\"\n" +
                                        "    }")
                                 .when()
                                 .put("http://localhost:3000/posts/12");

        result.prettyPrint();
        result.then().statusCode(200);
    }

    @Test
    public void deletePost_ShouldReturnOkStatus(){
        Response result = given().accept("application/json")
                                 .contentType("application/json")
                                 .when()
                                 .delete("http://localhost:3000/posts/14");
        result.prettyPrint();
        result.then().statusCode(200);
    }

//    Comments Api
    @Test
    public void createPostComment_ReturnOkStatus(){
        Response result = given().accept("application/json")
                                 .contentType("application/json")
                                 .body("{\n" +
                                        "      \"id\": 6,\n" +
                                        "      \"body\": \"comment 6\",\n" +
                                        "      \"postId\": 13\n" +
                                        "    }")
                                 .when()
                                 .post("http://localhost:3000/comments");
        result.prettyPrint();
        result.then().statusCode(201);
    }

//    fetching comments for post id 1
    @Test
    public void getComment_ReturnOkStatus(){
        Response commentsResult = given().accept("application/json")
                                         .contentType("application/json")
                                         .queryParam("postId", "1")
                                         .when()
                                         .get("http://localhost:3000/comments");
        commentsResult.prettyPrint();
        commentsResult.then().statusCode(200);
    }

    @Test
    public void getComments_ReturnOkStatus(){
        Response commentsResult = given().accept("application/json")
                                         .contentType("application/json")
                                         .when()
                                         .get("http://localhost:3000/comments");
        commentsResult.prettyPrint();
        commentsResult.then().statusCode(200);
    }


    @Test
    public void updateComment_ReturnOkStatus(){
        Response commentsResult = given().accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "      \"id\": 5,\n" +
                        "      \"body\": \"comment 55\",\n" +
                        "      \"postId\": 12\n" +
                        "    }")
                .when()
                .put("http://localhost:3000/comments");
        commentsResult.prettyPrint();
        commentsResult.then().statusCode(200);
    }


    @Test
    public void deleteComment_ReturnOkStatus(){
        Response commentsResult = given().accept("application/json")
                                         .contentType("application/json")
                                         .when()
                                         .delete("http://localhost:3000/comments/6");
        commentsResult.prettyPrint();
        commentsResult.then().statusCode(200);
    }

//    Profile Apis
    @Test
    public void createProfile_ReturnOkStatus(){
        Response profileResult = given().accept("application/json")
                                        .contentType("application/json")
                                        .body("{\n" +
                                                "      \"name\": \"bobyy\",\n" +
                                                "      \"id\": 7\n" +
                                                "    }")
                                        .when()
                                        .post("http://localhost:3000/profile");
        profileResult.prettyPrint();
        profileResult.then().statusCode(201);
    }


    @Test
    public void getProfile_ReturnOkStatus(){
        Response profileResult = given().accept("application/json")
                                        .contentType("application/json")
                                        .when()
                                        .get("http://localhost:3000/profile");
        profileResult.prettyPrint();
        profileResult.then().statusCode(200);
    }


    @Test
    public void updateProfile_ReturnOkStatus(){
        Response profileResult = given().accept("application/json")
                                        .contentType("application/json")
                                        .body("{\n" +
                                                "      \"name\": \"bobyyy\",\n" +
                                                "      \"id\": 6\n" +
                                                "    }")
                                        .when()
                                        .put("http://localhost:3000/profile/6");
        profileResult.prettyPrint();
        profileResult.then().statusCode(200);
    }


    @Test
    public void deleteProfile_ReturnOkStatus(){
        Response profileResult = given().accept("application/json")
                                        .contentType("application/json")
                                        .when()
                                        .delete("http://localhost:3000/profile/7");
        profileResult.prettyPrint();
        profileResult.then().statusCode(200);
    }

}
