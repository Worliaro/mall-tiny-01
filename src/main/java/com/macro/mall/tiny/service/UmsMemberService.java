package com.macro.mall.tiny.service;

import com.macro.mall.tiny.common.api.CommonResult;

/**
 * @Classname UmsMemberService
 * @Description ToDo
 * @Date 2020/7/3 15:38
 * @Creater by weiyao
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     * @param telephone
     * @return
     */
    CommonResult generateAuthCode(String telephone);


    /**
     * 判断手机号和验证码是否匹配
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone,String authCode);

}
