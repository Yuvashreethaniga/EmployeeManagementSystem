package data;

import java.util.List;
import io.restassured.response.Response;
import lombok.Data;

public class EmployeeData {
    private String id ;

    public Response getSingUpResponse() {
        return singUpResponse;
    }

    public void setSingUpResponse(Response singUpResponse) {
        this.singUpResponse = singUpResponse;
    }

    public Response getLoginResponse() {
        return loginResponse;
    }

    public void setLoginResponse(Response loginResponse) {
        this.loginResponse = loginResponse;
    }

    public Response getGeEmployeeDetailsByIdResponse() {
        return geEmployeeDetailsByIdResponse;
    }

    public void setGeEmployeeDetailsByIdResponse(Response geEmployeeDetailsByIdResponse) {
        this.geEmployeeDetailsByIdResponse = geEmployeeDetailsByIdResponse;
    }

    public Response getDeleteEmployeeResponse() {
        return deleteEmployeeResponse;
    }

    public void setDeleteEmployeeResponse(Response deleteEmployeeResponse) {
        this.deleteEmployeeResponse = deleteEmployeeResponse;
    }

    public List<Response> getFetchAllEmployees() {
        return fetchAllEmployees;
    }

    public void setFetchAllEmployees(List<Response> fetchAllEmployees) {
        this.fetchAllEmployees = fetchAllEmployees;
    }

    private  String name;
    private String location;
    private  String emailID;
    private Response singUpResponse;
    private Response loginResponse;
    private Response geEmployeeDetailsByIdResponse;
    private Response deleteEmployeeResponse;
    private List<Response> fetchAllEmployees;

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getSkills() {
        return Skills;
    }

    public void setSkills(String[] skills) {
        Skills = skills;
    }

    private String phone;
    private String Skills[] ;
}
