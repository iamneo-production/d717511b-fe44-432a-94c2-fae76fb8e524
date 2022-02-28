package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Slam;
import service.SlamDao;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
    
    private SlamDao slamDao;

    public void init(){
        slamDao = new SlamDao();
    }


    public void doGet(HttpServletRequest req, HttpServletResponse res){
        System.out.println("Inside Home Servlet");
        List<Slam> slamList = slamDao.viewAllSlams();
        req.setAttribute("slams", slamList);
        try {
            req.getRequestDispatcher("home.jsp").forward(req, res);
        } catch (ServletException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };

    }

}
