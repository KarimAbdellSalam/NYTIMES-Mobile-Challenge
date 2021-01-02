package dev.ny.challenge.callbacks;


import dev.ny.challenge.data.model.Article;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public interface OnInteractionListener {
    void onItemClicked(Article item,int position);
}
