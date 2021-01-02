package dev.ny.challenge.ui.base.templates;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;


import dev.ny.challenge.R;
import dev.ny.challenge.manager.LanguageControl;
import dev.ny.challenge.manager.OptionsControl;
import dev.ny.challenge.ui.base.BaseActivity;
import dev.ny.challenge.ui.base.BaseViewModel;


/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */
public abstract class ActivityWithBack<V extends BaseViewModel> extends BaseActivity<V> {

    public Menu menu;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void init() {
        createToolbar();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int toolbarMenuId = getToolbarOptionMenuId();
        if (toolbarMenuId != -1 )
            getMenuInflater().inflate(toolbarMenuId, menu);
        this.menu = menu;
        return true;
    }

    // Used to inflate toolbar actions
    protected abstract int getToolbarOptionMenuId();

    protected abstract int getUpIconId();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        } else {
            boolean optionSelected = OptionsControl.optionSelected(item, this);
            if (optionSelected)
                return true;  //false if you want to close search view
        }
        return super.onOptionsItemSelected(item);
    }

    private void createToolbar() { //TODO NEED TO BE ENHANCED
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView toolbar_title = toolbar.findViewById(R.id.toolbar_titleTv);
        ImageView logoIm = toolbar.findViewById(R.id.toolbar_logoIm);
        if (getScreenTitle() != null)
            toolbar_title.setText(getScreenTitle());
        else toolbar_title.setText("");
        if (getScreenLogo() != null) {
            logoIm.setVisibility(View.VISIBLE);
            logoIm.setImageDrawable(getScreenLogo());
        }
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        int upIconId = getUpIconId();
        if (upIconId != 0) {
            if (!LanguageControl.isRTLLocale(this))
                getSupportActionBar().setHomeAsUpIndicator(upIconId);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public abstract String getScreenTitle();

    public abstract Drawable getScreenLogo();

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
