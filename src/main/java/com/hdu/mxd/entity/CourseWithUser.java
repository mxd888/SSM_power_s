package com.hdu.mxd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseWithUser {
    private  int cId;
    private String cName;
    private List<User> user;
}
