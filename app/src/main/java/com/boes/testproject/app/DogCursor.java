package com.boes.testproject.app;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.boes.testproject.core.Dog;

public class DogCursor extends CursorWrapper {

    public DogCursor(Cursor c) {
        super(c);
    }

    public Dog sendDog() {
        String name = getString(getColumnIndex("name"));
        boolean likesBacon = getInt(getColumnIndex("likesBacon")) == 1 ? true : false;
        int id = getInt(getColumnIndex("id"));
        return new Dog(id, name, likesBacon);
    }

}
