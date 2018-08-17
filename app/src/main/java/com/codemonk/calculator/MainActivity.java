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

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * Calculator app
 * By
 * Shriharsha M Bhat
 */

public class MainActivity extends AppCompatActivity {

    private int[] numericButtons = {R.id.btn_one,R.id.btn_two,R.id.btn_three,R.id.btn_four,R.id.btn_five,R.id.btn_six,R.id.btn_seven,R.id.btn_eight,R.id.btn_nine,R.id.btn_zero};
    private int[] operatorButtons = {R.id.btn_divide,R.id.btn_plus,R.id.btn_minus,R.id.btn_multiply};
    private TextView txtScreen;
    private boolean lastNumeric;
    private boolean stateError;
    private boolean lastDot;
    View view1,view2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view1 = getLayoutInflater().inflate(R.layout.layout2, null);
        view2 = getLayoutInflater().inflate(R.layout.about_me, null);

        setContentView(view1);

        this.txtScreen = (TextView) findViewById(R.id.edt_txt);
        setNumericOnClickListener();
        setOperatorOnClickListener();
    }

    private void setNumericOnClickListener() {
        //common OnClickListener
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                if (stateError) {
                    txtScreen.setText(button.getText());
                    stateError = false;
                } else {
                    txtScreen.append(button.getText());
                }
                lastNumeric = true;
            }
        };
        for (int id : numericButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOperatorOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastNumeric && !stateError) {
                    Button button = (Button) v;
                    txtScreen.append(button.getText());
                    lastNumeric = false;
                    lastDot = false;
                }
            }
        };
        for (int id : operatorButtons) {
            findViewById(id).setOnClickListener(listener);
        }
        // Decimal point
        findViewById(R.id.btn_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastNumeric && !stateError && !lastDot) {
                    txtScreen.append(".");
                    lastNumeric = false;
                    lastDot = true;
                }

            }
        });

        // Clear button
        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtScreen.setText("");
                lastNumeric = false;
                stateError = false;
                lastDot = false;
            }
        });

        // Equal button
        findViewById(R.id.btn_equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqual();
            }
        });
    }

    private void onEqual() {
        if (lastNumeric && !stateError) {
            String txt = txtScreen.getText().toString();
            Expression expression = new ExpressionBuilder(txt).build();
            try {
                double result = expression.evaluate();
                txtScreen.setText(Double.toString(result));
                lastDot = true;
            } catch (ArithmeticException ex) {
                txtScreen.setText("Error");
                stateError = true;
                lastNumeric = false;
            }
        }
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



