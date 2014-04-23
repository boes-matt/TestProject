package com.boes.testproject.app;

import android.content.ContentValues;

import com.boes.testproject.core.Dog;

public class Content {

    public static ContentValues sendValues(Dog aDog) {
        ContentValues values = new ContentValues();
        values.put("id", aDog.sendID());
        values.put("name", aDog.sendName());
        values.put("likesBacon", aDog.isLikesBacon());
        return values;
    }

}
