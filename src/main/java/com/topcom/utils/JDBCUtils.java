package com.topcom.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.ElasticSearchDruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Properties;

/**
 * @function: jdbc连接elasticsearch
 * @auther: Create by wyf
 * @date: 2019/3/29
 * @version: v1.0
 */
public class JDBCUtils {

    public static String esHost = null;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new InputStreamReader(JDBCUtils.class.getClassLoader().getResourceAsStream("application.properties"), "UTF-8"));
            esHost = properties.getProperty("elasticsearch.host.ip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * jdbc获取connection
     *
     * @return
     */
    public static Connection getConnection() {

        Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.put("url", "jdbc:elasticsearch://" + JDBCUtils.esHost);
            DruidDataSource dds = (DruidDataSource) ElasticSearchDruidDataSourceFactory.createDataSource(properties);
            connection = dds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * connection close
      * @param connection
     */
    public  static void connClose(Connection connection){
        if (connection !=null){
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * dds close
     * @param dds
     */
    public  static void ddsClose(DruidDataSource dds){
        if (dds !=null){
            try {
                dds.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
