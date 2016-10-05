package com.produt.dbutil.login.dao;

import com.produt.dbutil.jdbc.JDBCUtils;
import com.produt.dbutil.login.service.LoginService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by durban126 on 16/10/5.
 */
public class LoginDao implements LoginService {
    private JDBCUtils jdbcUtils;

    public LoginDao(){
        jdbcUtils = new JDBCUtils();
    }

    public boolean login(List<Object> params) {
        boolean flag = false;
        String sql = "SELECT * FROM userinfo WHERE username = ? AND pass = ?";
        jdbcUtils.getConnection();
        try {
            Map<String, Object> map = jdbcUtils.findSingleResult(sql,params);
            flag = !map.isEmpty() ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release();
        }
        return flag;
    }
}
