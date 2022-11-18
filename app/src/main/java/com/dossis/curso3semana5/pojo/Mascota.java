package com.dossis.curso3semana5.pojo;

public class Mascota implements  Comparable{
    private int id;
    private String nombre;
    private int likes;

    private int idFoto;

    public Mascota(int id, String nombre, int likes, int idFoto) {
        this.id = id;
        this.nombre = nombre;
        this.likes = likes;
        this.idFoto = idFoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void addLike(){
        this.likes +=1;
    }


    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }


    @Override
    public int compareTo(Object o) {
        Mascota m = (Mascota) o;
        return m.getLikes() - this.getLikes();
    }
}
