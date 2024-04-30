package ge.tbc.tbcacademy.data.steps;
import ge.tbc.tbcacademy.data.dao.UserDao;
import ge.tbc.tbcacademy.data.model.User;
import java.sql.SQLException;

public class DatabaseSteps {
    private User currentUser;
    private Object[][] priceData;

    public void getUserFromDb(int id) {
        try {
            UserDao userDao = new UserDao();
            currentUser = userDao.getUserById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public User getCurrentUser() {
        return currentUser;
    }
}
