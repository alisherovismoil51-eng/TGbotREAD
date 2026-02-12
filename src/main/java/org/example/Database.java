package org.example;

import java.sql.*;

public class Database {

    String url = "jdbc:postgresql://localhost:5432/class9b23";
    String username = "postgres";
    String password = "root";

     public void create(Users users){

         try {
             Connection connection = DriverManager.getConnection(url , username , password);

             Statement statement = connection.createStatement();

             String query = "insert into users(chatid, firstname, lastname) values (" +
                     users.getChatid() + ", '" +
                     users.getFirstname() + "', '" +
                     users.getLastname() + "')";


             statement.execute(query);

             System.out.println("saqlandi");
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }


     public  String read(){
         StringBuilder result = new StringBuilder();


         try {
             Connection connection = DriverManager.getConnection(url , username , password);

             Statement statement = connection.createStatement();

             String query = "select * from users";
             ResultSet resultSet = statement.executeQuery(query);

             while (resultSet.next()){
                    Long chatid = resultSet.getLong(1);
                    String firstname = resultSet.getString(2);
                 String lastname = resultSet.getString(3);

                 result.append("chatid :").append(chatid)
                         .append("\n").append("firstname :").append(firstname)
                         .append("\n").append("lastname :").append(lastname).append("\n\n");
             }

         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
           return result.toString();
     }


     public  void  countUser(){
         StringBuilder stringBuilder = new StringBuilder();
         try {
             Connection connection  = DriverManager.getConnection(url , username , password );
             Statement statement  = connection.createStatement();

              String query="sell count(chatid) from users ";
              statement.executeQuery(query);
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }
}


