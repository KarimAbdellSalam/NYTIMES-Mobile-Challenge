package dev.ny.challenge.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import dev.ny.challenge.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * Created by Karim Abdell Salam on 1,JAN,2021
 */

public class Utils {
    public static class Const {

        public static class HTTP {
            // in milliseconds
            public static final long WRITE_TIMEOUT = 120;
            public static final long READ_TIMEOUT = 120;
            public static final long TIMEOUT = 120;
            public static final String OK  ="ok";
            public static final String API_FAILED = "Failed";

        }

        public class Action {
        }

        public class Ref {
            public static final String ARTICLE = "article";

        }
    }

    public static class UI {
        public static ProgressDialog showLoadingDialog(Context context) {
            ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.show();
            if (progressDialog.getWindow() != null) {
                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            progressDialog.setContentView(R.layout.progress_dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            return progressDialog;
        }
    }

    public static class Network {
        public static boolean checkInternetConnection(Context context) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            }
            return false;
        }
    }

    public static class Data {
        public static String loadJSONFromAsset(Context context, String jsonFileName) throws IOException {
            AssetManager manager = context.getAssets();
            InputStream is = manager.open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");
        }
        public static byte[] readBytes(InputStream inputStream)  {
            // this dynamically extends to take the bytes you read
            ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

            // this is storage overwritten on each iteration with bytes
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];

            // we need to know how may bytes were read to write them to the byteBuffer
            int len = 0;
            while (true) {
                try {
                    if (!((len = inputStream.read(buffer)) != -1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byteBuffer.write(buffer, 0, len);
            }

            // and then we can return your byte array.
            return byteBuffer.toByteArray();
        }

        public static <T> String loadJsonFileFromResources(Class<T> tClass,String filePath) {
            InputStream jsonStream = Objects.requireNonNull(tClass.getClassLoader()).getResourceAsStream(filePath);
            return new String(Utils.Data.readBytes(jsonStream));
        }
    }

    public static class TextUtils {
        public static boolean isEmpty(CharSequence str) {
            return str == null || str.length() == 0;
        }

        public static String removeUnnecessaryCharacters(String word) {
            if (TextUtils.isEmpty(word))
                return "";
            String regex = "[^a-zA-Z0-9\\s]";
            String regexSpaces = "\\s{2,}";
            return word.replaceAll(regex, "")
                    .replaceAll(regexSpaces, " ")
                    .toLowerCase();
        }
    }

    public static class Screen {
        public static int dpToPx(float dp) {
            float density = Resources.getSystem().getDisplayMetrics().density;
            return Math.round(dp * density);
        }

        public static float pxToDp(float px) {
            float densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
            return px / (densityDpi / 160f);
        }
    }
}
