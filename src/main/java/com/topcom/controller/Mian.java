package com.topcom.controller;

import com.topcom.service.QueryService;
import com.topcom.service.impl.QueryServiceImpl;
import net.sf.json.JSONArray;

/**
 * @function:
 * @auther: Create by wyf
 * @date: 2019/3/29
 * @version: v1.0
 */
public class Mian {
    public static void main(String[] args) {
        QueryService queryService =  new QueryServiceImpl();
        JSONArray array = queryService.query("yuqing_2019_3_6");
        System.out.println(array.toString());
    }
}
