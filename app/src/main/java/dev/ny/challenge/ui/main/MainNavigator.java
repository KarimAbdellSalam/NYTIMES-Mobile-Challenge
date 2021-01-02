package dev.ny.challenge.ui.main;

import dev.ny.challenge.data.model.Article;

/**
 * Created by Karim Abdell Salam on 1,Jan,2021
 */
public interface MainNavigator {
    void openArticleActivity(Article article, int position);
}
