package com.softserve.edu.registrator.data.external;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.registrator.tools.exception.GeneralCustomException;

public class DBUtils implements IExternalData {
    private final String SQL_EXCEPTION_FOUND = "SQL Exception found";
    //
    private String url;
    private String login;
    private String password;
    private String query;

    public DBUtils(String url, String login, String password, String query) {
        this.url = url;
        this.login = login;
        this.password = password;
        this.query = query;
    }

    public String getUrl() {
        return this.url;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPath() {
        return this.query;
    }
    
    public List<List<String>> getAllCells() {
        return getAllCells(query);
    }

    public List<List<String>> getAllCells(String query) {
        List<List<String>> allCells = new ArrayList<List<String>>();
        List<String> allRowCells = null;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        int columnCount = 0;
        //
        try {
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            // DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
            DriverManager.registerDriver(new org.postgresql.Driver());
            con = DriverManager.getConnection(getUrl(), getLogin(), getPassword());
        } catch (Exception e) {
            //throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
            throw new GeneralCustomException(SQL_EXCEPTION_FOUND, e);
        }
        // TODO Delete messages
        if (con != null) {
            System.out.println("+++Connection Successful! \n");
        } else {
            System.out.println("+++Connection fail \n");
            System.exit(0);
        }
        //
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            columnCount = rs.getMetaData().getColumnCount();
            //
            while (rs.next()) {
                allRowCells = new ArrayList<String>();
                for (int i = 1; i <= columnCount; i++) {
                    allRowCells.add(rs.getString(i));
                    // TODO Delete messages
                    System.out.print("+++\t" + rs.getString(i) + "\t");
                }
                allCells.add(allRowCells);
                // TODO Delete messages
                System.out.println();
            }
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            //throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
            throw new GeneralCustomException(SQL_EXCEPTION_FOUND, e);
        }
        return allCells;
    }

}
