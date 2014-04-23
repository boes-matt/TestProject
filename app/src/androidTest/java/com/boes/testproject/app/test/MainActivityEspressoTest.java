package com.boes.testproject.app.test;

import android.test.ActivityInstrumentationTestCase2;

import com.boes.testproject.app.MainActivity;
import com.boes.testproject.app.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.pressBack;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.doesNotExist;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDisplayed;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class MainActivityEspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {

    // Tests same functionality as MainActivityFunctionalTest but using Espresso
    // https://code.google.com/p/android-test-kit/wiki/Espresso

    public MainActivityEspressoTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testGoButtonLabelIsOrange() {
        onView(withId(R.id.btnGo)).check(matches(withText("Orange")));
    }

    public void testStartSecondActivity() {
        onView(withId(R.id.btnGo)).perform(click());

        // Assert that the Go button in MainActivity no longer exists
        onView(withId(R.id.btnGo)).check(doesNotExist());

        // TextView tvHello is in SecondActivity
        onView(withId(R.id.tvHello)).check(matches(isDisplayed()));

        // Go back, and click on Go button again
        pressBack();
        onView(withId(R.id.btnGo)).perform(click());
    }

}
