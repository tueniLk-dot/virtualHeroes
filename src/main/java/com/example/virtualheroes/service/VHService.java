package com.example.virtualheroes.service;

import com.example.virtualheroes.dto.VHDto;

import java.util.ArrayList;

public class VHService implements IVHService{

    private VHService(){

        ArrayList<VHDto> vhdao = new ArrayList<>();
    }

    @Override
    public void crearHeroe(VHDto vhdao) {

    }

    @Override
    public void eliminar(long id) {

    }


    @Override
    public void actualizar(long id, String nombre) {

    }

    @Override
    public ArrayList<VHDto> obtenerHeroes() {
        return null;
    }
}
