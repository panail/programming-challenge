package de.exxcellent.challenge.data;

import java.util.List;

public class ParsedData {
    public ParsedData(List<String> columnNames, List<List<String>> data) {
        this.columnNames = columnNames;
        this.data = data;
    }

    private final List<String> columnNames;

    private final List<List<String>> data;

    public List<String> getColumnNames() {
        return columnNames;
    }

    public List<List<String>> getData() {
        return data;
    }

    /**
     * finds the entry, where the difference between column1 and column2 is minimal and return a specified value
     *
     * @param column1      the first column to compare
     * @param column2      the second column to compare
     * @param returnColumn the column the returnvalue is taken from
     * @return The value in returnColumn from the entry where column2 - column1 is minimal
     */
    public String getEntryWithMinimalDifference(String column1, String column2, String returnColumn) {
        int minIndex = getIndexWithMinimalDifference(column1, column2);
        return getDataByColumnName(minIndex, returnColumn);
    }

    /**
     * finds the entry, where the difference between column1 and column2 is minimal
     *
     * @param column1 the first column to compare
     * @param column2 the second column to compare
     * @return the index of the entry where column2 - column1 is minimal
     */
    public int getIndexWithMinimalDifference(String column1, String column2) {
        int column1Index = columnNames.indexOf(column1);
        int column2Index = columnNames.indexOf(column2);
        int minIndex = 0;
        int minDifference = Math.abs(getDataInt(0, column1Index) - getDataInt(0, column2Index));
        for (int i = 0; i < data.size(); i++) {
            int difference = Math.abs(getDataInt(i, column1Index) - getDataInt(i, column2Index));
            if (difference < minDifference) {
                minIndex = i;
                minDifference = difference;
            }
        }
        return minIndex;
    }

    /**
     * returns data specified by index and column name
     *
     * @param row    index of the requested entry
     * @param column Name of the Column of the requested entry
     * @return specified data as String
     */
    public String getDataByColumnName(int row, String column) {
        int columnIndex = columnNames.indexOf(column);
        return data.get(row).get(columnIndex);
    }

    /**
     * returns numerical value specified by row and column index
     *
     * @param row    index of the requested entry
     * @param column Number of the Column of the requested entry
     * @return specified data as integer
     */
    public int getDataInt(int row, int column) {
        return Integer.parseInt(data.get(row).get(column));
    }

}
