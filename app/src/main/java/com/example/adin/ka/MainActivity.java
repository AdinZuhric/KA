package com.example.adin.ka;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
/*
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.izlaz) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager=getFragmentManager();

        if (id == R.id.uvod) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new First_fragment()).commit();
            // Handle the camera action
        } else if (id == R.id.teorija) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Second_fragment()).commit();

        } else if (id == R.id.zadaci) { fragmentManager.beginTransaction().replace(R.id.content_frame, new Third_fragment()).commit();

        } else if (id == R.id.kviz) { Intent i=new Intent(this,pitanje1activity.class);
            // i.putExtra("bodovi",bodovi);
            startActivity(i);
        }
        else if(id==R.id.simulacija){Intent i=new Intent(this,MainActivitySimulacija.class);
        startActivity(i);}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Izlazak iz aplikacije")
                .setMessage("Da li ste sigurni da želite izaći iz aplikacije?")
                .setPositiveButton("Da", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Ne", null)
                .show();}
    }
    public void rjesenje1(View v)
    {
    findViewById(R.id.rjesenje1).setVisibility(View.VISIBLE);
        findViewById(R.id.button1).setVisibility(View.GONE);

    }
    public void rjesenje2(View v)
    {
        findViewById(R.id.rjesenje2).setVisibility(View.VISIBLE);
        findViewById(R.id.button2).setVisibility(View.GONE);

    }
    public void rjesenje3(View v)
    {
        findViewById(R.id.rjesenje3).setVisibility(View.VISIBLE);
        findViewById(R.id.button3).setVisibility(View.GONE);

    }
    public void rjesenje4(View v)
    {
        findViewById(R.id.rjesenje4).setVisibility(View.VISIBLE);
        findViewById(R.id.button4).setVisibility(View.GONE);

    }
    public void rjesenje5(View v)
    {
        findViewById(R.id.rjesenje5).setVisibility(View.VISIBLE);
        findViewById(R.id.button5).setVisibility(View.GONE);

    }





public void otvoriTeorija(View v)
    {Intent i=new Intent(this,teorijaActivity.class);
        startActivity(i);}
public void otvoriZadaci(View v){ Intent i=new Intent(this,zadaciActivity.class);
    startActivity(i);}
    public void otvoriKviz(View v)
    {Intent i=new Intent(this,pitanje1activity.class);
    startActivity(i);}
public void otvoriSimulacija(View v)    {Intent i=new Intent(this,MainActivitySimulacija.class);
        startActivity(i);}

}
