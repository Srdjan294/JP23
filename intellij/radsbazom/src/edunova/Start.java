package edunova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Start {

    public Start(){

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection veza = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1/edunovapp21",
                    "edunova",
                    "edunova");

            Statement izraz = veza.createStatement();

            ResultSet rs = izraz.executeQuery("select * from smjer");
            while(rs.next()){
                System.out.println(rs.getString("naziv"));
            }
            rs.close();
            veza.close();

            System.out.println(veza.getMetaData().getDatabaseProductVersion());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Start();
    }
}
