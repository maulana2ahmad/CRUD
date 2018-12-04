package com.mractiveiddev.crudandroid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mractiveiddev.crudandroid.sql.DataHelper;

public class BuatBiodataActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button button1, button2;
    EditText etext1, etext2, etext3, etext4, etext5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dbHelper = new DataHelper(this);
        etext1 = (EditText) findViewById(R.id.editText1);
        etext2 = (EditText) findViewById(R.id.editText2);
        etext3 = (EditText) findViewById(R.id.editText3);
        etext4 = (EditText) findViewById(R.id.editText4);
        etext5 = (EditText) findViewById(R.id.editText5);

        //Button
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into biodata (no, nama, tgl, alamat) value ('"+
                        etext1.getText().toString() + "','" +
                        etext2.getText().toString() + "','" +
                        etext3.getText().toString() + "','" +
                        etext4.getText().toString() + "','" +
                        etext5.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                finish();
            }
        });

    }
}
