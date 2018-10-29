package com.example.adin.ka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class pitanje3activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pitanje3);
    }

    public void odgovor3(View v)
    {
        Intent i=getIntent();
        int bodovi=i.getIntExtra("bodovi",0);

        RadioButton b1,b2,b3;

        b1=(RadioButton)findViewById(R.id.rB1) ;
        b2=(RadioButton)findViewById(R.id.rB2) ;
        b3=(RadioButton)findViewById(R.id.rB3);

        if(b1.isChecked())
        {


            Intent intent=new Intent(this,pitanje4activity.class);
            intent.putExtra("bodovi",bodovi);
            startActivity(intent);
            finish();

        }
        else if(b2.isChecked())
        {

            Intent intent=new Intent(this,pitanje4activity.class);
            intent.putExtra("bodovi",bodovi);
            startActivity(intent);
            finish();


        }
        else if(b3.isChecked())
        {
            bodovi++;


            Intent intent=new Intent(this,pitanje4activity.class);
            intent.putExtra("bodovi",bodovi);
            startActivity(intent);
            finish();

        }
        else
        {
            Toast.makeText(pitanje3activity.this,"Niste odabrali nijedan odgovor",Toast.LENGTH_SHORT).show();}



    }

}

