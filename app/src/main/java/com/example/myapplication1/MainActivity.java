package com.example.myapplication1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
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

        //чтоб взять число с EditText
        EditText inputnumbr=findViewById(R.id.inputnumber);
        int number=Integer.parseInt(inputnumbr.getText().toString());
        //Чтоб вывеси результат в TextView
        TextView outputnumbr= (TextView) findViewById(R.id.OutputNumber);
        //переменные для вычисления Фибоначчи
        int f = 0, g = 1;
        //чтоб работать с прогрессбаром
        ProgressBar mProgressBar=(ProgressBar) findViewById(R.id.mprogressBar);
        //устанавливаем минимальное и максимальное значения progressbar
        mProgressBar.setMax(number);
        mProgressBar.setMin(0);
        //устанавливаем шаг
        int counter=0;

        //вычисляем число Фибоначчи
        for (int i = 1; number>= i; i++)
        {
            f = f + g;
            g = f - g;

            outputnumbr.setText(String.valueOf(f));
            counter++;
            mProgressBar.setProgress(counter);

        }

    }
}