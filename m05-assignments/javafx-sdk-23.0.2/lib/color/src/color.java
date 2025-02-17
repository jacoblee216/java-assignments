import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class color extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        HBox hbox = new HBox(10);
        Text colorText = new Text("Show Color");
        hbox.getChildren().add(colorText);
        VBox vbox = new VBox(10);
        Scene scene = new Scene(vbox, 200, 200);

        Text text1 = new Text("Red");
        Text text2 = new Text("Green");
        Text text3 = new Text("Blue");
        Text text4 = new Text("Opacity");
        Slider red = new Slider(0, 1, 0.5);
        Slider green = new Slider(0, 1, 0.5);
        Slider blue = new Slider(0, 1, 0.5);
        Slider opacity = new Slider(0, 1, 0.5);
        grid.add(text1, 0, 0);
        grid.add(text2, 0, 1);
        grid.add(text3, 0, 2);
        grid.add(text4, 0, 3);
        grid.add(red, 1, 0);
        grid.add(green, 1, 1);
        grid.add(blue, 1, 2);
        grid.add(opacity, 1, 3);

        red.valueProperty().addListener((current, oldValue, newValue) -> {
            colorText.setFill(javafx.scene.paint.Color.color(red.getValue(), green.getValue(), blue.getValue(), opacity.getValue()));
        });
        green.valueProperty().addListener((current, oldValue, newValue) -> {
            colorText.setFill(javafx.scene.paint.Color.color(red.getValue(), green.getValue(), blue.getValue(), opacity.getValue()));
        });
        blue.valueProperty().addListener((current, oldValue, newValue) -> {
            colorText.setFill(javafx.scene.paint.Color.color(red.getValue(), green.getValue(), blue.getValue(), opacity.getValue()));
        });
        opacity.valueProperty().addListener((current, oldValue, newValue) -> {
            colorText.setFill(javafx.scene.paint.Color.color(red.getValue(), green.getValue(), blue.getValue(), opacity.getValue()));
        });
        grid.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(hbox, grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
