package com.example.myapplication1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Calculatebutton_click(View view)
    {
        //create hundler to update the activity components from the thread
        final Handler handler=new Handler();
        //to take the number from EditText
        EditText inputnumbr=findViewById(R.id.inputnumber);
        final int number=Integer.parseInt(inputnumbr.getText().toString());
        //To post the result in TextView
        final TextView outputnumbr= (TextView) findViewById(R.id.OutputNumber);
        outputnumbr.setText("0");
        //variables for calculating Fibonacci
        final int[] f = {0};
        final int[] g = { 1 };
        //to work with progress bar
        final ProgressBar mProgressBar=(ProgressBar) findViewById(R.id.mprogressBar);
        //set the minimum and maximum values of the progressbar
        mProgressBar.setProgress(0);
        mProgressBar.setMax(number);
        mProgressBar.setMin(0);
        //set the step of the progress bar
        final int[] counter = {0};
        //create a thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                //calculate fibonacci number
                for (int i = 1; number>= i; i++)
                {
                    f[0] = f[0] + g[0];
                    g[0] = f[0] - g[0];
                    counter[0]++;
                    try
                    {
                        Thread.sleep(1000);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            //update progress bar and result
                            outputnumbr.setText(String.valueOf(f[0]));
                            mProgressBar.setProgress(counter[0]);
                        }
                    });
                }
            }
        }).start();
    }
}