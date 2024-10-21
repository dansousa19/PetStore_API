import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreTests {

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void deveCadastrarNovoPedidoDePetComSucesso() {

        String novoPedido = gerarDadosNovoPedido(1, 789, "2024-10-19T14:52:00.000+0000", "placed", true);

        given()
                .contentType(ContentType.JSON)
                .body(novoPedido)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .body("petId", equalTo(789))
                .body("status", equalTo("placed"))
                .log().all();
    }

    @Test
    public void deveRetornarErroAoPesquisarPetInexistente() {
        int petIdInexistente = 9999999;

        given()
                .when()
                .get("/pet/" + petIdInexistente)
                .then()
                .statusCode(404)
                .body("message", equalTo("Pet not found"))
                .log().all();
    }

    @Test
    public void deveAtualizarDadosDePetExistente() {

        String dadosPetAtualizados = gerarDadosAtualizacaoPet(789, "Max", "available");

        given()
                .contentType(ContentType.JSON)
                .body(dadosPetAtualizados)
                .when()
                .put("/pet")
                .then()
                .statusCode(200)
                .body("name", equalTo("Max"))
                .body("status", equalTo("available"))
                .log().all();
    }

    @Test
    public void deveRetornarPetsComStatusPending() {

        given()
                .queryParam("status", "pending")
                .when()
                .get("/pet/findByStatus")
                .then()
                .statusCode(200)
                .body("[0].status", equalTo("pending"))
                .log().all();
    }


    private String gerarDadosNovoPedido(int orderId, int petId, String shipDate, String status, boolean complete) {
        return "{ \"id\": " + orderId + ", \"petId\": " + petId + ", \"quantity\": 1, \"shipDate\": \"" + shipDate + "\", \"status\": \"" + status + "\", \"complete\": " + complete + " }";
    }


    private String gerarDadosAtualizacaoPet(int petId, String nome, String status) {
        return "{ \"id\": " + petId + ", \"name\": \"" + nome + "\", \"status\": \"" + status + "\" }";
    }
}
