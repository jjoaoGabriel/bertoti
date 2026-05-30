package org.example.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.example.Fut;

public class FutUI extends Application {

    private final FutService service =
            new FutService();

    private final TableView<Fut> table =
            new TableView<>();

    @Override
    public void start(Stage stage) {

        Label title =
                new Label("Sistema de Jogadores");

        TableColumn<Fut, Long> idCol =
                new TableColumn<>("ID");

        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        TableColumn<Fut, String> nameCol =
                new TableColumn<>("Nome");

        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        TableColumn<Fut, String> positionCol =
                new TableColumn<>("Posição");

        positionCol.setCellValueFactory(
                new PropertyValueFactory<>("position")
        );

        TableColumn<Fut, String> teamCol =
                new TableColumn<>("Time");

        teamCol.setCellValueFactory(
                new PropertyValueFactory<>("team")
        );

        TableColumn<Fut, Integer> ageCol =
                new TableColumn<>("Idade");

        ageCol.setCellValueFactory(
                new PropertyValueFactory<>("age")
        );

        table.getColumns().addAll(
                idCol,
                nameCol,
                positionCol,
                teamCol,
                ageCol
        );

        Button loadBtn =
                new Button("Carregar");

        loadBtn.setOnAction(e -> loadPlayers());

        Button addBtn =
                new Button("Adicionar");

        addBtn.setOnAction(e -> addPlayer());

        Button editBtn =
                new Button("Editar");

        editBtn.setOnAction(e -> editPlayer());

        Button deleteBtn =
                new Button("Deletar");

        deleteBtn.setOnAction(e -> deletePlayer());

        VBox layout =
                new VBox(
                        10,
                        title,
                        loadBtn,
                        addBtn,
                        editBtn,
                        deleteBtn,
                        table
                );

        Scene scene =
                new Scene(layout, 700, 500);

        stage.setTitle("CRUD Jogadores");

        stage.setScene(scene);

        stage.show();
    }

    private void loadPlayers() {

        table.setItems(
                FXCollections.observableArrayList(
                        service.getPlayers()
                )
        );
    }

    private void addPlayer() {

        Fut player =
                showPlayerDialog(null);

        if (player != null) {

            service.addPlayer(player);

            loadPlayers();
        }
    }

    private void editPlayer() {

        Fut selected =
                table.getSelectionModel()
                        .getSelectedItem();

        if (selected != null) {

            Fut updated =
                    showPlayerDialog(selected);

            if (updated != null) {

                service.updatePlayer(
                        selected.getId(),
                        updated
                );

                loadPlayers();
            }
        }
    }

    private void deletePlayer() {

        Fut selected =
                table.getSelectionModel()
                        .getSelectedItem();

        if (selected != null) {

            service.deletePlayer(selected.getId());

            loadPlayers();
        }
    }

    private Fut showPlayerDialog(Fut player) {

        Dialog<Fut> dialog =
                new Dialog<>();

        dialog.setTitle("Cadastro de Jogador");

        Label nameLabel =
                new Label("Nome:");

        TextField nameField =
                new TextField();

        Label positionLabel =
                new Label("Posição:");

        TextField positionField =
                new TextField();

        Label teamLabel =
                new Label("Time:");

        TextField teamField =
                new TextField();

        Label ageLabel =
                new Label("Idade:");

        TextField ageField =
                new TextField();

        if (player != null) {

            nameField.setText(player.getName());

            positionField.setText(
                    player.getPosition()
            );

            teamField.setText(
                    player.getTeam()
            );

            ageField.setText(
                    String.valueOf(
                            player.getAge()
                    )
            );
        }

        VBox layout =
                new VBox(
                        10,
                        nameLabel,
                        nameField,

                        positionLabel,
                        positionField,

                        teamLabel,
                        teamField,

                        ageLabel,
                        ageField
                );

        dialog.getDialogPane()
                .setContent(layout);

        ButtonType saveButton =
                new ButtonType(
                        "Salvar",
                        ButtonBar.ButtonData.OK_DONE
                );

        dialog.getDialogPane()
                .getButtonTypes()
                .addAll(
                        saveButton,
                        ButtonType.CANCEL
                );

        dialog.setResultConverter(button -> {

            if (button == saveButton) {

                try {

                    Fut p = new Fut();

                    p.setName(
                            nameField.getText()
                    );

                    p.setPosition(
                            positionField.getText()
                    );

                    p.setTeam(
                            teamField.getText()
                    );

                    p.setAge(
                            Integer.parseInt(
                                    ageField.getText()
                            )
                    );

                    return p;

                } catch (Exception e) {

                    System.out.println(
                            "Erro ao converter dados"
                    );
                }
            }

            return null;
        });

        return dialog.showAndWait()
                .orElse(null);
    }

    public static void main(String[] args) {
        launch();
    }
}