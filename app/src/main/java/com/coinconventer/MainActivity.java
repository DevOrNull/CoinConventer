package com.coinconventer;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonConvert);
        button.setOnClickListener(this);
    }

    @SuppressLint("DefaultLocale")
    public void onClick(View v){

        EditText editTextPrice = findViewById(R.id.editTextPrice);

        // Coins -> Rubles
        EditText editTextCoinsToRubles = findViewById(R.id.editTextCoinsToRubles);
        TextView textViewCoinsToRubles = findViewById(R.id.textViewCoinsToRubles);

        // Rubles -> Coins
        EditText editTextRublesToCoins = findViewById(R.id.editTextRublesToCoins);
        TextView textViewRublesToCoins = findViewById(R.id.textViewRublesToCoins);

        if (editTextPrice.getText().toString().isEmpty()
                || editTextPrice.getText().toString().equals(".")){
            textViewCoinsToRubles.setText("0");
            textViewRublesToCoins.setText("0");
            return;
        }

        if (editTextCoinsToRubles.getText().toString().isEmpty()
                || editTextCoinsToRubles.getText().toString().equals(".")) {
            textViewCoinsToRubles.setText("0");
            return;
        }

        Float mPrice = Float.parseFloat(editTextPrice.getText().toString());
        Float mCoinToRubles = Float.parseFloat(editTextCoinsToRubles.getText().toString());

        textViewCoinsToRubles.setText(String.format("%.2f", mCoinToRubles * mPrice));

        if (editTextRublesToCoins.getText().toString().isEmpty()
                || editTextRublesToCoins.getText().toString().equals(".")) {
            textViewRublesToCoins.setText("0");
            return;
        }

        Float mRublesToCoins = Float.parseFloat(editTextRublesToCoins.getText().toString());

        textViewRublesToCoins.setText(String.format("%.2f", mRublesToCoins / mPrice) + getString(R.string.kk));
        //костыль для корректного подсчёта, если editTextRublesToCoins.isEmpty
        textViewCoinsToRubles.setText(String.format("%.2f", mCoinToRubles * mPrice));
    }


/*        final EditText editTextCoinsToRubles = (EditText) findViewById(R.id.editTextCoinsToRubles);
        editTextCoinsToRubles.addTextChangedListener(new TextWatcher() {

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

                TextView textViewCoinsToRubles = (TextView) findViewById(R.id.textViewCoinsToRubles);
                EditText editTextPrice = (EditText) findViewById(R.id.editTextPrice);

                if (editTextCoinsToRubles.getText().toString().isEmpty()
                        || editTextCoinsToRubles.getText().toString().equals(".")
                        || editTextPrice.getText().toString().isEmpty()
                        || editTextPrice.getText().toString().equals(".")) {
                    textViewCoinsToRubles.setText("0");
                    return;
                }

                Float mPrice = Float.parseFloat(editTextPrice.getText().toString());
                Float mCoinToRubles = Float.parseFloat(editTextCoinsToRubles.getText().toString());

                textViewCoinsToRubles.setText(String.format("%.2f", mCoinToRubles * mPrice));

            }
        });*/

}


