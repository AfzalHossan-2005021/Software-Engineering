import java.util.HashMap;

public class BankingSystem {
    private final HashMap<String, User> users;
    private User activeUser;
    public BankingSystem(){
        this.users = new HashMap<>();
    }

    public void addUser(User user){
        users.put(user.getName(), user);
    }

    public User findUser(String userName){
        return users.get(userName);
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
}
