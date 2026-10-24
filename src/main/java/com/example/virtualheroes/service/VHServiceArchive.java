package com.example.virtualheroes.service;

import com.example.virtualheroes.dao.VHDao;
import com.example.virtualheroes.dto.VHDto;

import java.util.ArrayList;

public class VHServiceArchive implements IVHService {
    private VHDao vhdao;


    public VHServiceArchive() {
        this.vhdao = new VHDao();
    }

    @Override
    public void crearHeroe(VHDto heroe) {
        ArrayList<VHDto> heroes = vhdao.obtenerHeroes();
        heroes.add(heroe);
        vhdao.guardarHeroes(heroes);
    }

    @Override
    public void eliminar(long id) {

    }

    @Override
    public void actualizar(long id, String nombre) {

    }

    @Override
    public ArrayList<VHDto> obtenerHeroes() {
        return vhdao.obtenerHeroes();
    }

}