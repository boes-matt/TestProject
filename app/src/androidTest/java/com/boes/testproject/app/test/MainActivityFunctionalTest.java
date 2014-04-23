package com.boes.testproject.app.test;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

import com.boes.testproject.app.MainActivity;
import com.boes.testproject.app.R;
import com.boes.testproject.app.SecondActivity;

public class MainActivityFunctionalTest extends ActivityInstrumentationTestCase2<MainActivity> {

    // InstrumentationTest for integration testing between activities

    private MainActivity mMainActivity;

    public MainActivityFunctionalTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);
        mMainActivity = getActivity();
    }

    public void testGoButtonLabelIsOrange() {
        // Show that button label set with color of Cat
        // Demonstrates code in core java library (Cat class) being used in android app and android test
        Button btnGo = (Button) mMainActivity.findViewById(R.id.btnGo);
        assertEquals("Button label", "Orange", btnGo.getText().toString());
    }

    public void testStartSecondActivity() {
        ActivityMonitor monitor = getInstrumentation().addMonitor(SecondActivity.class.getName(), null, false);
        final Button btnGo = (Button) mMainActivity.findViewById(R.id.btnGo);

        // TouchUtils posts actions on UI thread automatically
        TouchUtils.clickView(this, btnGo);

        SecondActivity mStartedSecondActivity  = (SecondActivity) monitor.waitForActivityWithTimeout(3000);
        // SecondActivity mStartedSecondActivity = (SecondActivity) monitor.getLastActivity();
        assertNotNull(mStartedSecondActivity);

        TextView tvHello = (TextView) mStartedSecondActivity.findViewById(R.id.tvHello);
        ViewAsserts.assertOnScreen(mStartedSecondActivity.getWindow().getDecorView(), tvHello);
        assertEquals("Wrong text", "Hello world!", tvHello.getText().toString());

        // Go back and click button again
        sendKeys(KeyEvent.KEYCODE_BACK);

        // TouchUtils.clickView(this, btnGo);
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertTrue(btnGo.performClick());
            }
        });
    }

}
