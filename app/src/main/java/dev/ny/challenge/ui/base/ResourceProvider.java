package dev.ny.challenge.ui.base;

import android.content.Context;

import androidx.core.content.ContextCompat;


import javax.inject.Inject;

import dev.ny.challenge.R;

/**
 * Created by Karim Abdell Salam on 1,Jan,2021
 */
public class ResourceProvider implements IResourceProvider {

    private Context mContext;

    @Inject
    public ResourceProvider(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public String getString(int resId) {
        return mContext.getString(resId);
    }

    @Override
    public String getString(int resId, String value) {
        return mContext.getString(resId, value);
    }

    @Override
    public int getColor(int colorAccent) {
        return ContextCompat.getColor(mContext, R.color.colorAccent);
    }
}