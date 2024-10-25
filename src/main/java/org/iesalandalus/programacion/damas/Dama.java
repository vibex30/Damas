package org.iesalandalus.programacion.damas;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;


    //Por defecto
    public Dama() {
        this.color = Color.BLANCO;
        this.posicion=crearPosicionInicial();
        this.esDamaEspecial=false;
    }

    public Dama(Color color){
        setColor(color);
        this.posicion=crearPosicionInicial();
        this.esDamaEspecial=false;
    }


    public Color getColor () {
        return color;
    }

    private void setColor (Color color){
        if( color==null){
            throw new NullPointerException("El color no puede ser null.");
        }
        this.color = color;
    }


    public Posicion getPosicion () {
        return posicion;
    }

    public void setPosicion (Posicion posicion){
        if(posicion==null){
            throw new NullPointerException("Error, la posición no puede ser null.");
        }
        this.posicion = posicion;
    }









    public void mover (Direccion direccion, int pasos){


    }







    private Posicion crearPosicionInicial(){
        int fila;
        char columna;

        if( color==Color.BLANCO){       //FILAS 1,2 Y 3 SI ES BLANCA
            fila=(int)(Math.random()*3)+1;
        }else{                          //FILAS 6, 7 Y 8 SI ES NEGRA
            fila=(int)(Math.random()*3)+6;
        }
        int aleatorioColumna = (int) (Math.random() * 4); // Índice de 0 a 3

        columna=(char) ('a' + aleatorioColumna*2+1); //Las damas blancas se colocan en casilla negra, que serán impares


    return new Posicion(fila, columna);
    }

}
