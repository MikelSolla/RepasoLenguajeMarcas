/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msolla.practicadom;

/**
 *
 * @author 1gdaw08
 */
public class Alojamiento {
    private String id;
    private String tipo;
    private String nombre;
    private String municipio;
    private String web;
    private Integer capacidad;

    public Alojamiento(String id, String tipo, String nombre, String municipio, String web, Integer capacidad) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.municipio = municipio;
        this.web = web;
        this.capacidad = capacidad;
    }

    public Alojamiento() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    
}
