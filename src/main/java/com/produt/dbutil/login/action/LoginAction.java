package com.produt.dbutil.login.action;

import com.produt.dbutil.login.dao.LoginDao;
import com.produt.dbutil.login.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by durban126 on 16/10/5.
 */
public class LoginAction extends HttpServlet {
    private LoginService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        String path = req.getContextPath();

        String username = req.getParameter("username");
        String pass = req.getParameter("pass");

        List<Object> params = new ArrayList<Object>();
        params.add(username);
        params.add(pass);
        boolean flag = service.login(params);

        if (flag) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect(path + "/main.jsp");
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        service = new LoginDao();
    }
}
