package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.DB_Utils;
import utilities.JDBCReusableMethods;
import utilities.QueryManage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class DBstepDefinition {

    QueryManage querymanage = new QueryManage();

    static Statement statement;
    static ResultSet resultSet;
    static ResultSet resultSet1;

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {

        JDBCReusableMethods.getConnection();

        statement = JDBCReusableMethods.getStatement();

    }

    @Given("Query hazirlanir ve calistirilir.")
    public void query_hazirlanir_ve_calistirilir() throws SQLException {

        String query = "SELECT COUNT(*) FROM wonderworld_qa2.chat_users WHERE create_staff_id = 1";

        resultSet = statement.executeQuery(query);
    }

    @Given("Query sonuclari dogrulanir.")
    public void query_sonuclari_dogrulanir() throws SQLException {

        resultSet.next();
        int expectedData = 11;
        int actualData = resultSet.getInt(1);

        assertEquals(expectedData, actualData);

    }

    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        JDBCReusableMethods.closeConnection();

    }

    //---------------------------Query02-----------------------

    @Given("class_sections tablosu testi icin query hazirlanir.")
    public void class_sections_tablosu_testi_icin_query_hazirlanir() throws SQLException {

        resultSet = statement.executeQuery(ConfigReader.getProperty("query02"));

    }

    @Given("class_sections tablosu testi sonuclari dogrulanir.")
    public void class_sections_tablosu_testi_sonuclari_dogrulanir() throws SQLException {

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));

        }

    }

    @Given("students tablosu icin query hazirlanir.")
    public void students_tablosu_icin_query_hazirlanir() throws SQLException {

        String sql = querymanage.getQuery03();

        resultSet = statement.executeQuery(sql);


    }

    @Given("Students tablosundan donen sonuclari listeleyiniz")
    public void students_tablosundan_donen_sonuclari_listeleyiniz() throws SQLException {

       while(resultSet.next()){

           System.out.println("mother_name:  "+resultSet.getString(1)+ "     "+
                              "mother_occopation:   "+ resultSet.getString(2) );

       }

    }
}
