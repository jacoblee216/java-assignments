import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class mouse extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        Circle circle = new Circle(300, 135, 100);
        circle.setFill(Color.WHITE);
        root.getChildren().add(circle);

        EventHandler<MouseEvent> mousePressed = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                circle.setFill(Color.BLACK);
            }
        };
        EventHandler<MouseEvent> mouseReleased = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                circle.setFill(Color.WHITE);
            }
        };

        root.setOnMousePressed(mousePressed);
        root.setOnMouseReleased(mouseReleased);
        primaryStage.show();
    }
}
