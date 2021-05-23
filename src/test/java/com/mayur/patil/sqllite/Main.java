package com.mayur.patil.sqllite;

import java.sql.*;

public class Main
{
  static {
    try
    {
      Class.forName("org.sqlite.JDBC");
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
  private Connection connect() {
    // SQLite connection string

    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }
  /**
   * Create a new table in the test database
   *
   */
  public void createNewTable() {
    // SQL statement for creating a new table
    String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
        + "	id integer PRIMARY KEY,\n"
        + "	name text NOT NULL,\n"
        + "	capacity real\n"
        + ");";


    try (Connection conn = this.connect();
        Statement stmt = conn.createStatement()) {
      // create a new table
      stmt.execute(sql);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
  public void insert(String name, double capacity) {
    String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";

    try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, name);
      pstmt.setDouble(2, capacity);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
  public void selectAll(){
    String sql = "SELECT id, name, capacity FROM warehouses";

    try (Connection conn = this.connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){

      // loop through the result set
      while (rs.next()) {
        System.out.println(rs.getInt("id") +  "\t" +
            rs.getString("name") + "\t" +
            rs.getDouble("capacity"));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }


  /**
   * @param args the command line arguments
   */
  String url = "jdbc:sqlite:C://sqlite/test1.db";
  public static void main(String[] args) {

    Main main = new Main();
//    main.createNewTable();
//    main.insert("Mayur",1500);
//    main.insert("Ashish",2000);
    main.selectAll();
  }
}
