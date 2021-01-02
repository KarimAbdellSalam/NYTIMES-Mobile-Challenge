package dev.ny.challenge.data.remote;

import dev.ny.challenge.data.model.NYTResponse;
import io.reactivex.rxjava3.core.Single;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public interface ApiHelper {
    Single<NYTResponse> loadMostPopularNews(int rage);
}
