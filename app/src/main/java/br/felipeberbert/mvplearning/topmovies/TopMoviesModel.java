package br.felipeberbert.mvplearning.topmovies;


import br.felipeberbert.mvplearning.http.apimodel.Result;
import rx.Observable;
import rx.functions.Func2;

public class TopMoviesModel implements TopMoviesActivityMVP.Model {

    private Repository repository;

    public TopMoviesModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {

        return Observable.zip((Observable<? extends Result>) repository.getResultData(), repository.getCountryData(), new Func2<Result, String, ViewModel>() {
            @Override
            public ViewModel call(Result result, String s) {
                return new ViewModel(result.title,s);
            }
        });
    }

}