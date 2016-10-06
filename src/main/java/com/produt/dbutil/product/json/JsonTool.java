package com.produt.dbutil.product.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by durban126 on 16/10/6.
 */
public class JsonTool {

    public static String createJsonString(String key, Map<String, Object> data){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(key, data);
        String json = JSON.toJSONString(map);
        return json;
    }

    public static String createJsonString(String key, List<Map<String, Object>> data){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(key, data);
        String json = JSON.toJSONString(map);
        return json;
    }
}
