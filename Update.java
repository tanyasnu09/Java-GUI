import java.sql.*;

public class Update {
    void my_db_update(String studentid, String firstName, String surname, String gender,  String address) {
        try {
            int studentId = Integer.parseInt(studentid);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/swing_demo", "root", "goodiesruby@123");
            Statement st = con.createStatement();

            String query1 = "INSERT INTO `swing_demo`.`login` (`studentid`, `firstname`, `surname`, `gender`, `address`)"
                    + "VALUES ('" + studentid + "','" + firstName + "', '" + surname + "', '" + gender + "',  '" + address + "')";

            st.executeUpdate(query1); // record added.

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ... Your existing code for fetchRecords ...


    // ... Your existing code for my_db_update ...

    // Method to fetch records from the database
    public void fetchRecords() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/swing_demo";
            String username = "root";
            String password = "goodiesruby@123";

            try (Connection con = DriverManager.getConnection(dbUrl, username, password);
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM `login`")) {

                while (rs.next()) {
                    int sno = rs.getInt("sno");
                    System.out.println("Sno: " + sno);
                }
            } catch (SQLException ex) {
                System.out.println("Error fetching data: " + ex.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e.getMessage());
        }
    }
}

