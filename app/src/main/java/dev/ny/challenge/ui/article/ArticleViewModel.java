package dev.ny.challenge.ui.article;

import androidx.databinding.ObservableField;

import dev.ny.challenge.dagger.ApplicationComponent;
import dev.ny.challenge.data.model.Article;
import dev.ny.challenge.ui.base.BaseViewModel;

import javax.inject.Inject;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public class ArticleViewModel extends BaseViewModel {

    ObservableField<Article> article = new ObservableField<>();
    private IArticleInteractor interactor;

    @Inject
    public ArticleViewModel() {
        ApplicationComponent appComponent = getAppComponent();
        if (appComponent != null)
            interactor = appComponent.getMovieInteractor();
    }

    public void setArticle(Article article) {
        this.article.set(article);
        article.notifyChange();
    }

    private void showToast(String message) {
        showToast(message);
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

    public ObservableField<Article> getArticle() {
        return article;
    }

    public void setInteractor(ArticleInteractor interactor) {
        this.interactor = interactor;
    }

}
