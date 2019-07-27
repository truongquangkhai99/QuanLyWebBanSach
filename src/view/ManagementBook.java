package view;

import Model.Book;
import bll.BookManagementImpl;
import bll.IBookManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagementBook extends VBox {
//public class ManagementBook extends Stage {

	IBookManagement bookManagemnet = new BookManagementImpl();

	// @Override
	// public void start(Stage primaryStage) throws Exception {
	// TODO Auto-generated method stub

	public ManagementBook(Stage primaryStage) {
		TableView<Book> table = new TableView<>();
		table.setPadding(new Insets(20, 12, 12, 50));
		table.setEditable(true);
		table.setPrefHeight(250);
		
		GridPane grid = new GridPane();
		// GridPane grManaBook = new GridPane();
		grid.setHgap(15);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 12, 12, 50));

		Label bookId = new Label("ID");
		grid.add(bookId, 0, 0);
		TextField txBookId = new TextField();
		txBookId.setPrefWidth(350);
		grid.add(txBookId, 1, 0);

		Label titleBook = new Label("Title");
		grid.add(titleBook, 0, 1);
		TextField txTitleBook = new TextField();
		grid.add(txTitleBook, 1, 1);

		Label cateBook = new Label("Category");
		grid.add(cateBook, 2, 0);
		TextField txCateBook = new TextField();
		txCateBook.setPrefWidth(350);
		grid.add(txCateBook, 3, 0);

		Label author = new Label("Author");
		grid.add(author, 2, 1);
		TextField txAuthor = new TextField();
		grid.add(txAuthor, 3, 1);

		Label publisher = new Label("Publisher");
		grid.add(publisher, 0, 2);
		TextField txPublisher = new TextField();
		grid.add(txPublisher, 1, 2);

		Label publisherDate = new Label("Publisher Date");
		grid.add(publisherDate, 2, 2);
		DatePicker date = new DatePicker();
		date.setPrefWidth(350);
		grid.add(date, 3, 2);

		Label decription = new Label("Decription");
		grid.add(decription, 0, 3);
		TextField txDecription = new TextField();
		GridPane.setConstraints(txDecription, 0, 4, 4, 2, HPos.CENTER, VPos.CENTER);
		grid.add(txDecription, 0, 4);

		Label price = new Label("Price");
		grid.add(price, 2, 3);
		TextField txPrice = new TextField();
		grid.add(txPrice, 3, 3);

		Button search = new Button("Search");

		Button clear = new Button("Clear");
		clear.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				txBookId.setText("");
				txTitleBook.setText("");
				txCateBook.setText("");
				txAuthor.setText("");
				txDecription.setText("");
				txPublisher.setText("");
				txPrice.setText("");
				//date.setDayCellFactory("");

			}
		});

		Button remove = new Button("Remove");
		remove.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				Book selectedItem = table.getSelectionModel().getSelectedItem();
				table.getItems().remove(selectedItem);

			}
		});

		HBox book = new HBox();
		book.setSpacing(10);
		book.setPadding(new Insets(15, 15, 15, 15));
		book.getChildren().addAll(search, clear, remove);
		book.setAlignment(Pos.CENTER);
		GridPane.setConstraints(book, 0, 6, 4, 1, HPos.CENTER, VPos.CENTER);
		grid.add(book, 0, 6);

		

		TableColumn<Book, Integer> clId = new TableColumn<>("Id");
		clId.setCellValueFactory(new PropertyValueFactory<>("id"));
		// clId.setVisible(false);
		clId.setOnEditCommit(new EventHandler<CellEditEvent<Book, Integer>>() {
			@Override
			public void handle(CellEditEvent<Book, Integer> t) {
				int newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setPrice(newValue);
			}

		});

		TableColumn<Book, String> clTitle = new TableColumn<>("Title");
		clTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
		clTitle.setCellFactory(TextFieldTableCell.forTableColumn());
		clTitle.setOnEditCommit(new EventHandler<CellEditEvent<Book, String>>() {
			@Override
			public void handle(CellEditEvent<Book, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setTitle(newValue);
			}

		});

		TableColumn<Book, String> clCategory = new TableColumn<>("Category");
		clCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
		clCategory.setCellFactory(TextFieldTableCell.forTableColumn());
		clCategory.setOnEditCommit(new EventHandler<CellEditEvent<Book, String>>() {
			@Override
			public void handle(CellEditEvent<Book, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setCategory(newValue);
			}

		});

		TableColumn<Book, String> clDecription = new TableColumn<>("Decription");
		clDecription.setCellValueFactory(new PropertyValueFactory<>("decription"));
		clDecription.setCellFactory(TextFieldTableCell.forTableColumn());
		clDecription.setOnEditCommit(new EventHandler<CellEditEvent<Book, String>>() {
			@Override
			public void handle(CellEditEvent<Book, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setDecription(newValue);
			}

		});

		TableColumn<Book, String> clPublisherDate = new TableColumn<>("Publisher Date");
		clPublisherDate.setCellValueFactory(new PropertyValueFactory<>("publisherDate"));

		clPublisherDate.setOnEditCommit(new EventHandler<CellEditEvent<Book, String>>() {
			@Override
			public void handle(CellEditEvent<Book, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setPublisherDate(newValue);
			}

		});

		TableColumn<Book, String> clAuthor = new TableColumn<>("Author");
		clAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
		clAuthor.setCellFactory(TextFieldTableCell.forTableColumn());
		clAuthor.setOnEditCommit(new EventHandler<CellEditEvent<Book, String>>() {
			@Override
			public void handle(CellEditEvent<Book, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setAuthor(newValue);
			}

		});

		TableColumn<Book, String> clPublisher = new TableColumn<>("Publisher");
		clPublisher.setCellValueFactory(new PropertyValueFactory<>("Publisher"));
		clPublisher.setCellFactory(TextFieldTableCell.forTableColumn());
		clPublisher.setOnEditCommit(new EventHandler<CellEditEvent<Book, String>>() {
			@Override
			public void handle(CellEditEvent<Book, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setPublisher(newValue);
			}

		});

		TableColumn<Book, Double> clPrice = new TableColumn<>("Price");
		clPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		// salary.setCellFactory(TextFieldTableCell.forTableColumn());
		clPrice.setOnEditCommit(new EventHandler<CellEditEvent<Book, Double>>() {
			@Override
			public void handle(CellEditEvent<Book, Double> t) {
				Double newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setPrice(newValue);
			}

		});

		table.getColumns().addAll(clId, clTitle, clCategory, clDecription, clAuthor, clPublisherDate, clPublisher,
				clPrice);

		ObservableList<Book> data = FXCollections.observableArrayList(bookManagemnet.getAllBooks());

		table.setItems(data);

		// VBox vb = new VBox();
		this.setSpacing(10);
		this.getChildren().addAll(grid, table);

		// Scene scene = new Scene(vb);
		// this.setTitle("hello");
		// this.setScene(scene);
		// primaryStage.show();

	}

	/*
	 * public static void main(String[] args) { launch(args);
	 * 
	 * }
	 */
}
