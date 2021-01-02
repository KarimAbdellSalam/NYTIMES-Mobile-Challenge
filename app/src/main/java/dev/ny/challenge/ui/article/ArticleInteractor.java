package dev.ny.challenge.ui.article;

import dev.ny.challenge.data.DataHelper;
import dev.ny.challenge.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public class ArticleInteractor implements IArticleInteractor {
    private final SchedulerProvider schedulerProvider;
    private DataHelper dataHelper;

    @Inject
    public ArticleInteractor(DataHelper dataHelper, SchedulerProvider schedulerProvider) {
        this.dataHelper = dataHelper;
        this.schedulerProvider=schedulerProvider;
    }

}
