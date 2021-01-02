package dev.ny.challenge.ui.main;

import dev.ny.challenge.callbacks.InteractorCallback;
import dev.ny.challenge.data.model.Article;

import java.util.List;

/**
 * Created by Karim Abdell Salam on 1,Jan,2021
 */
public interface IMainInteractor {
    void loadArticles(InteractorCallback<List<Article>> callback);
}
