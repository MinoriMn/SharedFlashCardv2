package com.gmail.kamemaru2011;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.gmail.kamemaru2011.activity.top.TopActivity;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.*;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<TopActivity> topActivityActivityTestRule = new ActivityTestRule<>(TopActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.gmail.kamemaru2011", appContext.getPackageName());
    }

    @Test
    public void testFCList() throws InterruptedException {
        Intent intent = new Intent();
        TopActivity activity = topActivityActivityTestRule.launchActivity(intent);

        //起動確認
        assertThat(
                "TopActivity is running",
                activity.isFinishing(),
                Matchers.is(false)
        );

        //Navi起動
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.navigation_my_flash_card_list));

        //FCClick
        onView(withId(R.id.flash_card_list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, ViewActions.click()));

        //CClick

        onView(Matchers.allOf(withId(R.id.card_list), CoreMatchers.instanceOf(android.support.v7.widget.RecyclerView.class)))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, ViewActions.click()));

        Thread.sleep(1500);
    }
}
