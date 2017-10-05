package com.example.dima.cleverinvest;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button leftMoneyAmount;
    NavigationView menu;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = (NavigationView) findViewById(R.id.menu);
        menu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        Button burger = (Button) findViewById(R.id.burger_button);
        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.START)) {
                    drawerLayout.closeDrawer(Gravity.START);
                } else {
                    drawerLayout.openDrawer(Gravity.START);
                }
            }
        });

        setAmount();
        startCountAnimation();
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

        leftMoneyAmount = (Button) findViewById(R.id.left_money_amount);
        leftMoneyAmount.setText(StringHelper.formatDecimal(AmountHelper.getInstance().getMoneyToInvest()));

        leftMoneyAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGammelActivity();
            }
        });
    }

    private void startGammelActivity() {
        Intent intent = new Intent(this, GammelGeldActivity.class);
        startActivity(intent);
    }

    private void startCountAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(0, (float) AmountHelper.getInstance().getMoneyToInvest());
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                leftMoneyAmount.setText(StringHelper.formatDecimal((float) animation.getAnimatedValue()));
            }
        });
        animator.start();
    }

    @Override
    public void finishActivity(int requestCode) {
        super.finishActivity(requestCode);
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }
}
