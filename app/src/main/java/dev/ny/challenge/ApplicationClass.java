package dev.ny.challenge;

import android.app.Activity;
import android.app.Application;

import androidx.fragment.app.Fragment;

import dev.ny.challenge.dagger.AppModule;
import dev.ny.challenge.dagger.ApplicationComponent;
import dev.ny.challenge.dagger.DaggerApplicationComponent;
import dev.ny.challenge.utils.AppLogger;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public class ApplicationClass extends Application implements HasActivityInjector {

    private static ApplicationComponent appComponent;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;

    public static ApplicationComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppLogger.init();
        initBuild();
        initFont();
    }


    private void initBuild() {
        appComponent = DaggerApplicationComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }


    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    public void initFont() {

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/cheltenham_normal.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());

    }
}
