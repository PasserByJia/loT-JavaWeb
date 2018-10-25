package cn.jh.loTWeb.dao;

import cn.jh.loTWeb.domain.Item;
import util.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDao {
    //将构造器定义成私有方法，阻止其它类使用new创建该对象
    private ItemDao() {
    }
    //声明userDao对象引用
    private static ItemDao userDao = null;
    //返回(不是创建)
    public static ItemDao getInstance() {
        //如果UserDao.userDao，才会创建该对象
        if(ItemDao.userDao==null){
            ItemDao.userDao = new ItemDao();
        }
        return ItemDao.userDao;
    }

    public Item find(Integer id) throws SQLException {
        Item item = null;
        Connection connection = JdbcHelper.getConn();
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM item WHERE id=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            Double temperature = resultSet.getDouble("temperature");
            Double humidity = resultSet.getDouble("humidity");
            Double weight = resultSet.getDouble("weight");
            Integer infaredSensor = resultSet.getInt("infaredSensor");
            //以当前记录的各个字段值为参数，创建User对象
            item =
                    new Item(id,temperature,humidity,weight,infaredSensor);
        }
        JdbcHelper.close(preparedStatement,connection);
        return item;
    }


    public boolean update(Item item) throws SQLException{
        Connection connection = JdbcHelper.getConn();
        PreparedStatement preparedStatement =//预编译的语句
                connection.prepareStatement("UPDATE item SET " +
                        "temperature=?," +
                        "humidity=?," +
                        "weight=?," +
                        "infaredSensor=? " +
                        "WHERE id=?");
        preparedStatement.setDouble(1,item.getTemperature());
        preparedStatement.setDouble(2,item.getHumidity());
        preparedStatement.setDouble(3,item.getWeight());
        preparedStatement.setInt(4,item.getInfaredSensor());
        preparedStatement.setInt(5,item.getId());
        int affectedRowNum = preparedStatement.executeUpdate();
        JdbcHelper.close(preparedStatement,connection);
        return affectedRowNum >0;
    }
}
