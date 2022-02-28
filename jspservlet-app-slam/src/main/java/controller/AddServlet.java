package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Slam;
import service.SlamDao;

@WebServlet("/AddSlam")
public class AddServlet  extends HttpServlet{
    
    private SlamDao slamDao;

    public void init(){
        slamDao = new SlamDao();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("Inside Add Servlet do get");
        req.setAttribute("message", "Add slam book to your friend");
        try {
            req.getRequestDispatcher("/add.jsp").forward(req, res);
        } catch (ServletException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res){

        String message = null;
        Slam slam = new Slam();
        slam.setToWhom(req.getParameter("enterNameToWhom"));
        slam.setAboutThem(req.getParameter("enterAbout"));
        slam.setBestMemories(req.getParameter("enterBestMemories"));

        int status = slamDao.addSlam(slam);

        if(status !=0){
            message = "Slam added successfully";
        } else {
            message = "Error adding slam. Please try again.";
        }

        req.setAttribute("message", message);
        try {
            req.getRequestDispatcher("add.jsp").forward(req, res);
        } catch (ServletException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };
    }
}
