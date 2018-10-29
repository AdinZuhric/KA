package com.example.adin.ka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class pitanje1activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pitanje1);
    }

    public void odgovor(View v)
    {RadioButton b1,b2,b3;
        int bodovi=0;
        b1=(RadioButton)findViewById(R.id.radioButton) ;
        b2=(RadioButton)findViewById(R.id.radioButton1) ;
        b3=(RadioButton)findViewById(R.id.radioButton2);


        if(b1.isChecked())
        {
            Intent i=new Intent(this,pitanje2activity.class);
            i.putExtra("bodovi",bodovi);
            startActivity(i);
            finish();
        }
        else if(b2.isChecked())
        {
            bodovi++;

            Intent i=new Intent(this,pitanje2activity.class);
            i.putExtra("bodovi",bodovi);
            startActivity(i);
            finish();
        }
        else if(b3.isChecked())
        {


            Intent i=new Intent(this,pitanje2activity.class);
            i.putExtra("bodovi",bodovi);
            startActivity(i);
            finish();
        }
        else
        {
            Toast.makeText(pitanje1activity.this,"Niste odabrali nijedan odgovor",Toast.LENGTH_SHORT).show();}



    }

}

