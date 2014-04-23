package com.boes.testproject.app.test;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.test.ProviderTestCase2;
import android.util.Log;

import com.boes.testproject.app.Content;
import com.boes.testproject.app.DogContentProvider;
import com.boes.testproject.app.DogCursor;
import com.boes.testproject.core.Dog;

public class DogContentProviderTest extends ProviderTestCase2<DogContentProvider> {

    public DogContentProviderTest() {
        super(DogContentProvider.class, DogContentProvider.AUTHORITY);
    }

    public void testProviderCreated() {
        DogContentProvider provider = getProvider();
        assertNotNull(provider);
    }

    public void testMockResolver() {
        ContentResolver resolver = getMockContentResolver();

        Cursor emptyCursor = resolver.query(DogContentProvider.CONTENT_URI, null, null, null, null);
        assertEquals("Wrong count", 0, emptyCursor.getCount());

        Dog aDog = new Dog("Bucky", true);
        Uri aDogUri = resolver.insert(DogContentProvider.CONTENT_URI, Content.sendValues(aDog));

        Cursor cursor = resolver.query(aDogUri, null, null, null, null);
        assertEquals("Wrong count", 1, cursor.getCount());

        DogCursor dogCursor = new DogCursor(cursor);
        dogCursor.moveToFirst();
        Dog dbDog = dogCursor.sendDog();

        Log.d("ProviderTest", "aDog  = " + aDog);
        Log.d("ProviderTest", "dbDog = " + dbDog);
        assertEquals("Wrong dog", aDog, dbDog);

        Cursor dogsCursor = resolver.query(DogContentProvider.CONTENT_URI, null, null, null, null);
        assertEquals("Wrong count", 1, dogsCursor.getCount());
    }

    public void testProviderReset() {
        ContentResolver resolver = getMockContentResolver();
        Cursor emptyCursor = resolver.query(DogContentProvider.CONTENT_URI, null, null, null, null);
        assertEquals("Wrong count", 0, emptyCursor.getCount());
    }

}
