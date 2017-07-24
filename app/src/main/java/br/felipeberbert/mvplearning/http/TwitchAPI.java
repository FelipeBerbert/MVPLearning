package br.felipeberbert.mvplearning.http;

import br.felipeberbert.mvplearning.http.apimodel.Twitch;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;

/**
 * Created by Felipe Berbert on 21/07/2017.
 */

public interface TwitchAPI {

    @GET("games/top")
    Call<Twitch> getTopGames(@Header("Client-Id") String clientId);

    @GET("games/top")
    Observable<Twitch> getTopGamesObservable(@Header("Client-Id") String clientId);
}
