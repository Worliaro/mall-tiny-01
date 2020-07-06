package com.macro.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * @Classname UmsAdminLoginParam
 * @Description 用户登录参数
 * @Date 2020/7/6 11:41
 * @Creater by weiyao
 */
public class UmsAdminLoginParam {

    @ApiModelProperty(value = "用户名",required = true)
    @NotEmpty
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
