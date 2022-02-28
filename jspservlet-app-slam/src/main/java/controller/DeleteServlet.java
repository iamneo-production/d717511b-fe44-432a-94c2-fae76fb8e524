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

@WebServlet("/DeleteSlam")
public class DeleteServlet  extends HttpServlet{
    
    private SlamDao slamDao;

    public void init(){
        slamDao = new SlamDao();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        
        String message = null;

        Integer slamId = Integer.parseInt(req.getParameter("slamId"));
        int status = slamDao.deleteSlamById(slamId);
        
        if(status!=0){
            message = "Slam deleted successfully";
        } else {
            message = "Error deleting slam. Please try again";
        }
        
        List<Slam> slamList = slamDao.viewAllSlams();
        req.setAttribute("slams", slamList);
        req.setAttribute("message", message);
        try {
            req.getRequestDispatcher("home.jsp").forward(req, res);
        } catch (ServletException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };
    }

}
