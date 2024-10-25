package org.iesalandalus.programacion.damas;

import java.util.Objects;

public class Posicion {
    private int fila;
    private char columna;


    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    public Posicion(Posicion posicion){
        if(posicion==null){
            throw new NullPointerException("La posición no puede ser null.");
        }
        setFila(posicion.getFila());
        setColumna(posicion.getColumna());

    }


    public int getFila() {
        return fila;
    }

    private void setFila(int fila) {
        if(fila<1 || fila >8){
            throw new IllegalArgumentException("La fila no puede ser menor que 1 ni mayor que 8.");
        }

        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }



    private void setColumna(char columna) {
        if(columna<'a' ||columna>'h'){
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        }

        this.columna = columna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;
    }
}
