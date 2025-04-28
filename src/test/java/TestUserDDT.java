


import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

@TestMethodOrder(OrderAnnotation.class)
public class TestUserDDT {

    static String uriUser = "https://petstore.swagger.io/v2/user";

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/userMassa.csv", numLinesToSkip = 1, delimiter = ',')
    @Order(6)
    public void testPostUserDDT(
        int    id,
        String username,
        String firstName,
        String lastName,
        String email,
        String password,
        String phone,
        int userStatus
    ) {
        User user = new User();
        user.id = id;
        user.username = username;
        user.firstName = firstName;
        user.lastName = lastName;
        user.email = email;
        user.password = password;
        user.phone = phone;
        user.userStatus = userStatus;

        given()
            .contentType(ContentType.JSON)
            .body(new Gson().toJson(user))
        .when()
            .post(uriUser)
        .then()
            .log().all()
            .statusCode(200)
            .body("code", is(200))
            .body("type", is("unknown"))
            .body("message", is(String.valueOf(id))); // Verifica o retorno do ID do usuário
    }
}
