package com.cx.controller;

import com.alibaba.fastjson.JSON;
import com.cx.service.OpenRecordService;
import com.cx.service.RepaymentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/v1")
public class DTest {

    @Autowired
    private OpenRecordService openRecordService;

    @Autowired
    private RepaymentPlanService repaymentPlanService;

    @GetMapping("/demo1")
    @ResponseBody
    public String demo1(){
        repaymentPlanService.selectAllRepaymentPlan();
        return "";
    }
}
