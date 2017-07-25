package br.felipeberbert.mvplearning.root;

import android.app.Application;

import br.felipeberbert.mvplearning.http.ApiModule;
import br.felipeberbert.mvplearning.http.ApiModuleForInfo;
import br.felipeberbert.mvplearning.http.ApiModuleForName;
import br.felipeberbert.mvplearning.login.LoginModule;
import br.felipeberbert.mvplearning.topmovies.TopMoviesModule;

/**
 * Created by Felipe Berbert on 07/07/2017.
 */

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .apiModule(new ApiModule())
                .topMoviesModule(new TopMoviesModule())
                .apiModuleForInfo(new ApiModuleForInfo())
                .apiModuleForName(new ApiModuleForName())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
