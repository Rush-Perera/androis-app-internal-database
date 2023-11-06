package lk.rush.internaldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase appDb = openOrCreateDatabase("app_db", MODE_PRIVATE, null);

        appDb.execSQL("CREATE TABLE IF NOT EXISTS User(name VARCHAR, email VARCHAR, address VARCHAR)");

//        appDb.close();

    }
}