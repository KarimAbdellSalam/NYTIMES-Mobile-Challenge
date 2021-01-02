package dev.ny.challenge.adapters;


import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import dev.ny.challenge.data.model.Article;
import dev.ny.challenge.ui.main.ArticleListAdapter;

import java.util.List;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public class BindingAdaptation {

    @BindingAdapter({"imageUrl", "cacheEnabled"})
    public static void setImageUrl(ImageView imageView, String url, boolean cache) {
        Context context = imageView.getContext();
        if (!TextUtils.isEmpty(url))
            Glide.with(context)
                    .load(url)
                    .apply(cache ? RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL) : RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                    .into(imageView);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        if (!TextUtils.isEmpty(url))
            Glide.with(context)
                    .load(url)
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                    .into(imageView);
    }

    @BindingAdapter({"adapter", "dataItems"})
    public static void bindArticles(RecyclerView recyclerView, ArticleListAdapter adapter, List<Article> list) {
        recyclerView.setAdapter(adapter);
        adapter.updateItems(list);
    }
}
