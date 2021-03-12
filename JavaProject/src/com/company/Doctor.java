package com.company;

public class Doctor extends Hospital{
    //private variables
    private int idEmployee;
    private String firstNameDoctor;
    private String lastNameDoctor;
    private int costPerVisit;

    //constructor
    public Doctor(int idEmployee, String firstNameDoctor, String lastNameDoctor, int costPerVisit){
        this.costPerVisit = costPerVisit;
        this.firstNameDoctor = firstNameDoctor;
        this.lastNameDoctor = lastNameDoctor;
        this.idEmployee = idEmployee;
    }

    //encapsulation
    public void setCostPerVisit(int costPerVisit) {
        this.costPerVisit = costPerVisit;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstNameDoctor() {
        return firstNameDoctor;
    }

    public void setFirstNameDoctor(String firstNameDoctor) {
        this.firstNameDoctor = firstNameDoctor;
    }

    public String getLastNameDoctor() {
        return lastNameDoctor;
    }

    public int getCostPerVisit() {
        return costPerVisit;
    }

    public void setLastNameDoctor(String lastNameDoctor) {
        this.lastNameDoctor = lastNameDoctor;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    //polymorphism
    @Override
    public String toString(){
        return "Id: "+idEmployee+", first name: "+firstNameDoctor+", last name: "+lastNameDoctor+", cost per visit: "+costPerVisit;
    }
}
