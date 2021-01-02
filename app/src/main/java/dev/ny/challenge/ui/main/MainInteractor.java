package dev.ny.challenge.ui.main;

import dev.ny.challenge.callbacks.InteractorCallback;
import dev.ny.challenge.data.DataHelper;
import dev.ny.challenge.data.model.Article;
import dev.ny.challenge.data.model.NYTResponse;
import dev.ny.challenge.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public class MainInteractor implements IMainInteractor {
    private DataHelper dataHelper;
    private SchedulerProvider schedulerProvider;

    @Inject
    public MainInteractor(DataHelper dataHelper, SchedulerProvider schedulerProvider) {
        this.dataHelper = dataHelper;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public void loadArticles(InteractorCallback<List<Article>> callback) {
        dataHelper.loadMostPopularNews(7)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(new SingleObserver<NYTResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull NYTResponse nytResponse) {
                        callback.onSuccess(nytResponse.getArticles());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onFailed(e);
                    }
                });
    }

}
