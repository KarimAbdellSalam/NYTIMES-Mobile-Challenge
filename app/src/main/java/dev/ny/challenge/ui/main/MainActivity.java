package dev.ny.challenge.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import dev.ny.challenge.BR;
import dev.ny.challenge.R;
import dev.ny.challenge.data.model.Article;
import dev.ny.challenge.databinding.ActivityMainBinding;
import dev.ny.challenge.manager.ScreenControl;
import dev.ny.challenge.ui.base.BaseActivity;
import dev.ny.challenge.ui.base.BaseViewHolder;

import javax.inject.Inject;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public class MainActivity extends BaseActivity<MainViewModel> implements MainNavigator {

    @Inject
    MainViewModel viewModel;

    private ActivityMainBinding binding;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void init() {
        RecyclerView recyclerView = ((ActivityMainBinding) getViewDataBinding()).articleRc;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = (ActivityMainBinding) getViewDataBinding();
        viewModel.setNavigator(this);
        viewModel.loadData();
    }


    @Override
    public void openArticleActivity(Article article, int position) {
        BaseViewHolder viewHolder = (BaseViewHolder) binding.articleRc.findViewHolderForAdapterPosition(position);
        // used to make image Transition
        if (viewHolder instanceof ArticleListAdapter.HeaderViewHolder) {
            ImageView articleIm = ((ArticleListAdapter.HeaderViewHolder) viewHolder).getBinding().articleIm;
            ScreenControl.openArticleActivity(this, article, articleIm);
        } else ScreenControl.openArticleActivity(this, article);
    }
}