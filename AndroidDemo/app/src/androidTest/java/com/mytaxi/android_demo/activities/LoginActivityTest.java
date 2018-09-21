package com.mytaxi.android_demo.activities;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import com.mytaxi.android_demo.R;

import static android.support.test.espresso.action.ViewActions.typeText;
import static org.hamcrest.Matchers.not;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.is;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<AuthenticationActivity> mActivityTestRule = new ActivityTestRule<>(AuthenticationActivity.class, true, false);
    public ActivityTestRule<MainActivity> mMainActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void logintoApp() throws Exception {
            mActivityTestRule.launchActivity(new Intent());
            //wait for the app to launch
            try {
                Thread.sleep(5000);
            }catch(Exception e) {
                e.printStackTrace();
            }
            //type in username
            onView(withId(R.id.edt_username)).perform(replaceText("crazydog335"), closeSoftKeyboard());

            //type in password
            onView(withId(R.id.edt_password)).perform(replaceText("venture"), closeSoftKeyboard());

            //click on login button
            onView(withId(R.id.btn_login)).perform(click());

            Thread.sleep(5000);
    }


    @Test()
    public void search_Driver() throws Exception {
        mMainActivity.launchActivity(null);
        Thread.sleep(5000);
        onView(withId(R.id.textSearch)).check(matches(isDisplayed()));
        onView(withId(R.id.textSearch)).perform(typeText("sa"), closeSoftKeyboard());
        Thread.sleep(5000);
        onView(withText("Sarah Scott"))
                .inRoot(withDecorView(not(is(mMainActivity.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
        onView(withText("Sarah Scott")).inRoot(withDecorView(not(is(mMainActivity.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

        onView(withText("Sarah Scott"))
                .inRoot(withDecorView(not(is(mMainActivity.getActivity().getWindow().getDecorView()))))
                .perform(click());

        onView((withId(R.id.fab))).check(matches(isDisplayed()));
        onView((withId(R.id.fab))).perform(click());
    }

}
