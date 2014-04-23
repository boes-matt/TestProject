package com.boes.testproject.app;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class NumberService extends Service {

    private final IBinder mBinder = new FirstBinder();

    private int mNumber;

    public NumberService() {
        mNumber = 0;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class FirstBinder extends Binder {
        NumberService getService() {
            return NumberService.this;
        }
    }

    public int sendNextNumber() {
        mNumber++;
        return mNumber;
    }

}
