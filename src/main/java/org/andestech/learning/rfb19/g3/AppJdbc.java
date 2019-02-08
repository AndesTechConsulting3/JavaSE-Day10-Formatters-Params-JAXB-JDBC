package org.andestech.learning.rfb19.g3;

import java.sql.*;
import java.util.Properties;

public class AppJdbc {

    public static void main(String[] args) throws ClassNotFoundException
    {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost/RFB18";

        Properties properties = new Properties();
        properties.setProperty("user","user01");
        properties.setProperty("password","postgres");
        properties.setProperty("port", "5432");
        //....

        Connection connection = null;
        Statement statement = null;
        PreparedStatement statement1 = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, properties);
            System.out.println(connection);

            statement = connection.createStatement(
                    ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_INSENSITIVE);

            statement1 =
                    connection.prepareStatement("insert into t10(id, data) values(?,?)");

            for(int i=20; i<25; i++) {
            statement1.setInt(1, i);
            statement1.setString(2, "NEW DATA Новые Данные" + i);
            statement1.execute();

}

//            statement.execute("create table t10(id integer, data varchar(50), " +
//                    "created timestamp default now());");
            //statement.execute("drop table t10;");

//           int cols =  statement.executeUpdate("insert into t10(id, data) values(1,'TEST DATA')");
//            System.out.println(cols + " updated");
//for(int i=2; i<15; i++) {
//    statement.executeUpdate("insert into t10(id, data) values("+i+",'TEST DATA" + i +"')");
//}

          statement.executeUpdate("delete from t10 where id<5;");

          rs =   statement.executeQuery("select * from t10;");

          while (rs.next())
          {
              Date date = rs.getDate("created");
              System.out.printf("%d, %s, %s\n", rs.getInt("id"), rs.getString("data"), date.toString());

          }

          //connection.commit();


            rs.close();
            statement.close();
            statement1.close();
            connection.close();
        }
        catch (SQLException ex){ex.printStackTrace();}
        finally {
            try {
            if(rs != null)rs.close();
            if(statement != null)  statement.close();
            if(statement1 != null) statement1.close();
            if(connection != null) connection.close();}
            catch (SQLException ex){ex.printStackTrace();}
        }


    }
}
