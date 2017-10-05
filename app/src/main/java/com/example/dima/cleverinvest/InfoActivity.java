package com.example.dima.cleverinvest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

   /* Integer income = 3000;
    Integer fixCost = 1300;
    Integer other = 1000;
    Integer maxReserve = income-(fixCost+other);
    Integer reserve = income-(fixCost+other); */
    TextView reserveTextView;
    TextView lazyMoneyView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView incomeTextView = (TextView) findViewById(R.id.incomeValue);
        incomeTextView.setText(StringHelper.formatDecimal(AmountHelper.getInstance().getAvgIncome()));

        TextView fixCostTextView = (TextView) findViewById(R.id.fixCostValue);
        fixCostTextView.setText("-" + StringHelper.formatDecimal(AmountHelper.getInstance().getAvgFixCost()));

        TextView otherTextView = (TextView) findViewById(R.id.otherValue);
        otherTextView.setText("-" + StringHelper.formatDecimal(AmountHelper.getInstance().getAvgOtherCost()));

        reserveTextView = (TextView) findViewById(R.id.reserveValue);
        reserveTextView.setText("-" + StringHelper.formatDecimal(AmountHelper.getInstance().getReserve()));

        lazyMoneyView = (TextView) findViewById(R.id.lazyMoneyValue);
        lazyMoneyView.setText(StringHelper.formatDecimal(AmountHelper.getInstance().getMoneyToInvest()));

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax((int) (AmountHelper.getInstance().getMoneyToInvest()+ (int) AmountHelper.getInstance().getReserve()));
        seekBar.setProgress((int) AmountHelper.getInstance().getReserve());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                AmountHelper.getInstance().setReserve(progress);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                reserveTextView.setText("-" + StringHelper.formatDecimal(AmountHelper.getInstance().getReserve()));
                lazyMoneyView.setText(StringHelper.formatDecimal(AmountHelper.getInstance().getMoneyToInvest()));

            }
        });
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, GammelGeldActivity.class);
        super.startActivity(intent);
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
