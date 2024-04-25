package ge.tbc.tbcacademy.data.dao;

import ge.tbc.tbcacademy.data.dao.daoutils.MSSQLConnection;
import ge.tbc.tbcacademy.data.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User getUserById(int id) throws SQLException {
        String preparedQuery = "SELECT * FROM users WHERE UserID=?";
        PreparedStatement pstmt = null;
        User exactUser = null;

        try(Connection conn = MSSQLConnection.connect()){
            pstmt = conn.prepareStatement(preparedQuery);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                int studentId = rs.getInt(1);
                String firstName = rs.getString("Username");
                String lastName = rs.getString("Password");
                exactUser = new User(studentId, firstName, lastName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exactUser;
    }
}
