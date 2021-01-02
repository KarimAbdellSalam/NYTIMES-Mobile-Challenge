package dev.ny.challenge.ui.article;

import androidx.annotation.Nullable;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import dev.ny.challenge.BR;
import dev.ny.challenge.R;
import dev.ny.challenge.data.model.Article;
import dev.ny.challenge.databinding.ActivityArticleBinding;
import dev.ny.challenge.ui.base.templates.ActivityWithBack;
import dev.ny.challenge.utils.Utils;

import javax.inject.Inject;

public class ArticleActivity extends ActivityWithBack<ArticleViewModel> {


    public ActivityArticleBinding binding;
    @Inject
    ArticleViewModel viewModel;
    private Article article;

    public static Intent newIntent(Context context) {
        return new Intent(context, ArticleActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_article;
    }

    @Override
    public ArticleViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(Utils.Const.Ref.ARTICLE)) {
            article = (Article) extras.getSerializable(Utils.Const.Ref.ARTICLE);
        }
        super.onCreate(savedInstanceState);
        binding = (ActivityArticleBinding) getViewDataBinding();
        viewModel.setArticle(article);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected int getToolbarOptionMenuId() {
        return -1;
    }

    @Override
    protected int getUpIconId() {
        return 0;
    }

    @Override
    public String getScreenTitle() {
        return article.getTitle();
    }

    @Override
    public Drawable getScreenLogo() {
        return null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
    }
}