import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import items.*;
import javafx.scene.layout.HBox;
import java.util.*;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
import javafx.scene.layout.Region;

public class App extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        ListView<VBox> foodView = new ListView<>();
        ListView<VBox> cleanView = new ListView<>();
        ListView<VBox> kitchenView = new ListView<>();
        ListView<VBox> liquidView = new ListView<>();
        HBox selectButtons = new HBox(10);
        selectButtons.setStyle("-fx-alignment: center;");



        RadioButton foodButton = new RadioButton("Food");
        RadioButton cleanSuppliesButton = new RadioButton("Cleaning Supplies");
        RadioButton kitchenwareButton = new RadioButton("Kitchenware");
        RadioButton liquidCleanButton = new RadioButton("Liquid Cleaning Supplies");

        ToggleGroup group = new ToggleGroup(); // radio selectButtons for user to select but they are mutually exclusive
        foodButton.setToggleGroup(group);
        cleanSuppliesButton.setToggleGroup(group);
        kitchenwareButton.setToggleGroup(group);
        liquidCleanButton.setToggleGroup(group);

        Button itemButton = new Button("Choose Item Type");
        Button addButton = new Button("Add Items");
        selectButtons.getChildren().addAll(itemButton, addButton);

        ObservableList<String> foodItems = FXCollections.observableArrayList("Cheese", "Beef", "Chicken", "Pork", "Tortilla", "Rice", "Beans", "Salsa", "Guacamole"); // create a list of food items
        ObservableList<String> cleanSuppliesItems = FXCollections.observableArrayList("Paper Towels", "Toilet Paper", "Trash Bags", "Sponges", "Broom", "Mop", "Dust Pan", "Vacuum", "Power Scrubber"); // create a list of cleaning supplies
        ObservableList<String> kitchenwareItems = FXCollections.observableArrayList("Plates", "Bowls", "Cups", "Silverware", "Pots", "Pans", "Cutting Board", "Knife", "Spatula"); // create a list of kitchenware
        ObservableList<String> liquidCleanItems = FXCollections.observableArrayList("Bleach", "Windex", "Dish Soap", "Laundry Detergent", "Fabric Softener", "Vinegar", "Baking Soda", "Hydrogen Peroxide"); // create a list of liquid cleaning supplies
        
        ListView<VBox> itemType = new ListView<>();
        itemType.setPadding(new Insets(10));

        ArrayList<Food> foodList = new ArrayList<>();
        ArrayList<nonLiquidClean> cleanList = new ArrayList<>();
        ArrayList<Kitchenware> kitchenList = new ArrayList<>();
        ArrayList<liquidClean> liquidList = new ArrayList<>();



        itemButton.setOnAction(e -> { // event listener for choose item type button
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle(); // takes string from radio button and saves it to the list view
            String type = selectedRadioButton.getText(); 
            if (type.equals("Food")) {
                ObservableList<VBox> foodHBoxes = FXCollections.observableArrayList();
                for (String foodItem : foodItems) {
                    Label foodLabel = new Label(foodItem);
                    TextField numItems = new TextField();
                    numItems.setPromptText("Number of Items");
                    numItems.setMaxWidth(110);
                    VBox expandableBox = new VBox(numItems);
                    expandableBox.setVisible(false);
                    expandableBox.setManaged(false);
                    Button toggleButton = new Button("↓");
                    toggleButton.setMinSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
                    toggleButton.setOnAction(event -> {
                        boolean isExpanded = expandableBox.isVisible();
                        expandableBox.setVisible(!isExpanded);
                        expandableBox.setManaged(!isExpanded);
                        toggleButton.setText(isExpanded ? "↓" : "↑");
                    });
                    Region spacer = new Region();
                    HBox.setHgrow(spacer, Priority.ALWAYS);
                    HBox hBox = new HBox(foodLabel, spacer, toggleButton);
                    VBox vBox = new VBox(hBox, expandableBox);
                    VBox.setMargin(vBox, new Insets(10, 0, 10, 0)); // Set top and bottom padding to 10, left and right padding to 0
                    foodHBoxes.add(vBox);
                }
                itemType.setItems(foodHBoxes);
            } else if (type.equals("Cleaning Supplies")) {
                ObservableList<VBox> cleanSuppliesHBoxes = FXCollections.observableArrayList();
                for (String cleanItems : cleanSuppliesItems) {
                    Label cleanLabel = new Label(cleanItems);
                    TextField numItems = new TextField();
                    numItems.setPromptText("Number of Items");
                    numItems.setMaxWidth(110);
                    VBox expandableBox = new VBox(numItems);
                    expandableBox.setVisible(false);
                    expandableBox.setManaged(false);
                    Button toggleButton = new Button("↓");
                    toggleButton.setMinSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
                    toggleButton.setOnAction(event -> {
                        boolean isExpanded = expandableBox.isVisible();
                        expandableBox.setVisible(!isExpanded);
                        expandableBox.setManaged(!isExpanded);
                        toggleButton.setText(isExpanded ? "↓" : "↑");
                    });
                    Region spacer = new Region();
                    HBox.setHgrow(spacer, Priority.ALWAYS);
                    HBox hBox = new HBox(cleanLabel, spacer, toggleButton);
                    VBox vBox = new VBox(hBox, expandableBox);
                    VBox.setMargin(vBox, new Insets(10, 0, 10, 0)); // Set top and bottom padding to 10, left and right padding to 0
                    cleanSuppliesHBoxes.add(vBox);
                }
                itemType.setItems(cleanSuppliesHBoxes);
            } else if (type.equals("Kitchenware")) {
                ObservableList<VBox> kitchenwareHBoxes = FXCollections.observableArrayList();
                for (String kitchenItems : kitchenwareItems) {
                    Label kitchenLabel = new Label(kitchenItems);
                    TextField numItems = new TextField();
                    numItems.setPromptText("Number of Items");
                    numItems.setMaxWidth(110);
                    VBox expandableBox = new VBox(numItems);
                    expandableBox.setVisible(false);
                    expandableBox.setManaged(false);
                    Button toggleButton = new Button("↓");
                    toggleButton.setMinSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
                    toggleButton.setOnAction(event -> {
                        boolean isExpanded = expandableBox.isVisible();
                        expandableBox.setVisible(!isExpanded);
                        expandableBox.setManaged(!isExpanded);
                        toggleButton.setText(isExpanded ? "↓" : "↑");
                    });
                    Region spacer = new Region();
                    HBox.setHgrow(spacer, Priority.ALWAYS);
                    HBox hBox = new HBox(kitchenLabel, spacer, toggleButton);
                    VBox vBox = new VBox(hBox, expandableBox);
                    VBox.setMargin(vBox, new Insets(10, 0, 10, 0)); // Set top and bottom padding to 10, left and right padding to 0
                    kitchenwareHBoxes.add(vBox);
                }
                itemType.setItems(kitchenwareHBoxes);
            } else if (type.equals("Liquid Cleaning Supplies")) {
                ObservableList<VBox> liquidCleanHBoxes = FXCollections.observableArrayList();
                for (String liquidItems : liquidCleanItems) {
                    Label liquidLabel = new Label(liquidItems);
                    TextField numItems = new TextField();
                    numItems.setPromptText("Number of Items");
                    numItems.setMaxWidth(110);
                    VBox expandableBox = new VBox(numItems);
                    expandableBox.setVisible(false);
                    expandableBox.setManaged(false);
                    Button toggleButton = new Button("↓");
                    toggleButton.setMinSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
                    toggleButton.setOnAction(event -> {
                        boolean isExpanded = expandableBox.isVisible();
                        expandableBox.setVisible(!isExpanded);
                        expandableBox.setManaged(!isExpanded);
                        toggleButton.setText(isExpanded ? "↓" : "↑");
                    });
                    Region spacer = new Region();
                    HBox.setHgrow(spacer, Priority.ALWAYS);
                    HBox hBox = new HBox(liquidLabel, spacer, toggleButton);
                    VBox vBox = new VBox(hBox, expandableBox);
                    VBox.setMargin(vBox, new Insets(10, 0, 10, 0)); // Set top and bottom padding to 10, left and right padding to 0
                    liquidCleanHBoxes.add(vBox);
                }
                itemType.setItems(liquidCleanHBoxes);
            }
        });
        addButton.setOnAction(e -> { // event listener for add item button
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle(); // takes string from radio button and saves it to the list view
            String type = selectedRadioButton.getText();
            for (VBox vBox : itemType.getItems()) {
                switch (type) {
                    case "Food":
                        HBox hBox = (HBox) vBox.getChildren().get(0);
                        Label label = (Label) hBox.getChildren().get(0);
                        TextField textField = (TextField) ((VBox) vBox.getChildren().get(1)).getChildren().get(0);
                        addIntegerValidation(textField); // Add input validation
                        if (!textField.getText().trim().isEmpty()) {
                            String item = label.getText();
                            int numItems = Integer.parseInt(textField.getText());
                            for (int i = 0; i < numItems; i++) {
                                foodList.add(new Food(item));
                            }
                            if (checkFoodItem(foodView, item)) {
                                int currentNumItems = 0;
                                for (int i = 0; i < foodList.size(); ++i) {
                                    if (foodList.get(i).getFoodName().equals(item)) {
                                        currentNumItems++;
                                    }
                                }
                                updateTextFieldValue(foodView, item, numItems, currentNumItems - numItems);
                            } else {
                                TextField deleteTextField = new TextField();
                                deleteTextField.setPromptText("Number of Items");
                                addIntegerValidation(deleteTextField); // Add input validation
                                Button deleteButton = new Button("Delete");
                                HBox foodExpandableBox = new HBox(10, deleteTextField, deleteButton);
                                foodExpandableBox.setVisible(false);
                                foodExpandableBox.setManaged(false);
                                Button toggleButton = new Button("↓");
                                toggleButton.setMinSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
                                toggleButton.setOnAction(event -> {
                                    boolean isExpanded = foodExpandableBox.isVisible();
                                    foodExpandableBox.setVisible(!isExpanded);
                                    foodExpandableBox.setManaged(!isExpanded);
                                    toggleButton.setText(isExpanded ? "↓" : "↑");
                                });
                                Region spacer = new Region();
                                HBox.setHgrow(spacer, Priority.ALWAYS);
                                Label foodLabel = new Label(item);
                                Label numFood = new Label(String.valueOf(numItems));
                                HBox listBox = new HBox(10, foodLabel, numFood, spacer, toggleButton);
                                VBox deleteBox = new VBox(listBox, foodExpandableBox);
                                VBox.setMargin(deleteBox, new Insets(20, 0, 20, 0));
                                foodView.getItems().add(deleteBox);

                                // Set user data for the delete button
                                deleteButton.setUserData(deleteBox);
                                deleteButton.setOnAction(deleteEvent -> {
                                    TextField expandableTextField = (TextField) foodExpandableBox.getChildren().get(0);
                                    int deleteNumItems = Integer.parseInt(expandableTextField.getText());
                                    int temp = 0;
                                    int currentNumItems1 = 0;
                                    for (int i = 0; i < foodList.size(); i++) {
                                        if (foodList.get(i).getFoodName().equals(item)) {
                                            currentNumItems1++;
                                        }
                                    }
                                    for (int i = 0; i < foodList.size(); i++) {
                                        if (temp < deleteNumItems && foodList.get(i).getFoodName().equals(item)) {
                                            foodList.remove(i);
                                            temp++;
                                        }
                                    }
                                    deleteNumItems = 0 - deleteNumItems;
                                    deleteTextFieldValue(foodView, item, currentNumItems1, deleteNumItems);
                                });
                            }
                        }
                        break;
                    case "Cleaning Supplies":
                        HBox hBox1 = (HBox) vBox.getChildren().get(0);
                        Label label1 = (Label) hBox1.getChildren().get(0);
                        TextField textField1 = (TextField) ((VBox) vBox.getChildren().get(1)).getChildren().get(0);
                        addIntegerValidation(textField1); // Add input validation
                        if (!textField1.getText().trim().isEmpty()) {
                            String item1 = label1.getText();
                            int numItems1 = Integer.parseInt(textField1.getText());
                            boolean electric = false;
                            for (int i = 0; i < numItems1; i++) {
                                if (item1.equals("Vacuum") || item1.equals("Power Scrubber")) {
                                    cleanList.add(new nonLiquidClean(item1, true));
                                    electric = true;
                                } else {
                                cleanList.add(new nonLiquidClean(item1, false));
                                }
                            }
                            if (checkCleanItem(cleanView, item1)) {
                                int currentNumItems1 = 0;
                                for (int i = 0; i < cleanList.size(); ++i) {
                                    if (cleanList.get(i).getName().equals(item1)) {
                                        currentNumItems1++;
                                    }
                                }
                                updateTextFieldValue(cleanView, item1, numItems1, currentNumItems1 - numItems1);
                            } else {
                                TextField deleteTextField = new TextField();
                                deleteTextField.setPromptText("Number of Items");
                                addIntegerValidation(deleteTextField); // Add input validation
                                Button deleteButton = new Button("Delete");
                                HBox cleanExpandableBox = new HBox(10, deleteTextField, deleteButton);
                                cleanExpandableBox.setVisible(false);
                                cleanExpandableBox.setManaged(false);
                                Button toggleButton = new Button("↓");
                                toggleButton.setMinSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
                                toggleButton.setOnAction(event -> {
                                    boolean isExpanded = cleanExpandableBox.isVisible();
                                    cleanExpandableBox.setVisible(!isExpanded);
                                    cleanExpandableBox.setManaged(!isExpanded);
                                    toggleButton.setText(isExpanded ? "↓" : "↑");
                                });
                                Region spacer = new Region();
                                HBox.setHgrow(spacer, Priority.ALWAYS);
                                Label cleanLabel = new Label(item1);
                                Label electricLabel = new Label();
                                if (electric) {
                                    electricLabel.setText("ELECTRIC");
                                    electricLabel.setStyle("-fx-text-fill: red;");
                                }
                                Label numClean = new Label(String.valueOf(numItems1));

                                HBox listBox = new HBox(10, cleanLabel, numClean, electricLabel, spacer, toggleButton);
                                listBox.setStyle("-fx-padding: 5;");
                                VBox deleteBox = new VBox(listBox, cleanExpandableBox);
                                VBox.setMargin(deleteBox, new Insets(20, 0, 20, 0));
                                cleanView.getItems().add(deleteBox);

                                // Set user data for the delete button
                                deleteButton.setUserData(deleteBox);
                                deleteButton.setOnAction(deleteEvent -> {
                                    TextField expandableTextField = (TextField) cleanExpandableBox.getChildren().get(0);
                                    int deleteNumItems = Integer.parseInt(expandableTextField.getText());
                                    int temp = 0;
                                    int currentNumItems1 = 0;
                                    for (int i = 0; i < cleanList.size(); i++) {
                                        if (cleanList.get(i).getName().equals(item1)) {
                                            currentNumItems1++;
                                        }
                                    }
                                    for (int i = 0; i < cleanList.size(); i++) {
                                        if (temp < deleteNumItems && cleanList.get(i).getName().equals(item1)) {
                                            cleanList.remove(i);
                                            temp++;
                                        }
                                    }
                                    deleteNumItems = 0 - deleteNumItems;
                                    deleteTextFieldValue(cleanView, item1, currentNumItems1, deleteNumItems);
                                });
                            }
                        }
                        break;
                    case "Kitchenware":
                        HBox hBox2 = (HBox) vBox.getChildren().get(0);
                        Label label2 = (Label) hBox2.getChildren().get(0);
                        TextField textField2 = (TextField) ((VBox) vBox.getChildren().get(1)).getChildren().get(0);
                        addIntegerValidation(textField2); // Add input validation
                        if (!textField2.getText().trim().isEmpty()) {
                            String item2 = label2.getText();
                            int numItems2 = Integer.parseInt(textField2.getText());
                            for (int i = 0; i < numItems2; i++) {
                                kitchenList.add(new Kitchenware(item2));
                            }
                            if (checkKitchenItem(kitchenView, item2)) {
                                int currentNumItems2 = 0;
                                for (int i = 0; i < kitchenList.size(); ++i) {
                                    if (kitchenList.get(i).getName().equals(item2)) {
                                        currentNumItems2++;
                                    }
                                }
                                updateTextFieldValue(kitchenView, item2, numItems2, currentNumItems2 - numItems2);
                            } else {
                                TextField deleteTextField = new TextField();
                                deleteTextField.setPromptText("Number of Items");
                                addIntegerValidation(deleteTextField); // Add input validation
                                Button deleteButton = new Button("Delete");
                                HBox kitchenExpandableBox = new HBox(10, deleteTextField, deleteButton);
                                kitchenExpandableBox.setVisible(false);
                                kitchenExpandableBox.setManaged(false);
                                Button toggleButton = new Button("↓");
                                toggleButton.setMinSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
                                toggleButton.setOnAction(event -> {
                                    boolean isExpanded = kitchenExpandableBox.isVisible();
                                    kitchenExpandableBox.setVisible(!isExpanded);
                                    kitchenExpandableBox.setManaged(!isExpanded);
                                    toggleButton.setText(isExpanded ? "↓" : "↑");
                                });
                                Region spacer = new Region();
                                HBox.setHgrow(spacer, Priority.ALWAYS);
                                Label kitchenLabel = new Label(item2);
                                Label numKitchen = new Label(String.valueOf(numItems2));
                                HBox listBox = new HBox(10, kitchenLabel, numKitchen, spacer, toggleButton);
                                listBox.setStyle("-fx-padding: 5;");
                                VBox deleteBox = new VBox(listBox, kitchenExpandableBox);
                                VBox.setMargin(deleteBox, new Insets(20, 0, 20, 0));
                                kitchenView.getItems().add(deleteBox);

                                // Set user data for the delete button
                                deleteButton.setUserData(deleteBox);
                                deleteButton.setOnAction(deleteEvent -> {
                                    TextField expandableTextField = (TextField) kitchenExpandableBox.getChildren().get(0);
                                    int deleteNumItems = Integer.parseInt(expandableTextField.getText());
                                    int temp = 0;
                                    int currentNumItems1 = 0;
                                    for (int i = 0; i < kitchenList.size(); i++) {
                                        if (kitchenList.get(i).getName().equals(item2)) {
                                            currentNumItems1++;
                                        }
                                    }
                                    for (int i = 0; i < kitchenList.size(); i++) {
                                        if (temp < deleteNumItems && kitchenList.get(i).getName().equals(item2)) {
                                            kitchenList.remove(i);
                                            temp++;
                                        }
                                    }
                                    deleteNumItems = 0 - deleteNumItems;
                                    deleteTextFieldValue(kitchenView, item2, currentNumItems1, deleteNumItems);
                                });
                            }
                        }
                        break;
                    case "Liquid Cleaning Supplies":
                        HBox hBox3 = (HBox) vBox.getChildren().get(0);
                        Label label3 = (Label) hBox3.getChildren().get(0);
                        TextField textField3 = (TextField) ((VBox) vBox.getChildren().get(1)).getChildren().get(0);
                        addIntegerValidation(textField3); // Add input validation
                        if (!textField3.getText().trim().isEmpty()) {
                            String item3 = label3.getText();
                            int numItems3 = Integer.parseInt(textField3.getText());
                            boolean toxic = false;
                            for (int i = 0; i < numItems3; i++) {
                                if (item3.equals("Vinegar") || item3.equals("Baking Soda") || item3.equals("Hydrogen Peroxide")) {
                                    liquidList.add(new liquidClean(item3, false));
                                } else {
                                    liquidList.add(new liquidClean(item3, true));
                                    toxic = true;
                                }
                            }
                            if (checkLiquidItem(liquidView, item3)) {
                                int currentNumItems3 = 0;
                                for (int i = 0; i < liquidList.size(); ++i) {
                                    if (liquidList.get(i).getName().equals(item3)) {
                                        currentNumItems3++;
                                    }
                                }
                                updateTextFieldValue(liquidView, item3, numItems3, currentNumItems3 - numItems3);
                            } else {
                                TextField deleteTextField = new TextField();
                                deleteTextField.setPromptText("Number of Items");
                                addIntegerValidation(deleteTextField); // Add input validation
                                Button deleteButton = new Button("Delete");
                                HBox liquidExpandableBox = new HBox(10, deleteTextField, deleteButton);
                                liquidExpandableBox.setVisible(false);
                                liquidExpandableBox.setManaged(false);
                                Button toggleButton = new Button("↓");
                                toggleButton.setMinSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
                                toggleButton.setOnAction(event -> {
                                    boolean isExpanded = liquidExpandableBox.isVisible();
                                    liquidExpandableBox.setVisible(!isExpanded);
                                    liquidExpandableBox.setManaged(!isExpanded);
                                    toggleButton.setText(isExpanded ? "↓" : "↑");
                                });
                                Region spacer = new Region();
                                HBox.setHgrow(spacer, Priority.ALWAYS);
                                Label liquidLabel = new Label(item3);
                                Label toxicLabel = new Label(toxic ? "TOXIC" : "");
                                if (toxic) {
                                    toxicLabel.setStyle("-fx-text-fill: red;");
                                }
                                Label numLiquid = new Label(String.valueOf(numItems3));
                                HBox listBox = new HBox(10, liquidLabel, numLiquid, toxicLabel, spacer, toggleButton);
                                listBox.setStyle("-fx-padding: 5;");
                                VBox deleteBox = new VBox(listBox, liquidExpandableBox);
                                VBox.setMargin(deleteBox, new Insets(20, 0, 20, 0));
                                liquidView.getItems().add(deleteBox);

                                // Set user data for the delete button
                                deleteButton.setUserData(deleteBox);
                                deleteButton.setOnAction(deleteEvent -> {
                                    TextField expandableTextField = (TextField) liquidExpandableBox.getChildren().get(0);
                                    int deleteNumItems = Integer.parseInt(expandableTextField.getText());
                                    int temp = 0;
                                    int currentNumItems1 = 0;
                                    for (int i = 0; i < liquidList.size(); i++) {
                                        if (liquidList.get(i).getName().equals(item3)) {
                                            currentNumItems1++;
                                        }
                                    }
                                    for (int i = 0; i < liquidList.size(); i++) {
                                        if (temp < deleteNumItems && liquidList.get(i).getName().equals(item3)) {
                                            liquidList.remove(i);
                                            temp++;
                                        }
                                    }
                                    deleteNumItems = 0 - deleteNumItems;
                                    deleteTextFieldValue(liquidView, item3, currentNumItems1, deleteNumItems);
                                });
                            }
                        }
                        break;
                }
            }
        });
        GridPane buttonGrid = new GridPane();
        buttonGrid.setPadding(new Insets(50));
        buttonGrid.setHgap(15);
        buttonGrid.setVgap(15);
        buttonGrid.add(foodButton, 0, 0);
        buttonGrid.add(cleanSuppliesButton, 1, 0);
        buttonGrid.add(kitchenwareButton, 2, 0); // add nodes to gridpane
        buttonGrid.add(liquidCleanButton, 3, 0);
        selectButtons.setStyle("-fx-alignment: center;");
        buttonGrid.setStyle("-fx-alignment: center;"); // center both grid pane and vbox
        VBox vBox1 = new VBox(10, buttonGrid, itemType, selectButtons);
        vBox1.setStyle("-fx-alignment: center;");
        GridPane lists = new GridPane();
        lists.setPadding(new Insets(10));
        lists.setHgap(10);
        Label foodLabelNode = new Label("Food");
        Label cleanLabelNode = new Label("Cleaning Equipment");
        Label kitchenLabelNode = new Label("Kitchenware");
        Label liquidLabelNode = new Label("Cleaning Supplies");
        lists.add(foodLabelNode, 0, 0);
        lists.add(cleanLabelNode, 1, 0);
        lists.add(kitchenLabelNode, 2, 0);
        lists.add(liquidLabelNode, 3, 0);
        lists.setHalignment(foodLabelNode, HPos.CENTER);
        lists.setHalignment(cleanLabelNode, HPos.CENTER);
        lists.setHalignment(kitchenLabelNode, HPos.CENTER);
        lists.setHalignment(liquidLabelNode, HPos.CENTER);
        GridPane.setHgrow(foodView, Priority.ALWAYS);
        GridPane.setHgrow(cleanView, Priority.ALWAYS);
        GridPane.setHgrow(kitchenView, Priority.ALWAYS);
        GridPane.setHgrow(liquidView, Priority.ALWAYS);
        lists.add(foodView, 0, 1);
        lists.add(cleanView, 1, 1);
        lists.add(kitchenView, 2, 1);
        lists.add(liquidView, 3, 1);
        lists.setStyle("-fx-alignment: center;");
        HBox.setHgrow(foodView, Priority.ALWAYS);
        HBox.setHgrow(cleanView, Priority.ALWAYS);
        HBox.setHgrow(kitchenView, Priority.ALWAYS);
        HBox.setHgrow(liquidView, Priority.ALWAYS);
        VBox root = new VBox(vBox1, lists);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 1000, 800);
        stage.setScene(scene);

        stage.setTitle("Inventory Management System");
        stage.show();
    }
    private boolean checkFoodItem(ListView<VBox> foodView, String item) {
        for (VBox vBox : foodView.getItems()) {
            HBox hBox = (HBox) vBox.getChildren().get(0);
            Label label = (Label) hBox.getChildren().get(0);
            if (label.getText() == item) {
                return true;
            }
        }
        return false;
    }
    private boolean checkCleanItem(ListView<VBox> cleanView, String item) {
        for (VBox vBox : cleanView.getItems()) {
            HBox hBox = (HBox) vBox.getChildren().get(0);
            Label label = (Label) hBox.getChildren().get(0);
            if (label.getText() == item) {
                return true;
            }
        }
        return false;
    }
    private boolean checkKitchenItem(ListView<VBox> kitchenView, String item) {
        for (VBox vBox : kitchenView.getItems()) {
            HBox hBox = (HBox) vBox.getChildren().get(0);
            Label label = (Label) hBox.getChildren().get(0);
            if (label.getText() == item) {
                return true;
            }
        }
        return false;
    }
    private boolean checkLiquidItem(ListView<VBox> liquidView, String item) {
        for (VBox vBox : liquidView.getItems()) {
            HBox hBox = (HBox) vBox.getChildren().get(0);
            Label label = (Label) hBox.getChildren().get(0);
            if (label.getText() == item) {
                return true;
            }
        }
        return false;
    }
 
    private void updateTextFieldValue(ListView<VBox> listView, String item, int numItems, int currentNumItems) {
        for (VBox vBox : listView.getItems()) {
            if (!vBox.getChildren().isEmpty()) {
                HBox hBox = (HBox) vBox.getChildren().get(0); // Get the first child (HBox)
    
                if (!hBox.getChildren().isEmpty()) {
                    Label label = (Label) hBox.getChildren().get(0); // Get the first Label in HBox
                    Label numLabel = (Label) hBox.getChildren().get(1); // Get the second Label in HBox
    
                    if (label.getText().equals(item)) { // Check if it's the correct Label
                        String strNum = String.valueOf(numItems + currentNumItems); // Convert the number to a String
                        numLabel.setText(strNum); // Update the label text
                        break; // Stop after finding and updating the correct label
                    }
                }
            }
        }
    }
    private void deleteTextFieldValue(ListView<VBox> listView, String item, int currentNum, int deleteNum) {
        for (VBox vBox : listView.getItems()) {
            if (!vBox.getChildren().isEmpty()) {
                HBox hBox = (HBox) vBox.getChildren().get(0); // Get the first child (HBox)
    
                if (!hBox.getChildren().isEmpty()) {
                    Label label = (Label) hBox.getChildren().get(0); // Get the first Label in HBox
                    Label numLabel = (Label) hBox.getChildren().get(1); // Get the second Label in HBox
    
                    if (label.getText().equals(item)) { // Check if it's the correct Label
                        int newNum = currentNum + deleteNum;
                        if (newNum <= 0) {
                            listView.getItems().remove(vBox);
                            break;
                        }
                        else {
                            String strNum = String.valueOf(newNum); // Convert the number to a String
                            numLabel.setText(strNum); // Update the label text
                            break; // Stop after finding and updating the correct label
                        }
                    }
                }
            }
        }
    }
    private void addIntegerValidation(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
