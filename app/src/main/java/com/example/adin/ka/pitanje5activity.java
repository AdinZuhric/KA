package com.example.adin.ka;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class pitanje5activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pitanje5);
    }

    public void odgovor5(View v)
    {
        Intent i=getIntent();
        int bodovi=i.getIntExtra("bodovi",0);

        RadioButton b1,b2;

        b1=(RadioButton)findViewById(R.id.rb51) ;
        b2=(RadioButton)findViewById(R.id.rb52) ;


        if(b1.isChecked())
        {
            bodovi++;


            skor(bodovi);
            //Intent intent=new Intent(this,MainActivity.class);
           // startActivity(intent);
        }
        else if(b2.isChecked())
        {


         skor(bodovi);
           // Intent intent=new Intent(this,MainActivity.class);
           // startActivity(intent);

        }

        else
        {
            Toast.makeText(pitanje5activity.this,"Niste odabrali nijedan odgovor",Toast.LENGTH_SHORT).show();}


    }
    public int skor(int n)
    {

        {
            new AlertDialog.Builder(this)
                    .setMessage("Odgovorili ste tačno na "+String.valueOf(n)+" od 5 pitanja.")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            finish();

                        }

                    })
                    .show();}
    return 0;}

}


