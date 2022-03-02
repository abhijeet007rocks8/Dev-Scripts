package com.app.currencyconverter.controller;

import com.app.currencyconverter.api.CurrencyApi;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class CurrencyConvertedController {

    @FXML private ComboBox<String> comboBoxCurrency1;
    @FXML private ComboBox<String> comboBoxCurrency2;
    @FXML private TextField txtCurrency1;
    @FXML private TextField txtCurrency2;
    @FXML private Label lblCurrency1;
    @FXML private Label lblCurrency2;
    @FXML private Label lblExcCurrency1;
    @FXML private Label lblExcCurrency2;
    @FXML private Label lblExchangeAmount;
    @FXML private Label lblStaticAmount;
    @FXML private Label lblFetchingData;

    private static TreeMap<String, String> list = null;
    private static String currency1 = null;
    private static String currency2 = null;
    private static Double rate1 = null;
    private static Double rate2 = null;
    private static Double exchangeRate = null;

    private void showFetchingData(){
        lblFetchingData.setVisible(true);
    }

    private void hideFetchingData(){
        lblFetchingData.setVisible(false);
    }

    private void showExchangeCurrencyStats(){
        lblStaticAmount.setVisible(true);
        lblExcCurrency1.setVisible(true);
        lblExcCurrency2.setVisible(true);
        lblExchangeAmount.setVisible(true);
    }

    private void hideExchangeCurrencyStats(){
        lblStaticAmount.setVisible(false);
        lblExcCurrency1.setVisible(false);
        lblExcCurrency2.setVisible(false);
        lblExchangeAmount.setVisible(false);
    }

    private String getCountryCode(String selectedItem){
        return selectedItem.substring(selectedItem.indexOf("(")+1, selectedItem.length()-1);
    }

    private void onSelectedCurrencyChanged(){
        if (currency1 != null && currency2 != null){
            try {
                showFetchingData();
                exchangeRate = CurrencyApi.getExchangeData(currency1, currency2);
                lblExchangeAmount.setText(String.format("%5.2f", exchangeRate));
                showExchangeCurrencyStats();
                hideFetchingData();
            } catch (IOException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
            }
        }
    }

    private void onBaseCurrencyAmountChanged(){
        rate2 = rate1*exchangeRate;
        txtCurrency2.setText(String.format("%5.2f", rate2));
    }

    private void onDesiredCurrencyAmountChanged(){
        rate1 = rate2/exchangeRate;
        txtCurrency1.setText(String.format("%5.2f", rate1));
    }

    @FXML
    public void initialize(){
        try{
            hideExchangeCurrencyStats();
            showFetchingData();
            list = (TreeMap<String, String>) CurrencyApi.getSymbolNames();
            list.keySet().forEach(key -> {
                comboBoxCurrency1.getItems().add(String.format("%s (%s)", list.get(key), key));
                comboBoxCurrency2.getItems().add(String.format("%s (%s)", list.get(key), key));
            });
            txtCurrency1.textProperty().addListener(((observableValue, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    txtCurrency1.setText(newValue.replaceAll("[^\\d|^.]", ""));
                }
            }));
            txtCurrency2.textProperty().addListener(((observableValue, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    txtCurrency2.setText(newValue.replaceAll("[^\\d|^.]", ""));
                }
            }));
        }catch (IOException e){
            hideFetchingData();
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
    }

    @FXML
    public void onCurrency1Clicked(){
        currency1 = getCountryCode(comboBoxCurrency1.getSelectionModel().getSelectedItem());
        lblCurrency1.setText(currency1);
        lblExcCurrency1.setText(currency1);
        onSelectedCurrencyChanged();
    }

    @FXML
    public void onCurrency2Clicked(){
        currency2 = getCountryCode(comboBoxCurrency2.getSelectionModel().getSelectedItem());
        lblCurrency2.setText(currency2);
        lblExcCurrency2.setText(currency2);
        onSelectedCurrencyChanged();
    }

    @FXML
    public void onCurrency1TextChanged() {
        try{
            rate1 = Double.valueOf(txtCurrency1.getText());
            onBaseCurrencyAmountChanged();
        }catch (NullPointerException | NumberFormatException ignored){}
    }

    @FXML
    public void onCurrency2TextChanged() {
        try{
            rate2 = Double.valueOf(txtCurrency2.getText());
            onDesiredCurrencyAmountChanged();
        }catch (NullPointerException | NumberFormatException ignored){}
    }

}
