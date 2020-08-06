package com.neo.apitest.controller;

import com.neo.apitest.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @GetMapping("/")
    public String apiInfo() {
        commonService.testKhuVuc();
        return "API TEST";
    }
}
