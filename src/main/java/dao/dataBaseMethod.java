package dao;


import lib.getConfig;

import java.io.IOException;
import java.sql.*;

public class dataBaseMethod {


    //获取数据库Connection对象
    public Connection getDataBaseConnection() {
        getConfig get=new getConfig();
        Connection conn=null;
        try {
            Class.forName(get.getValueByKey("dataBaseDriver"));
            conn= DriverManager.getConnection(get.getValueByKey("dataBaseUrl"),get.getValueByKey("dataBaseUserName"),get.getValueByKey("dataBasePassword"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    //查询数据库
    public void getDataFromDataBase(String sql){

        try {
            Connection conn = getDataBaseConnection();
            PreparedStatement sta=conn.prepareStatement(sql);
            ResultSet result = sta.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }






}
