package br.felipeberbert.mvplearning.root;

import javax.inject.Singleton;

import br.felipeberbert.mvplearning.http.ApiModule;
import br.felipeberbert.mvplearning.login.LoginActivity;
import br.felipeberbert.mvplearning.login.LoginModule;
import dagger.Component;

/**
 * Created by Felipe Berbert on 07/07/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);
}
