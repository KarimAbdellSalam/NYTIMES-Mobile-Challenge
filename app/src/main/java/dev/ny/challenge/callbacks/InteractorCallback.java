package dev.ny.challenge.callbacks;


/**
 * Created by Karim Abdell Salam on 1,Jan,2021
 */
public interface InteractorCallback<T> {
    public void onSuccess(T t);

    public void onFailed(Throwable errors);

}
