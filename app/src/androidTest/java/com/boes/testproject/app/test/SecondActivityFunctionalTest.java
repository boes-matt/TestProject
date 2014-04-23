package com.boes.testproject.app.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TextView;

import com.boes.testproject.app.R;
import com.boes.testproject.app.SecondActivity;

public class SecondActivityFunctionalTest extends ActivityInstrumentationTestCase2<SecondActivity> {

    public SecondActivityFunctionalTest() {
        super(SecondActivity.class);
    }

    public void testSetText() {
        SecondActivity activity = getActivity();
        final TextView tvHello = (TextView) activity.findViewById(R.id.tvHello);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvHello.setText("New text!");
            }
        });

        getInstrumentation().waitForIdleSync();
        assertEquals("Wrong text", "New text!", tvHello.getText().toString());
    }

    @UiThreadTest
    public void testSetTextWithAnnotation() {
        SecondActivity activity = getActivity();
        final TextView tvHello = (TextView) activity.findViewById(R.id.tvHello);

        tvHello.setText("New text!");
        assertEquals("Wrong text", "New text!", tvHello.getText().toString());
    }

}
