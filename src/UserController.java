import java.util.List;

public class UserController {
    private final Users repo;

    public UserController(Users repo) {
        this.repo = repo;
    }

    public String createUser(String name, String surname) {
        User user = new User(name, surname);

        boolean created = repo.createUser(user);

        return (created ? "User was created!" : "User creation was failed!");
    }

    public String getUser(int id) {
        User user = repo.getUser(id);

        return (user == null ? "User was not found!" : user.toString());
    }

    public String getAllUsers() {
        List<User> users = repo.getAllUsers();

        return users.toString();
    }
}