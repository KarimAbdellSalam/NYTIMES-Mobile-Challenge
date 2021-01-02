package dev.ny.challenge.dagger;

import dev.ny.challenge.ui.article.ArticleActivityModule;
import dev.ny.challenge.ui.main.MainActivity;
import dev.ny.challenge.ui.main.MainActivityModule;
import dev.ny.challenge.ui.article.ArticleActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainActivityModule.class
    })
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {ArticleActivityModule.class
    })
    abstract ArticleActivity bindArticleActivity();
}
