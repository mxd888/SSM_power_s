package com.hdu.mxd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String username;
    private String password;
    private Integer sId;


    public User(String username, String password, Integer sId) {
        this.username = username;
        this.password = password;
        this.sId = sId;
    }
}

