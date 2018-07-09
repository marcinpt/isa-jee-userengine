package com.isa.userengine.servlets;


import com.isa.userengine.dao.UsersRepositoryDaoBean;
import com.isa.userengine.domain.User;
import com.isa.userengine.dao.UsersRepositoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {

    private UsersRepositoryDao userRepositoryDao;

    public void init() throws ServletException {
        super.init();
        userRepositoryDao = new UsersRepositoryDaoBean();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idParam = req.getParameter("id");
        String nameParam = req.getParameter("name");
        String loginParam = req.getParameter("login");
        String passwordParam = req.getParameter("password");
        String ageParam = req.getParameter("age");

        if (!isParamValid(idParam, nameParam, loginParam, passwordParam, ageParam)) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        User user = new User();
        user.setId(Integer.parseInt(idParam));
        user.setName(nameParam);
        user.setLogin(loginParam);
        user.setPassword(passwordParam);
        user.setAge(Integer.parseInt(ageParam));

        userRepositoryDao.addUser(user);

    }

    private boolean isParamValid(String... params) {

        for (String param : params) {
            if (param == null || param.isEmpty()) {
                return false;
            }
        }

        return true;
    }
}