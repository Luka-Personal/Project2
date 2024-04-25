package ge.tbc.tbcacademy.data.model;

public class User {
    private final int userId;
    private final String userName, password;

    public User(int userId, String userName, String password)
    {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }
    public String getUserName() {
        return this.userName;
    }
    public String getPassword() {
        return this.password;
    }
    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + userId +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
