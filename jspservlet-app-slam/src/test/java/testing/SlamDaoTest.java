package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
 
import java.sql.Connection;
import java.sql.SQLException;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
 
import model.BlogList;
import service.SlamDao;
 
class SlamDaoTest {
     
    private static SlamDao dao;
     
    @BeforeAll
    static void init() {
        Connection conn = ConnectionManager.getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dao = new SlamDao(conn);
    }
     
    @AfterAll
    static void teardown() {
        Connection conn = ConnectionManager.getConnection();
        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    @Test
    void addListTest() {
        Slam list = new Slam();
        list.setToWhom("Alice");
        list.setAboutThem("sweet hearted");
        list.setBestMemories("hostel life");
        dao.addSlam(list);
        Slam listFromDb = dao.viewSlamById(1);
        assertEquals("Alice", listFromDb.getToWhom(), "Name must be equal");
    }
    
    @Test
    void deleteListTest() {
        dao.deleteSlam(1);
        Slam listFromDb = dao.viewSlamById(1);
        assertNull(listFromDb.getToWhom(), "Slam should be null");
    }
    
    @Test
    void updateListTest() {
        Slam list = new Slam();
        list.setToWhom("Alice");
        list.setAboutThem("sweet hearted");
        list.setBestMemories("hostel life");
        dao.addSlam(list);
        list.setToWhom("Julie");
        dao.updateSlam(list);
        Slam listFromDb = dao.viewSlamById(1);
        assertEquals("Julie", listFromDb.getToWhom(), "Name must be equal");
    }
 
}