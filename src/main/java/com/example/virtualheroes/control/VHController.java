package com.example.virtualheroes.control;

import com.example.virtualheroes.dto.VHDto;
import com.example.virtualheroes.service.IVHService;
import com.example.virtualheroes.service.VHService;
import com.example.virtualheroes.service.VHServiceArchive;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

public class VHController {

    @FXML
    public TextField txtId;
    @FXML
    public TextField txtNombre;
    @FXML
    public Button btnCrear;
    @FXML
    public Button btnMostrar;
    @FXML
    public Button btnEliminar;
    @FXML
    public Button btnActualizar;
    @FXML
    public TableView<VHDto> tableHeroes;


    @FXML
    public TableColumn<VHDto, Long> colId;
    @FXML
    public TableColumn<VHDto, String> colNombre;


    private IVHService heroesService;

    public VHController() {
        this.heroesService = new VHServiceArchive();
    }

    @FXML
    public void initializacion(){
        colId.setCellValueFactory( new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        refrescarTabla();
    }
    private void refrescarTabla() {
        tableHeroes.setItems(FXCollections.observableArrayList(heroesService.obtenerHeroes()));
    }
    private void limpiar() {
        txtId.clear();
        txtNombre.clear();
        chkLimpiar.setSelected(false);
    }
    private void alerta(String mensaje) {
        new Alert(Alert.AlertType.WARNING, mensaje).show();
    }



    @FXML
    public void handleCrear(MouseEvent mouseEvent) {
        Integer id = Integer.parseInt(txtId.getText());
        String nombre = txtNombre.getText();
        VHDto heroeDto = new VHDto(id, nombre);
        this.heroesService.crearHeroe(heroeDto);
    }
    @FXML
    public void handleEliminar(MouseEvent mouseEvent) {
        try {
            long id = Long.parseLong(txtId.getText().trim());
            heroesService.eliminar(id);
            refrescarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            alerta("Selecciona un héroe o ingresa un ID válido");
        }
    }

    @FXML
    public void handleMostrar(MouseEvent mouseEvent) {
        refrescarTabla();

    }

    @FXML
    public void handleActualizarr(MouseEvent mouseEvent) {
    try {
        long id = Long.parseLong(txtId.getText().trim());
        heroesService.actualizar(id, txtNombre.getText().trim());
        refrescarTabla();
        limpiarCampos();
    } catch (NumberFormatException e) {
        alerta("Selecciona un héroe o ingresa un ID válido");
    }
}


    @FXML
    public void handleSelection(MouseEvent mouseEvent) {
        System.out.println(this.heroesService.obtenerHeroes().size());
        for (VHDto heroe : this.heroesService.obtenerHeroes()) {
            System.out.println(heroe);
        }
    }
}
