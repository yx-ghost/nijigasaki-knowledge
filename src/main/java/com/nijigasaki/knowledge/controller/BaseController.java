package com.nijigasaki.knowledge.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nijigasaki.knowledge.model.entity.BaseEntity;
import com.nijigasaki.knowledge.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BaseController<T extends BaseEntity,S extends IService<T>> {
    @Autowired
    S baseService;

    @PostMapping("/add")
    public Boolean add(@RequestBody T t) {
        return baseService.save(t);
    }

    @PostMapping("/edit")
    public Boolean edit(@RequestBody T t) {
        return baseService.updateById(t);
    }

//    @GetMapping("/list")
//    public IPage<T> list() {
//        return baseService.page();
//    }

}
