//package jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
////import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class JdbcMain {
//
//    public static void main(String[] args) {
//
//        try {
//            System.out.println("Hello");
//            String url = "jdbc:mysql://localhost:3306/jdbc1";
//            String un = "root";
//            String pwd = "rushitemgire";
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver Loaded");
//
//            Connection con = DriverManager.getConnection(url, un, pwd);
//            System.out.println("Connection established");
//            System.out.println(con);
//            
//            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,0);
//
//            String query = "select * from student";
//            
////          PreparedStatement ps = con.prepareStatement(query);
//            
//            ResultSet res = stmt.executeQuery(query);	
//            System.out.println("Query executed successfully");
//            
//            ResultSetMetaData metadata = res.getMetaData();
//            
//            System.out.println();
//            for(int i=1;i<=metadata.getColumnCount();i++)
//            {
//            	System.out.print(res.getMetaData().getColumnName(i)+"\t");
//            }
//            System.out.println();
//            
//
//            while (res.next()) {
//                System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getLong(4));
//            }
//            
//            res.first();
//            System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getLong(4));
//            
//            res.absolute(2);
//            System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getLong(4));
//            
//            res.close();
//            stmt.close();
//            con.close();
//
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver is not loaded");
//        } catch (SQLException e) {
//            System.out.println("Connection not established");
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.out.println("Another issue");
//            e.printStackTrace();
//        }
//    }
//}
