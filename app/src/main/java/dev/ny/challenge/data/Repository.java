package dev.ny.challenge.data;

import android.content.Context;

import com.google.gson.Gson;

import dev.ny.challenge.BuildConfig;
import dev.ny.challenge.data.model.NYTResponse;
import dev.ny.challenge.data.remote.ProjectApi;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public class Repository implements DataHelper {
    private Gson gson;
    Context mContext;
    ProjectApi.MostPopularApi mostPopularApi;

    @Inject
    public Repository(Retrofit retrofit, Context mContext, Gson gson) {
        mostPopularApi = retrofit.create(ProjectApi.MostPopularApi.class);
        this.mContext = mContext;
        this.gson = gson;
    }

    @Override
    public Single<NYTResponse> loadMostPopularNews(int rage) {
        return mostPopularApi.getMostPopularArticles(rage, BuildConfig.API_KEY);
    }
}
