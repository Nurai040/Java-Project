package com.company;

public class Patient extends Doctor implements CostCalculator{
    //private variables
    private int idPatient;
    private String firstNamePatient;
    private String lastNamePatient;
    private String diagnosis;
    private int visits;

    //constructor
    public Patient(){}
    public Patient(int idEmployee, String firstNameDoctor, String lastNameDoctor,String qualification, int costPerVisit, int idPatient, String firstNamePatient, String lastNamePatient, String diagnosis, int visits){
        super(idEmployee, firstNameDoctor, lastNameDoctor, costPerVisit,qualification);
        this.diagnosis = diagnosis;
        this.firstNamePatient = firstNamePatient;
        this.lastNamePatient = lastNamePatient;
        this.idPatient = idPatient;
        this.visits = visits;
    }

    //creating methods for Database
    public String createTable(){
        return "CREATE TABLE Patient " +
                "(idPatient serial primary key, " +
                "firstNamePatient char(14), " +
                "lastNamePatient char(14), " +
                "diagnosis char(24), " +
                "visits integer, " +
                "idDoctor decimal references Doctor(idDoctor))";
    }
    public String addInformation(){
        return "INSERT INTO Patient( firstNamePatient, lastNamePatient, diagnosis, visits, idDoctor) " +
                "VALUES ('Jake', 'White', 'Nasmork', 15, 2), " +
                "('Jasmine', 'Anistone', 'Siyp', 24, 2), " +
                "('Kyle', 'Oneal', 'Bipolar', 14, 1), " +
                "('Adil', 'Ficus', 'Heart attack', 10, 3), " +
                "('Niman', 'Red', 'Appendix', 7, 4), " +
                "('Line', 'Vertical', 'Tahicardia', 18, 3), " +
                "('Bill', 'Gates', 'Acne', 30, 5)";
    }
    //encapsulation
    public int getIdPatient() {
        return idPatient;
    }

    public int getVisits() {
        return visits;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getFirstNamePatient() {
        return firstNamePatient;
    }

    public String getLastNamePatient() {
        return lastNamePatient;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setFirstNamePatient(String firstNamePatient) {
        this.firstNamePatient = firstNamePatient;
    }

    public void setLastNamePatient(String lastNamePatient) {
        this.lastNamePatient = lastNamePatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    //polymorphism
    @Override
    public String toString(){
        return "Id: "+idPatient+", First name: "+firstNamePatient+", Last name: "+lastNamePatient+", Diagnosis: "+diagnosis+", Visits: "+visits;
    }
}
