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

@WebServlet("/UpdateSlam")
public class UpdateServlet  extends HttpServlet{
    
    private SlamDao slamDao;

    public void init(){
        slamDao = new SlamDao();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        
        Integer slamId = Integer.parseInt(req.getParameter("slamId"));

        Slam slam = slamDao.viewSlamById(slamId);

        req.setAttribute("message", "Update slam book to your friend");
        req.setAttribute("slam", slam);
        try {
            req.getRequestDispatcher("update.jsp").forward(req, res);
        } catch (ServletException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res){

        String message = null;
        Slam slam = new Slam();
        slam.setSlamId(Integer.parseInt(req.getParameter("slamId")));
        slam.setToWhom(req.getParameter("enterNameToWhom"));
        slam.setAboutThem(req.getParameter("enterAbout"));
        slam.setBestMemories(req.getParameter("enterBestMemories"));

        int status = slamDao.updateSlam(slam);

        if(status !=0){
            message = "Slam updated successfully ";
        } else {
            message = "Error updating slam. Please try again.";
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
