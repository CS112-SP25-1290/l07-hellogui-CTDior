package edu.miracosta.cs112.lab07;//package name here depending on your IDE

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application implements EventHandler<ActionEvent> {

    /*** GUI COMPONENTS ***/
    Label label;            // bottom-right label (updates with text field)
    Label topLabel;         // top-left label (used as counter)
    Button button1;         // updates label with text
    Button button2;         // counts clicks
    TextField inputField;   // input field for text
    int clickCount = 0;

    /*** DRIVER main ***/
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello GUI: Your Name");

        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Initialize GUI components
        label = new Label("Hello GUI World"); // bottom-right
        topLabel = new Label("Count: 0");     // top-left

        button1 = new Button("Update Label"); // bottom-left
        button2 = new Button("Count Clicks"); // bottom-right

        inputField = new TextField(); // center
        inputField.setPromptText("Enter new text");

        // Register event handlers
        button1.setOnAction(this);
        button2.setOnAction(this);

        // Layout manager for positioning
        AnchorPane anchorPane = new AnchorPane();

        // Position everything
        AnchorPane.setBottomAnchor(label, 0.0);
        AnchorPane.setRightAnchor(label, 0.0);
        anchorPane.getChildren().add(label);

        AnchorPane.setTopAnchor(topLabel, 10.0);
        AnchorPane.setLeftAnchor(topLabel, 10.0);
        anchorPane.getChildren().add(topLabel);

        AnchorPane.setBottomAnchor(button1, 10.0);
        AnchorPane.setLeftAnchor(button1, 10.0);
        anchorPane.getChildren().add(button1);

        AnchorPane.setBottomAnchor(button2, 10.0);
        AnchorPane.setRightAnchor(button2, 10.0);
        anchorPane.getChildren().add(button2);

        AnchorPane.setTopAnchor(inputField, 130.0);
        AnchorPane.setLeftAnchor(inputField, 50.0);
        AnchorPane.setRightAnchor(inputField, 50.0);
        anchorPane.getChildren().add(inputField);

        // Add the anchorPane to the stack layout
        layout.getChildren().add(anchorPane);
    }

    /*** Event Handler Logic ***/
    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button1) {
            // Set label to text field input
            String input = inputField.getText();
            if (!input.isEmpty()) {
                label.setText(input);
            }
        } else if (actionEvent.getSource() == button2) {
            // Increment counter on top label
            clickCount++;
            topLabel.setText("Count: " + clickCount);
        }
    }
}
