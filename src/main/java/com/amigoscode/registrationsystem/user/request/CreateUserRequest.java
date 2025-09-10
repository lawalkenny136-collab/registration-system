package com.amigoscode.registrationsystem.user.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequest {

    @JsonProperty(required = true)
    String firstName;
    @JsonProperty(required = false)
    String lastname;

}
