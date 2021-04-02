package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Calculatebutton_click(View view)
    {
        //чтоб взять число с EditText
        EditText inputnumbr=findViewById(R.id.inputnumber);
        int number=Integer.parseInt(inputnumbr.getText().toString());
        //Чтоб вывеси результат в TextView
        TextView outputnumbr= (TextView) findViewById(R.id.OutputNumber);

        //вычисляем фиббоначи
        int f = 0, g = 1;

        for (int i = 1; number >= i; i++) {
            System.out.print(f + " ");
            f = f + g;
            g = f - g;
            outputnumbr.setText(String.valueOf(f));
        }

    }
}