package apiController;

import constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.configController;

import java.util.HashMap;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class employeeApiServiceController {

    static String baseUrl = configController.get("baseUrl");
    static String endpoint = configController.get("studentsPort");

    public static Response addNewEmployee(Object empData) {
        RequestSpecification request = given().baseUri(baseUrl)
                .contentType("application/json")
                .body(empData);

        return request
                .when()
                .post(EndPoints.SING_UP);
    }

    public static Response getAllEmployees() {
        RequestSpecification request = given().baseUri(baseUrl)
                .contentType("application/json");

        return request
                .when()
                .get(EndPoints.SING_UP);
    }

    public static Response getEmployeeById(String employeeId) {
        RequestSpecification request = given().baseUri(baseUrl)
                .contentType("application/json");

        return request
                .when()
                .get(EndPoints.SING_UP + "/" + employeeId);
    }

    public static Response deleteEmployeeById(String empId) {
        RequestSpecification request = given().baseUri(baseUrl)
                .contentType("application/json");

        return request
                .when()
                .delete(EndPoints.SING_UP + "/" + empId);
    }

    public static Response updateEmployeeDetails(String empId, Object updatedEmpData) {
        RequestSpecification request = given().baseUri(baseUrl)
                .contentType("application/json")
                .body(updatedEmpData);

        return request
                .when()
                .put(EndPoints.SING_UP + "/" + empId);
    }

    public static String generateRandomEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder prefix = new StringBuilder();
        Random random = new Random();

        // Generate 8-character random name
        for (int i = 0; i < 8; i++) {
            prefix.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        // Append random 4-digit number
        int randomNumber = 1000 + random.nextInt(9000);

        // Combine parts and domain
        return prefix.toString() + randomNumber + "@testmail.com";
    }

    public static String generateEmployeeId() {
        Random random = new Random();

        // Generate a 4-digit number between 1000 and 9999
        int employeeId = 1000 + random.nextInt(9000);

        // Return as string
        return String.valueOf(employeeId);
    }


}