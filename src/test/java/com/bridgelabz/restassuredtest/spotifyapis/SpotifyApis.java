package com.bridgelabz.restassuredtest.spotifyapis;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyApis {
    String token = "Bearer BQAS8wYPoHTOLxRL5WVKGZTV3pANWwlZtJUaZ1dt_ki-QsA-NmaEone882yAXy47tRnHL-ONFDVvQpOr9QHnqQUNeyATV79NBCYVc4qlsjpHmzsdaeM1bPp2_MA8XaDaIAGr6ZYp16ZfDKV-8sMvhuiBAPjZCgAe2WzCwdONVfYsWIHMJDCxmzpQsr6OXVMCKgkKC-f3amUXaiMhcWgkPqS3CvdhdOzfDKC7p6ywnZ3xxwO6US9aSHvhX5VLY52quHIZuKHzVWA951_MAJIW2ktB9x3fbzI2skDVKK8pqZffy7bwXtpSztWBNPtRnO17ct_DGVEZ3j-1Jg";
    String userId = "31jyu3h64mhdvjwqm3pz7lvodfty";
    String playListId = "3gGyj7QUjXoZzngXVGReY1";

    //     Users Profile
    @Test
    public void getCurrentUserProfileApiExecution_Return200StatusCode(){
        given().header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me")
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void getUsersProfileApiExecution_Return200StatusCode() {
        given().header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/31jyu3h64mhdvjwqm3pz7lvodfty")
                .then()
                .log()
                .all()
                .statusCode(200);
}

//  Search
    @Test
    public void getSearchForItemApiExecution_Return200StatusCode(){
         Response searchResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .queryParam("q","Atif Aslam")
                                        .queryParam("type","track")
                                        .when()
                                        .get("\thttps://api.spotify.com/v1/me");
         searchResult.prettyPrint();
        Assert.assertEquals(searchResult.getStatusCode(), 200);
    }

//    PlayList Apis

    @Test
    public void createPlaylist_ApiExecution_ReturnOkStatus(){
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .body("{\n" +
                                                "  \"name\": \"fav\",\n" +
                                                "  \"description\": \"New playlist description\",\n" +
                                                "  \"public\": false\n" +
                                                "}")
                                        .pathParam("user_id",userId)
                                        .when()
                                        .post("\thttps://api.spotify.com/v1/users/{user_id}/playlists");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 201);
}

    @Test
    public void AddItemsToPlaylist_ApiExecution_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .body("{\n" +
                                                "  \"name\": \"fav\",\n" +
                                                "  \"description\": \"New playlist description\",\n" +
                                                "  \"public\": false\n" +
                                                "}")
                                        .pathParam("playlist_id", playListId)
                                        .queryParam("uris", "spotify:track:1301WleyT98MSxVHPZCA6M")
                                        .when()
                                        .post("\thttps://api.spotify.com/v1/playlists/{playlist_id}/tracks");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 201);
    }

    @Test
    public void getCurrentUsersPlaylist_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .when()
                                        .get("https://api.spotify.com/v1/me/playlists");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getPlaylist_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("playlist_id", playListId)
                                        .when()
                                        .get("https://api.spotify.com/v1/playlists/{playlist_id}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getPlaylistItems_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("playlist_id", playListId)
                                        .when()
                                        .get("https://api.spotify.com/v1/playlists/{playlist_id}/tracks");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getUsersPlaylist_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("user_id",userId)
                                        .when()
                                        .get("\thttps://api.spotify.com/v1/users/{user_id}/playlists");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getPlaylistCoverImage_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("playlist_id", playListId)
                                        .when()
                                        .get("\thttps://api.spotify.com/v1/playlists/{playlist_id}/images");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void updatePlaylistItems_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("playlist_id", playListId)
                                        .queryParam("uris", "spotify:track:5W7DOVGQLTigu09afW7QMT")
                                        .body("{\n" +
                                                "  \"range_start\": 1,\n" +
                                                "  \"insert_before\": 3,\n" +
                                                "  \"range_length\": 2\n" +
                                                "}")
                                        .when()
                                        .put("https://api.spotify.com/v1/playlists/{playlist_id}/tracks");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 201);
    }


    @Test
    public void changePlaylistDetails_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("playlist_id", playListId)
                                        .queryParam("uris", "spotify:track:5W7DOVGQLTigu09afW7QMT")
                                        .body("{\n" +
                                                "  \"name\": \"Updated Playlist \",\n" +
                                                "  \"description\": \"Updated playlist description\",\n" +
                                                "  \"public\": false\n" +
                                                "}")
                                        .when()
                                        .put("https://api.spotify.com/v1/playlists/{playlist_id}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void deletePlaylistItems_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("playlist_id", playListId)
                                        .queryParam("uris", "spotify:track:5W7DOVGQLTigu09afW7QMT")
                                        .body("{\"tracks\":[{\"uri\":\"spotify:track:4iV5W9uYEdYUVa79Axb7Rh\"}]}")
                                        .when()
                                        .delete("https://api.spotify.com/v1/playlists/{playlist_id}/tracks");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


//    --> Tracks Apis <--

    @Test
    public void getTracksAudioAnalysis_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("id", "0EkX4heaF3USfcCQCWidAU")
                                        .when()
                                        .get("https://api.spotify.com/v1/audio-analysis/{id}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }

    @Test
    public void getTracksAudioFeatures_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .queryParam("ids", "0EkX4heaF3USfcCQCWidAU,35JYW9SktSN295Nk4YjDKb")
                                        .when()
                                        .get("https://api.spotify.com/v1/audio-features");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getTracksAudioFeaturess_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("id", "0EkX4heaF3USfcCQCWidAU")
                                        .when()
                                        .get("https://api.spotify.com/v1/audio-features/{id}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getSeveralTracks_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .queryParam("ids", "0EkX4heaF3USfcCQCWidAU,35JYW9SktSN295Nk4YjDKb")
                                        .when()
                                        .get("https://api.spotify.com/v1/tracks");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getTrack_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("id", "0EkX4heaF3USfcCQCWidAU")
                                        .when()
                                        .get("https://api.spotify.com/v1/tracks/{id}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


//    --> Shows Apis <--

    @Test
    public void getSeveralShows_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .queryParam("ids", "0EkX4heaF3USfcCQCWidAU,35JYW9SktSN295Nk4YjDKb")
                                        .when()
                                        .get("https://api.spotify.com/v1/shows");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getShowEpisodes_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("id", "38bS44xjbVVZ3No3ByF1dJ")
                                        .when()
                                        .get("https://api.spotify.com/v1/shows/{id}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getShow_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("id", "38bS44xjbVVZ3No3ByF1dJ")
                                        .when()
                                        .get("https://api.spotify.com/v1/shows/{id}/episodes");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


//    --> Personalization <--
    @Test
    public void getUsersTopItem_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("type", "artist")
                                        .when()
                                        .get("https://api.spotify.com/v1/me/top/{type}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }

//    Markets

    @Test
    public void getAvailableMarkets_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .when()
                                        .get("https://api.spotify.com/v1/markets");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }

//    --> Albums Apis <--

    @Test
    public void getAlbumTrack_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("id", "4aawyAB9vmqN3uQ7FjRGTy")
                                        .when()
                                        .get("https://api.spotify.com/v1/albums/{id}/tracks");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getAlbum_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("id", "4aawyAB9vmqN3uQ7FjRGTy")
                                        .when()
                                        .get("https://api.spotify.com/v1/albums/{id}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getSeveralAlbums_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .queryParam("ids", "0EkX4heaF3USfcCQCWidAU,35JYW9SktSN295Nk4YjDKb")
                                        .when()
                                        .get("https://api.spotify.com/v1/albums");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }

//    Artist Apis

    @Test
    public void getArtistsAlbums_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("id", "0TnOYISbd1XYRBk9myaseg")
                                        .when()
                                        .get("https://api.spotify.com/v1/artists/{id}/albums");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getArtistsRelatedArtists_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("id", "0TnOYISbd1XYRBk9myaseg")
                                        .when()
                                        .get("https://api.spotify.com/v1/artists/{id}/related-artists");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }

//    @Test
//    public void getArtistsTopTrack_ReturnOkStatus() {
//        Response createResult = given().contentType("application/json")
                        //                .accept("application/json")
                        //                .header("Authorization", token)
                        //                .pathParam("id", "0TnOYISbd1XYRBk9myaseg")
                        //                .pathParam("market", "ES")
                        //                .when()
                        //                .get("https://api.spotify.com/v1/artists/{id}/top-tracks");
//        createResult.prettyPrint();
//        Assert.assertEquals(createResult.getStatusCode(), 200);
//    }


    @Test
    public void getArtists_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("id", "0TnOYISbd1XYRBk9myaseg")
                                        .when()
                                        .get("https://api.spotify.com/v1/artists/{id}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getSeveralArtists_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .queryParam("ids", "0EkX4heaF3USfcCQCWidAU,35JYW9SktSN295Nk4YjDKb")
                                        .when()
                                        .get("https://api.spotify.com/v1/artists");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


//    Browse Apis

    @Test
    public void getAvailableGenreSeeds_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .when()
                                        .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }

    @Test
    public void getSeveralBrowseCategories_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .when()
                                        .get("https://api.spotify.com/v1/browse/categories");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getSingleBrowseCategory_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("category_id", "sleep")
                                        .when()
                                        .get("https://api.spotify.com/v1/browse/categories/{category_id}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getCategoryPlaylist_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("category_id", "sleep")
                                        .when()
                                        .get("https://api.spotify.com/v1/browse/categories/{category_id}/playlists");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getFeaturedPlaylist_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .when()
                                        .get("https://api.spotify.com/v1/browse/featured-playlists");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getNewReleases_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .when()
                                        .get("https://api.spotify.com/v1/browse/new-releases");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }

    @Test
    public void getRecommendation_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("seed_artists", "4NHQUGzhtTLFvgF5SZesLK")
                                        .pathParam("seed_genres", "seed_genres")
                                        .pathParam("seed_tracks", "0c6xIDDpzE81m2q797ordA")
                                        .when()
                                        .get("https://api.spotify.com/v1/recommendations/{seed_artists}/{seed_artists}/{seed_tracks}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }

 //  Chapter apis
    @Test
    public void getAChapter_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("id", "0D5wENdkdwbqlrHoaJ9g29a")
                                        .when()
                                        .get("https://api.spotify.com/v1/chapters/{id}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


    @Test
    public void getSeveralChapters_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("ids", "0IsXVP0JmcB2adSE338GkK,3ZXb8FKZGU0EHALYX6uCzU")
                                        .when()
                                        .get("https://api.spotify.com/v1/chapters/{ids}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }

//    Episodes Apis

    @Test
    public void getEpisode_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("id", "512ojhOuo1ktJprKbVcKyQ")
                                        .when()
                                        .get("https://api.spotify.com/v1/episodes/{id}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }

    @Test
    public void getSeveralEpisode_ReturnOkStatus() {
        Response createResult = given().contentType("application/json")
                                        .accept("application/json")
                                        .header("Authorization", token)
                                        .pathParam("ids", "77o6BIVlYM3msb4MMIL1jH,0Q86acNRm6V9GYx55SXKwf")
                                        .when()
                                        .get("https://api.spotify.com/v1/episodes/{ids}");
        createResult.prettyPrint();
        Assert.assertEquals(createResult.getStatusCode(), 200);
    }


}
