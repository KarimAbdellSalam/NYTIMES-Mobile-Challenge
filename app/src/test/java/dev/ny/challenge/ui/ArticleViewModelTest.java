package dev.ny.challenge.ui;

import dev.ny.challenge.data.DataHelper;
import dev.ny.challenge.data.model.Article;
import dev.ny.challenge.ui.base.UIHelper;
import dev.ny.challenge.ui.article.ArticleInteractor;
import dev.ny.challenge.ui.article.ArticleViewModel;
import dev.ny.challenge.ui.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.rxjava3.schedulers.TestScheduler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by Karim Abdell Salam on 2,Jan,2021
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class ArticleViewModelTest {

    @Mock
    DataHelper dataHelper;

    @Mock
    UIHelper uiHelper;


    @Spy
    public ArticleViewModel articleViewModel;

    private TestScheduler mTestScheduler;
    private ArticleInteractor articleInteractor;
    private Article article;

    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        articleInteractor = new ArticleInteractor(dataHelper, testSchedulerProvider);
        article = Article.Mock.getArticle();
        articleViewModel.setArticle(article);
        articleViewModel.setInteractor(articleInteractor);
        articleViewModel.setUIHelper(uiHelper);
    }

    @Test
    public void setSomething() {
        //todo test something
    }


    @After
    public void tearDown() throws Exception {
        mTestScheduler = null;
        articleViewModel = null;
    }

}
