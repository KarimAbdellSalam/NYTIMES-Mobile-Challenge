package dev.ny.challenge.dagger;

import android.content.Context;

import dev.ny.challenge.ApplicationClass;
import dev.ny.challenge.ui.base.ResourceProvider;
import dev.ny.challenge.ui.main.MainInteractor;
import dev.ny.challenge.ui.article.ArticleInteractor;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Karim Abdell Salam on 1,Jan,2021
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class,ActivityBuilder.class})
public interface ApplicationComponent {
    Context context();
    void inject(ApplicationClass applicationClass);
    ResourceProvider getResourceProvider();
    MainInteractor getMainInteractor();
    ArticleInteractor getMovieInteractor();
}
