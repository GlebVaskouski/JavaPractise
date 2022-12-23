package com.example.ltwui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;


public class HelloApplication extends Application {
    private TableView<Shoes> table = new TableView<Shoes>();
    private TableView<Shoes> safeTable = new TableView<Shoes>();
    private Shop st = new Shop();

    @Override
    public void start(Stage stage) throws IOException {
        VBox vBox = new VBox();
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("Сортировки");
        Menu menu2 = new Menu("Данные");
        Menu menu3 = new Menu("Дополнительно");

        MenuItem sortMenuItemByName = new MenuItem("Сортировка по названию обуви");
        MenuItem sortMenuItemByCost = new MenuItem("Сортировка по цене");
        MenuItem fRead = new MenuItem("Ввести с файла");
        MenuItem addShoe = new MenuItem("Добавить элемент");
        MenuItem changeEl = new MenuItem("Изменить элемент");
        MenuItem showStore = new MenuItem("Отобразить товары");
        MenuItem fWrite = new MenuItem("Записать в файл");
        MenuItem binSearch = new MenuItem("Бинарный поиск по имени");
        MenuItem filterByYear = new MenuItem("Фильтр по году");

        menu1.getItems().add(sortMenuItemByName);
        menu1.getItems().add(sortMenuItemByCost);

        menu2.getItems().add(fRead);
        menu2.getItems().add(addShoe);
        menu2.getItems().add(changeEl);
        menu2.getItems().add(showStore);
        menu2.getItems().add(fWrite);

        menu3.getItems().add(binSearch);
        menu3.getItems().add(filterByYear);

        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        menuBar.getMenus().add(menu3);

        Label label1 = new Label("Поле ввода данных:");
        TextField textField = new TextField();
        Label label2 = new Label("Поле вывода:");
        Label label3 = new Label();
        Label label4 = new Label("Таблица:");
        Label label5 = new Label();
        Label label6 = new Label();
        label1.setFont(new Font(textSize));
        label2.setFont(new Font(textSize));
        label3.setFont(new Font(textSize));
        label4.setFont(new Font(textSize));
        label5.setFont(new Font(textSize));
        label6.setFont(new Font(textSize));

        vBox.getChildren().add(menuBar);
        vBox.getChildren().add(label1);
        vBox.getChildren().add(textField);
        vBox.getChildren().add(label2);
        vBox.getChildren().add(label3);
        vBox.getChildren().add(label6);
        vBox.getChildren().add(label4);
        vBox.getChildren().add(label5);

        table.setEditable(true);

        TableColumn idCol = new TableColumn("Номер");
        idCol.setMinWidth(150);
        idCol.setCellValueFactory( new PropertyValueFactory<Shoes, String>("id"));
        idCol.setCellFactory(TextFieldTableCell.forTableColumn());
        idCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Shoes, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Shoes, String> t) {
                        ((Shoes) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setId(t.getNewValue());
                    }
                }
        );

        TableColumn nameCol = new TableColumn("Название обуви");
        nameCol.setMinWidth(150);
        nameCol.setCellValueFactory( new PropertyValueFactory<Shoes, String>("pName"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Shoes, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Shoes, String> t) {
                        ((Shoes) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPName(t.getNewValue());
                    }
                }
        );

        TableColumn firmCol = new TableColumn("Название фирмы");
        firmCol.setMinWidth(150);
        firmCol.setCellValueFactory( new PropertyValueFactory<Shoes, String>("pCompany"));
        firmCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firmCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Shoes, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Shoes, String> t) {
                        ((Shoes) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPCompany(t.getNewValue());
                    }
                }
        );

        TableColumn dateCol = new TableColumn("Дата поставки");
        dateCol.setMinWidth(150);
        dateCol.setCellValueFactory( new PropertyValueFactory<Shoes, String>("pDate"));
        dateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dateCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Shoes, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Shoes, String> t) {
                        ((Shoes) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPDate(t.getNewValue());
                    }
                }
        );


        TableColumn pairCol = new TableColumn("Количество пар");
        pairCol.setMinWidth(150);
        pairCol.setCellValueFactory( new PropertyValueFactory<Shoes, String>("pCountOfPairs"));
        pairCol.setCellFactory(TextFieldTableCell.forTableColumn());
        pairCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Shoes, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Shoes, String> t) {
                        ((Shoes) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPCountOfPairs(t.getNewValue());
                    }
                }
        );

        TableColumn priceCol = new TableColumn("Стоимость");
        priceCol.setMinWidth(150);
        priceCol.setCellValueFactory( new PropertyValueFactory<Shoes, String>("pPrice"));
        priceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        priceCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Shoes, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Shoes, String> t) {
                        ((Shoes) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPPrice(t.getNewValue());
                    }
                }
        );

        table.getColumns().addAll(idCol, nameCol, firmCol, dateCol, pairCol, priceCol);
        vBox.getChildren().add(table);

        sortMenuItemByName.setOnAction((new EventHandler<ActionEvent>() { //Сортировка по азванию
            public void handle(ActionEvent event) {
                st.SortByName();
                ObservableList<Shoes> data = st.getList();
                table.setItems(data);
            }
        }));

        sortMenuItemByCost.setOnAction((new EventHandler<ActionEvent>() { //Сортировка по цене
            public void handle(ActionEvent event) {
                st.SortByPrice();
                ObservableList<Shoes> data = st.getList();
                table.setItems(data);
            }
        }));

        fRead.setOnAction((new EventHandler<ActionEvent>() { //Ввод из файла
            public void handle(ActionEvent event) {
                try {
                    st.enteringDataFromFile("D:\\PP last projects\\LTWUI\\src\\main\\java\\com\\example\\ltwui\\in.txt");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                ObservableList<Shoes> data = st.getList();
                table.setItems(data);
            }
        }));

        addShoe.setOnAction((new EventHandler<ActionEvent>() { //Добавить элемент
            public void handle(ActionEvent event) {
                st.addEmptyPair();
                ObservableList<Shoes> data = st.getList();
                table.setItems(data);
            }
        }));

        changeEl.setOnAction((new EventHandler<ActionEvent>() { //Изменить элемент
            public void handle(ActionEvent event) {
                String str = textField.getText();
                textField.setText("");
                ArrayList<String> stringArrayList = st.getWords(str);

                int row = 0, colum = 0;
                row = Integer.parseInt(stringArrayList.get(0)) - 1;
                colum = Integer.parseInt(stringArrayList.get(1));
                String replacementStr = stringArrayList.get(2);

                switch (colum){
                    case 2:
                        st.list.get(row).setPName(replacementStr);
                        break;
                    case 3:
                        st.list.get(row).setPCompany(replacementStr);
                        break;
                    case 4:
                        st.list.get(row).setPDate(replacementStr);
                        String tempDateStr = replacementStr;
                        int pointIndex = tempDateStr.lastIndexOf(".");;
                        int month =  parseInt(tempDateStr.substring(0, pointIndex));
                        int year =  parseInt(tempDateStr.substring(pointIndex + 1));
                        st.list.get(row).setPMonth(month);
                        st.list.get(row).setPYear(year);
                        break;
                    case 5:
                        st.list.get(row).setPCountOfPairs(replacementStr);
                        break;
                    case 6:
                        st.list.get(row).setPPrice(replacementStr);
                        break;
                }

                ObservableList<Shoes> data = st.getList();
                table.setItems(data);
            }
        }));

        showStore.setOnAction((new EventHandler<ActionEvent>() { //Отобразить товары
            public void handle(ActionEvent event) {
                label3.setText("");
                label5.setText("Обувь доступная в магазине:");
                ObservableList<Shoes> data = st.getList();
                table.setItems(data);
            }
        }));

        fWrite.setOnAction((new EventHandler<ActionEvent>() { //Ввод в файла
            public void handle(ActionEvent event) {
                try {
                    st.fOutput("D:\\PP last projects\\LTWUI\\src\\main\\java\\com\\example\\ltwui\\out.txt");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }));

        binSearch.setOnAction((new EventHandler<ActionEvent>() { //Бинарный поиск по имени
            public void handle(ActionEvent event) {
                st.SortByName();
                String name = textField.getText();
                textField.setText("");
                int index = st.binSearchByName(name);

                System.out.println("-> " + index);
                if(index < 0) label3.setText("Данного товара нет в магазине!");
                else {
                table.requestFocus();
                table.getSelectionModel().select(index);
                table.getFocusModel().focus(index);
                }
            }
        }));

        filterByYear.setOnAction((new EventHandler<ActionEvent>() { //Фильтровать по году
            public void handle(ActionEvent event) {
                String strYear = textField.getText();
                textField.setText("");
                int year = Integer.parseInt(strYear);
                ArrayList<Shoes> arrayList = st.FilterByYear(year);
                if (arrayList.size() == 0){
                    label3.setText("Товаров данного года выпуска нет в магазине!");
                }else {
                    label5.setText("Обувь " + strYear + " года поступления");
                    Shop tempShop = new Shop(FXCollections.observableArrayList(arrayList));
                    ObservableList<Shoes> tempData = tempShop.getList();
                    table.setItems(tempData);
                }
            }
        }));

        Group group = new Group();
        group.getChildren().add(vBox);
        Scene scene = new Scene(group, 900, 650);
        stage.setTitle("Обувной магазин");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    final double textSize = 16;
}