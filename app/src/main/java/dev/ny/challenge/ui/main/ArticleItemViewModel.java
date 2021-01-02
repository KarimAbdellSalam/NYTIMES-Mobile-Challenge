package dev.ny.challenge.ui.main;


import androidx.databinding.ObservableField;

import dev.ny.challenge.callbacks.OnInteractionListener;
import dev.ny.challenge.data.model.Article;


public class ArticleItemViewModel {
    private Article item;
    private int position;
    private OnInteractionListener mListener;

    public ArticleItemViewModel(Article item,int position, OnInteractionListener mListener) {
        this.mListener = mListener;
        this.item = item;
        this.position=position;
    }

    private ObservableField<String> getObservableString(String field) {
        return new ObservableField<>(field);
    }

    public void onItemClick() {
        mListener.onItemClicked(item,position);
    }

    public OnInteractionListener getmListener() {
        return mListener;
    }

    public Article getArticle() {
        return item;
    }

    public void setItem(Article item) {
        this.item = item;
    }



}