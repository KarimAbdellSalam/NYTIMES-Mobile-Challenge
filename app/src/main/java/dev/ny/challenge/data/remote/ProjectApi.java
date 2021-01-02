package dev.ny.challenge.data.remote;

import dev.ny.challenge.data.model.NYTResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Karim Abdell Salam on 1,Jan,2021
 */
public interface ProjectApi {
    public interface MostPopularApi {
        @GET("svc/mostpopular/v2/viewed/{range}.json")
        Single<NYTResponse> getMostPopularArticles(@Path("range") int range,
                                                   @Query("api-key") String apiKey);
    }

}
