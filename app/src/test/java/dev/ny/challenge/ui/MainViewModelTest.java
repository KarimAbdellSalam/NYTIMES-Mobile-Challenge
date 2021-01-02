package dev.ny.challenge.ui;

import dev.ny.challenge.data.DataHelper;
import dev.ny.challenge.data.model.Article;
import dev.ny.challenge.data.model.NYTResponse;
import dev.ny.challenge.ui.base.UIHelper;
import dev.ny.challenge.ui.main.IMainViewModel;
import dev.ny.challenge.ui.main.MainInteractor;
import dev.ny.challenge.ui.main.MainViewModel;
import dev.ny.challenge.ui.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.TestScheduler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by Karim Abdell Salam on 2,Jan,2021
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class MainViewModelTest {
    @Mock
    IMainViewModel mViewModel;

    @Mock
    DataHelper dataHelper;

    @Mock
    UIHelper uiHelper;

    @Spy
    private MainViewModel mainViewModel;

    private TestScheduler mTestScheduler;

    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        MainInteractor mainInteractor = new MainInteractor(dataHelper, testSchedulerProvider);
        mainViewModel.setInteractor(mainInteractor);
        mainViewModel.setUIHelper(uiHelper);

    }

    @Test
    public void test_loading_movies() {
        NYTResponse nytResponse = new NYTResponse();
        List<Article> articles = Article.Mock.getArticles();
        nytResponse.setArticles(articles);
        assertEquals(mainViewModel.getArticlesData().get().size(), 0);

        doReturn(Single.just(nytResponse))
                .when(dataHelper)
                .loadMostPopularNews(7);

        mainViewModel.loadData();
        mTestScheduler.triggerActions();

        assertNotNull(mainViewModel.getArticlesData().get());
        assertEquals(mainViewModel.getArticlesData().get().getClass(), articles.getClass());
        assertNotEquals(mainViewModel.getArticlesData().get().size(), 0);
        assertEquals(mainViewModel.getArticlesData().get().size(), 5);

    }

    @After
    public void tearDown() throws Exception {
        mTestScheduler = null;
        mainViewModel = null;
    }

}
