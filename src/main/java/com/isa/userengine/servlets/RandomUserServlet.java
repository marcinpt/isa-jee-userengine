package com.isa.userengine.servlets;

import com.isa.userengine.cdi.RandomUserCDIApplicationDao;
import com.isa.userengine.cdi.RandomUserCDIRequestDao;
import com.isa.userengine.cdi.RandomUserCDISessionDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/random-user")
public class RandomUserServlet extends HttpServlet {

    @Inject
    private RandomUserCDIRequestDao randomUserCDIRequestDao;

    @Inject
    private RandomUserCDISessionDao randomUserCDISessionDao;

    @Inject
    private RandomUserCDIApplicationDao randomUserCDIApplicationDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.println("Request scoped: " + randomUserCDIRequestDao.getRandomUser().toString());
        writer.println("Session scoped: " + randomUserCDISessionDao.getRandomUser().toString());
        writer.println("Application scoped: " + randomUserCDIApplicationDao.getRandomUser().toString());
    }
}