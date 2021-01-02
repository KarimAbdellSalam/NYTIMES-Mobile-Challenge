package dev.ny.challenge.ui.article;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import dev.ny.challenge.R;
import dev.ny.challenge.data.model.Article;
import dev.ny.challenge.utils.Utils;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Created by Karim Abdell Salam on 2,Jan,2021
 */

@RunWith(AndroidJUnit4.class)
public class ArticleActivityTest {
    Article article = Article.Mock.getArticle();
    String expectedPackage = "dev.ny.challenge";

    @Rule
    public ActivityTestRule<ArticleActivity> activityTestRule =
            new ActivityTestRule<ArticleActivity>(ArticleActivity.class, true, false /*lazy launch activity*/) {

                @Override
                protected Intent getActivityIntent() {
                    /*added predefined intent data*/
                    Intent intent = new Intent();
                    intent.putExtra(Utils.Const.Ref.ARTICLE, article);
                    return intent;
                }
            };

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals(expectedPackage, appContext.getPackageName());
    }

    @Test
    public void checkViewsDisplay() {
        activityTestRule.launchActivity(null);
        onView(withId(R.id.articleTitleTv))
                .check(matches(isDisplayed()));
        onView(withId(R.id.articleAbstractTv))
                .check(matches(isDisplayed()));
        onView(withId(R.id.articleIm))
                .check(matches(isDisplayed()));
        onView(withId(R.id.copyrightsTv))
                .check(matches(isDisplayed()));
        onView(withId(R.id.bylineTv))
                .check(matches(isDisplayed()));
        onView(withId(R.id.publishedDateTv))
                .check(matches(isDisplayed()));
        onView(withId(R.id.updatedDateTv))
                .check(matches(isDisplayed()));
    }

    @Test
    public void checkViewsDataValues() {
        activityTestRule.launchActivity(null);
        onView(withId(R.id.articleTitleTv))
                .check(matches(withText(article.getTitle())));
        onView(withId(R.id.articleAbstractTv))
                .check(matches(withText(article.getAbstract())));
        onView(withId(R.id.copyrightsTv))
                .check(matches(withText(article.getMedia().get(0).getCopyright())));
        onView(withId(R.id.bylineTv))
                .check(matches(withText(article.getByline())));
        onView(withId(R.id.publishedDateTv))
                .check(matches(withText("Published "+article.getPublishedDate())));
        onView(withId(R.id.updatedDateTv))
                .check(matches(withText("Updated "+article.getUpdated())));
    }

}
