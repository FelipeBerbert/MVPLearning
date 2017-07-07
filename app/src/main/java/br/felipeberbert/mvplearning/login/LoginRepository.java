package br.felipeberbert.mvplearning.login;

/**
 * Created by Felipe Berbert on 07/07/2017.
 */

public interface LoginRepository {

    User getUser();
    void saveUser(User user);
}
