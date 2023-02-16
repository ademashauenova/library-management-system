import java.util.List;

public interface Users {
    boolean createUser(User user);
    User getUser(int id);
    List<User> getAllUsers();
}