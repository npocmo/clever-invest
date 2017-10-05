package com.example.dima.cleverinvest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.formatter.SimpleAxisValueFormatter;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.view.LineChartView;

public class InvestActivity extends AppCompatActivity {

    private LineChartView chart1;
    private LineChartView chart2;
    private int numberOfPointsMuster = 6;
    private int numberOfPoints = 6;

    float[] musterdepotValues = new float[120];
    float[] depotValues = new float[120];

    private ValueShape shape = ValueShape.CIRCLE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest);

        chart1 = (LineChartView) findViewById(R.id.chart1);
        chart2 = (LineChartView) findViewById(R.id.chart2);

        generateValues();

        generateDataChart1();
        generateDataChart2();

        // Disable viewport recalculations, see toggleCubic() method for more info.
        chart1.setViewportCalculationEnabled(false);
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
        numberOfPointsMuster = i;


        int j = 0;
        depotValues[j] = (float) 80;
        j++;
        depotValues[j] = (float) 81;
        j++;
        depotValues[j] = (float) 82;
        j++;
        depotValues[j] = (float) 82;
        j++;
        depotValues[j] = (float) 81;
        j++;
        depotValues[j] = (float) 81.22;
        j++;
        depotValues[j] = (float) 84;
        j++;
        depotValues[j] = (float) 85;
        j++;
        depotValues[j] = (float) 88;
        j++;
        depotValues[j] = (float) 91;
        j++;
        depotValues[j] = (float) 95;
        j++;
        depotValues[j] = (float) 100;
        j++;
        depotValues[j] = (float) 97;
        j++;
        depotValues[j] = (float) 110;
        j++;
        depotValues[j] = (float) 99;
        j++;
        depotValues[j] = (float) 97;
        j++;
        depotValues[j] = (float) 95;
        j++;
        depotValues[j] = (float) 96;
        j++;
        depotValues[j] = (float) 92;
        j++;
        depotValues[j] = (float) 90;
        j++;
        depotValues[j] = (float) 88;
        j++;
        depotValues[j] = (float) 89;
        j++;
        depotValues[j] = (float) 90;
        j++;
        depotValues[j] = (float) 91;
        j++;
        depotValues[j] = (float) 91.2;
        j++;
        depotValues[j] = (float) 89.9;
        j++;
        depotValues[j] = (float) 89.3;
        j++;
        depotValues[j] = (float) 88;
        j++;
        depotValues[j] = (float) 89;
        j++;
        depotValues[j] = (float) 87;
        j++;
        depotValues[j] = (float) 93;
        j++;
        depotValues[j] = (float) 94;
        j++;
        depotValues[j] = (float) 95;
        j++;
        depotValues[j] = (float) 94;
        j++;
        depotValues[j] = (float) 95;
        j++;
        depotValues[j] = (float) 96;
        j++;
        depotValues[j] = (float) 95.5;
        j++;
        depotValues[j] = (float) 94.5;
        j++;
        depotValues[j] = (float) 93;
        j++;
        depotValues[j] = (float) 94;
        j++;
        depotValues[j] = (float) 92;
        j++;
        depotValues[j] = (float) 95.4;
        j++;
        numberOfPoints = j;


    }

    private void generateDataChart1() {

        List<Line> lines = new ArrayList<Line>();

        List<PointValue> values = new ArrayList<PointValue>();
        for (int j = 0; j < numberOfPointsMuster; ++j) {
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
        chart1.setLineChartData(data);
    }


    private void generateDataChart2() {

        List<Line> lines = new ArrayList<Line>();

        List<PointValue> values = new ArrayList<PointValue>();
        for (int j = 0; j < numberOfPoints; ++j) {
            values.add(new PointValue(j, depotValues[j]));
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
        chart2.setLineChartData(data);
    }

}
