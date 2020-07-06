package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.mbg.model.UmsPermission;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * @Classname UmsAdminRoleRelationDao
 * @Description 后台用户与角色管理自定义Dao
 * @Date 2020/7/6 9:58
 * @Creater by weiyao
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
