package com.example.dima.cleverinvest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.formatter.SimpleAxisValueFormatter;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.view.LineChartView;

public class GammelGeldActivity extends AppCompatActivity {

    private LineChartView chart;
    private LineChartData data;
    private int numberOfLines = 1;
    private int maxNumberOfLines = 4;
    private int numberOfPoints = 6;

    float[][] randomNumbersTab = new float[maxNumberOfLines][120];

    private boolean hasAxes = true;
    private boolean hasAxesNames = true;
    private boolean hasLines = true;
    private boolean hasPoints = true;
    private ValueShape shape = ValueShape.CIRCLE;
    private boolean isFilled = true;
    private boolean hasLabels = false;
    private boolean isCubic = false;
    private boolean hasLabelForSelected = false;
    private boolean pointsHaveDifferentColor;
    private boolean hasGradientToTransparent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gammel_geld);

        chart = (LineChartView) findViewById(R.id.chart);

        generateValues();

        generateData();

        // Disable viewport recalculations, see toggleCubic() method for more info.
        chart.setViewportCalculationEnabled(false);

        TextView lazyMoney = (TextView) findViewById(R.id.lazyMoney);
        lazyMoney.setText(StringHelper.formatDecimal(AmountHelper.getInstance().getMoneyToInvest()));

        TextView gammelGeld = (TextView) findViewById(R.id.gammelGeldGegenwert);
        String youCouldHave = StringHelper.formatDecimal(AmountHelper.getInstance().getMoneyYouCouldHave());
        gammelGeld.setText(getString(R.string.you_could_have, youCouldHave));
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

    private void generateValues() {
        //for (int i = 0; i < maxNumberOfLines; ++i) {
        //for (int j = 0; j < numberOfPoints; ++j) {
        //randomNumbersTab[i][j] = (float) Math.random() * 100f;
        //}
        //}
        int i = 0;
        randomNumbersTab[0][i] = (float) 115;
        i++;
        randomNumbersTab[0][i] = (float) 116;
        i++;
        randomNumbersTab[0][i] = (float) 111;
        i++;
        randomNumbersTab[0][i] = (float) 117;
        i++;
        randomNumbersTab[0][i] = (float) 123;
        i++;
        randomNumbersTab[0][i] = (float) 122.22;
        i++;
        randomNumbersTab[0][i] = (float) 122.39;
        i++;
        randomNumbersTab[0][i] = (float) 123;
        i++;
        randomNumbersTab[0][i] = (float) 125;
        i++;
        randomNumbersTab[0][i] = (float) 127;
        i++;
        randomNumbersTab[0][i] = (float) 126.6;
        i++;
        randomNumbersTab[0][i] = (float) 130;
        i++;
        randomNumbersTab[0][i] = (float) 128;
        i++;
        randomNumbersTab[0][i] = (float) 129.1;
        i++;
        randomNumbersTab[0][i] = (float) 129.2;
        i++;
        randomNumbersTab[0][i] = (float) 129.3;
        i++;
        randomNumbersTab[0][i] = (float) 129.2;
        i++;
        randomNumbersTab[0][i] = (float) 130;
        i++;
        randomNumbersTab[0][i] = (float) 131;
        i++;
        randomNumbersTab[0][i] = (float) 129;
        i++;
        randomNumbersTab[0][i] = (float) 127;
        i++;
        randomNumbersTab[0][i] = (float) 126;
        i++;
        randomNumbersTab[0][i] = (float) 127;
        i++;
        randomNumbersTab[0][i] = (float) 127.9;
        i++;
        randomNumbersTab[0][i] = (float) 131;
        i++;
        randomNumbersTab[0][i] = (float) 133;
        i++;
        randomNumbersTab[0][i] = (float) 134;
        i++;
        randomNumbersTab[0][i] = (float) 135;
        i++;
        randomNumbersTab[0][i] = (float) 134;
        i++;
        randomNumbersTab[0][i] = (float) 138;
        i++;
        randomNumbersTab[0][i] = (float) 140;
        i++;
        randomNumbersTab[0][i] = (float) 139;
        i++;
        randomNumbersTab[0][i] = (float) 140;
        i++;
        randomNumbersTab[0][i] = (float) 141;
        i++;
        randomNumbersTab[0][i] = (float) 142;
        i++;
        randomNumbersTab[0][i] = (float) 143;
        i++;
        randomNumbersTab[0][i] = (float) 143;
        i++;
        randomNumbersTab[0][i] = (float) 143.2;
        i++;
        randomNumbersTab[0][i] = (float) 142.7;
        i++;
        randomNumbersTab[0][i] = (float) 143;
        i++;
        randomNumbersTab[0][i] = (float) 145;
        i++;
        randomNumbersTab[0][i] = (float) 147;
        i++;

        numberOfPoints = i;
    }

    private void generateData() {

        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < numberOfLines; ++i) {

            List<PointValue> values = new ArrayList<PointValue>();
            for (int j = 0; j < numberOfPoints; ++j) {
                values.add(new PointValue(j, randomNumbersTab[i][j]));
            }

            Line line = new Line(values);
            line.setColor(ContextCompat.getColor(getApplicationContext(), R.color.bright_yellow));
            line.setShape(shape);
            line.setCubic(isCubic);
            line.setFilled(isFilled);
            line.setHasLabels(hasLabels);
            line.setHasLabelsOnlyForSelected(hasLabelForSelected);
            line.setHasLines(hasLines);
            //line.setHasPoints(hasPoints);
            line.setHasPoints(false);
            if (pointsHaveDifferentColor) {
                line.setPointColor(ContextCompat.getColor(getApplicationContext(), R.color.bright_yellow));
            }
            lines.add(line);
        }

        data = new LineChartData(lines);

        if (hasAxes) {
            Axis axisX = new Axis();

            axisX.setValues(null);
            axisX.setHasSeparationLine(true);
            axisX.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.dark));
            axisX.setHasLines(true);
            axisX.setLineColor(ContextCompat.getColor(getApplicationContext(), R.color.dark));
            axisX.setHasTiltedLabels(true);
            axisX.setTextSize(14);

            axisX.setFormatter(new SimpleAxisValueFormatter().setAppendedText(". Month".toCharArray()));//.setAppendedText("km".toCharArray()));

            Axis axisY = new Axis();
            axisY.setHasLines(true);
            axisY.setLineColor(ContextCompat.getColor(getApplicationContext(), R.color.dark));
            axisY.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.dark));
            axisY.setHasSeparationLine(true);
            //if (hasAxesNames) {
            if (false) {
                axisX.setName("");
                axisY.setName("");
            }
            data.setAxisXBottom(axisX);
            data.setAxisYLeft(axisY);
        } else {
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
        }

        data.setBaseValue(Float.NEGATIVE_INFINITY);
        chart.setLineChartData(data);
    }

}
