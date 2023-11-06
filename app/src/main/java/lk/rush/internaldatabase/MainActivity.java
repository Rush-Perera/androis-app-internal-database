package lk.rush.internaldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.getWritableDatabase();

        User user = new User("Achintha", "achintha@jiat.lk", "Colombo 5");
        dbHelper.insertUser(user);


//        List<User> users = dbHelper.getAllUsers();

//        users.forEach(u-> {
//            Log.i(TAG, u.getName()+" "+u.getEmail());
//        });



    }
}