package com.produt.dbutil.product.json;

import com.produt.dbutil.product.dao.ProductDao;
import com.produt.dbutil.product.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by durban126 on 16/10/6.
 */
public class ProductJsonAction extends HttpServlet {

    private ProductService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        String actionFlag = req.getParameter("action_flag");
        if(actionFlag.equals("single")){
            String proid = req.getParameter("proid");
            Map<String, Object> map = service.viewProduct(proid);
            String jsonString = JsonTool.createJsonString("product", map);
            out.print(jsonString);
        } else if(actionFlag.equals("more")){
            String proname = req.getParameter("proname");
            proname = proname == null ? "" : proname;
            List<Map<String, Object>> list = service.listProduct(proname);
            String jsonString = JsonTool.createJsonString("products", list);
            out.print(jsonString);
        }

        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        service = new ProductDao();
    }
}
