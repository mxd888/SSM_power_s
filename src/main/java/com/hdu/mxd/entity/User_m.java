package com.hdu.mxd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by DELL(mxd) on 2020/12/10 23:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_m {


    private int id;
    private String username;
    private String password;
    private int s_num;
    private Sclass sclass;
    private List<Course> courses;
}
