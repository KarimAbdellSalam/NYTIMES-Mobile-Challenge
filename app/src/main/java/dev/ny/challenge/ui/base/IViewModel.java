package dev.ny.challenge.ui.base;

import android.content.Intent;

/**
 * Created by Karim Abdell Salam on 1,Jan,2021
 */
interface IViewModel {

    public void onActivityResult(int requestCode, int resultCode, Intent data);

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);

}
