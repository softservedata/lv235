package com.softserve.edu.registrator.controls;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * WebElement pretable = Search.xpath("");
 * ITable table = new Table(pretable);
 */
public final class Table implements ITable {
    private static final String OUT_ROWS_RANGE = "Out of rows range. Count row in table is %d, required %d";
    private static final String OUT_COLUMN_RANGE =  "Out of column range. Count column in table is %d, required %d";
    //
    private WebElement tableWebElement;
    private List<WebElement> tableHeader;
    private List<List<WebElement>> tableBody;

    public Table(WebElement tableWebElement) {
        this.tableWebElement = tableWebElement;
        initTable();
    }

    private void initTable() {
        this.tableBody = new ArrayList<List<WebElement>>();
        tableHeader = tableWebElement.findElements(By.tagName("th"));
        // TODO Remove Local Variable tBody
        WebElement tBody = tableWebElement.findElement(By.tagName("tbody"));
        for (WebElement tableRow : tBody.findElements(By.tagName("tr"))) {
            this.tableBody.add(tableRow.findElements(By.tagName("td")));
        }
    }

    private int getFirstIndex(String value, boolean isRow) {
        boolean isRun = true;
        int rowIndex = -1;
        int columnIndex = -1;
        for (int i = 0; (i < getRowCount()) && isRun; i++) {
            for (int j = 0; j < getColumnCount(); j++) {
                if (getCell(i,j).getText().trim().toLowerCase().equals(value
                        .trim().toLowerCase())) {
                    rowIndex = i;
                    columnIndex = j;
                    isRun = false;
                    break;
                }
            }
        }
        return isRow?rowIndex:columnIndex;
    }

    private List<Integer> getAllIndexes(String value, boolean isRow) {
        List<Integer> indexes = new ArrayList<>(); 
        for (int i = 0; i < getRowCount(); i++) {
            for (int j = 0; j < getColumnCount(); j++) {
                if (getCell(i,j).getText().trim().toLowerCase().equals(value
                        .trim().toLowerCase())) {
                    if (isRow) {
                        indexes.add(i);
                    } else {
                        indexes.add(j);
                    }
                }

            }
        }
        return indexes;
    }

    private boolean isRowIndexEnable(int rowIndex) {
        boolean isEnable = (0 <= rowIndex) && (rowIndex < getRowCount());
        if (!isEnable) {
            // TODO Develop Custom Exception
            throw new RuntimeException(String.format(OUT_ROWS_RANGE,
                    getRowCount(), rowIndex));
        }
        return isEnable;
    }

    private boolean isColumnIndexEnable(int columnIndex) {
        boolean isEnable = (0 <= columnIndex) && (columnIndex < getColumnCount());
        if (!isEnable) {
            // TODO Develop Custom Exception
            throw new RuntimeException(String.format(OUT_COLUMN_RANGE,
                    getColumnCount(), columnIndex));
        }
        return isEnable;
    }

    public int getRowCount() {
        return getTableBody().size();
    }

    public int getColumnCount() {
        return getHeader().size();
    }

    public WebElement getTableWebElement() {
        return tableWebElement;
    }

    public List<WebElement> getHeader() {
        return tableHeader;
    }

    public List<List<WebElement>> getTableBody() {
        return tableBody;
    }

    public List<WebElement> getRowByIndex(int rowIndex) {
        return isRowIndexEnable(rowIndex)?getTableBody().get(rowIndex):null;
    }

    public List<WebElement> getRowByValue(String value){
        return getRowByIndex(getFirstIndex(value, true));
    }
    
    public List<List<WebElement>> getRowsByValue(String value) {
        List<List<WebElement>> rows = new ArrayList<>();
        for (int rowIndex : getAllIndexes(value, true)) {
            rows.add(getRowByIndex(rowIndex));
        }
        return rows;
    }
    
    public List<WebElement> getRowByValueInColumn(String value, int columnIndex) {
        return getRowByIndex(getRowIndexByValueInColumn(value, columnIndex));
    }

    public int getRowIndexByValueInColumn(String value, int columnIndex) {
        int rowIndex = -1;
        int i = -1;
        for (List<WebElement> row : getTableBody()) {
            i++;
            if (row.get(columnIndex).getText()
                    .trim().toLowerCase().equals(value.trim().toLowerCase())) {
                rowIndex = i;
                break;
            }
        }
        return isRowIndexEnable(rowIndex)?rowIndex:-1;
    }

    public List<WebElement> getColumnByIndex(int columnIndex) {
        List<WebElement> column = new ArrayList<>();
        if (isColumnIndexEnable(columnIndex)) {
            for (List<WebElement> row : getTableBody()) {
                column.add(row.get(columnIndex));
            }
        }
        return column;
    }

    public List<WebElement> getColumnByValue(String value) {
        return getColumnByIndex(getFirstIndex(value, false));
    }
    
    public List<List<WebElement>> getColumnsByValue(String value) {
        List<List<WebElement>> columns = new ArrayList<>();
        for (int columnIndex : getAllIndexes(value, false)) {
            columns.add(getColumnByIndex(columnIndex));
        }
        return columns;
    }
    
    public List<WebElement> getColumnByValueInRow(String value, int rowIndex) {
        return getColumnByIndex(getColumnIndexByValueInRow(value, rowIndex));
    }

    public int getColumnIndexByValueInRow(String value, int rowIndex){
        int columnIndex =-1;
        int i=-1;
        for (WebElement cell : getRowByIndex(rowIndex)) {
            i++;
            if (cell.getText().trim().toLowerCase().equals(value
                    .trim().toLowerCase())) {
                columnIndex = i;
                break;
            }
        }
        return isColumnIndexEnable(columnIndex)?columnIndex:-1;
    }

    public List<WebElement> getColumnByValueOfHeader(String value) {
        return getColumnByIndex(getColumnIndexByValueOfHeader(value));
    }

    public int getColumnIndexByValueOfHeader(String value) {
        int columnIndex =-1;
        int i=-1;
        for (WebElement cell : getHeader()) {
            i++;
            if (cell.getText().trim().toLowerCase().equals(value
                    .trim().toLowerCase())) {
                columnIndex = i;
                break;
            }
        }
        return isColumnIndexEnable(columnIndex)?columnIndex:-1;
    }

    public WebElement getCell(int rowIndex, int columnIndex) {
        return getTableBody().get(rowIndex).get(columnIndex);
    }
     
}
