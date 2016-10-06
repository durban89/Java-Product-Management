package com.produt.dbutil.product.dao;

import com.produt.dbutil.jdbc.JDBCUtils;
import com.produt.dbutil.product.service.ProductService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by durban126 on 16/10/6.
 */
public class ProductDao implements ProductService {

    private JDBCUtils jdbcUtils;

    public ProductDao() {
        jdbcUtils = new JDBCUtils();
    }

    public boolean addProduct(List<Object> params) {
        boolean flag = false;
        String sql = "INSERT INTO product (proname,proprice,proaddress,proimage) VALUES (?,?,?,?)";
        try {
            jdbcUtils.getConnection();
            flag = jdbcUtils.updateByPreparedStatement(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release();
        }

        return flag;
    }
}
