package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {

    //private String fileName = "src/sample/example.csv";
    private String fileName = "src/sample/test.csv";

    @FXML
    private LineChart<Number, Number> lineChart;

    public void randButton(){
        RandData.makeData();
    }

    public void buttonAction(ActionEvent event){
        lineChart.getData().clear();

        List<String> line = new CSVReader().readingCSV(fileName);
        double[] values = new double[line.size()];


        for (int i = 0; i < line.size(); i++){
            values[i] = Double.parseDouble(line.get(i));
            //System.out.println(values[i]);
        }

        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        series.setName("Graph");
        for (int i = 0; i < values.length; i++){
            series.getData().add(new XYChart.Data<Number, Number>(i, values[i]));
        }

        lineChart.getData().add(series);
    }
}