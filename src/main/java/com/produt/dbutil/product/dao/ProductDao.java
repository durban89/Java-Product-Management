package com.produt.dbutil.product.dao;

import com.produt.dbutil.jdbc.JDBCUtils;
import com.produt.dbutil.product.service.ProductService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public List<Map<String, Object>> listProduct(String proname) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String sql = "SELECT * FROM product WHERE (1=1) ";
        StringBuffer buffer = new StringBuffer(sql);
        List<Object> params = new ArrayList<Object>();
        if (proname != null) {
            buffer.append(" AND proname LIKE ?");
            params.add("%" + proname + "%");
        }
        jdbcUtils.getConnection();
        try {
            list = jdbcUtils.findMoreResult(buffer.toString(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
