package com.example.virtualheroes.dto;

public class VHDto {

    private long id;
    private String number;


    public VHDto(Integer id, String nombre, boolean sexo, int edad){
        this.id=id;
        this.number =nombre;

    }

    public VHDto(Integer id, String nombre) {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNumber() {

        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "VHDto{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
