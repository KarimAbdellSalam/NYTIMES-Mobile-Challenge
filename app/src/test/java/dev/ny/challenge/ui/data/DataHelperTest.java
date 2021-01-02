package dev.ny.challenge.ui.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.ny.challenge.data.Repository;
import dev.ny.challenge.utils.Utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.annotations.NonNull;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Karim Abdell Salam on 2,Jan,2021
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class DataHelperTest {

    Repository repository;


    private MockWebServer mockWebServer = new MockWebServer();
    private Retrofit retrofit;


    @Before
    public void setup() throws Exception {
        mockWebServer.start();
        retrofit = FactoryForTest.Network.buildRetrofit(mockWebServer);
        repository = new Repository(retrofit, null, FactoryForTest.Converters.provideGson());
    }

    @After
    public void teardown() {
        retrofit = null;
        try {
            mockWebServer.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
