package com.lin.service;  
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;  
  
import com.lin.baseTest.SpringTestCase;  
import com.lin.domain.User;  
  
/** 
 * 功能概要：UserService单元测试 
 *  
 * @author linbingwen 
 * @since  2015年9月28日  
 */  
public class UserServiceTest extends SpringTestCase {  
    @Autowired  
    private UserService userService;  
    Logger logger = Logger.getLogger(UserServiceTest.class);  
      
    @Test  
    public void selectUserByIdTest(){  
        User user = userService.selectUserById(10);  
        logger.debug("查找结果" + user);  
    }  
      
    @Test
    public void jdbcTest() throws SQLException, ClassNotFoundException{
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/learning", "root", "123456");
    	Statement statement=connection.createStatement();
    	ResultSet rs=statement.executeQuery("select * from t_user");
    	while(rs.next()){
    		System.out.println(rs.getString(1));
    	}
    }
  
}  
