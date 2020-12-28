package com.hdu.mxd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by DELL(mxd) on 2020/12/28 13:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuInCourseAll {
    private String username;
    private String password;
    private List<Course> courses;
}
