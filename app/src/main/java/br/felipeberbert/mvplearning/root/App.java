package br.felipeberbert.mvplearning.root;

import android.app.Application;

import br.felipeberbert.mvplearning.login.LoginModule;

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
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
