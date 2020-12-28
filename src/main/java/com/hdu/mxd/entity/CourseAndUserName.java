package com.hdu.mxd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseAndUserName {
    private  int cId;
    private String cName;
    private String username;
    private int uId;
//    private List<User> user;
}
