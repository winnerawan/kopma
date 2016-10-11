package id.ac.dharma_iswara.koperasimahasiswa.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by winnerawan on 10/8/16.
 */
public class SQLiteHandler extends SQLiteOpenHelper {

    private static final String TAG = SQLiteHandler.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "kopmadatabase.db";
    private static final String TABLE_NAME = "user";
    private static final String id = "id";
    private static final String entity_id = "id";
    private static final String name = "name";
    private static final String email = "email";
    private static final String avatar = "avatar";
    private static final String tel = "tel";
    private static final String session = "session";

    private static final String KEY_ID = "entity_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_AVATAR = "avatar";
    private static final String KEY_TEL = "tel";
    private static final String KEY_SESSION = "session";


    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " +TABLE_NAME+"("
                +KEY_ID+" INTEGER PRIMARY KEY,"
                +KEY_NAME+" TEXT,"
                +KEY_EMAIL+" TEXT UNIQUE,"+KEY_AVATAR+" TEXT,"
                +KEY_TEL+" TEXT,"
                +KEY_SESSION+" TEXT" +")";
        db.execSQL(CREATE_TABLE);
        Log.e(TAG, CREATE_TABLE);
        Log.e(TAG, "database dibuat");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addUser(String entity_id, String name, String email, String avatar, String tel, String session) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, entity_id);
        values.put(KEY_NAME, name);
        values.put(KEY_EMAIL, email);
        values.put(KEY_AVATAR, avatar);
        values.put(KEY_TEL, tel);
        values.put(KEY_SESSION, session);

        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        Log.e(TAG, "new user inserted "+id);
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            user.put("entity_id", cursor.getString(0));
            user.put("name", cursor.getString(1));
            user.put("email", cursor.getString(2));
            user.put("avatar", cursor.getString(3));
            user.put("tel", cursor.getString(4));
            user.put("session", cursor.getString(5));
        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

        return user;
    }

    public void deleteUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_NAME, null, null);
        db.close();

        Log.d(TAG, "Deleted all user info from sqlite");
    }
}
