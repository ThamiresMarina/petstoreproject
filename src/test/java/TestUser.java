
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestUser {

    static String ct = "application/json";
    static String uriUser = "https://petstore.swagger.io/v2/user";
    static int userid = 2920001;
    String username = "thami";
    String email = "thamiressantos@email.com";
    String password = "123456";
    int[] userStatus = {1, 2};
   

    //Função de leitura de Json
    public static String lerArquivoJson(String arquivoJson) throws IOException{

        return new String(Files.readAllBytes(Paths.get(arquivoJson)));

    }

    @Test @Order(1)
    public void testPostUser() throws IOException{
//carrega os dados de arquivo do user
    String jsonBody = lerArquivoJson("src/test/resources/json/user.json");    

    // Teste via restAssured

       // Criação do usuário
       given()
       .contentType(ct)
       .body(jsonBody)
       .log().all()
   .when()
       .post(uriUser)
   .then()
       .log().all()
       .statusCode(200); // Apenas status aqui

    }

    @Test @Order(2)
    public void testGetUser() throws IOException, InterruptedException{
        Thread.sleep(1000);
   // Validação via GET
   
   int userid = 2920001; // ID do usuário a ser validado
   String username = "thami"; // Nome do usuário a ser validado


   given()
       .contentType(ct)
       .log().all()
   .when()
       .get(uriUser + "/" + username)
   .then()
       .log().all()
       .statusCode(200)
       .body("username", is(username))
       .body("id", is(userid))
       .body("firstName", is("Thamires"))
       .body("lastName", is("Santos"))
       .body("email", is(email))
       .body("password", is(password))
       .body("phone", is("922291111"))
       .body("userStatus", is(userStatus[0]));
    }

    @Test @Order(3)
    public void testLoginUser() {
    String resultadoEsperado = "logged in user session:";   
   
    

        Response resposta = (Response) given()
            .contentType(ct)
            .queryParam("username", username)
            .queryParam("password", password)
            .log().all()
        .when()
            .get(uriUser +  "/login?username=" + username + "&password=" + password)
        .then()
            .log().all()
            .statusCode(200)
            .body("code", is(200))
            .body("type", is("unknown"))        
            .body("message", containsString(resultadoEsperado)) 
            .body("message", hasLength(36))
        .extract()
        .response(); // Extrai a resposta para uma variável Response
            
        
        String token = resposta.jsonPath().getString("message").substring(16);    
        System.out.println("Token extraído: " + token);
     }


    @Test @Order(4)
    public void testPutUser() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/user2.json");
    
        // Atualiza o usuário
        given()
            .contentType(ct)
            .log().all()
            .body(jsonBody)
        .when()
            .put(uriUser + "/" + username)
        .then()
            .log().all()
            .statusCode(200)
            .body("code", is(200))
            .body("type", is("unknown"))
            .body("message", is(String.valueOf(userid)));
    
    }

    @Test @Order(5)
    public void testDeleteUser() throws IOException {
        // Deleta o usuário
        given()
            .contentType(ct)
            .log().all()
        .when()
            .delete(uriUser + "/" + username)
        .then()
            .log().all()
            .statusCode(200) 
            .body("code", is(200))
            .body("type", is("unknown"))
            .body("message", is(String.valueOf(username))); 

    }   

    private void extract() {
        throw new UnsupportedOperationException("Not supported yet.");
    }   
        
        
}

   







