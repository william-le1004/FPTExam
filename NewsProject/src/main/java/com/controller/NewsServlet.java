package com.controller; /**
 * @author Will
 * @project NewsProject
 * @date 7/29/2023
 */

import com.dao.NewsDAO;
import com.model.News;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NewsServlet", value = "/danh-sach")
public class NewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<News> newsList = NewsDAO.getInstance().selectAll();
        int amountOfNews = newsList.size();
        session.setAttribute("amountOfNews",amountOfNews);
        session.setAttribute("newslist",newsList);
        RequestDispatcher rd = request.getRequestDispatcher("views/content.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
