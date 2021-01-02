package dev.ny.challenge.manager;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;

import dev.ny.challenge.data.model.Article;
import dev.ny.challenge.ui.main.MainActivity;
import dev.ny.challenge.ui.article.ArticleActivity;
import dev.ny.challenge.utils.Utils;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public class ScreenControl {
    public static void openMainActivity(Activity activity) {
        activity.startActivity(MainActivity.newIntent(activity));
    }

    public static void openArticleActivity(Activity activity, Article article, ImageView articleIm) {
        Intent intent = ArticleActivity.newIntent(activity);
        intent.putExtra(Utils.Const.Ref.ARTICLE, article);
        Pair<View, String> p1 = Pair.create(articleIm, articleIm.getTransitionName());
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, p1);
        activity.startActivity(intent, options.toBundle());
    }
    public static void openArticleActivity(Activity activity, Article article) {
        Intent intent = ArticleActivity.newIntent(activity);
        intent.putExtra(Utils.Const.Ref.ARTICLE, article);
        activity.startActivity(intent);
    }
}
