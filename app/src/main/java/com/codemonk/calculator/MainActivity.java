package com.codemonk.calculator;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Calculator app
 * By
 * Shriharsha M Bhat
 */

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,bdot,b0,bequal,bdivide,bplus,bminus,bmulti,bclear;

    Boolean add=false,sub=false,divide=false,multiply=false;

    Double value1,value2;

    TextView edttxt;
    View view1,view2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.layout1);
        view1=getLayoutInflater().inflate(R.layout.layout1,null);
        view2=getLayoutInflater().inflate(R.layout.about_me,null);

        setContentView(view1);
        b1= (Button) findViewById(R.id.btn_one);
        b2= (Button) findViewById(R.id.btn_two);
        b3= (Button) findViewById(R.id.btn_three);
        b4= (Button) findViewById(R.id.btn_four);
        b5= (Button) findViewById(R.id.btn_five);
        b6= (Button) findViewById(R.id.btn_six);
        b7= (Button) findViewById(R.id.btn_seven);
        b8= (Button) findViewById(R.id.btn_eight);
        b9= (Button) findViewById(R.id.btn_nine);
        b0= (Button) findViewById(R.id.btn_zero);
        bdot= (Button) findViewById(R.id.btn_dot);
        bequal= (Button) findViewById(R.id.btn_equal);
        bdivide= (Button) findViewById(R.id.btn_divide);
        bplus= (Button) findViewById(R.id.btn_plus);
        bminus= (Button) findViewById(R.id.btn_minus);
        bmulti= (Button) findViewById(R.id.btn_multiply);
        bclear= (Button) findViewById(R.id.btn_clear);
        edttxt= (TextView) findViewById(R.id.edt_txt);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.click);
        final MediaPlayer mediaPlayer1= MediaPlayer.create(this,R.raw.result);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                edttxt.setText(edttxt.getText()+"1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                edttxt.setText(edttxt.getText()+"2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                edttxt.setText(edttxt.getText()+"3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                edttxt.setText(edttxt.getText()+"4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                edttxt.setText(edttxt.getText()+"5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                edttxt.setText(edttxt.getText()+"6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                edttxt.setText(edttxt.getText()+"7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                edttxt.setText(edttxt.getText()+"8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                edttxt.setText(edttxt.getText()+"9");
            }
        });

        bdot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                edttxt.setText(edttxt.getText()+".");
            }
        });

        b0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                edttxt.setText(edttxt.getText()+"0");
            }
        });

        bequal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                value2=Double.parseDouble(edttxt.getText()+"");
                edttxt.setText("=");
                edttxt.setText(null);


                mediaPlayer1.start();
                if(add==true)
                {
                    edttxt.setText(value1+value2+"");
                    add=false;
                }
                else if(sub==true)
                {
                    edttxt.setText(value1-value2+"");
                    sub=false;
                }
                else if(multiply==true)
                {
                    edttxt.setText(value1*value2+"");
                    multiply=false;
                }
                else if(divide==true)
                {
                    if(value2!=0)
                    {
                        edttxt.setText(value1/value2+"");
                        divide=false;
                    }
                    else
                        edttxt.setText("Error");

                }

            }
        });

        bdivide.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                  value1 =Double.parseDouble(edttxt.getText()+"");
                    divide = true;
                    edttxt.setText(null);

            }
        });

        bmulti.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                    value1 = Double.parseDouble(edttxt.getText() + "");
                    //edttxt.setText(" * ");
                    multiply = true;
                    edttxt.setText(null);

            }
        });

        bplus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                    value1= Double.parseDouble(edttxt.getText()+"");
                    //edttxt.setText( " + ");
                    add = true;
                    edttxt.setText("+");

            }
        });

        bminus.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                  String x = edttxt.getText().toString();
                  value1= Double.parseDouble(x);
                 // value1= Double.parseDouble(edttxt.getText()+"");
                    //edttxt.setText( " - ");
                    sub = true;
                    edttxt.setText(null);

            }
        });

        bclear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
             edttxt.setText("");
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        switch(id)
        {
            case R.id.abt_me :
                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
                setContentView(view2);
                TextView textView2= (TextView) findViewById(R.id.textView2);
                textView2.setText("Shriharsha M\nNational Institute Of Engineering, Mysore\n+91 9483904242\nshriharsha05@gmail.com");
                break;
            case R.id.blog :
                Toast.makeText(this,"Blog",Toast.LENGTH_LONG).show();
                String url = "http://hackersheavenblog.blogspot.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.wapp : String message = "Hey there!!\nCheck this awesome calculator app :)";
                             Intent sendIntent = new Intent();
                             sendIntent.setAction(Intent.ACTION_SEND);
                             sendIntent.putExtra(Intent.EXTRA_TEXT,message);
                             sendIntent.setType("text/plain");
                             sendIntent.setPackage("com.whatsapp");
                             startActivity(sendIntent);
            case R.id.home_btn:setContentView(view1);


        }
        return true;
    }


}



