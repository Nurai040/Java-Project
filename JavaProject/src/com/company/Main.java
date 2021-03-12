package com.company;

//importing libraries
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //creating connection
        Connection c = null;
        Statement stmt = null;
        try {
            //load driver's class file into memory at the runtime
            Class.forName("org.postgresql.Driver");
            //establish the connection
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5434/hospital", "postgres", "123");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Database opened successfully ");
            //execute queries with the database using object of statement
            stmt = c.createStatement();
            //dropping schema and creating schema
            String sql = "Drop schema public cascade;" +
                    "CREATE SCHEMA public";
            //inputting text into postgreSQL
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE Hospital " +
                    "(idHospital decimal primary key, " +
                    "name char(32), " +
                    "city char(24))";
            //inputting text into postgreSQL
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE Doctor " +
                    "(idDoctor decimal primary key, " +
                    "firstNameDoctor char(14), " +
                    "lastNameDoctor char(14), " +
                    "costPerVisit integer, " +
                    "idHospital decimal references Hospital(idHospital))";
            //inputting text into postgreSQL
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE Patient " +
                    "(idPatient decimal primary key, " +
                    "firstNamePatient char(14), " +
                    "lastNamePatient char(14), " +
                    "diagnosis char(24), " +
                    "visits integer, " +
                    "idDoctor decimal references Doctor(idDoctor))";
            //inputting text into postgreSQL
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Hospital(idHospital, name, city) " +
                    "VALUES (1, '1st named after Dr. White', 'Chicago')," +
                    "(2, '5th named after Plutonus', 'Atlanta'), " +
                    "(3, '4th named after Mr. Nobody', 'Texas')";
            //inputting text into postgreSQL
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Doctor(idDoctor, firstNameDoctor, lastNameDoctor, costPerVisit, idHospital) " +
                    "VALUES (1, 'Harry', 'Potter', 2000, 1), " +
                    "(2, 'Adam', 'Sandler', 5000, 1), " +
                    "(3, 'George', 'Hype', 8000, 2), " +
                    "(4, 'Papa', 'Timmie', 40000, 2), " +
                    "(5, 'Mama', 'Black', 5000, 3), " +
                    "(6, 'Nick', 'Brown', 8888, 3)";
            //inputting text into postgreSQL
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Patient(idPatient, firstNamePatient, lastNamePatient, diagnosis, visits, idDoctor) " +
                    "VALUES (1, 'Jake', 'White', 'Depression', 15, 2), " +
                    "(2, 'Jasmine', 'Anistone', 'Depression', 24, 2), " +
                    "(3, 'Kyle', 'Oneal', 'Bipolar', 14, 1), " +
                    "(4, 'Adil', 'Ficus', 'Depression', 10, 3), " +
                    "(5, 'Niman', 'Red', 'Agression', 7, 4), " +
                    "(6, 'Line', 'Vertical', 'Stress', 18, 6), " +
                    "(7, 'Bill', 'Gates', 'Bipolar', 30, 5)";
            //inputting text into postgreSQL
            stmt.executeUpdate(sql);
            Statement finalStmt = stmt;
            //execute query to the database
            ResultSet resultSet = finalStmt.executeQuery(
                    "SELECT * from Hospital ");
            //processing the result
            while(resultSet.next()) {
                int idHospital = resultSet.getInt("idHospital");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");

                Hospital hospital = new Hospital(idHospital, name, city);
                System.out.println(hospital.toString());
            }
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Input id of hospital and I will show you their doctors: ");
            Scanner scanner = new Scanner(System.in);
            String idHosp = scanner.nextLine();
            //execute query to the database
            resultSet = finalStmt.executeQuery(
                    "SELECT name, Doctor.idDoctor, Doctor.firstNameDoctor, Doctor.lastNameDoctor, Doctor.costPerVisit from Hospital " +
                            "INNER JOIN Doctor ON Doctor.idHospital = Hospital.idHospital " +
                            "WHERE Doctor.idHospital = "+idHosp);
            //processing the result
            while(resultSet.next()) {
                int idDoctor = resultSet.getInt("idDoctor");
                String firstNameDoctor = resultSet.getString("firstNameDoctor");
                String lastNameDoctor = resultSet.getString("lastNameDoctor");
                int costPerVisit = resultSet.getInt("costPerVisit");

                Doctor doctor = new Doctor(idDoctor, firstNameDoctor, lastNameDoctor, costPerVisit);
                System.out.println(doctor.toString());
            }
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Input id of doctor to see patient(s): ");
            String idDoc = scanner.nextLine();

            resultSet = finalStmt.executeQuery(
                    "SELECT costPerVisit, idPatient, firstNamePatient, lastNamePatient, diagnosis, visits FROM DOCTOR " +
                            "INNER JOIN Patient ON Doctor.idDoctor = Patient.idDoctor " +
                            "WHERE Doctor.idDoctor = "+idDoc);
            while(resultSet.next()){
                int costPerVisit = resultSet.getInt("costPerVisit");
                int idPatient = resultSet.getInt("idPatient");
                String firstNamePatient = resultSet.getString("firstNamePatient");
                String lastNamePatient = resultSet.getString("lastNamePatient");
                String diagnosis = resultSet.getString("diagnosis");
                int visits = resultSet.getInt("visits");

                Patient patient = new Patient(idPatient, firstNamePatient, lastNamePatient, diagnosis, visits);
                System.out.println(patient.toString());
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("Bill at the moment: ");
                System.out.println(patient.bills(visits, costPerVisit)+" tenge");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}