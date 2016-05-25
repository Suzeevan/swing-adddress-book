package Quiz;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Anil Lama on 6/5/2015.
 */
public class SQL {

    private Scanner input = new Scanner(System.in);
    private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String DB_URL = "jdbc:mysql://localhost/";

    private String dbName = "quiz";
    private String username = "root";
    private String password = null;

    private Statement stmt;
    private Connection conn;
    private PreparedStatement preparedStatement;

    public SQL(){
        try{
            Class.forName(JDBC_DRIVER);

//            System.out.println("Connecting to " + dbName + " database...");
            conn = DriverManager.getConnection(DB_URL+dbName,username,password);
//            System.out.println("Connected to " +dbName+" database successfully...");
        } catch (Exception e) {
            System.out.println("Problem in connecting to " + dbName + " database");
        }
    }

    public boolean loginValidate(String username, String password){
        boolean valid = false;
        String query = "select * from user where Username = ? && Password = ?";
        ResultSet result = null;

        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                if(username.equals(result.getString("Username"))){
                    if (password.equals(result.getString("Password"))){
                        valid = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return valid;
    }


    public String selectQuestion(int questionNo){
        String query = "select * from questiontable where Id = "+questionNo;
        String question = "";
        ResultSet result = null;
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
            while (result.next()) {
                question = result.getString("Question");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public String selectAnswer(int questionNo) {
        String query = "select * from answertable where Q_Id = "+questionNo;
        String answer = "";
        ResultSet result = null;
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
            while (result.next()) {
                answer = result.getString("Answer");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }


    public String[] selectOption(int questionNo){
        String query = "select * from optiontable where Q_Id = "+questionNo;
        String[] option =  new  String[4];
        ResultSet result = null;
        int counter = 0;

        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
            while (result.next()) {
                option[counter] = result.getString("Option");
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return option;
    }



}
