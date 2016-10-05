package com.produt.dbutil.register.dao;

import com.produt.dbutil.jdbc.JDBCUtils;
import com.produt.dbutil.register.service.RegisterService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by durban126 on 16/10/5.
 */
public class RegisterDao implements RegisterService {
    private JDBCUtils jdbcUtils;

    public RegisterDao(){
        jdbcUtils = new JDBCUtils();
    }

    public boolean ResigterUser(List<Object> params) {
        boolean flag = false;

        jdbcUtils.getConnection();
        String sql = "insert into userinfo (username,pass) values (?,?)";

        try {
            flag = jdbcUtils.updateByPreparedStatement(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release();
        }
        return flag;

    }
}
