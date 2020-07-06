package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.mbg.model.UmsPermission;

import java.util.List;

/**
 * @Classname UmsAdminService
 * @Description ToDo
 * @Date 2020/7/6 8:16
 * @Creater by weiyao
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);


    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long id);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的token
     */
    String login(String username, String password);

    /**
     * 注册功能
     * @param umsAdminParam
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdminParam);
}
