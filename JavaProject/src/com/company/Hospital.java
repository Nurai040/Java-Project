package com.company;

public class Hospital implements CostCalculator{
    //private variables
    private int idHospital;
    private String name;
    private String city;

    //two constructors
    public Hospital(){

    };

    public Hospital(int idHospital, String name, String city){
        this.city = city;
        this.idHospital = idHospital;
        this.name = name;
    }

    //encapsulation
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    //polymorphism
    @Override
    public String toString(){
        return "Id of hospital: "+idHospital+", name of hospital: "+name+", city of hospital: "+city;
    }
}
