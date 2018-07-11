package com.isa.userengine.servlets;


import com.isa.userengine.cdi.MaxPulseBean;
import com.isa.userengine.dao.UsersRepositoryDao;
import com.isa.userengine.domain.Gender;
import com.isa.userengine.domain.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {
    @EJB
    private UsersRepositoryDao usersRepositoryDao;
    @Inject
    private MaxPulseBean maxPulseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Integer id = Integer.parseInt(idParam);
        User useById = usersRepositoryDao.getUserByld(id);


        PrintWriter writer = resp.getWriter();

        if (useById != null) {
            writer.println("Found user name is: " + useById.getName());

            double pulse = 0D;

            if (useById.getGender().equals(Gender.MAN)) {
                pulse = maxPulseBean.getManMaxPulse(useById.getAge());
            } else if (useById.getGender().equals(Gender.WOMAN)) {
                pulse = maxPulseBean.getWomanPulse(useById.getAge());
            }

            if (pulse != 0D) {
                writer.println("And max pulse is: " + pulse);
            }
        } else {
            writer.println("User not found.");
        }


    }
}