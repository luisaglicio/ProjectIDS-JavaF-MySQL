package gui;

import java.net.URL;
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.ZoneId;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
//import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.entities.Aluno;
import model.entities.NotasFaltas;
import model.exceptions.ValidationException;
import model.services.AlunoService;
import model.services.NotasFaltasService;

public class NotasFaltasFormController implements Initializable {

	private NotasFaltas entity;

	private NotasFaltasService service;

	private AlunoService alunoService;

	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtfaltas_b1;
	
	@FXML
	private TextField txtfaltas_b2;
	
	@FXML
	private TextField txtfaltas_b3;
	
	@FXML
	private TextField txtfaltas_b4;
	
	@FXML
	private TextField txtNota_sala_aula_B1;
	
	@FXML
	private TextField txtNota_sala_aula_B2;
	
	@FXML
	private TextField txtNota_sala_aula_B3;
	
	@FXML
	private TextField txtNota_sala_aula_B4;
	
	@FXML
	private TextField txtNota_tarefas_B1;
	
	@FXML
	private TextField txtNota_tarefas_B2;
	
	@FXML
	private TextField txtNota_tarefas_B3;
	
	@FXML
	private TextField txtNota_tarefas_B4;
	
	@FXML
	private TextField txtNota_trabalho_B1;
	
	@FXML
	private TextField txtNota_trabalho_B2;
	
	@FXML
	private TextField txtNota_trabalho_B3;
	
	@FXML
	private TextField txtNota_trabalho_B4;
	
	@FXML
	private TextField txtNota_prova_B1;
	
	@FXML
	private TextField txtNota_prova_B2;
	
	@FXML
	private TextField txtNota_prova_B3;
	
	@FXML
	private TextField txtNota_prova_B4;
	
	@FXML
	private ComboBox<Aluno> comboBoxAluno;
	
	
	@FXML
	private Label labelErrorfaltas_b1;
	
	@FXML
	private Label labelErrorfaltas_b2;
	
	@FXML
	private Label labelErrorfaltas_b3;
	
	@FXML
	private Label labelErrorfaltas_b4;
	
	@FXML
	private Label labelErrorNota_sala_aula_B1;
	
	@FXML
	private Label labelErrorNota_sala_aula_B2;
	
	@FXML
	private Label labelErrorNota_sala_aula_B3;
	
	@FXML
	private Label labelErrorNota_sala_aula_B4;
	
	@FXML
	private Label labelErrorNota_tarefas_B1;
	
	@FXML
	private Label labelErrorNota_tarefas_B2;
	
	@FXML
	private Label labelErrorNota_tarefas_B3;
	
	@FXML
	private Label labelErrorNota_tarefas_B4;
	
	@FXML
	private Label labelErrorNota_trabalho_B1;
	
	@FXML
	private Label labelErrorNota_trabalho_B2;
	
	@FXML
	private Label labelErrorNota_trabalho_B3;
	
	@FXML
	private Label labelErrorNota_trabalho_B4;
	
	@FXML
	private Label labelErrorNota_prova_B1;
	
	@FXML
	private Label labelErrorNota_prova_B2;
	
	@FXML
	private Label labelErrorNota_prova_B3;
	
	@FXML
	private Label labelErrorNota_prova_B4;
		
	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	private ObservableList<Aluno> obsList;

	public void setNotasFaltas(NotasFaltas entity) {
		this.entity = entity;
	}

	public void setServices(NotasFaltasService service, AlunoService alunoService) {
		this.service = service;
		this.alunoService = alunoService;
	}

	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}

	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			notifyDataChangeListeners();
			Utils.currentStage(event).close();
		} catch (ValidationException e) {
			setErrorMessages(e.getErrors());
		} catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}

	private void notifyDataChangeListeners() {
		for (DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
	}

	//Neste trexo eu configuro as ações da tela de cadastro de notas
	private NotasFaltas getFormData() {
		NotasFaltas obj = new NotasFaltas();

		ValidationException exception = new ValidationException("Validation error");

		//obj.setId(Utils.tryParseToInt(txtId.getText()));

		if (txtfaltas_b1.getText() == null || txtfaltas_b1.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setFaltasB1(Utils.tryParseToInt(txtfaltas_b1.getText()));
		
		if (txtfaltas_b2.getText() == null || txtfaltas_b2.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setFaltasB2(Utils.tryParseToInt(txtfaltas_b2.getText()));
		
		if (txtfaltas_b3.getText() == null || txtfaltas_b3.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setFaltasB3(Utils.tryParseToInt(txtfaltas_b3.getText()));
		
		if (txtfaltas_b4.getText() == null || txtfaltas_b4.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setFaltasB4(Utils.tryParseToInt(txtfaltas_b4.getText()));
		
		if (txtNota_sala_aula_B1.getText() == null || txtNota_sala_aula_B1.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaSalaAulaB1(Utils.tryParseToDouble(txtNota_sala_aula_B1.getText()));
		
		if (txtNota_sala_aula_B2.getText() == null || txtNota_sala_aula_B2.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaSalaAulaB2(Utils.tryParseToDouble(txtNota_sala_aula_B2.getText()));
		
		if (txtNota_sala_aula_B3.getText() == null || txtNota_sala_aula_B3.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaSalaAulaB3(Utils.tryParseToDouble(txtNota_sala_aula_B3.getText()));
		
		if (txtNota_sala_aula_B4.getText() == null || txtNota_sala_aula_B4.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaSalaAulaB4(Utils.tryParseToDouble(txtNota_sala_aula_B4.getText()));
				
		if (txtNota_tarefas_B1.getText() == null || txtNota_tarefas_B1.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaTarefasB1(Utils.tryParseToDouble(txtNota_tarefas_B1.getText()));
		
		if (txtNota_tarefas_B2.getText() == null || txtNota_tarefas_B2.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaTarefasB2(Utils.tryParseToDouble(txtNota_tarefas_B2.getText()));
		
		if (txtNota_tarefas_B3.getText() == null || txtNota_tarefas_B3.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaTarefasB3(Utils.tryParseToDouble(txtNota_tarefas_B3.getText()));
		
		if (txtNota_tarefas_B4.getText() == null || txtNota_tarefas_B4.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaTarefasB4(Utils.tryParseToDouble(txtNota_tarefas_B4.getText()));
		
		if (txtNota_trabalho_B1.getText() == null || txtNota_trabalho_B1.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaTrabalhoB1(Utils.tryParseToDouble(txtNota_trabalho_B1.getText()));
		
		if (txtNota_trabalho_B2.getText() == null || txtNota_trabalho_B1.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaTrabalhoB2(Utils.tryParseToDouble(txtNota_trabalho_B2.getText()));
		
		if (txtNota_trabalho_B3.getText() == null || txtNota_trabalho_B3.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaTrabalhoB3(Utils.tryParseToDouble(txtNota_trabalho_B3.getText()));
		
		if (txtNota_trabalho_B4.getText() == null || txtNota_trabalho_B4.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaTrabalhoB4(Utils.tryParseToDouble(txtNota_trabalho_B4.getText()));
		
			
		if (txtNota_prova_B1.getText() == null || txtNota_prova_B1.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaProvaB1(Utils.tryParseToDouble(txtNota_prova_B1.getText()));
		
		if (txtNota_prova_B2.getText() == null || txtNota_prova_B2.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaProvaB2(Utils.tryParseToDouble(txtNota_prova_B2.getText()));
		
		if (txtNota_prova_B3.getText() == null || txtNota_prova_B3.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaProvaB3(Utils.tryParseToDouble(txtNota_prova_B3.getText()));
		
		if (txtNota_prova_B4.getText() == null || txtNota_prova_B4.getText().trim().equals("")) {
			exception.addError("error", "Field can't be empty");
		}
		obj.setNotaProvaB4(Utils.tryParseToDouble(txtNota_prova_B4.getText()));
		
				
		obj.setAluno(comboBoxAluno.getValue());
		
		if (exception.getErrors().size() > 0) {
			throw exception;
		}

		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	//trecho para inicializar os dados
	private void initializeNodes() {
		//Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldInteger(txtfaltas_b1);
		Constraints.setTextFieldInteger(txtfaltas_b2);
		Constraints.setTextFieldInteger(txtfaltas_b3);
		Constraints.setTextFieldInteger(txtfaltas_b4);
		Constraints.setTextFieldDouble(txtNota_sala_aula_B1);
		Constraints.setTextFieldDouble(txtNota_sala_aula_B2);
		Constraints.setTextFieldDouble(txtNota_sala_aula_B3);
		Constraints.setTextFieldDouble(txtNota_sala_aula_B4);
		Constraints.setTextFieldDouble(txtNota_tarefas_B1);
		Constraints.setTextFieldDouble(txtNota_tarefas_B2);
		Constraints.setTextFieldDouble(txtNota_tarefas_B3);
		Constraints.setTextFieldDouble(txtNota_tarefas_B4);
		Constraints.setTextFieldDouble(txtNota_trabalho_B1);
		Constraints.setTextFieldDouble(txtNota_trabalho_B2);
		Constraints.setTextFieldDouble(txtNota_trabalho_B3);
		Constraints.setTextFieldDouble(txtNota_trabalho_B4);
		Constraints.setTextFieldDouble(txtNota_prova_B1);
		Constraints.setTextFieldDouble(txtNota_prova_B2);
		Constraints.setTextFieldDouble(txtNota_prova_B3);
		Constraints.setTextFieldDouble(txtNota_prova_B4);
		initializeComboBoxAluno();
	}

	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		//txtId.setText(String.valueOf(entity.getId()));
		txtfaltas_b1.setText(String.valueOf(entity.getFaltasB1()));
		txtfaltas_b2.setText(String.valueOf(entity.getFaltasB2()));
		txtfaltas_b3.setText(String.valueOf(entity.getFaltasB3()));
		txtfaltas_b4.setText(String.valueOf(entity.getFaltasB4()));
		Locale.setDefault(Locale.US);
		txtNota_sala_aula_B1.setText(String.format("%.2f", entity.getNotaSalaAulaB1()));
		txtNota_sala_aula_B2.setText(String.format("%.2f", entity.getNotaSalaAulaB2()));
		txtNota_sala_aula_B3.setText(String.format("%.2f", entity.getNotaSalaAulaB3()));
		txtNota_sala_aula_B4.setText(String.format("%.2f", entity.getNotaSalaAulaB4()));
		txtNota_tarefas_B1.setText(String.format("%.2f", entity.getNotaTarefasB1()));
		txtNota_tarefas_B2.setText(String.format("%.2f", entity.getNotaTarefasB2()));
		txtNota_tarefas_B3.setText(String.format("%.2f", entity.getNotaTarefasB3()));
		txtNota_tarefas_B4.setText(String.format("%.2f", entity.getNotaTarefasB4()));
		txtNota_trabalho_B1.setText(String.format("%.2f", entity.getNotaTrabalhoB1()));
		txtNota_trabalho_B2.setText(String.format("%.2f", entity.getNotaTrabalhoB2()));
		txtNota_trabalho_B3.setText(String.format("%.2f", entity.getNotaTrabalhoB3()));
		txtNota_trabalho_B4.setText(String.format("%.2f", entity.getNotaTrabalhoB4()));
		txtNota_prova_B1.setText(String.format("%.2f", entity.getNotaProvaB1()));
		txtNota_prova_B2.setText(String.format("%.2f", entity.getNotaProvaB2()));
		txtNota_prova_B3.setText(String.format("%.2f", entity.getNotaProvaB3()));
		txtNota_prova_B4.setText(String.format("%.2f", entity.getNotaProvaB4()));
		
		
		if (entity.getAluno() == null) {
			comboBoxAluno.getSelectionModel().selectFirst();
		} else {
			comboBoxAluno.setValue(entity.getAluno());
		}
	}

	public void loadAssociatedObjects() {
		if (alunoService == null) {
			throw new IllegalStateException("AlunoService was null");
		}
		List<Aluno> list = alunoService.findAll();
		obsList = FXCollections.observableArrayList(list);
		comboBoxAluno.setItems(obsList);
	}

	private void setErrorMessages(Map<String, String> errors) {
		Set<String> fields = errors.keySet();

		labelErrorfaltas_b1.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorfaltas_b2.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorfaltas_b3.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorfaltas_b4.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_sala_aula_B1.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_sala_aula_B2.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_sala_aula_B3.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_sala_aula_B4.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_tarefas_B1.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_tarefas_B2.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_tarefas_B3.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_tarefas_B4.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_trabalho_B1.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_trabalho_B2.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_trabalho_B3.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_trabalho_B4.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_prova_B1.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_prova_B2.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_prova_B3.setText((fields.contains("error") ? errors.get("error") : ""));
		labelErrorNota_prova_B4.setText((fields.contains("error") ? errors.get("error") : ""));
				
	}

	private void initializeComboBoxAluno() {
		Callback<ListView<Aluno>, ListCell<Aluno>> factory = lv -> new ListCell<Aluno>() {
			@Override
			protected void updateItem(Aluno item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		comboBoxAluno.setCellFactory(factory);
		comboBoxAluno.setButtonCell(factory.call(null));
	}
}