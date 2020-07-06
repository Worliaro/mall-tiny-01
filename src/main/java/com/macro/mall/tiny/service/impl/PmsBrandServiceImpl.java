package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.PmsBrandMapper;
import com.macro.mall.tiny.mbg.model.PmsBrand;
import com.macro.mall.tiny.mbg.model.PmsBrandExample;
import com.macro.mall.tiny.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname PmsBrandServiceImpl
 * @Description ToDo
 * @Date 2020/7/3 12:07
 * @Creater by weiyao
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {

        List<PmsBrand> pmsBrands = pmsBrandMapper.selectByExample(new PmsBrandExample());
        return pmsBrands;
    }
}
