package dev.ny.challenge.ui.main;

import androidx.databinding.ObservableField;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import dev.ny.challenge.callbacks.InteractorCallback;
import dev.ny.challenge.callbacks.OnInteractionListener;
import dev.ny.challenge.dagger.ApplicationComponent;
import dev.ny.challenge.data.model.Article;
import dev.ny.challenge.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public class MainViewModel extends BaseViewModel<MainNavigator> implements IMainViewModel, OnInteractionListener {

    private IMainInteractor interactor;
    ObservableField<List<Article>> articlesData = new ObservableField<>(new ArrayList<>());
    public ArticleListAdapter adapter = new ArticleListAdapter(new ArrayList<>());


    @Inject
    public MainViewModel() {
        ApplicationComponent appComponent = getAppComponent();
        if (appComponent != null)
            interactor = appComponent.getMainInteractor();
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void loadData() {
        setIsLoading(true);
        interactor.loadArticles(interactorCallback);
        adapter.setOnInteractionListener(this);
    }

    InteractorCallback<List<Article>> interactorCallback = new InteractorCallback<List<Article>>() {
        @Override
        public void onSuccess(List<Article> movies) {
            setIsLoading(false);
            articlesData.set(movies);
            articlesData.notifyChange();
        }

        @Override
        public void onFailed(Throwable errors) {
            setIsLoading(false);
        }
    };

    @Override
    public void onItemClicked(Article item,int position) {
        getNavigator().openArticleActivity(item,position);
    }


    public ObservableField<List<Article>> getArticlesData() {
        return articlesData;
    }

    public void setArticlesData(ObservableField<List<Article>> articlesData) {
        this.articlesData = articlesData;
    }

    public ArticleListAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ArticleListAdapter adapter) {
        this.adapter = adapter;
    }

    public void setInteractor(MainInteractor interactor) {
        this.interactor = interactor;
    }


    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            loadData();
        }
    };

    public SwipeRefreshLayout.OnRefreshListener getOnRefreshListener() {
        return onRefreshListener;
    }
}
