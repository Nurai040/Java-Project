package com.company;

public class Patient extends Hospital implements CostCalculator{
    //private variables
    private int idPatient;
    private String firstNamePatient;
    private String lastNamePatient;
    private String diagnosis;
    private int visits;

    //constructor
    public Patient(int idPatient, String firstNamePatient, String lastNamePatient, String diagnosis, int visits){
        this.diagnosis = diagnosis;
        this.firstNamePatient = firstNamePatient;
        this.lastNamePatient = lastNamePatient;
        this.idPatient = idPatient;
        this.visits = visits;
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
        return "Id: "+idPatient+", first name: "+firstNamePatient+", lat name: "+lastNamePatient+", diagnosis: "+diagnosis+", visits: "+visits;
    }
}
