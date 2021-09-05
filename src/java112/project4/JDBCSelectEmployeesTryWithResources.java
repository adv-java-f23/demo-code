package java112.project4;
  
import java.io.*;
import java.sql.*;
  
/**
 *
 *@author     Paula Waite
 *
 */
public class JDBCSelectEmployeesTryWithResources {
  
    public void runSample() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
            return;
        }


        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/student", "student", "student");
             Statement statement = connection.createStatement();
            ) {

            performQuery(statement);

            // for demonstration purposes, send the connection/statement to another method
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
    }

    private void performQuery(Statement statement) throws SQLException {
        String name = "Smith";
        String queryString = "SELECT emp_id, first_name, last_name"
                + " FROM employees " + "WHERE last_name like '"
                + name + "%'";

        System.out.println("queryString: " + queryString);
        System.out.println();
        ResultSet resultSet = statement.executeQuery(queryString);

        processResults(resultSet);
    }

    private void processResults(ResultSet resultSet) {
        while (resultSet.next()) {
            String employeeId = resultSet.getString("emp_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            System.out.println(" Row: " + employeeId + " "
                    + firstName + " " + lastName);
        }

        System.out.println();

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columns = resultSetMetaData.getColumnCount();
        String nameOne = resultSetMetaData.getColumnName(1);
        String typeOne = resultSetMetaData.getColumnTypeName(1);
        String labelOne = resultSetMetaData.getColumnLabel(1);
        System.out.println(" Column count : " + columns);
        System.out.println(" Column 1 name : " + nameOne);
        System.out.println(" Column 1 type : " + typeOne);
        System.out.println(" Column 1 label name : " + labelOne);

        System.out.println();
    }

    /**
     *  The main program for the JDBCSelectWhereExample class
     *
     *@param  args  The command line arguments
     *
     *@since
     *
     */
    public static void main(String[] args) {
  
        JDBCSelectEmployees employees = new JDBCSelectEmployees();
  
        employees.runSample();
  
    }
}
