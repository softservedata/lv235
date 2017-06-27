package com.softserve.edu.registrator.controls;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface ITable {

    int getRowCount();

    int getColumnCount();
    
    WebElement getTableWebElement();
    
    List<WebElement> getHeader();
    
    List<List<WebElement>> getTableBody();

    List<WebElement> getRowByIndex(int rowIndex);

    List<WebElement> getRowByValue(String value);

    List<List<WebElement>> getRowsByValue(String value);
    
    List<WebElement> getRowByValueInColumn(String value, int columnIndex);

    int getRowIndexByValueInColumn(String value, int columnIndex);

    List<WebElement> getColumnByIndex(int columnIndex);

    List<WebElement> getColumnByValue(String value);
    
    List<List<WebElement>> getColumnsByValue(String value);
    
    List<WebElement> getColumnByValueInRow(String value, int rowIndex);

    int getColumnIndexByValueInRow(String value, int rowIndex);

    List<WebElement> getColumnByValueOfHeader(String value);

    int getColumnIndexByValueOfHeader(String value);

    WebElement getCell(int rowIndex, int columnIndex);

}
