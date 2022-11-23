package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class APIUtilities {

    public static RequestSpecification Request;

    public APIUtilities() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(FetchEnvParamsValues.fetchParamValue("BASE_URL_API_ENV"));
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        Request = RestAssured.given()
                .spec(requestSpec)
                .header("Accept", "application/json")
                .header("X-ApiKey", "service246");
    }

    public static ResponseOptions<Response> get(String resource) {
        try {
            return Request.get(new URI(resource));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void getWithPathParams(String url, Map<String, String> pathParams) {
        Request.pathParams(pathParams);
        try {
            Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public ResponseOptions<Response> postWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> body) {
        Request.pathParams(pathParams);
        Request.body(body);
        try {
            return Request.post(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

}
