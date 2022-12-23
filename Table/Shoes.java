package com.example.ltwui;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import static java.lang.Integer.parseInt;

public class Shoes  {
    private static int IND = 0;
    private SimpleStringProperty pName; // Имя обуви
    private SimpleStringProperty pCompany; // Название компании
    private SimpleStringProperty pDate; // Дата поставки
    private SimpleIntegerProperty pMonth; // Месяц поставки
    private SimpleIntegerProperty pYear; // Год поставки
    private SimpleStringProperty pCountOfPairs; // Количество пар
    private SimpleStringProperty pPrice; // Стоимость
    private SimpleStringProperty id; // Стоимость

    public String getPName() {
        return pName.get();
    }

    public SimpleStringProperty pNameProperty() {
        return pName;
    }

    public static int getIND() {
        return IND;
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public static void setIND(int IND) {
        Shoes.IND = IND;
    }

    public void setPName(String pName) {
        this.pName.set(pName);
    }

    public String getPCompany() {
        return pCompany.get();
    }

    public SimpleStringProperty pCompanyProperty() {
        return pCompany;
    }

    public void setPCompany(String pCompany) {
        this.pCompany.set(pCompany);
    }

    public String getPDate() {
        return pDate.get();
    }

    public SimpleStringProperty pDateProperty() {
        return pDate;
    }

    public void setPDate(String pDate) {
        this.pDate.set(pDate);
    }

    public int getPMonth() {
        return pMonth.get();
    }

    public SimpleIntegerProperty pMonthProperty() {
        return pMonth;
    }

    public void setPMonth(int pMonth) {
        this.pMonth.set(pMonth);
    }

    public int getPYear() {
        return pYear.get();
    }

    public SimpleIntegerProperty pYearProperty() {
        return pYear;
    }

    public void setPYear(int pYear) {
        this.pYear.set(pYear);
    }

    public String getPCountOfPairs() {
        return pCountOfPairs.get();
    }

    public SimpleStringProperty pCountOfPairsProperty() {
        return pCountOfPairs;
    }

    public void setPCountOfPairs(String pCountOfPairs) {
        this.pCountOfPairs.set(pCountOfPairs);
    }

    public String getPPrice() {
        return pPrice.get();
    }

    public SimpleStringProperty pPriceProperty() {
        return pPrice;
    }

    public void setPPrice(String pPrice) {
        this.pPrice.set(pPrice);
    }

    public Shoes() {
        this.pName = new SimpleStringProperty("Нет");
        this.pCompany = new SimpleStringProperty("Нет");
        this.pDate = new SimpleStringProperty("Нет");
        this.pMonth = new SimpleIntegerProperty(0);
        this.pYear = new SimpleIntegerProperty(0);
        this.pCountOfPairs = new SimpleStringProperty("0");
        this.pPrice = new SimpleStringProperty("0");;
        this.id = new SimpleStringProperty(Integer.toString(IND));
        IND += 1;
    }

    public Shoes(SimpleStringProperty pName, SimpleStringProperty pCompany, SimpleStringProperty pDate, SimpleStringProperty pCountOfPairs, SimpleStringProperty pPrice) {
        String str = pDate.get();
        int pointIndex = str.lastIndexOf(".");;
        int month =  parseInt(str.substring(0, pointIndex));
        int year =  parseInt(str.substring(pointIndex + 1));

        this.pName = pName;
        this.pCompany = pCompany;
        this.pDate = pDate;
        this.pMonth = new SimpleIntegerProperty(month);
        this.pYear = new SimpleIntegerProperty(year);
        this.pCountOfPairs = pCountOfPairs;
        this.pPrice = pPrice;
        this.id = new SimpleStringProperty(Integer.toString(IND));
        IND += 1;
    }

    @Override
    public String toString() {
        return "Shoes{" + pName +
                ", " + pCompany +
                ", " + pDate +
                ", " + pCountOfPairs +
                ", " + pPrice + '}';
    }
}
