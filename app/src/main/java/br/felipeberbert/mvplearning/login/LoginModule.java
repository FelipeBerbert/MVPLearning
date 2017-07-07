package br.felipeberbert.mvplearning.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Felipe Berbert on 07/07/2017.
 */

@Module
public class LoginModule {

    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model){
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(LoginRepository repository){
        return new LoginModel(repository);
    }

    @Provides
    public LoginRepository provideLoginRepository() {
        return new MemoryRepository();
    }
}
