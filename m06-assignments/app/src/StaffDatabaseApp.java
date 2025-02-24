import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;

public class StaffDatabaseApp extends Application {
    private TextField idField, lastNameField, firstNameField, miField, addressField, cityField, stateField, phoneField, emailField;
    private Connection conn;

    @Override
    public void start(Stage primaryStage) {
        // Connect to database
        connectToDatabase();

        // UI Setup
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(5);
        grid.setHgap(10);

        // Create labels and text fields
        grid.add(new Label("ID:"), 0, 0);
        idField = new TextField();
        grid.add(idField, 1, 0);

        grid.add(new Label("Last Name:"), 0, 1);
        lastNameField = new TextField();
        grid.add(lastNameField, 1, 1);

        grid.add(new Label("First Name:"), 0, 2);
        firstNameField = new TextField();
        grid.add(firstNameField, 1, 2);

        grid.add(new Label("MI:"), 0, 3);
        miField = new TextField();
        grid.add(miField, 1, 3);

        grid.add(new Label("Address:"), 0, 4);
        addressField = new TextField();
        grid.add(addressField, 1, 4);

        grid.add(new Label("City:"), 0, 5);
        cityField = new TextField();
        grid.add(cityField, 1, 5);

        grid.add(new Label("State:"), 0, 6);
        stateField = new TextField();
        grid.add(stateField, 1, 6);

        grid.add(new Label("Phone:"), 0, 7);
        phoneField = new TextField();
        grid.add(phoneField, 1, 7);

        grid.add(new Label("Email:"), 0, 8);
        emailField = new TextField();
        grid.add(emailField, 1, 8);

        // Buttons
        Button viewButton = new Button("View");
        Button insertButton = new Button("Insert");
        Button updateButton = new Button("Update");

        grid.add(viewButton, 0, 9);
        grid.add(insertButton, 1, 9);
        grid.add(updateButton, 2, 9);

        // Button Actions
        viewButton.setOnAction(e -> viewRecord());
        insertButton.setOnAction(e -> insertRecord());
        updateButton.setOnAction(e -> updateRecord());

        // Set up the stage
        primaryStage.setTitle("Staff Database Management");
        primaryStage.setScene(new Scene(grid, 400, 400));
        primaryStage.show();
    }

    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
        } catch (SQLException e) {
            showAlert("Database Connection Failed!");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void viewRecord() {
        String id = idField.getText();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Staff WHERE id = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                lastNameField.setText(rs.getString("lastName"));
                firstNameField.setText(rs.getString("firstName"));
                miField.setText(rs.getString("mi"));
                addressField.setText(rs.getString("address"));
                cityField.setText(rs.getString("city"));
                stateField.setText(rs.getString("state"));
                phoneField.setText(rs.getString("telephone"));
                emailField.setText(rs.getString("email"));
            } else {
                showAlert("No record found for ID: " + id);
            }
        } catch (SQLException e) {
            showAlert("Error fetching record.");
            e.printStackTrace();
        }
    }

    private void insertRecord() {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Staff VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, idField.getText());
            stmt.setString(2, lastNameField.getText());
            stmt.setString(3, firstNameField.getText());
            stmt.setString(4, miField.getText());
            stmt.setString(5, addressField.getText());
            stmt.setString(6, cityField.getText());
            stmt.setString(7, stateField.getText());
            stmt.setString(8, phoneField.getText());
            stmt.setString(9, emailField.getText());

            int rows = stmt.executeUpdate();
            if (rows > 0) showAlert("Record Inserted Successfully!");
        } catch (SQLException e) {
            showAlert("Error inserting record.");
            e.printStackTrace();
        }
    }

    private void updateRecord() {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                "UPDATE Staff SET lastName=?, firstName=?, mi=?, address=?, city=?, state=?, telephone=?, email=? WHERE id=?"
            );
            stmt.setString(1, lastNameField.getText());
            stmt.setString(2, firstNameField.getText());
            stmt.setString(3, miField.getText());
            stmt.setString(4, addressField.getText());
            stmt.setString(5, cityField.getText());
            stmt.setString(6, stateField.getText());
            stmt.setString(7, phoneField.getText());
            stmt.setString(8, emailField.getText());
            stmt.setString(9, idField.getText());

            int rows = stmt.executeUpdate();
            if (rows > 0) showAlert("Record Updated Successfully!");
        } catch (SQLException e) {
            showAlert("Error updating record.");
            e.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
