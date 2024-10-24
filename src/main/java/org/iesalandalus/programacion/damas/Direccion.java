package org.iesalandalus.programacion.damas;

public enum Direccion {
    NORESTE ("Noreste"),
    SURESTE("Sureste"),
    SUROESTE("Suroeste"),
    NOROESTE("Noroeste");

    private final String cadenaAmostrar;

    //Constructor privado
    private Direccion (String cadenaAmostrar){
        this.cadenaAmostrar=cadenaAmostrar;
    }

    @Override
    public String toString() {
        return  cadenaAmostrar;
    }
}
