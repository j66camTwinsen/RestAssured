package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

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
        return Request.get(resource);
    }

    public static void getWithPathParams(String url, Map<String, String> pathParams) {
        Request.pathParams(pathParams);
        Request.get(url);
    }

    public ResponseOptions<Response> postWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> body) {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);
    }

}
