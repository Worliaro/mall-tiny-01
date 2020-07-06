package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.UmsAdminLoginParam;
import com.macro.mall.tiny.mbg.model.UmsPermission;
import com.macro.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname UmsAdminController
 * @Description ToDo
 * @Date 2020/7/6 11:39
 * @Creater by weiyao
 */
@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation("登录以后返回token")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam,BindingResult result){
        String token = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if(token==null){
            return CommonResult.validateFailed("用户名或密码错误");
        }
        HashMap<String, String> tokenMap  = new HashMap<>();
        tokenMap .put("token",token);
        tokenMap .put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap );
    }


//    @ApiOperation(value = "用户注册")
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result) {
//        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
//        if (umsAdmin == null) {
//            CommonResult.failed();
//        }
//        return CommonResult.success(umsAdmin);
//    }
//
    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = umsAdminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }

}
