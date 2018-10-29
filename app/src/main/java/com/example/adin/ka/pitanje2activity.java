package com.example.adin.ka;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.internal.NavigationSubMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class pitanje2activity extends AppCompatActivity
        {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pitanje2);

     //   getMenuInflater().inflate(R.menu.activity_main_drawer,);

    }

    public  void  odgovor2(View v)
    {
        Intent i=getIntent();
        int bodovi=i.getIntExtra("bodovi",0);
        RadioButton b1,b2;
            b1=(RadioButton)findViewById(R.id.radioButton) ;
            b2=(RadioButton)findViewById(R.id.radioButton2) ;

            if(b1.isChecked())
            {
                bodovi++;
                Intent intent=new Intent(this,pitanje3activity.class);
                intent.putExtra("bodovi",bodovi);
                startActivity(intent);
                finish();


            }
            else if(b2.isChecked())
            {
                Intent intent=new Intent(this,pitanje3activity.class);
                intent.putExtra("bodovi",bodovi);
                startActivity(intent);
                finish();

            }
            else
            {
                Toast.makeText(pitanje2activity.this,"Niste odabrali nijedan odgovor",Toast.LENGTH_SHORT).show();}


    }
}
