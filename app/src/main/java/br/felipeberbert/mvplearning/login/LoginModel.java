package br.felipeberbert.mvplearning.login;

/**
 * Created by Felipe Berbert on 07/07/2017.
 */

public class LoginModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String fname, String lname) {
        repository.saveUser(new User(fname, lname));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
