package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Controller {
    @FXML
    private TextField textField1;
    @FXML
    private Button button1;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private Label label1;

    private int i=0;

    @FXML
    public void initialize(){
        button1.setDisable(true);
    }

    @FXML
    public void textField1Empty(){
        String text = textField1.getText();
        boolean disabledButtons = text.isEmpty()|| text.trim().isEmpty();
        button1.setDisable(disabledButtons);
    }

    @FXML
    public void button1Press(ActionEvent e) {
        if (e.getSource().equals(button1)){
            System.out.println("Button1 pressed. Text in textField1 is: " + textField1.getText()+".");
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String p = Platform.isFxApplicationThread() ? "UI" : "Background";
                    System.out.println("I will update " + p +".");
                    i++;
                    Thread.sleep(3000);
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {
                            System.out.println(p + " updated.");
                            label1.setText("Time has gone\nButton clicked " + i + " times");
                        }
                    });
                } catch (InterruptedException event) {
                }
            }
        };

        new Thread(task).start();
        if(checkBox1.isSelected()){
            textField1.clear();
            button1.setDisable(true);
        }
    }

    @FXML
    public void checkBox1Checked(){
        System.out.println("Check box checked status: " +(checkBox1.isSelected()?"True":"Not"));
    }
}