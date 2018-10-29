package com.example.adin.ka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class pitanje4activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pitanje4);
    }

    public void odgovor4(View v)
    {
        Intent i=getIntent();
        int bodovi=i.getIntExtra("bodovi",0);

        RadioButton b1,b2;

        b1=(RadioButton)findViewById(R.id.rb41) ;
        b2=(RadioButton)findViewById(R.id.rb42) ;


        if(b1.isChecked())
        {
bodovi++;

            Intent intent=new Intent(this,pitanje5activity.class);
            intent.putExtra("bodovi",bodovi);
            startActivity(intent);
            finish();

        }
        else if(b2.isChecked())
        {

            Intent intent=new Intent(this,pitanje5activity.class);
            intent.putExtra("bodovi",bodovi);
            startActivity(intent);
            finish();


        }

        else
        {
            Toast.makeText(pitanje4activity.this,"Niste odabrali nijedan odgovor",Toast.LENGTH_SHORT).show();}



    }

}


