package com.produt.dbutil.product.service;

import java.util.List;
import java.util.Map;

/**
 * Created by durban126 on 16/10/6.
 */
public interface ProductService {
    public boolean addProduct(List<Object> params);

    public List<Map<String, Object>> listProduct(String proname);

    public List<Map<String, Object>> listProduct(String proname, int start, int end);

    public int getItemCount();

    public boolean delProduct(String[] ids);

    public Map<String, Object> viewProduct(String proid);
}
