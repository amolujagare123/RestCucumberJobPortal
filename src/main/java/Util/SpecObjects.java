package Util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class SpecObjects {

    public static RequestSpecification getRequestSpecObject()
    {
        return  new RequestSpecBuilder()
                .setBaseUri("http://localhost:9897/")
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }


}
