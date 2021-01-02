package dev.ny.challenge.ui.main;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import dev.ny.challenge.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by Karim Abdell Salam on 2,JAN,2021
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    String expectedPackage = "dev.ny.challenge";

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals(expectedPackage, appContext.getPackageName());
    }


    @Test
    public void checkViewsDisplay() {
        onView(withId(R.id.refreshSr))
                .check(matches(isDisplayed()));
        waitFor(3000);

        onView(withId(R.id.articleRc))
                .check(matches(isDisplayed()));
    }

    @Test
    public void checkActions() {
        waitFor(3000);
        onView(withId(R.id.articleRc)).perform(actionOnItemAtPosition(0, click()));
        waitFor(2000);
        pressBack();
        onView(withId(R.id.articleRc)).perform(actionOnItemAtPosition(1, click()));
        waitFor(2000);
        pressBack();
    }

    private void waitFor(int milli) {
        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
