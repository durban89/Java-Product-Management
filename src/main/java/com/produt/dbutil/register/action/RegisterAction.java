package com.produt.dbutil.register.action;

import com.produt.dbutil.register.dao.RegisterDao;
import com.produt.dbutil.register.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by durban126 on 16/10/5.
 */
public class RegisterAction extends HttpServlet {

    private RegisterService service;

    public RegisterAction(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        String path = req.getContextPath();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String pass = req.getParameter("pass");
        out.println("username = " + username);
        out.println("pass = " + pass);

        List<Object> params = new ArrayList<Object>();
        params.add(username);
        params.add(pass);

        boolean flag = service.ResigterUser(params);

        if(flag){
            resp.sendRedirect(path + "/index.jsp");
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        this.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();

        service = new RegisterDao();
    }
}
