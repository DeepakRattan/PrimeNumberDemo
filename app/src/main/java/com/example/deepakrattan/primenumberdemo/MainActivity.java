package com.example.deepakrattan.primenumberdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtLowerLimit, edtUpperLimit;
    private Button btnPrime;
    private TextView txtPrime;
    int lowerLimit, upperLimit;
    boolean flag = false;
    StringBuffer buffer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewByID
        edtLowerLimit = (EditText) findViewById(R.id.edtLowerLimit);
        edtUpperLimit = (EditText) findViewById(R.id.edtUpperlimit);
        btnPrime = (Button) findViewById(R.id.btnPrime);
        txtPrime = (TextView) findViewById(R.id.txtPrime);
        buffer = new StringBuffer();

        btnPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("onClick", "button clicked");
                lowerLimit = Integer.parseInt(edtLowerLimit.getText().toString());
                upperLimit = Integer.parseInt(edtUpperLimit.getText().toString());

                Log.e("upper Limit", String.valueOf(upperLimit));
                Log.e("lower Limit", String.valueOf(lowerLimit));

                for (int i = lowerLimit; i < upperLimit; i++) {

                    for (int j = 2; j < i; j++) {

                        if (i % j == 0) {
                            flag = false;
                            break;
                        } else {
                            flag = true;
                            // buffer.append(i + ", ");
                            // Log.e("buffer", buffer.toString());

                        }
                    }


                    if (flag) {
                        buffer.append(i + ",");
                    }
                }

                char c = buffer.charAt(buffer.length() - 1);
                if (c == ',') {
                    buffer.deleteCharAt(buffer.length() - 1);
                }
                //Toast.makeText(MainActivity.this, buffer.toString(), Toast.LENGTH_LONG).show();
                txtPrime.setText(buffer);


            }
        });

    }
}
