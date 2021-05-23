package com.mayur.patil.sqllite;

import java.sql.*;

public class Connect
{
  private static String url = "jdbc:sqlite:C:\\Users\\maypatil\\Documents\\SPRINT\\Q2\\M5\\NDSTECH-25382\\MAP1\\UR10907\\ROOT.NDS";
  private static String bmdFilePath = "C:\\Users\\maypatil\\Documents\\SPRINT\\Q2\\M5\\NDSTECH-25382\\MAP1\\UR10907\\BMD.NDS";

  private Connection connect()
  {
    // SQLite connection string
    Connection conn = null;
    try
    {
      conn = DriverManager.getConnection(url);
    }
    catch (SQLException e)
    {
      System.out.println("=> " + e.getMessage());
    }
    return conn;
  }

  public void selectAll()
  {
    String sql = "SELECT * FROM bmdTileTable";

//    try
//    {
//      Connection conn = this.connect();
//      Statement stmt = conn.createStatement();
//      ResultSet rs = stmt.executeQuery(sql);
//
//      // loop through the result set
//      while (rs.next())
//      {
//        System.out.println(rs.getInt("productId") + "\t" +
//            rs.getString("internalName") + "\t" +
//            rs.getInt("productTypeMask"));
//      }
//    }
//    catch (SQLException e)
//    {
//      e.printStackTrace();
//      System.out.println("<== " + e.getMessage());
//    }
    try
    {
      Class.forName("org.sqlite.JDBC");
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    try (Connection bmdConnection = DriverManager.getConnection("jdbc:sqlite:" + bmdFilePath);
        Statement statement = bmdConnection.createStatement();)
    {

      ResultSet set = statement.executeQuery(sql);
      while (set.next())
      {
        System.out.println(set.getInt(1));
      }

    }
    catch (SQLException e)
    {

      e.printStackTrace();
    }
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args)
  {
    new Connect().selectAll();
  }
}
