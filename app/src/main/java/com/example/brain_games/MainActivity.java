package com.example.brain_games;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Random random = new Random();
    TextView textView;Button btn,btn2,btn3,btn4;
    Button[] all;int c,correct=0,total=0;TextView textView1;TextView textViewl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public  void Onclick(View v){
        final Button bt6=(Button)findViewById(R.id.button5);
        textView = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        final TextView textView2=(TextView)findViewById(R.id.textView4);
        textView1 = (TextView) findViewById(R.id.textView2);
        textViewl=(TextView)findViewById(R.id.textView3);
        textView1.setVisibility(View.INVISIBLE);
        textViewl.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        btn.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        bt6.setVisibility(View.INVISIBLE);
        btn.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        correct=0;total=0;
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                textView2.setText(String.valueOf(millisUntilFinished/1000+" sec"));
            }

            @Override
            public void onFinish() {
                textView1.setText("DONE!!!");
                bt6.setText("Once More!!!");
                bt6.setVisibility(View.VISIBLE);
                bt6.setBackgroundColor(Color.BLUE);
                correct=0;
                total=0;
                btn.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);


            }
        }.start();
        dash();
    }
    private void dash(){
        int x = new Random().nextInt(100);
        int y = new Random().nextInt(100);
        int z = x + y;
        textView.setText(Integer.toString(x) + " + " + Integer.toString(y));
        all= new Button[]{btn, btn2, btn3, btn4};
        c=random.nextInt(all.length);
        Button bt5 = all[c];
        for(int i=0;i<all.length;i++){
            if(i==c){
                all[c].setText(Integer.toString(z));
            }
            else{
                all[i].setText(Integer.toString(random.nextInt(200)));
            }
        }
        bt5.setText(Integer.toString(x + y));
        bt5.setOnClickListener(this);
        btn.setOnClickListener( this);
        btn2.setOnClickListener( this);
        btn3.setOnClickListener( this);
        btn4.setOnClickListener( this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==all[c].getId()){
            textView1.setText("Correct!!");
            correct++;
        }
        else{
            textView1.setText("Wrong :(");
        }
        total++;

        textViewl.setVisibility(View.VISIBLE);
        textViewl.setText(Integer.toString(correct)+"/"+Integer.toString(total));
        textView1.setVisibility(View.VISIBLE);
        dash();
    }
}







