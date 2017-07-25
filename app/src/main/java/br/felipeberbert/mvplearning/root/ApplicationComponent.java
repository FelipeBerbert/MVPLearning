package br.felipeberbert.mvplearning.root;

import javax.inject.Singleton;

import br.felipeberbert.mvplearning.http.ApiModule;
import br.felipeberbert.mvplearning.http.ApiModuleForInfo;
import br.felipeberbert.mvplearning.http.ApiModuleForName;
import br.felipeberbert.mvplearning.login.LoginActivity;
import br.felipeberbert.mvplearning.login.LoginModule;
import br.felipeberbert.mvplearning.topmovies.TopMoviesActivity;
import br.felipeberbert.mvplearning.topmovies.TopMoviesModule;
import dagger.Component;

/**
 * Created by Felipe Berbert on 07/07/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class, ApiModule.class, ApiModuleForName.class, ApiModuleForInfo.class, TopMoviesModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);
    void inject(TopMoviesActivity target);
}
