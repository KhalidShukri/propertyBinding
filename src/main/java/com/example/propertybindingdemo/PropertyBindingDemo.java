package com.example.propertybindingdemo;

import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyBindingDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

//        Unidirectional Binding
        Slider slider = new Slider(0,100,50);
        Label sliderLabel = new Label();
        sliderLabel.textProperty().bind(
                Bindings.format("Slider value: %.2f",slider.valueProperty())
        );
//        Bidirectional Binding
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        textField1.textProperty().bindBidirectional(textField2.textProperty());

//        Custom Binding
        Label sumLabel = new Label();
        sumLabel.textProperty().bind(
                Bindings.createStringBinding(
                        ()->"sum: " + (slider.getValue() + Double.parseDouble
                                (textField1.getText())),
                        slider.valueProperty(),
                        textField1.textProperty()
                )
        );
        root.getChildren().addAll(slider,sliderLabel,textField1,textField2,sumLabel);
        Scene scene = new Scene(root);
        stage.setTitle("Property Binding Demo");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
