package com.aamir.auth;


import lombok.Data;

@Data
public class User {
    private Type type;
    private Profile profile;
}
