package com.example.dima.cleverinvest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    private int numberOfPoints = 6;

    float[] musterdepotValues = new float[120];

    private ValueShape shape = ValueShape.CIRCLE;

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
        int i = 0;
        musterdepotValues[i] = (float) 115;
        i++;
        musterdepotValues[i] = (float) 116;
        i++;
        musterdepotValues[i] = (float) 111;
        i++;
        musterdepotValues[i] = (float) 117;
        i++;
        musterdepotValues[i] = (float) 123;
        i++;
        musterdepotValues[i] = (float) 122.22;
        i++;
        musterdepotValues[i] = (float) 122.39;
        i++;
        musterdepotValues[i] = (float) 123;
        i++;
        musterdepotValues[i] = (float) 125;
        i++;
        musterdepotValues[i] = (float) 127;
        i++;
        musterdepotValues[i] = (float) 126.6;
        i++;
        musterdepotValues[i] = (float) 130;
        i++;
        musterdepotValues[i] = (float) 128;
        i++;
        musterdepotValues[i] = (float) 129.1;
        i++;
        musterdepotValues[i] = (float) 129.2;
        i++;
        musterdepotValues[i] = (float) 129.3;
        i++;
        musterdepotValues[i] = (float) 129.2;
        i++;
        musterdepotValues[i] = (float) 130;
        i++;
        musterdepotValues[i] = (float) 131;
        i++;
        musterdepotValues[i] = (float) 129;
        i++;
        musterdepotValues[i] = (float) 127;
        i++;
        musterdepotValues[i] = (float) 126;
        i++;
        musterdepotValues[i] = (float) 127;
        i++;
        musterdepotValues[i] = (float) 127.9;
        i++;
        musterdepotValues[i] = (float) 131;
        i++;
        musterdepotValues[i] = (float) 133;
        i++;
        musterdepotValues[i] = (float) 134;
        i++;
        musterdepotValues[i] = (float) 135;
        i++;
        musterdepotValues[i] = (float) 134;
        i++;
        musterdepotValues[i] = (float) 138;
        i++;
        musterdepotValues[i] = (float) 140;
        i++;
        musterdepotValues[i] = (float) 139;
        i++;
        musterdepotValues[i] = (float) 140;
        i++;
        musterdepotValues[i] = (float) 141;
        i++;
        musterdepotValues[i] = (float) 142;
        i++;
        musterdepotValues[i] = (float) 143;
        i++;
        musterdepotValues[i] = (float) 143;
        i++;
        musterdepotValues[i] = (float) 143.2;
        i++;
        musterdepotValues[i] = (float) 142.7;
        i++;
        musterdepotValues[i] = (float) 143;
        i++;
        musterdepotValues[i] = (float) 145;
        i++;
        musterdepotValues[i] = (float) 147;
        i++;
        numberOfPoints = i;
    }

    private void generateData() {

        List<Line> lines = new ArrayList<Line>();

        List<PointValue> values = new ArrayList<PointValue>();
        for (int j = 0; j < numberOfPoints; ++j) {
            values.add(new PointValue(j, musterdepotValues[j]));
        }

        Line line = new Line(values);
        line.setColor(ContextCompat.getColor(getApplicationContext(), R.color.bright_yellow));
        line.setShape(shape);
        boolean isCubic = false;
        line.setCubic(isCubic);
        boolean isFilled = true;
        line.setFilled(isFilled);
        boolean hasLabels = false;
        line.setHasLabels(hasLabels);
        boolean hasLabelForSelected = false;
        line.setHasLabelsOnlyForSelected(hasLabelForSelected);
        boolean hasLines = true;
        line.setHasLines(hasLines);
        //line.setHasPoints(hasPoints);
        line.setHasPoints(false);
        lines.add(line);

        LineChartData data = new LineChartData(lines);

        boolean hasAxes = true;
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

    public void startInvest(View view) {
        Intent intent = new Intent(this, InvestActivity.class);

        startActivity(intent);

    }

    public void startScan(View view) {
        Intent intent = new Intent(this, ScanActivity.class);
        startActivity(intent);
    }

    public void startInfo(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

}
