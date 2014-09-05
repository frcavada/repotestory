package com.example.spawn.myapplication2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends Activity {

    int counter = 0;
    int result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my);
    }
    public void onClick(View view){
        TextView textView = (TextView)findViewById(R.id.textViewResult);
        if (counter == 0)textView.setText("");
        counter++;
        if (view instanceof Button){
            Button button = (Button) view;
            if (button.getText().equals("Solve") && counter == 4){
                counter = 0;
                char op = textView.getText().charAt(1);
                int a = Integer.parseInt(textView.getText().charAt(0)+"");
                int b = Integer.parseInt(textView.getText().charAt(2)+"");

                switch (op){
                    case '+':
                        result = (a+b);
                        break;
                    case '-':
                        result = (a - b);
                        break;
                    case 'X':
                        result = (a * b);
                        break;
                    case '/':
                        result = (a / b);
                        break;
                }
                textView.setText(""+result);
            }
            else textView.append(button.getText());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
