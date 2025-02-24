import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import items.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import java.util.*;
import javafx.scene.control.*;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;

public class App extends Application {
    private SimpleObjectProperty<Scene> sceneProperty = new SimpleObjectProperty<>();

    @Override
    public void start(Stage stage) throws Exception {
        ListView<String> listView = new ListView<>();
        Random rand = new Random();

        TextField itemNameField = new TextField();
        itemNameField.setPromptText("Enter item name"); // user input field

        RadioButton foodButton = new RadioButton("Food");
        RadioButton cleanSuppliesButton = new RadioButton("Cleaning Supplies");
        RadioButton kitchenwareButton = new RadioButton("Kitchenware");
        RadioButton liquidCleanButton = new RadioButton("Liquid Cleaning Supplies");

        ToggleGroup group = new ToggleGroup(); // radio buttons for user to select but they are mutually exclusive
        foodButton.setToggleGroup(group);
        cleanSuppliesButton.setToggleGroup(group);
        kitchenwareButton.setToggleGroup(group);
        liquidCleanButton.setToggleGroup(group);

        Button addButton = new Button("Add Item");
        Button deleteButton = new Button("Delete All Items");

        ArrayList<Food> foodList = new ArrayList<>(); // create a list of foods
        int range = 10 + rand.nextInt(20);
        for (int i = 0; i < range; i++) {
            int randomFood = rand.nextInt(4);
            int temp = randomFood;
            while (true) {
                randomFood = rand.nextInt(4);
                if (randomFood != temp) {
                    break;
                }
            }
            switch (randomFood) { // random item generator
                case 1:
                    foodList.add(new Food("Fruit", "Apple"));
                    temp = randomFood;
                    break;
                case 2:
                    foodList.add(new Food("Vegetable", "Carrot"));
                    temp = randomFood;
                    break;
                case 3:
                    foodList.add(new Food("Grain", "Rice"));
                    temp = randomFood;
                    break;
                case 4:
                    foodList.add(new Food("Meat", "Chicken"));
                    temp = randomFood;
                    break;
                case 5:
                    foodList.add(new Food("Dairy", "Milk"));
                    temp = randomFood;
                    break;
            }
        }
        for (int i = 0; i < foodList.size(); i++) { // add the random foods into the list view
            listView.getItems().add(foodList.get(i).getFoodType() + ": " + foodList.get(i).getFoodName());
        }

        addButton.setOnAction(e -> { // event listener for add button
            String name = itemNameField.getText().trim();
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle(); // takes string from radio button and saves it to the list view
            String type = selectedRadioButton.getText(); 

            if (!name.isEmpty() && group.getSelectedToggle() != null) {
                listView.getItems().add(type + ": " + name);
                itemNameField.clear();
            }
        });
        deleteButton.setOnAction(e -> { // event listener for delete button
            listView.getItems().clear();
        }
            
        );

        GridPane grid = new GridPane();
        grid.add(foodButton, 0, 0);
        grid.add(cleanSuppliesButton, 1, 0);
        grid.add(kitchenwareButton, 0, 1); // add nodes to gridpane
        grid.add(liquidCleanButton, 1, 1);
        grid.setStyle("-fx-alignment: center;"); // center both grid pane and vbox
        VBox root = new VBox(10, grid, itemNameField, addButton, deleteButton, listView);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");
        VBox.setVgrow(listView, Priority.ALWAYS);

        sceneProperty.set(new Scene(root, 300, 400));
        stage.setScene(sceneProperty.get());

        stage.setTitle("Inventory Management System");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


