package com.boes.testproject.app;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.SparseArray;

import com.boes.testproject.core.Dog;

public class DogContentProvider extends ContentProvider {

    public static final String AUTHORITY = "com.boes.testproject.app.provider";
    public static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);
    public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI, "dogs");

    private SparseArray<Dog> db;

    private static final int DOGS = 1;
    private static final int DOG = 2;
    private static final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    static { matcher.addURI(AUTHORITY, "dogs",  DOGS);
             matcher.addURI(AUTHORITY, "dogs/#", DOG); }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        if (matcher.match(uri) == DOG) {
            int id = Integer.parseInt(uri.getLastPathSegment());
            Dog aDog = db.get(id);

            String[] columns = {"id", "name", "likesBacon"};
            MatrixCursor cursor = new MatrixCursor(columns);
            addDog(cursor, aDog);

            cursor.setNotificationUri(getContext().getContentResolver(), uri);
            return cursor;
        }

        if (matcher.match(uri) == DOGS) {
            return sendCursorForDogs(db);
        }

        throw new IllegalArgumentException("Unsupported URI: " + uri);
    }

    private Cursor sendCursorForDogs(SparseArray<Dog> dogs) {
        String[] columns = {"id", "name", "likesBacon"};
        MatrixCursor cursor = new MatrixCursor(columns);
        for (int i = 0; i < dogs.size(); i++) {
            addDog(cursor, dogs.get(i));
        }
        return cursor;
    }

    private void addDog(MatrixCursor cursor, Dog aDog) {
        cursor.addRow(new Object[] { aDog.sendID(), aDog.sendName(),
                                     aDog.isLikesBacon() ? 1 : 0 });
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (matcher.match(uri) == DOGS) {
            int id = values.getAsInteger("id");
            String name = values.getAsString("name");
            Boolean likesBacon = values.getAsBoolean("likesBacon");

            Dog aDog = new Dog(id, name, likesBacon);
            db.put(id, aDog);

            return Uri.withAppendedPath(CONTENT_URI, String.valueOf(id));
        }
        throw new IllegalArgumentException("Unsupported URI: " + uri);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public boolean onCreate() {
        db = new SparseArray<Dog>();

        return true;
    }

}
