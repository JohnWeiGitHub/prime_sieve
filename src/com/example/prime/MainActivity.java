package com.example.prime;

import java.util.ArrayList;

import android.os.Bundle;
import android.R.string;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements Button.OnClickListener {
    EditText editInput;
    TextView textPrime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         editInput = (EditText)this.findViewById(R.id.editText1);
         textPrime  = (TextView)this.findViewById(R.id.textView2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        int input;
        input = Integer.parseInt(editInput.getText().toString());
        listAllPrime(input);
        
    }
    void listAllPrime (int input)
    {
        ArrayList<Boolean> primeList = new ArrayList<Boolean>();
        primeList.add(0, false);
        primeList.add(1, false);
        for(int i=0;i<=input;i++)
            primeList.add(i,true);
        for(int i=2;i<Math.sqrt(input);i++) {
            for(int j=i+i;j<=input;j+=i){
                /*if(primeList.get(j) == true) {
                    if(j%i == 0){
                        primeList.set(j, false);
                    }
                }
                */
                primeList.set(j, false);
            }            
        }
        String strPrimeList = new String();
        for(int i=0;i<=input;i++){
            if(primeList.get(i)==true) {
                strPrimeList= strPrimeList+" "+i;
            }
        }
        textPrime.setText(strPrimeList);        
    }
}
