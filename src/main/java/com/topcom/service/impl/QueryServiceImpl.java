package com.topcom.service.impl;

import com.topcom.dao.QueryDao;
import com.topcom.service.QueryService;
import net.sf.json.JSONArray;

/**
 * @function:
 * @auther: Create by wyf
 * @date: 2019/3/29
 * @version: v1.0
 */
public class QueryServiceImpl implements QueryService {

    QueryDao dao = new QueryDao();

    @Override
    public JSONArray query(String index) {
        return dao.query(index);
    }
}
