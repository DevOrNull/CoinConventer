package com.coinconventer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Float.valueOf;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        //implementing OnClickListener (need to override the method)
        button.setOnClickListener(this);

    }

        public void onClick(View v){

            EditText editTextPrice = (EditText) findViewById(R.id.editTextPrice);

            EditText editTextCoinsForRubles = (EditText) findViewById(R.id.editTextCoinsForRubles);
            TextView textViewCoinsForRubles = (TextView) findViewById(R.id.textViewCoinsForRubles);

            if (editTextCoinsForRubles.getText().toString().isEmpty()
                    || editTextCoinsForRubles.getText().toString().equals(".")
                    || editTextPrice.getText().toString().isEmpty()
                    || editTextPrice.getText().toString().equals(".")) {
                textViewCoinsForRubles.setText("0");
                return;
            }

            Float mPrice = Float.parseFloat(editTextPrice.getText().toString());
            Float mCoinToRubles = Float.parseFloat(editTextCoinsForRubles.getText().toString());

            textViewCoinsForRubles.setText(String.format("%.2f", mCoinToRubles * mPrice));

            // RublesForCoins
            TextView textViewRublesForCoins = (TextView) findViewById(R.id.textViewRublesForCoins);
            EditText editTextRublesForCoins = (EditText) findViewById(R.id.editTextRublesForCoins);

            if (editTextPrice.getText().toString().isEmpty()
                    || editTextPrice.getText().toString().equals(".")
                    || editTextRublesForCoins.getText().toString().isEmpty()
                    || editTextRublesForCoins.getText().toString().equals(".")) {
                textViewRublesForCoins.setText("0");
                return;
            }

            Float mRublesForCoins = Float.parseFloat(editTextRublesForCoins.getText().toString());

            textViewRublesForCoins.setText(String.format("%.2f", mRublesForCoins / mPrice) + " kk");
            textViewCoinsForRubles.setText(String.format("%.2f", mCoinToRubles * mPrice));

        }


/*        final EditText editTextCoinsForRubles = (EditText) findViewById(R.id.editTextCoinsForRubles);
        editTextCoinsForRubles.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                TextView textViewCoinsForRubles = (TextView) findViewById(R.id.textViewCoinsForRubles);
                EditText editTextPrice = (EditText) findViewById(R.id.editTextPrice);

                if (editTextCoinsForRubles.getText().toString().isEmpty()
                        || editTextCoinsForRubles.getText().toString().equals(".")
                        || editTextPrice.getText().toString().isEmpty()
                        || editTextPrice.getText().toString().equals(".")) {
                    textViewCoinsForRubles.setText("0");
                    return;
                }

                Float mPrice = Float.parseFloat(editTextPrice.getText().toString());
                Float mCoinToRubles = Float.parseFloat(editTextCoinsForRubles.getText().toString());

                textViewCoinsForRubles.setText(String.format("%.2f", mCoinToRubles * mPrice));

            }
        });*/

}


