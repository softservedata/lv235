package com.softserve.edu.registrator.data.external;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.registrator.data.users.UserUtils;
import com.softserve.edu.registrator.data.users.UserUtils.UserUtilsFields;
import com.softserve.edu.registrator.tools.exception.GeneralCustomException;

public class DBUtils implements IExternalData {

    private static class SelectUsersFactory implements IRowFactory {
        public List<String> updateRow(List<String> row) {
            List<List<String>> roles= new DBUtils("jdbc:postgresql://192.168.195.250:5432/registrator_db",
                    "postgres", "postgres", DBUtils.DBUtilsQueries.SELECT_ROLES).getAllCells();
            List<String> resultRow = new ArrayList<>();
            String cell;
            for (int i = 0; i < UserUtils.UserUtilsFields.values().length; i++) {
                resultRow.add(new String());
            }
            for (int i = 0; i < row.size(); i++) {
                //DBUtils.this.query;
                if (DBUtilsQueries.SELECT_USERS.getFields()[i].getnumber() > 0) {
                    cell = row.get(i); 
                    if (DBUtilsQueries.SELECT_USERS.getFields()[i] == UserUtilsFields.ROLE) {
                        for (List<String> role : roles) {
                            if (role.get(0).equals(cell)) {
                                cell = role.get(1);
                                break;
                            }
                        }
                    }
                    if (DBUtilsQueries.SELECT_USERS.getFields()[i] == UserUtilsFields.PASSWORD) {
                        cell = "admin";
                    }
                    resultRow.add(DBUtilsQueries.SELECT_USERS.getFields()[i].getnumber(), cell);
                }
            }
            return resultRow;
        }
    }

    private static class SelectRolesFactory implements IRowFactory {
        public List<String> updateRow(List<String> row) {
            return row;
        }
    }

    public static enum DBUtilsQueries {
        SELECT_USERS("select user_id, first_name, last_name, email, login, password, status, role_id, territorialcommunity_id from users;",
                new SelectUsersFactory(),
                UserUtilsFields.UNNECESSARY, UserUtilsFields.FIRSTNAME, UserUtilsFields.LASTNAME,
                UserUtilsFields.EMAIL, UserUtilsFields.LOGIN, UserUtilsFields.PASSWORD,
                UserUtilsFields.STATUS, UserUtilsFields.ROLE, UserUtilsFields.COMMUNITY),
        SELECT_ROLES("select role_id, type from roles;",
                new SelectRolesFactory(),
                UserUtilsFields.UNNECESSARY, UserUtilsFields.UNNECESSARY);
        //
        private String query;
        private IRowFactory rowFactory;
        private UserUtilsFields[] fields; 

        private DBUtilsQueries(String query, IRowFactory rowFactory, UserUtilsFields... fields) {
            this.query = query;
            this.rowFactory = rowFactory;
            this.fields = fields; 
        }

        public IRowFactory getRowFactory() {
            return rowFactory;
        }

        public UserUtilsFields[] getFields() {
            return fields;
        }
        
        @Override
        public String toString() {
            return query;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private final String SQL_EXCEPTION_FOUND = "SQL Exception found";
    //
    private String url;
    private String login;
    private String password;
    private DBUtilsQueries query;

    public DBUtils(String url, String login, String password, DBUtilsQueries query) {
        this.url = url;
        this.login = login;
        this.password = password;
        this.query = query;
    }

    public IRowFactory getRowFactory() {
        return this.query.getRowFactory();
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
        return this.query.toString();
    }
    
    public List<List<String>> getAllCells() {
        return getAllCells(query.toString());
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
