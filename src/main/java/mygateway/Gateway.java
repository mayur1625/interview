package mygateway;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Gateway
{

  static String csvPath = "C:\\Users\\maypatil\\Documents\\Projects\\Akela\\Akela08\\nds_compiler\\basicnav\\etc\\config\\gateway_replacements.csv";
  static Connection con;
  static Map<Integer, List<RangeIntersectionIds>> mapOfRII = new HashMap<>();
  static List<GatewayIds> gatewayIdsList = new ArrayList<>();

  public static void main(String[] args) throws IOException
  {
    Map mappedGateway = mappedGateway();
    Gateway app = new Gateway();
    connect();
    app.selectAll();

    Map<Integer, Map<Integer, String>> map = readCSV("C:\\Users\\maypatil\\Documents\\SPRINT\\Gateway\\Gateway_Replacement_CSV.csv");
    Iterator<Map.Entry<Integer, Map<Integer, String>>> iter = map.entrySet().iterator();
    //int count = 0;
    //int sum = 0;
    while (iter.hasNext())
    {
      Map.Entry<Integer, Map<Integer, String>> entry = iter.next();
      //System.out.println(++count + ": k=>" + entry.getKey());
      Iterator<Map.Entry<Integer, String>> iter2 = entry.getValue().entrySet().iterator();
      //sum += entry.getValue().size();
      while (iter2.hasNext())
      {
        Map.Entry<Integer, String> entry2 = iter2.next();

        if (mapOfRII.containsKey(entry2.getKey()))
        {
          List<RangeIntersectionIds> llist = mapOfRII.get(entry2.getKey());
          Iterator<RangeIntersectionIds> iiter = llist.iterator();
          boolean yes = false;
          while (iiter.hasNext())
          {
            String isUsed = iiter.next().isUsed;
            if (isUsed != null && isUsed.equals("Y"))
            {
              //System.out.println(isUsed);
              yes = true;
            }
          }
//          if (yes)
//            System.out.print("Y");
//          else
//            System.out.print("N");
        }

        //System.out.println("v1=>" + entry2.getKey() + ", v2=>" + entry2.getValue());
      }
    }
    //System.out.println("Total loaded map: " + sum);
  }

  private static void connect()
  {
    // SQLite connection string
    String url = "jdbc:sqlite:C:\\Users\\maypatil\\Documents\\SPRINT\\Q2\\M6\\NDSTECH-22235\\ASIA\\PREV_IDS.NDS";
    try
    {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection(url);
    }
    catch (SQLException | ClassNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public void selectAll()
  {
    String sql = "SELECT PACKED_TILE_ID, TPID, PVID, IS_USED, LAT ,LON FROM RANGE_INTERSECTION_IDS WHERE "
        + "PACKED_TILE_ID not LIKE ('20%') AND "
        + "PACKED_TILE_ID not LIKE ('84%') AND "
        + "PACKED_TILE_ID not LIKE ('33%') AND "
        + "PACKED_TILE_ID not LIKE ('13%')";

    try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql))
    {
      // loop through the result set
      int count = 0;
      while (rs.next())
      {
        count++;
        RangeIntersectionIds rii = new RangeIntersectionIds(
            rs.getInt("PACKED_TILE_ID"),
            rs.getInt("TPID"),
            rs.getInt("PVID"),
            rs.getInt("LAT"),
            rs.getInt("LON"),
            rs.getString("IS_USED"));
        List<RangeIntersectionIds> list = null;
        if (mapOfRII.containsKey(rs.getInt("PVID")))
        {
          list = mapOfRII.get(rs.getInt("PVID"));
          if (!list.contains(rii))
            list.add(rii);
        }
        else
        {
          list = new ArrayList<>();
          list.add(rii);
          mapOfRII.put(rs.getInt("PVID"), list);
        }
      }
      System.out.println("Total " + count + " range intersaction loaded..");
    }
    catch (SQLException e)
    {
      System.out.println(e.getMessage());
    }
    sql = "SELECT * FROM GATEWAY_IDS";

    try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql))
    {
      // loop through the result set
      int cnt = 0;
      while (rs.next())
      {
        cnt++;
        GatewayIds gi = new GatewayIds(
            rs.getInt("PACKED_TILE_ID"),
            rs.getInt("TPID"),
            rs.getInt("GATEWAY_ID"),
            rs.getString("IS_USED"),
            rs.getInt("VERSION_ID")
        );
        gatewayIdsList.add(gi);
      }
      System.out.println("Total " + cnt + " gateways loaded..");
    }
    catch (SQLException e)
    {
      System.out.println(e.getMessage());
    }
    //System.out.println(gatewayIdsList.size());
  }

  public static Map<Integer, Integer> mappedGateway()
  {
    Map<Integer, Integer> map = new HashMap<>();
    try (Scanner sc = new Scanner(new File(csvPath)))
    {
      //sc.useDelimiter(",");   //sets the delimiter pattern

      while (sc.hasNext())
      {
        String[] gateways = sc.next().split(",");
        if (gateways[0].startsWith("#"))
          continue;
        map.put(Integer.parseInt(gateways[0]), Integer.parseInt(gateways[1]));
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return map;
  }

  public static Map<Integer, Map<Integer, String>> readCSV(String csv)
  {
    Map<Integer, Map<Integer, String>> map = new LinkedHashMap<>();
    try (Scanner sc = new Scanner(new File(csv)))
    {
      //sc.useDelimiter(",");   //sets the delimiter pattern
      sc.next(); // Skip header
      int cnt = 0;
      while (sc.hasNext())
      {
        cnt++;
        String str[] = sc.next().split(",");
        //System.out.println(Arrays.toString(str));
        Map<Integer, String> key = null;
        if (map.containsKey(Integer.parseInt(str[1])))
        {
          key = map.get(Integer.parseInt(str[1]));
          key.put(Integer.parseInt(str[0]), str[2]);
        }
        else
        {
          key = new LinkedHashMap<>();
          key.put(Integer.parseInt(str[0]), str[2]);
          map.put(Integer.parseInt(str[1]), key);
        }


        //Map<Integer, String> key = map.containsKey(str[1]) ? map.get(str[1]) : new LinkedHashMap<>();
//        key.put(Integer.parseInt(str[0]), str[2]);
//        map.put(Integer.parseInt(str[1]), key);
      }
      //System.out.println(map.get(847364469));
      System.out.println("Total " + cnt + " read from xlsx, keys: " + map.size());
      //map.entrySet().stream().forEach(a -> System.out.print(a.getValue().size()));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return map;
  }

  public static void readExcel() throws IOException
  {

    try
    {
      File file = new File("C:\\Users\\maypatil\\Documents\\SPRINT\\Gateway\\Gateway_Replacement.xlsx");   //creating a new file instance
      FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file
      XSSFWorkbook wb = new XSSFWorkbook(fis);
      XSSFSheet sheet = wb.getSheetAt(3);     //creating a Sheet object to retrieve object
      Iterator<Row> itr = sheet.iterator();    //iterating over excel file
      while (itr.hasNext())
      {
        Row row = itr.next();
        Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
        while (cellIterator.hasNext())
        {
          Cell cell = cellIterator.next();
          switch (cell.getCellType())
          {
            case Cell.CELL_TYPE_STRING:    //field that represents string cell type
              System.out.print("=>" + cell.getStringCellValue() + "\t\t\t");
              break;
            case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
              System.out.printf("" + cell.getNumericCellValue() + "\t\t\t");
              System.out.printf("%.5f\t\t\t", cell.getNumericCellValue());
              break;
            default:
          }
        }
        System.out.println("");
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}

class RangeIntersectionIds
{
  int packedTileId;
  int tpid;
  int pvid;
  int lat;
  int lon;
  String isUsed;

  public RangeIntersectionIds(int packedTileId, int tpid, int pvid, int lat, int lon, String isUsed)
  {
    this.packedTileId = packedTileId;
    this.tpid = tpid;
    this.pvid = pvid;
    this.lat = lat;
    this.lon = lon;
    this.isUsed = isUsed;
  }

  public int getPackedTileId()
  {
    return packedTileId;
  }

  public void setPackedTileId(int packedTileId)
  {
    this.packedTileId = packedTileId;
  }

  public int getTpid()
  {
    return tpid;
  }

  public void setTpid(int tpid)
  {
    this.tpid = tpid;
  }

  public int getPvid()
  {
    return pvid;
  }

  public void setPvid(int pvid)
  {
    this.pvid = pvid;
  }

  public int getLat()
  {
    return lat;
  }

  public void setLat(int lat)
  {
    this.lat = lat;
  }

  public int getLon()
  {
    return lon;
  }

  public void setLon(int lon)
  {
    this.lon = lon;
  }

  public String getIsUsed()
  {
    return isUsed;
  }

  public void setIsUsed(String isUsed)
  {
    this.isUsed = isUsed;
  }

  @Override public String toString()
  {
    return "RangeIntersectionIds{" +
        "packedTileId=" + packedTileId +
        ", tpid=" + tpid +
        ", pvid=" + pvid +
        ", lat=" + lat +
        ", lon=" + lon +
        ", isUsed='" + isUsed + '\'' +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    RangeIntersectionIds that = (RangeIntersectionIds) o;
    return packedTileId == that.packedTileId && tpid == that.tpid && pvid == that.pvid && lat == that.lat && lon == that.lon && Objects
        .equals(isUsed, that.isUsed);
  }

  @Override public int hashCode()
  {
    return Objects.hash(packedTileId, tpid, pvid, lat, lon, isUsed);
  }
}

class GatewayIds
{
  int packedTileId;
  int tpid;
  int gatewayId;
  String isUsed;
  int version;

  public GatewayIds(int packedTileId, int tpid, int gatewayId, String isUsed, int version)
  {
    this.packedTileId = packedTileId;
    this.tpid = tpid;
    this.gatewayId = gatewayId;
    this.isUsed = isUsed;
    this.version = version;
  }

  @Override public String toString()
  {
    return "GatewayIds{" +
        "packedTileId=" + packedTileId +
        ", tpid=" + tpid +
        ", gatewayId=" + gatewayId +
        ", isUsed='" + isUsed + '\'' +
        ", version=" + version +
        '}';
  }

  public int getPackedTileId()
  {
    return packedTileId;
  }

  public void setPackedTileId(int packedTileId)
  {
    this.packedTileId = packedTileId;
  }

  public int getTpid()
  {
    return tpid;
  }

  public void setTpid(int tpid)
  {
    this.tpid = tpid;
  }

  public int getGatewayId()
  {
    return gatewayId;
  }

  public void setGatewayId(int gatewayId)
  {
    this.gatewayId = gatewayId;
  }

  public String getIsUsed()
  {
    return isUsed;
  }

  public void setIsUsed(String isUsed)
  {
    this.isUsed = isUsed;
  }

  public int getVersion()
  {
    return version;
  }

  public void setVersion(int version)
  {
    this.version = version;
  }
}
