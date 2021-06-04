package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import application.Main;
import db.DbIntegrityException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.NotasFaltas;
import model.services.AlunoService;
import model.services.NotasFaltasService;

public class NotasFaltasListController implements Initializable, DataChangeListener {

	private NotasFaltasService service;

	@FXML
	private TableView<NotasFaltas> tableViewNotasFaltas;

	@FXML
	private TableColumn<NotasFaltas, Integer> tableColumnId;
	
	@FXML
	private TableColumn<NotasFaltas, Integer> tableColumnFaltasB1;
	
	@FXML
	private TableColumn<NotasFaltas, Integer> tableColumnFaltasB2;
	
	@FXML
	private TableColumn<NotasFaltas, Integer> tableColumnFaltasB3;
	
	@FXML
	private TableColumn<NotasFaltas, Integer> tableColumnFaltasB4;
	
	@FXML
	private TableColumn<NotasFaltas, Integer> tableColumnTotalFaltas;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaSalaAulaB1;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaSalaAulaB2;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaSalaAulaB3;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaSalaAulaB4;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaTarefasB1;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaTarefasB2;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaTarefasB3;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaTarefasB4;
		
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaTrabalhoB1;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaTrabalhoB2;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaTrabalhoB3;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaTrabalhoB4;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaProvaB1;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaProvaB2;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaProvaB3;
	
	@FXML
	private TableColumn<NotasFaltas, Double> tableColumnBaseNotaProvaB4;
	
	@FXML
	private TableColumn<NotasFaltas, String> tableColumnSituacaoAluno;
	
	@FXML
	private TableColumn<NotasFaltas, NotasFaltas> tableColumnEDIT;

	@FXML
	private TableColumn<NotasFaltas, NotasFaltas> tableColumnREMOVE;

	@FXML
	private Button btNew;

	private ObservableList<NotasFaltas> obsList;

	
	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		NotasFaltas obj = new NotasFaltas();
		createDialogForm(obj, "/gui/NotasFaltasForm.fxml", parentStage);
	}

	public void setNotasFaltasService(NotasFaltasService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnFaltasB1.setCellValueFactory(new PropertyValueFactory<>("faltasB1"));
		tableColumnFaltasB2.setCellValueFactory(new PropertyValueFactory<>("faltasB2"));
		tableColumnFaltasB3.setCellValueFactory(new PropertyValueFactory<>("faltasB3"));
		tableColumnFaltasB4.setCellValueFactory(new PropertyValueFactory<>("faltasB4"));
		tableColumnTotalFaltas.setCellValueFactory(new PropertyValueFactory<>("totalFaltas"));
		tableColumnBaseNotaSalaAulaB1.setCellValueFactory(new PropertyValueFactory<>("notaSalaAulaB1"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaSalaAulaB1, 2);
		tableColumnBaseNotaSalaAulaB2.setCellValueFactory(new PropertyValueFactory<>("notaSalaAulaB2"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaSalaAulaB2, 2);
		tableColumnBaseNotaSalaAulaB3.setCellValueFactory(new PropertyValueFactory<>("notaSalaAulaB3"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaSalaAulaB3, 2);
		tableColumnBaseNotaSalaAulaB4.setCellValueFactory(new PropertyValueFactory<>("notaSalaAulaB4"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaSalaAulaB4, 2);
		tableColumnBaseNotaTarefasB1.setCellValueFactory(new PropertyValueFactory<>("notaTarefasB1"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaTarefasB1, 2);
		tableColumnBaseNotaTarefasB2.setCellValueFactory(new PropertyValueFactory<>("notaTarefasB2"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaTarefasB2, 2);
		tableColumnBaseNotaTarefasB3.setCellValueFactory(new PropertyValueFactory<>("notaTarefasB3"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaTarefasB3, 2);
		tableColumnBaseNotaTarefasB4.setCellValueFactory(new PropertyValueFactory<>("notaTarefasB4"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaTarefasB4, 2);
		tableColumnBaseNotaTrabalhoB1.setCellValueFactory(new PropertyValueFactory<>("notaTrabalhoB1"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaTrabalhoB1, 2);
		tableColumnBaseNotaTrabalhoB2.setCellValueFactory(new PropertyValueFactory<>("notaTrabalhoB2"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaTrabalhoB2, 2);
		tableColumnBaseNotaTrabalhoB3.setCellValueFactory(new PropertyValueFactory<>("notaTrabalhoB3"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaTrabalhoB3, 2);
		tableColumnBaseNotaTrabalhoB4.setCellValueFactory(new PropertyValueFactory<>("notaTrabalhoB4"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaTrabalhoB4, 2);
		tableColumnBaseNotaProvaB1.setCellValueFactory(new PropertyValueFactory<>("notaProvaB1"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaProvaB1, 2);
		tableColumnBaseNotaProvaB2.setCellValueFactory(new PropertyValueFactory<>("notaProvaB2"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaProvaB2, 2);
		tableColumnBaseNotaProvaB3.setCellValueFactory(new PropertyValueFactory<>("notaProvaB3"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaProvaB3, 2);
		tableColumnBaseNotaProvaB4.setCellValueFactory(new PropertyValueFactory<>("notaProvaB4"));
		Utils.formatTableColumnDouble(tableColumnBaseNotaProvaB4, 2);
		tableColumnSituacaoAluno.setCellValueFactory(new PropertyValueFactory<>("situacaoAluno"));
		
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewNotasFaltas.prefHeightProperty().bind(stage.heightProperty());
	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<NotasFaltas> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewNotasFaltas.setItems(obsList);
		initEditButtons();
		initRemoveButtons();
	}
	
	
	
	private void createDialogForm(NotasFaltas obj, String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			NotasFaltasFormController controller = loader.getController();
			controller.setNotasFaltas(obj);
			controller.setServices(new NotasFaltasService(), new AlunoService());
			controller.loadAssociatedObjects();
			controller.subscribeDataChangeListener(this);
			controller.updateFormData();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Enter NotasFaltas data");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void onDataChanged() {
		updateTableView();
	}

	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<NotasFaltas, NotasFaltas>() {
			private final Button button = new Button("edit");

			@Override
			protected void updateItem(NotasFaltas obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/NotasFaltasForm.fxml", Utils.currentStage(event)));
			}
		});
	}

	private void initRemoveButtons() {
		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnREMOVE.setCellFactory(param -> new TableCell<NotasFaltas, NotasFaltas>() {
			private final Button button = new Button("remove");

			@Override
			protected void updateItem(NotasFaltas obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> removeEntity(obj));
			}
		});
	}

	private void removeEntity(NotasFaltas obj) {
		Optional<ButtonType> result = Alerts.showConfirmation("Confirmation", "Are you sure to delete?");

		if (result.get() == ButtonType.OK) {
			if (service == null) {
				throw new IllegalStateException("Service was null");
			}
			try {
				service.remove(obj);
				updateTableView();
			}
			catch (DbIntegrityException e) {
				Alerts.showAlert("Error removing object", null, e.getMessage(), AlertType.ERROR);
			}
		}
	}
}