package com.example.adin.ka;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MainActivitySimulacija extends AppCompatActivity {
    //V mView =new V(MainActivity.this);
    // mView.setData(new Bundle());
    AlertDialog.Builder alertDialog;
    String string = "";
    EditText editText;
    int opcija = 0;
    V myV;

    public void posalji(V v)
    {
        v.stringV=string;
    }
    public void opcija1(View v) {

        alertDialog=new AlertDialog.Builder(MainActivitySimulacija.this);

        alertDialog.setTitle("ime stanja");
        alertDialog.setMessage("unesi naziv stanja");
        final EditText input = new EditText(getApplicationContext());
        input.setTextColor(Color.BLACK);
        input.setBackgroundColor(Color.WHITE);
        input.setPadding(0,0,0,5);


        //final Message input1=new Message(getApplicationContext());
        final CheckBox checkBox =new CheckBox(getApplicationContext());
        checkBox.setText("Prihvatljivo stanje");
        checkBox.setTextColor(Color.BLACK);
        final LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.addView(input);
        linearLayout.addView(checkBox);
        alertDialog.setView(linearLayout);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //You will get as string input data in this variable.
                // here we convert the input to a string and show in a toast.
                String srt = input.getEditableText().toString();
string=srt;
myV.stringV=srt;
                if(checkBox.isChecked())
                    myV.prihvatljivoStanje=true;

                Toast.makeText(getApplicationContext(),string,Toast.LENGTH_LONG).show();
                opcija=1;
                dialog.cancel();



            }

        });

        AlertDialog alert = alertDialog.create();
        alert.show();

        opcija = 1;
    }

    public void opcija2(View v) {

        alertDialog=new AlertDialog.Builder(MainActivitySimulacija.this);

        alertDialog.setMessage("Unesi granu");
        final EditText input = new EditText(getApplicationContext());
        input.setHint("Od: ");
        input.setTextColor(Color.BLACK);
        input.setBackgroundColor(Color.WHITE);
        input.setPadding(0,0,0,5);
        final EditText input1=new EditText(getApplicationContext());
        input1.setHint("Do: ");
        input1.setTextColor(Color.BLACK);
        input1.setBackgroundColor(Color.WHITE);
        final  EditText input2=new EditText(getApplicationContext());
        input2.setHint("Simbol: ");
        input2.setTextColor(Color.BLACK);
        input2.setBackgroundColor(Color.WHITE);
        final LinearLayout layout=new LinearLayout(this);


        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(input);
        layout.addView(input1);
        layout.addView(input2);
        alertDialog.setView(layout);

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //You will get as string input data in this variable.
                // here we convert the input to a string and show in a toast.
                String srt = input.getEditableText().toString();
                String srt1 = input1.getEditableText().toString();
                String srt2 = input2.getEditableText().toString();
                string=srt;
                myV.stringV=srt;
               // Toast.makeText(getApplicationContext(),string,Toast.LENGTH_LONG).show();



                int a=0;
                while ( a<myV.konacniAutomat.velicina())
                {if (!myV.konacniAutomat.getStanje(a).getNaziv().equals(srt))
                { a++;}
                else  break;}
                int a1=0;
                while ( a1<myV.konacniAutomat.velicina())
                {if (!myV.konacniAutomat.getStanje(a1).getNaziv().equals(srt1))
                { a1++;}
                else  break;}
                if(a==myV.konacniAutomat.velicina() || a1==myV.konacniAutomat.velicina())
                {
                    //dialog.cancel();
                    Toast toast= Toast.makeText(MainActivitySimulacija.this, "Unijeli ste nepostojeće stanje.", Toast.LENGTH_SHORT);
                    toast.show();
                    dialog.cancel();
                    return;
                }

                int b=0;
                while (b<myV.konacniAutomat.duzinaAlfabeta())
                { if(!(String.valueOf(myV.konacniAutomat.getAlfabet(b)).equals(srt2)))
                {b++;}
                else break;}
                if(!daLiIspravanString(srt2))
                {
                    Toast toast= Toast.makeText(MainActivitySimulacija.this, "Unijeli ste nepostojeći simbol.", Toast.LENGTH_SHORT);
                    toast.show();
                    dialog.cancel();
                    return;
                }

    myV.konacniAutomat.prelazi.get(a).set(b,srt1);
                dialog.cancel();

            }

        });

        AlertDialog alert = alertDialog.create();
        alert.show();


    }
    public boolean daLiIspravanString(String s)
    {
        boolean ispravan=false;
        for(int j=0;j<s.length();j++)
        {ispravan=false;
            for (int i=0;i<myV.konacniAutomat.duzinaAlfabeta();i++)
        { if(s.charAt(j)==myV.konacniAutomat.getAlfabet(i))
     ispravan=true;
            if(i+1==myV.konacniAutomat.duzinaAlfabeta() && ispravan==false)
        return  false;}
        }
        return true;
    }
    public void provjeriString(View v)
    {

        EditText editText=(EditText) findViewById(R.id.unesiString);
        editText.getText().toString();
        String s=editText.getText().toString();

      if(!daLiIspravanString(s))
      {
          Toast toast= Toast.makeText(MainActivitySimulacija.this, "Nije ispravan string, jer postoje simboli koji nisu dio alfabeta", Toast.LENGTH_SHORT);
          toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,250);
          toast.show();
      }
          else{
        if (myV.konacniAutomat.provjeriString(s)) {
            Toast toast= Toast.makeText(MainActivitySimulacija.this, "Automat prihvaća riječ "+s+"\n"+myV.konacniAutomat.prelaziStanja(s), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,250);
            toast.show();
        } else {
            Toast toast= Toast.makeText(MainActivitySimulacija.this, "Automat ne prihvaća riječ "+s+"\n"+myV.konacniAutomat.prelaziStanja(s), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,250);
            toast.show();
    }}

        TextView textView=  (TextView) findViewById(R.id.prelazakStanja);
        textView.setText(myV.konacniAutomat.prelaziStanja(s));
        textView.setVisibility(View.VISIBLE);
        textView.setFocusable(true);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simulacija_activity_main);
        V drawCross = new V(this);
        myV=drawCross;
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.view);
        layout1.addView(drawCross);
        alertDialog=new AlertDialog.Builder(MainActivitySimulacija.this);

        alertDialog.setTitle("Alfabet");
        alertDialog.setMessage("Unesite sve simbole alfabeta(Σ) koji će biti korišteni za simulaciju:");
        final EditText input = new EditText(getApplicationContext());
        input.setHint("Npr: abc");
        alertDialog.setView(input);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //You will get as string input data in this variable.
                // here we convert the input to a string and show in a toast.
                String srt = input.getEditableText().toString();
                myV.konacniAutomat.setAlfabet(srt);

                Toast.makeText(getApplicationContext(),srt,Toast.LENGTH_LONG).show();
                dialog.cancel();

            }

        });

        AlertDialog alert = alertDialog.create();
        alert.show();

        // setContentView(new V(this));
      //  KonacniAutomat konacniAutomat = new KonacniAutomat();
//        Point po = new Point(15, 15);
        //Point po1 = new Point(30, 80);


       // Stanje s = new Stanje("a1", po);
        //Stanje s1 = new Stanje("b1", po1);
        //drawCross.konacniAutomat.dodajStanje(s);
        //s.getNaziv();
      // konacniAutomat.dodajStanje(s);
       /* konacniAutomat.dodajStanje(s1);
        konacniAutomat.setPocetnoStanje(s);
        konacniAutomat.dodajFinalnoStanje(s1);
        konacniAutomat.setAlfabet("ab");*/
       /* if (konacniAutomat.provjeriString("aaaabbbab")) {
            Toast.makeText(MainActivity.this, "tacno", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "netacno", Toast.LENGTH_SHORT).show();
        }*/


    }
    /**
     * Created by adin on 6/5/2016.
     */
    public  class V extends View
    {

       public String stringV="adin";
        Bundle bundle=new Bundle();
public boolean prihvatljivoStanje=false;

        public void setData(Bundle data)
        {
            bundle =data;
        }

        KonacniAutomat konacniAutomat=new KonacniAutomat();
        //s.getNaziv();
        //konacniAutomat.dodajStanje(s);
       // EditText editText;
        private List<Point> stanja=new ArrayList<Point>();
        Point p=new Point();
String nazivStanja="adin";
          public V(Context con)
          {
              super(con);
          }
        public V getView()
        {return  this;}

        public String unesiNazivStanja() {

            alertDialog=new AlertDialog.Builder(MainActivitySimulacija.this);

            alertDialog.setTitle("ime stanja");
            alertDialog.setMessage("unesi naziv stanja");
            final EditText input = new EditText(getApplicationContext());

            alertDialog.setView(input);
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                    //You will get as string input data in this variable.
                    // here we convert the input to a string and show in a toast.
                    String srt = input.getEditableText().toString();
                    stringV =srt;

                    Toast.makeText(getApplicationContext(),srt,Toast.LENGTH_LONG).show();
dialog.cancel();

                }

            });

            AlertDialog alert = alertDialog.create();
            alert.show();
            //stringV=input.getEditableText().toString();
            return stringV;
        }
        public void opcija1(View v)
        {
            alertDialog=new AlertDialog.Builder(MainActivitySimulacija.this);

            alertDialog.setTitle("ime stanja");
            alertDialog.setMessage("unesi naziv stanja");
            final EditText input = new EditText(getApplicationContext());
            alertDialog.setView(input);
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    //You will get as string input data in this variable.
                    // here we convert the input to a string and show in a toast.
                    String srt = input.getEditableText().toString();

                    stringV=srt;
                    //Toast.makeText(getApplicationContext(),stringV,Toast.LENGTH_LONG).show();
                    dialog.cancel();
                    stringV =srt;
                    opcija=1;

                }

            });

            AlertDialog alert = alertDialog.create();
            alert.show();

        }
@Override
        public boolean onTouchEvent(MotionEvent e)
        {
            if(opcija==1)
            {

            Point p=new Point();
            p.x=(int)e.getX();
            p.y=(int)e.getY();
               // konacniAutomat.setPoint(p);
               // unesiNazivStanja();
            int nalegla=0;
            int visina=0;
            int h=0;
            double hipotenuza=0;
            for(int i=0;i<konacniAutomat.velicina();i++)
            {
                 nalegla=(p.x-konacniAutomat.getStanje(i).getX());
                 visina=(p.y-konacniAutomat.getStanje(i).getY());
                 h=(nalegla*nalegla+visina*visina);
                 hipotenuza=Math.sqrt(h);
                if(hipotenuza<(double)100)
                    return false;
            }

               nazivStanja = stringV;

                Stanje s=new Stanje(nazivStanja,p);

konacniAutomat.dodajStanje(s);
                if(prihvatljivoStanje)
                {konacniAutomat.dodajFinalnoStanje(s);
                prihvatljivoStanje=false;}

                opcija=0;
               // Toast.makeText(MainActivity.this,String.valueOf(konacniAutomat.prelazi.size()+konacniAutomat.stanja.size()),Toast.LENGTH_SHORT).show();

                return true;}
            opcija=0;
            return true;
        }


@Override
        protected void onDraw(Canvas c) {
    super.onDraw(c);

    Paint paint = new Paint();
    paint.setColor(Color.BLACK);
    paint.setStrokeWidth(5);
    Paint slova = new Paint();
    slova.setColor(Color.BLACK);
    slova.setStrokeWidth(10);
    slova.setTextSize(30);
    paint.setStyle(Paint.Style.STROKE);
    Paint unutrasnjost=new Paint();
    unutrasnjost.setColor(Color.WHITE);
    konacniAutomat.prelazi=myV.konacniAutomat.prelazi;


    String h="";
    for (int i = 0; i < konacniAutomat.prelazi.size(); i++) {
        for (int j = 0; j < konacniAutomat.prelazi.get(i).size(); j++) {
            if (!(konacniAutomat.prelazi.get(i).get(j).equals("")))
            {
                int a=0;
                while (a<konacniAutomat.velicina())
                if (!(konacniAutomat.prelazi.get(i).get(j).equals(konacniAutomat.getStanje(a).getNaziv())))
                    a++;
                else {
                    break;}


                c.drawLine(konacniAutomat.getStanje(i).getX(), konacniAutomat.getStanje(i).getY(), konacniAutomat.getStanje(a).getX(), konacniAutomat.getStanje(a).getY(), paint);
                double d = 20;
                d = d * Math.PI / 180;
                int x1 = konacniAutomat.getStanje(a).getX();
                int y1 = konacniAutomat.getStanje(a).getY();
                int x2 = konacniAutomat.getStanje(i).getX();
                int y2 = konacniAutomat.getStanje(i).getY();
                int nalegla = (x2 - x1);
                int visina = (y2 - y1);

                double ugao = Math.atan2(visina, nalegla);


                float sredinaX = (float) ((konacniAutomat.getStanje(a).getX()+50*Math.cos(ugao)));
                float sredinaY = (float) ((konacniAutomat.getStanje(a).getY()+50*Math.sin(ugao)));


                float sx2 = (float) (sredinaX + 40 * Math.cos(d));
                float sy2 = (float) (sredinaY + 40 * Math.sin(-d));

                float sx3 = (float) (sredinaX + 40 * Math.cos(-d));
                float sy3 = (float) (sredinaY + 40 * Math.sin(d));

                // p'x = cos(theta) * (px-ox) - sin(theta) * (py-oy) + ox

                // p'y = sin(theta) * (px-ox) + cos(theta) * (py-oy) + oy
                float sX = (float) (Math.cos(ugao) * (sx2 - sredinaX) - Math.sin(ugao) * (sy2 - sredinaY) + sredinaX);
                float sY = (float) (Math.sin(ugao) * (sx2 - sredinaX) + Math.cos(ugao) * (sy2 - sredinaY) + sredinaY);
                float sX1 = (float) (Math.cos(ugao) * (sx3 - sredinaX) - Math.sin(ugao) * (sy3 - sredinaY) + sredinaX);
                float sY1 = (float) (Math.sin(ugao) * (sx3 - sredinaX) + Math.cos(ugao) * (sy3 - sredinaY) + sredinaY);
if(i==a)
{
    c.drawCircle(konacniAutomat.getStanje(i).getX(),konacniAutomat.getStanje(i).getY()-50,40,paint);
    c.drawLine (konacniAutomat.getStanje(i).getX()+5,konacniAutomat.getStanje(i).getY()-90,
            (float) (konacniAutomat.getStanje(i).getX()+5 - 30 * Math.cos(d+Math.toRadians(15))),
            (float) (konacniAutomat.getStanje(i).getY()-90 - 30 * Math.sin(-d-Math.toRadians(15))),paint);
    c.drawLine (konacniAutomat.getStanje(i).getX()+5,konacniAutomat.getStanje(i).getY()-90,
            (float) (konacniAutomat.getStanje(i).getX()+5 - 30 * Math.cos(-d+Math.toRadians(5))),
            (float) (konacniAutomat.getStanje(i).getY()-90 - 30 * Math.sin(d-Math.toRadians(5))),paint);
    String string="";
    for(int z=0;z<=j;z++)
        if(konacniAutomat.prelazi.get(i).get(z).equals(konacniAutomat.prelazi.get(i).get(j)))
            if(string.equals(""))
                string+=konacniAutomat.getAlfabet(z);
    else
            string+=", "+konacniAutomat.getAlfabet(z);

    c.drawText(string,konacniAutomat.getStanje(i).getX()+5,konacniAutomat.getStanje(i).getY()-100,slova);

}
                else {
    String string="";
    for(int z=0;z<=j;z++)
        if(konacniAutomat.prelazi.get(i).get(z).equals(konacniAutomat.prelazi.get(i).get(j)))
            if(string.equals(""))
                string+=konacniAutomat.getAlfabet(z);
            else
                string+=", "+konacniAutomat.getAlfabet(z);
               c.drawLine(sredinaX, sredinaY, sX, sY, paint);
                c.drawLine(sredinaX, sredinaY, sX1, sY1, paint);



    c.drawText(string, (float) (Math.cos(ugao)*(25)-Math.sin(ugao)*(35)+sredinaX ),
            (float) ((float) Math.sin(ugao)*(25)+Math.cos(ugao)*(35)+sredinaY), slova);
    }

            }
        }


    }
    for (int i = 0; i < konacniAutomat.velicina(); i++) {
       c.drawCircle(konacniAutomat.getStanje(i).getX(), konacniAutomat.getStanje(i).getY(), 50, unutrasnjost);
        c.drawCircle(konacniAutomat.getStanje(i).getX(), konacniAutomat.getStanje(i).getY(), 50, paint);
        c.drawText(konacniAutomat.getStanje(i).getNaziv(), konacniAutomat.getStanje(i).getX()-10, konacniAutomat.getStanje(i).getY(), slova);
    }
    Stanje s=konacniAutomat.getPocetnoStanje();
    if(s!=null) {
        c.drawLine(s.getX() - 110, s.getY(), s.getX() - 50, s.getY(), paint);
        c.drawLine(s.getX()-50,s.getY(),(float)( s.getX()-50-40*Math.cos(Math.toRadians(20))),
                (float) (s.getY()+40*Math.sin(-Math.toRadians(20))),paint);
        c.drawLine(s.getX()-50,s.getY(),(float)( s.getX()-50-40*Math.cos(-Math.toRadians(20))),
                (float) (s.getY()+40*Math.sin(Math.toRadians(20))),paint);

    }

    for(int i=0;i<konacniAutomat.finalnaStanjaSize();i++)
    {
        c.drawCircle(konacniAutomat.getFinalnoStanje(i).getX(),konacniAutomat.getFinalnoStanje(i).getY(),41,paint);
    }
            invalidate();


        }
    }


}
