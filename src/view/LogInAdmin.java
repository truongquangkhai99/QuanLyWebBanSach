package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import login.AdminManagement;

public class LogInAdmin extends Stage {
	public static boolean stateLogin = false;
	AdminManagement admin = new AdminManagement();

	public LogInAdmin() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);

		Label adminLogin = new Label("Admin Login");
		adminLogin.setFont(new Font("Times New Roman", 23));
		adminLogin.getStyleClass().add("title");
		GridPane.setConstraints(adminLogin, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER);
		grid.add(adminLogin, 0, 0, 2, 1);

		Label adminName = new Label("User Name: ");
		grid.add(adminName, 0, 1);

		TextField txAdminName = new TextField();
		txAdminName.setPrefWidth(200);
		grid.add(txAdminName, 1, 1);

		Label adminPassword = new Label("Password: ");
		grid.add(adminPassword, 0, 2);

		PasswordField txAdminPassword = new PasswordField();
		txAdminPassword.setPrefWidth(200);
		grid.add(txAdminPassword, 1, 2);

		HBox hbox = new HBox();
		hbox.setSpacing(20);
		grid.add(hbox, 1, 3);

		Button login = new Button("Login");
		login.getStyleClass().add("button");
		login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (txAdminName.getText().equals("") || "".equals(txAdminPassword.getText())) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information");
					alert.setHeaderText(null);
					alert.setContentText("Please filled out all required ! ");
					alert.showAndWait();

				} else if (admin.checkLogin(txAdminName.getText(), txAdminPassword.getText())) {
					close();
					new MainView();
					stateLogin = true;
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Username or Password is wrong!");
					alert.showAndWait();
				}
				
				// MainView.logInAmins.close();

			}

		});
		// login.setGraphic(new ImageView(imgLogin));

		Button clear = new Button("Clear");
		clear.getStyleClass().add("button");
		// clear.setGraphic(new ImageView(imgCancel));
		clear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				txAdminName.setText("");
				txAdminPassword.setText("");
			}
		});

		hbox.getChildren().addAll(login, clear);
		grid.getStyleClass().add("background");

		Scene signIn = new Scene(grid);
		signIn.getStylesheets().add("LayOut.css");
		Stage stage = new Stage();
		stage.setTitle("Log In");

		this.setScene(signIn);

	}

}
