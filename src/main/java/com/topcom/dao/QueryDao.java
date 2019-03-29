package com.topcom.dao;

import com.alibaba.druid.pool.DruidPooledResultSet;
import com.topcom.utils.JDBCUtils;
import net.sf.json.JSONArray;


import java.sql.*;

/**
 * @function: 查询es dao
 * @auther: Create by wyf
 * @date: 2019/3/29
 * @version: v1.0
 */
public class QueryDao {


    public JSONArray query(String index) {

        Connection connection = JDBCUtils.getConnection();

        JSONArray jsonArray = new JSONArray();

        String sql = "SELECT  id,type,title,content from " + index + "   where type ='NEWS' limit 10";

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            DruidPooledResultSet resultSet = (DruidPooledResultSet) ps.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String content = resultSet.getString("title");
                System.out.println(id + "*********" + content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.connClose(connection);
        }
        return jsonArray;
    }
}
