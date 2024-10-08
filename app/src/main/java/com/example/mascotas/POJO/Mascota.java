package com.example.mascotas.POJO;

public class Mascota {
    private int id;
    private String nombre;
    private int imagen;
    private int ranqueo;
    private boolean esRanqueado;

    public Mascota(String nombre, int imagen, int ranqueo, boolean esRanqueado) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.ranqueo = ranqueo;
        this.esRanqueado = esRanqueado;
    }

    public Mascota(int imagen, int ranqueo) {
        this.imagen = imagen;
        this.ranqueo = ranqueo;
    }

    public Mascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getRanqueo() {
        return ranqueo;
    }

    public void setRanqueo(int ranqueo) {
        this.ranqueo = ranqueo;
    }

    public boolean isEsRanqueado() {
        return esRanqueado;
    }

    public void setEsRanqueado(boolean esRanqueado) {
        this.esRanqueado = esRanqueado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
