import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class img extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane, 800, 600);
        Image img1 = new Image("flag1.gif");
        ImageView imgview1 = new ImageView(img1);
        pane.add(imgview1, 0, 0);
        Image img2 = new Image("flag2.gif");
        ImageView imgview2 = new ImageView(img2);
        pane.add(imgview2, 1, 0);
        Image img3 = new Image("flag6.gif");
        ImageView imgview3 = new ImageView(img3);
        pane.add(imgview3, 0, 1);
        Image img4 = new Image("flag7.gif");
        ImageView imgview4 = new ImageView(img4);
        pane.add(imgview4, 1, 1);
        primaryStage.show();
        primaryStage.setScene(scene);
    }
}
