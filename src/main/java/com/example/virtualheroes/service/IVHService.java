package com.example.virtualheroes.service;

import com.example.virtualheroes.dto.VHDto;

import java.util.ArrayList;

public interface IVHService {
    void crearHeroe(VHDto vhdao);
    void eliminar(long id);
    void actualizar(long id, String nombre);
    ArrayList<VHDto> obtenerHeroes();
}