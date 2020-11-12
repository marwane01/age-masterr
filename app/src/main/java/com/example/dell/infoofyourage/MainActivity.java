package com.example.dell.infoofyourage;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;



public class MainActivity extends AppCompatActivity {
    EditText birthyear,birthmonth,birthday;
    Button butoonview,reset;
    TextView textView1,textView2,textView3,textView4,textView5;
    conterm ct;
    int sum9;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        birthyear= findViewById(R.id.birthyear);
        birthmonth= findViewById(R.id.birthmonth);
        birthday= findViewById(R.id.birthday);
        butoonview= findViewById(R.id.calcul);
        textView1=findViewById( R.id.Yearss );
        textView2=findViewById( R.id.Monthss );
        textView3=findViewById( R.id.Dayss );
        textView4=findViewById( R.id.Hourss );
        textView5=findViewById( R.id.Secondss );
        reset=(Button)findViewById( R.id.reset );
        reset.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reseeet();
            }
        });



    }


    public void startt(View view) {

        try{


            Calendar calendar=Calendar.getInstance();
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH);
            int day=calendar.get(Calendar.DAY_OF_MONTH);
            int hour=calendar.get(Calendar.HOUR_OF_DAY);
            int minute=calendar.get(Calendar.MINUTE);
            int second=calendar.get(Calendar.SECOND);

            int birthYear = Integer.parseInt(birthyear.getText() + "");
            int birthMonth = Integer.parseInt(birthmonth.getText() + "");
            int birthDay = Integer.parseInt(birthday.getText() + "");


            int summ = year - birthYear;
            int sum = (year - 1) - birthYear;
            int sum2 = sum * 12;
            int sum3 = (12 - birthMonth) + (month - 1);
            int sum4 = sum2 + sum3;
            int sum5 = sum4 * 30;
            int sum6 = (30 - birthDay) + day;
            int sum7 = sum5 + sum6;
            int sum8 = (sum7 * 24) + hour;
            sum9 = (sum8 * 3600) + (minute * 60) + second;

            if(birthMonth < month){
                textView1.setText( "Years : "+summ );}

            if(birthMonth == month){
                if (birthDay==day){
                    textView1.setText( "Years : "+summ );
                }

                if (birthDay<day){
                    textView1.setText( "Years : "+summ );
                }
                if (birthDay>day){
                    textView1.setText( "Years : "+sum );
                }
            }

            if(birthMonth > month){
                textView1.setText( "Years : "+sum ); }

            textView2.setText( "Months : " + sum4);
            textView3.setText( "Days : " + sum7 );
            textView4.setText( "Hours : " + sum8+" h" );


        }catch(Exception ex){
            System.out.println( ex );
        }

        starttime();
    }

         void starttime() {

            ct = new conterm(10000, 1000);


            ct.start();

        }

        public class conterm extends CountDownTimer {
            conterm(long millisInFuture, long contDownTimer) {
                super(millisInFuture, contDownTimer);
            }

            @Override
            public void onTick(long millisUntilFinished) {

                textView5.setText("Seconds : " + String.valueOf(sum9) + "s");
                sum9++;

            }

            @Override
            public void onFinish() {
                starttime();
            }
        }

        private void reseeet() {
            recreate();
        }

}
