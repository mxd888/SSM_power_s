package com.hdu.mxd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sclass")  //对数据表名注解
public class Sclass {

    // @TableId(value = “id”, type = IdType.AUTO)  表主键标识
    @TableId(value = "s_id")
    private int sId;
    @TableField  //  表字段标识
    private String sName;
    @TableField
    private String sNum;
}
