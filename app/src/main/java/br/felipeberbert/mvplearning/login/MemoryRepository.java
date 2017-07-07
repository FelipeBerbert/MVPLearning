package br.felipeberbert.mvplearning.login;

/**
 * Created by Felipe Berbert on 07/07/2017.
 */

public class MemoryRepository implements LoginRepository {

    private User user;

    @Override
    public User getUser() {
        if (user == null) {
            User user = new User("John", "Doe");
            user.setId(0);
            return user;
        } else {
            return user;
        }
    }

    @Override
    public void saveUser(User user) {
        if (user == null){
            user = getUser();
        }

        this.user = user;
    }
}
