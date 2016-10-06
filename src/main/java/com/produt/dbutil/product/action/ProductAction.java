package com.produt.dbutil.product.action;

import com.produt.dbutil.product.dao.ProductDao;
import com.produt.dbutil.product.service.ProductService;
import com.produt.dbutil.util.DividePage;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by durban126 on 16/10/6.
 */
public class ProductAction extends HttpServlet {
    private ProductService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String actionFlag = req.getParameter("action_flag");
        if (actionFlag.equals("add")) {
            addProduct(req, resp);
        } else if (actionFlag.equals("list")) {
            listProduct(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String actionFlag = req.getParameter("action_flag");
        if (actionFlag.equals("add")) {
            addProduct(req, resp);
        } else if (actionFlag.equals("list")) {
            listProduct(req, resp);
        }
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String proname = req.getParameter("proname");

        int recordCount = service.getItemCount();
        int currentPage = 1;
        String pageNum = req.getParameter("page_num");
        if(pageNum != null){
            currentPage = Integer.parseInt(pageNum);
        }

        DividePage dividePage = new DividePage(5,recordCount, currentPage);
        int start = dividePage.getFromIndex();
        int end = dividePage.getToIndex();

        List<Map<String, Object>> list = service.listProduct(proname, start, end);

        req.setAttribute("dividePage", dividePage);
        req.setAttribute("listProduct", list);
        req.setAttribute("proname", proname);
        req.getRequestDispatcher("/product/item.jsp").forward(req, resp);
    }


    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //表单含有文件要处理
        String path = req.getContextPath();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

        //构建一个文件上传类
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setFileSizeMax(3 * 1024 * 1024);
        servletFileUpload.setSizeMax(6 * 1024 * 1024);

        List<FileItem> list = null;
        List<Object> params = new ArrayList<Object>();
        try {
            list = servletFileUpload.parseRequest(req);
            //取出所有表单的值：判断非文本字段和文本字段
            for (FileItem fileItem : list) {
                if (fileItem.isFormField()) {
                    if (fileItem.getFieldName().equals("proname")) {
                        params.add(fileItem.getString("utf-8"));
                    }

                    if (fileItem.getFieldName().equals("proprice")) {
                        params.add(fileItem.getString("utf-8"));
                    }

                    if (fileItem.getFieldName().equals("proaddress")) {
                        params.add(fileItem.getString("utf-8"));
                    }
                } else {
                    String image = fileItem.getName();
                    params.add(image);
                    String uploadPath = req.getRealPath("/upload");
                    File realPath = new File(uploadPath + "/" + image);

                    fileItem.write(realPath);

                    //把数据插入数据库
                    boolean flag = service.addProduct(params);
                    if (flag) {
                        resp.sendRedirect(path + "/servlet/ProductAction?action_flag=list");
                    }
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        service = new ProductDao();
    }
}
