package com.testSerenity.stories;


import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

//para ejecutar con serenityBDD
@RunWith(SerenityRunner.class)
public class SerenityTest1 {

    //definir before
    @BeforeClass
    public static void setURI(){
       // RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.baseURI = "https://reqres.in/";
    }
    //los metodos que vamos agregar son para cada caso de prueba

    // /pet/findByStatus

    @Test
    public void getPetStatus(){
        //agregar rest
        //RestAssured.given().when().get("/pet/findByStatus").then().log().all().statusCode(200);
        SerenityRest.given().when().get("/api/users?page=2").then().log().all().statusCode(200);
    }
    //test que fallado
    @Test
    public  void getUsersInformation(){
        SerenityRest.given().when().get("/api/users?page=2").then().log().all().statusCode(500);
    }

    //no se ejecutara
    @Pending
    @Test
    public void getUsersInformationSkipped(){
        SerenityRest.given().when().get("/api/users?page=2").then().log().all().statusCode(500);
    }
    //error

    @Test
    public void getUsersInformationError(){
        System.out.println(1/0);
    }
    //cachar los errores
    @Ignore
    @Test
    public void getUsersIgnore(){
        System.out.println(1/0);
    }


    @Test
    public void getUsersCompromise() throws FileNotFoundException {
        File f = new File("c:\\test\\testing\\doc.xls");
        FileReader fr= new FileReader("f");

    }
    @Manual
    @Test
    public void getUsersCompromise_Manual() throws FileNotFoundException {

        SerenityRest.given().when().get("/api/users?page=2").then().log().all().statusCode(500);
    }

}
