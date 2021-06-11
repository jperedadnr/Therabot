package com.mysecondapplication.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.BottomNavigation;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import java.io.IOException;
import java.util.ArrayList;
import com.mysecondapplication.views.Session;
import com.mysecondapplication.views.Sessions;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TertiaryView extends View {

    ArrayList<Double> feelings1;
    ArrayList<Double> feelings2;

    public TertiaryView() {

        getStylesheets().add(TertiaryView.class.getResource("tertiary.css").toExternalForm());

        Font font = new Font("Comfortaa", 15);
        Font font1 = new Font("Comfortaa", 24);
        // Use a GridPane to create a login interface insights 
        VBox grid = new VBox();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //grid.setStyle("-fx-background-color: black;");

        Label scenetitle = new Label("Settings");
        scenetitle.setFont(font1);
        //scenetitle.setAlignment(Pos.TOP_LEFT);
        grid.getChildren().add(scenetitle);
        //scenetitle.setStyle("-fx-text-fill: grey;");
        Label h2 = new Label("This code\nis a\nplaceholder.");
        h2.setFont(font);
        //scenetitle.setStyle("-fx-text-fill: grey;");
        grid.getChildren().add(h2);

        setCenter(grid);

        /*Font font = new Font("Comfortaa", 15);
        Font font1 = new Font("Comfortaa", 24);
        // Use a GridPane to create a login interface insights 
        VBox grid = new VBox();
        //grid.setStyle("-fx-background-color: black;");
        grid.setAlignment(Pos.CENTER);
        Insets snI = new Insets(10, 10, 10, 10);
        grid.setPadding(snI);

        String name = (session.getID());

        Label scenetitle = new Label("Hello, " + name + "!");
        scenetitle.setFont(font1);
        //scenetitle.setAlignment(Pos.TOP_LEFT);
        grid.getChildren().add(scenetitle);
        //scenetitle.setStyle("-fx-text-fill: grey;");
        Label h2 = new Label("Here are your insights for today.");
        h2.setFont(font);
        VBox vbox = new VBox(); // make sure name read in is same as file name
        vbox.setAlignment(Pos.CENTER);
        Insets ssnI = new Insets(10, 10, 10, 10);
        vbox.setPadding(snI);
        ArrayList<Double> feelings1 = sessions.getFeelings1();
        ArrayList<Double> feelings2 = sessions.getFeelings2();
        ArrayList<Double> differences = new ArrayList<Double>();
        for (int i = 0; i < feelings1.size(); i++) {
            differences.add(feelings2.get(i) - feelings1.get(i));
        }

        if (feelings1.size() > 0) {
            Label[] datatxt = new Label[feelings1.size()]; //THIS IS IT?

            //Let x-axis show categories
            CategoryAxis xAxis = new CategoryAxis();
            //Let y-axis show numbers
            NumberAxis yAxis = new NumberAxis();
            //Specify the label of x-axis
            //Show the x-axis labels on bottom
            //Specify the title of y-axis
            yAxis.setLabel("Your Mood Change with Therabot!");
            //Instantiate the LineChart class
            LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
            //Provide a title for the chart       
            //Display symbols at data points (or don't)
            lineChart.setCreateSymbols(false);  //  Y / N ?
            //Define an XYChart.Series    
            XYChart.Series series = new XYChart.Series();
            //Specify a name for the series
            series.setName("Data for " + name);

            //Specify data to go with the XYChart.Series
            //Assign series to the chart
            lineChart.setPrefSize(280.2, 280.2);
            lineChart.setMinSize(220.2, 220.2);
            lineChart.setMaxSize(320.2, 320.2);
            lineChart.getData().add(series);
            vbox.getChildren().addAll(lineChart);

            for (int i = 0; i < feelings1.size(); i++) {
                double d1 = feelings1.get(i).doubleValue();
                d1 = (int) d1;
                double d2 = feelings2.get(i).doubleValue();
                d2 = (int) d2;										// Day "names.get(i), differences.get(i)
                double d = differences.get(i).doubleValue();
                d = (int) d;
                int day = i + 1;
                String str = d1 + " " + d2 + " " + d; //NO THIS IS IT!
                series.getData().addAll(new XYChart.Data("Day " + day, d));
                datatxt[i] = new Label(str);

                //vbox.getChildren().add(datatxt[i]);
            }
        }//scenetitle.setStyle("-fx-text-fill: grey;");
        String response = analyzeData(sessions);
        Label h5 = new Label(response);
        h5.setFont(font);
        grid.getChildren().addAll(h2, vbox, h5);

        setCenter(grid);
    }

    public String analyzeData(Sessions sessions) {
        ArrayList<Double> feeling1 = sessions.getFeelings1();
        ArrayList<Double> feeling2 = sessions.getFeelings2();
        String response = "";
        int n = feeling1.size();
        double errthd = 4;
        int nP = 0;
        int nN = 0;
        ArrayList<Double> differences = new ArrayList<Double>();
        for (int i = 0; i < n - 1; i++) {
            differences.add(i, (feeling2.get(i)) - (feeling1.get(i)));
            if (differences.get(i).doubleValue() > errthd) {
                nP++;
            } else if (differences.get(i).doubleValue() < -errthd) {
                nN++;
            }
        }
        switch (nP - nN) {
            case 4:
                response = "You have shown amazing progress.\nKeepup the great work! ";
                break;
            case 3:
                response = "Our sessions have helped you a lot\nsince our first visit! I'm glad I was able to help.";
                break;
            case 2:
                response = "You have shown great progress.\nKeep it up!";
                break;
            case 1:
                response = "You have been slowly improving\nsince our first session! Keep going, you are doing well.";
                break;
            case 0:
                response = "I don't have enough data to prove\nany change yet, but over time you'll start to see change. Keep going!";
                break;
            case -1:
                response = "It seems that our sessions have not\nhelped your mood increase. Hopefully we can change that!";
                break;
            case -2:
                response = "Looks like you have not shown much\n improvement since our first session. Let's try again next time!";
                break;
            case -3:
                response = "It appears that your sessions have not\nimproved your mood. Don't give up!";
                break;
            case -4:
                response = "It seems as though you have not been\nimproving since our first session. Let's keep trying!";
                break;
            default:
                if (nP - nN > 4) {
                    response = "You are progressing outstandingly! I'm so glad that I could support you.";
                } else if (nP - nN < -4) {
                    response = "It looks as though you have not improved over the course of our sessions. Let's stay motivated for next time!";
                } else {
                    response = "Sorry, there's a problem. Please check back tomorrow!";
                }
        }
        return response;*/
    }

}
