package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
    public static Connection conn;
    public static ResultSet resultSet;
    public static ResultSetMetaData rsMetaData;

    public static Connection getConnection() {

        try {
            conn = DriverManager.getConnection(ConfigReader.getPropertyValue("dbUrl"), ConfigReader.getPropertyValue("dbUsername"), ConfigReader.getPropertyValue("dbPassword"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static ResultSet getResultSet(String sqlQuery) {
        try {
            resultSet = getConnection().createStatement().executeQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static List<Map<String, String>> listOfMapsfromDB(String sqlQuery) {

        List<Map<String, String>> listOfRowMaps = new ArrayList<>();
        Map<String, String> rowMap;

        try {
            resultSet = getResultSet(sqlQuery);
            rsMetaData = resultSet.getMetaData();

            while(resultSet.next()) {
                rowMap = new LinkedHashMap<>();

                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    rowMap.put(rsMetaData.getColumnName(i), resultSet.getString(i));
                }
                listOfRowMaps.add(rowMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfRowMaps;
    }

    public static Map<String, String> mapFromDataBase(String sqlQuery) {

        Map<String, String> rowMap = new LinkedHashMap<>();

        try {
            resultSet = getResultSet(sqlQuery);
            ResultSetMetaData rsMetaData = resultSet.getMetaData();
            resultSet.next();

            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                rowMap.put(rsMetaData.getColumnName(i), resultSet.getString(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowMap;
    }

}