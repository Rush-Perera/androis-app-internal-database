package lk.rush.internaldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "app_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER_ID = "id";
    private static final String TABLE_USER_NAME = "name";
    private static final String TABLE_USER_EMAIL = "email";
    private static final String TABLE_USER_ADDRESS = "address";
    private static final String TABLE_USER = "User";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS User(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR, email VARCHAR, address VARCHAR)");
        db.execSQL("CREATE TABLE IF NOT EXISTS Product(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, description VARCHAR, price REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertUser(User user) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_USER_NAME, user.getName());
        values.put(TABLE_USER_EMAIL, user.getEmail());
        values.put(TABLE_USER_ADDRESS, user.getAddress());

        long id = database.insert("User", null, values);
//        database.close();
        return id;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DATABASE_NAME, null);
        if (cursor.moveToFirst()){
            do {
                User user = new User();
                int idIndex = cursor.getColumnIndex(TABLE_USER_ID);
                int nameIndex = cursor.getColumnIndex(TABLE_USER_NAME);
                int emailIndex = cursor.getColumnIndex(TABLE_USER_EMAIL);
                int addressIndex = cursor.getColumnIndex(TABLE_USER_ADDRESS);
                if (idIndex >= 0) {
                    user.setId(cursor.getInt(idIndex));
                }
                if (nameIndex >= 0) {
                    user.setName(cursor.getString(nameIndex));
                }
                if (emailIndex >= 0) {
                    user.setEmail(cursor.getString(emailIndex));
                }
                if (addressIndex >= 0 ) {
                    user.setAddress(cursor.getString(addressIndex));
                }
                users.add(user);
            }while (cursor.moveToNext());
        }

        cursor.close();
//        database.close();
        return users;
    }

    public void updateUser(User user) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_USER_NAME, user.getName());
        values.put(TABLE_USER_EMAIL, user.getEmail());
        values.put(TABLE_USER_ADDRESS, user.getAddress());

        String where = TABLE_USER_ID+"= ?";

        database.update(TABLE_USER, values, where, new String[]{String.valueOf(user.getId())});

    }

    public void deleteUser(long id) {
        SQLiteDatabase database = this.getWritableDatabase();
        String where = TABLE_USER_ID + "= ?";
        database.delete(TABLE_USER, where, new String[]{String.valueOf(id)});
//        database.close();
    }
}
