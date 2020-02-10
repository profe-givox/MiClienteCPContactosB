package net.ivanvega.miclientecpcontactosb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractCPContactos.FIELD_USUARIO, "perroverde");
        contentValues.put(ContractCPContactos.FIELD_EMAIL, "perroverde@perrros.com");
        contentValues.put(ContractCPContactos.FIELD_TEL, "4451002345");

        Uri uri =  getContentResolver().insert(ContractCPContactos.CONTENT_URI,
                contentValues
        );

        Toast.makeText(this, uri.toString(),
                Toast.LENGTH_SHORT).show();

        Log.d("MIURI", uri.toString());

        lv = findViewById(R.id.lv);


        Cursor c = getContentResolver().query
                (   Uri.withAppendedPath(ContractCPContactos.CONTENT_URI, "5")  ,
                        ContractCPContactos.PROJECTION,
                        null, null,null);


        SimpleCursorAdapter adp =
                new SimpleCursorAdapter(this,
                        android.R.layout.simple_list_item_2,
                        c, new String[]{
                                ContractCPContactos.FIELD_USUARIO,
                        ContractCPContactos.FIELD_EMAIL
                },new int[]{android.R.id.text1,
                        android.R.id.text2}
                        ,SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE
                );

        lv.setAdapter(adp);

    }
}
