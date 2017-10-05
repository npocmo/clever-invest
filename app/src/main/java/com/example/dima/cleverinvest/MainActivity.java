package com.example.dima.cleverinvest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView menu = (NavigationView) findViewById(R.id.menu);
        menu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        setAmount();
        setToolbar();

    }

    private void setAmount() {
        TextView giroAmount = (TextView) findViewById(R.id.giro_amount);
        giroAmount.setText(StringHelper.formatDecimal(AmountHelper.getInstance().getGiroAmount()));

        TextView visaAmount = (TextView) findViewById(R.id.visa_amount);
        visaAmount.setText(StringHelper.formatDecimal(AmountHelper.getInstance().getVisaAmount()));

        TextView depotAmount = (TextView) findViewById(R.id.depot_amount);
        depotAmount.setText(StringHelper.formatDecimal(AmountHelper.getInstance().getDepotAmount()));

        TextView summeAmount = (TextView) findViewById(R.id.summe_amount);
        summeAmount.setText(StringHelper.formatDecimal(AmountHelper.getInstance().getSumme()));
    }

    private void setToolbar() {
//        getSupportActionBar().setTitle("Clever Invest");
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.dark)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Bearbeiten");
        return super.onCreateOptionsMenu(menu);
    }
}
