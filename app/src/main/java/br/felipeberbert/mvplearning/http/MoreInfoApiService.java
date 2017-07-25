package br.felipeberbert.mvplearning.http;


import br.felipeberbert.mvplearning.http.apimodel.OmdbApi;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MoreInfoApiService {

    @GET("/")
    Observable <OmdbApi> getCountry(@Query("t") String title);


}