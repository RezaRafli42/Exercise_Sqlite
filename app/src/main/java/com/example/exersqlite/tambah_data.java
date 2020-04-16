package com.example.exersqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class tambah_data extends AppCompatActivity {

    int id_To_Update = 0;
    private DBHelper mydb;
    EditText dataNama, dataPhone, dataEmail, dataAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        dataNama   = (EditText) findViewById(R.id.editText1);
        dataPhone  = (EditText) findViewById(R.id.editText2);
        dataEmail  = (EditText) findViewById(R.id.editText3);
        dataAlamat = (EditText) findViewById(R.id.editText4);

        mydb  = new DBHelper(this);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int Value = extras.getInt("id");

            if(Value>0){
                //means this is the view part not the add contact part.
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();

                String name   = rs.getString(rs.getColumnIndex(DBHelper.COLUMN_NAMA));
                String phone  = rs.getString(rs.getColumnIndex(DBHelper.COLUMN_PHONE));
                String email  = rs.getString(rs.getColumnIndex(DBHelper.COLUMN_EMAIL));
                String alamat = rs.getString(rs.getColumnIndex(DBHelper.COLUMN_ALAMAT));

                if (!rs.isClosed()){
                    rs.close();
                }
    }


    public void Pindah1(View view) {
        Intent intentKu = new Intent(tambah_data.this,
                    MainActivity.class);
            startActivity(intentKu);
    }
}
