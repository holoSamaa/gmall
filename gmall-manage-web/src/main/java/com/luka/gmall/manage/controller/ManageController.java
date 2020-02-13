package com.luka.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.luka.gmall.bean.*;
import com.luka.gmall.service.ManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author horo
 */
@RestController
@CrossOrigin
public class ManageController {
    @Reference
    private ManageService manageService;

    @RequestMapping("/getCatalog1")
    public List<BaseCatalog1> getCatalog1(){
        return manageService.getCatalog1();
    }

    @RequestMapping("/getCatalog2")
    public List<BaseCatalog2> getCatalog2(String catalog1Id){
        return manageService.getCatalog2(catalog1Id);
    }

    @RequestMapping("/getCatalog3")
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        return manageService.getCatalog3(catalog2Id);
    }

    @RequestMapping("/attrInfoList")
    public List<BaseAttrInfo> attrinfoList(String catalog3Id){
        return manageService.getAttrList(catalog3Id);
    }

    @RequestMapping("/saveAttrInfo")
    public void SaveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        manageService.saveAttrInfo(baseAttrInfo);
    }

    @RequestMapping(value = "/getAttrValueList", method = RequestMethod.POST)
    public List<BaseAttrValue> getAttrValueList(String attrId){
        return manageService.getAttrInfo(attrId).getAttrValueList();
    }

    @RequestMapping("/spuList")
    public List<SpuInfo> getSpuInfoList(String catalog3Id){
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);
        return manageService.getSpuInfoList(spuInfo);
    }
}

