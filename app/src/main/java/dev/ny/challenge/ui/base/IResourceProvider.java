package dev.ny.challenge.ui.base;

/**
 * Created by Karim Abdell Salam on 1,Jan,2021
 */
public interface IResourceProvider {

    String getString(int resId);

    String getString(int resId, String value);

    int getColor(int colorAccent);
}
