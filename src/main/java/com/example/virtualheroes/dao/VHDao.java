package com.example.virtualheroes.dao;
import com.example.virtualheroes.dto.VHDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class VHDao {
    private final Path archivo;
    private final Gson gson;
    public VHDao() {
        String NOMBRE_ARCHIVO = "heroes.json";
        this.archivo = Path.of(System.getProperty("user.home"), NOMBRE_ARCHIVO);
        System.out.println("HeroesDao archivo: " + this.archivo);
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    public void guardarHeroes(ArrayList<VHDto> heroes) {
        try {
            String datos = this.gson.toJson(heroes);
            Files.writeString(this.archivo, datos);
        } catch (IOException e) {
            System.out.println("HeroesDao guardarHeroes: " + e.getMessage());
        }
    }
    public ArrayList<VHDto> obtenerHeroes() {
        try {
            String datos = Files.readString(this.archivo);
            Type tipoLista = new TypeToken<ArrayList<VHDto>>() {}.getType();
            ArrayList<VHDto> listado = this.gson.fromJson(datos, tipoLista);
            if (listado == null) {
                return new ArrayList<>();
            }
            return listado;
        }  catch (IOException e) {
            return new ArrayList<>();
        }
    }
}