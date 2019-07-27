package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainView extends Application {

	// static Stage logInAmins = new LogInAdmin();
	public void start(Stage primaryStage) throws Exception {
		BorderPane br = new BorderPane();

		
		VBox managementBook = new ManagementBook(primaryStage);
		
		HBox bottom = new HBox();

		Image book = new Image(getClass().getResourceAsStream("/sach.jfif"));
		ImageView imageBook = new ImageView(book);
		
		Label titleWeb = new Label("******FX BOOK SALE******");
		titleWeb.getStyleClass().add("title");
		titleWeb.setFont(new Font("Arial", 30));
		

		// image phu
		// Giao dien admin
		
		Label titleWeb1 = new Label("******FX BOOK SALE******");
		titleWeb1.getStyleClass().add("title");
		titleWeb1.setFont(new Font("Arial", 30));
		
		Button manaBook = new Button("Management Book");
		manaBook.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				br.setCenter(managementBook);

			}
		});

		Button manaUser = new Button("Management User");

		Button manaOrder = new Button("Management Order");

		Button signOut = new Button("Log Out");
		signOut.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				br.setTop(titleWeb);
				br.setCenter(imageBook);
				br.setBottom(bottom);

			}
		});

		HBox ql = new HBox();
		ql.setSpacing(10);
		ql.setPadding(new Insets(30, 00, 00, 0));
		ql.getChildren().addAll(manaBook, manaUser, manaOrder, signOut);
		ql.setAlignment(Pos.TOP_RIGHT);

		VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 0));
		vb.getChildren().addAll(titleWeb1, ql);
////////////////////////////
		Button admin = new Button("ADMIN");
		admin.getStyleClass().add("button");
		
		admin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				Stage logInAmins = new LogInAdmin();
				logInAmins.initModality(Modality.WINDOW_MODAL);
				logInAmins.initOwner(primaryStage);
				logInAmins.showAndWait();

				if (LogInAdmin.stateLogin) {
					br.setTop(vb);
					br.setCenter(managementBook);
					br.setBottom(null);
				}

			}
		});

		Button user = new Button("USER");
		user.getStyleClass().add("button");

		
		br.setCenter(imageBook);

		
		bottom.setSpacing(10);
		bottom.getChildren().addAll(admin, user);

		
		
		
		br.setTop(titleWeb);
		br.setBottom(bottom);
		br.getStyleClass().add("background");

		

		Scene scene = new Scene(br, 1000, 800);
		scene.getStylesheets().add("LayOut.css");
		Image bk = new Image(getClass().getResourceAsStream("/open-book.png"));
		primaryStage.setTitle("FX BOOK SALE");
		primaryStage.getIcons().add(bk);
		primaryStage.setFullScreen(false);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
