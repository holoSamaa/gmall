package com.luka.gmall.service;

import com.luka.gmall.bean.*;

import java.util.List;

/**
 * @author horo
 */
public interface ManageService {
    /**
     * 获取分类信息
     * @return
     */
    List<BaseCatalog1> getCatalog1();

    /**
     * 获取二级分类信息
     * @param catalog1Id
     * 一级分类ID
     * @return
     */
    List<BaseCatalog2> getCatalog2(String catalog1Id);

    /**
     * 获取三级分类信息
     * @param catalog2Id
     * 二级分类ID
     * @return
     */
    List<BaseCatalog3> getCatalog3(String catalog2Id);

    /**
     * 获取基础属性
     * @param catalog3Id
     * 三级分类ID
     * @return
     */
    List<BaseAttrInfo> getAttrList(String catalog3Id);

    /**
     * 保存属性
     * @param baseAttrInfo
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
     * 获取属性
     * @param attrId
     * @return
     */
    BaseAttrInfo getAttrInfo(String attrId);

    /**
     * 获取spu信息
     * @param spuInfo
     * @return
     */
    List<SpuInfo> getSpuInfoList(SpuInfo spuInfo);
}
