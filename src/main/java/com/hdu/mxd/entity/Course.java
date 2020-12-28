package com.hdu.mxd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "course")
public class Course {
    @TableId(value = "c_id")
    private  int cId;
    @TableField
    private String cName;
    @TableField(exist = false)
    private List<User> user;

    public Course(int cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }
}
