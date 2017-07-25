package br.felipeberbert.mvplearning.topmovies;


import br.felipeberbert.mvplearning.http.apimodel.Result;
import rx.Observable;


public interface Repository {

    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    Observable<String> getCountriesFromMemory();

    Observable<String> getCountriesFromNetwork();

    Observable<String> getCountryData();

    Observable<Result> getResultData();

}