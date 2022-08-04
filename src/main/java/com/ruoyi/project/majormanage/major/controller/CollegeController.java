package com.ruoyi.project.majormanage.major.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.majormanage.major.domain.College;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/majormanage/college")
public class CollegeController extends BaseController {
    private String prefix = "majormanage/college";

    @GetMapping()
    public String college() { return  prefix + "/list"; }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(College college){
        startPage();
//        List<College> list =
        return null;
    }
}
