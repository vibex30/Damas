package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;

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
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
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




    public void mover (Direccion direccion, int pasos)throws OperationNotSupportedException{
        if(direccion==null){
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }
        if(pasos<1){
            throw new IllegalArgumentException("Error, los pasos no pueden ser menores que uno.");
        }

        if(!esDamaEspecial){
            if(this.color == Color.BLANCO){
                if(direccion==Direccion.SURESTE||direccion==Direccion.SUROESTE){
                    throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
                }else if (pasos>1){
                    throw new OperationNotSupportedException("ERROR: Las damas normales solo se pueden mover 1 casilla.");
                }

                switch (direccion){
                    case NORESTE -> this.setPosicion(new Posicion(getPosicion().getFila() + 1, (char) (getPosicion().getColumna() + 1)));
                    case NOROESTE -> this.setPosicion(new Posicion(getPosicion().getFila()+1, (char)(getPosicion().getColumna()-1)));
                }
                if(this.posicion.getFila() ==8){
                    this.esDamaEspecial=true;

                }

            } else {
                if(direccion==Direccion.NORESTE||direccion==Direccion.NOROESTE){
                    throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
                } else if (pasos>1) {
                    throw new OperationNotSupportedException("ERROR: Las damas normales solo se pueden mover 1 casilla.");

                }
                switch (direccion) {
                    case SURESTE ->
                            this.setPosicion(new Posicion(getPosicion().getFila() - 1, (char) (getPosicion().getColumna() + 1)));
                    case SUROESTE ->
                            this.setPosicion(new Posicion(getPosicion().getFila() - 1, (char) (getPosicion().getColumna() - 1)));
                }
                if(this.posicion.getFila()==1){
                    this.esDamaEspecial=true;
                }
            }
        }else{
            switch (direccion){
                case NOROESTE -> this.setPosicion(new Posicion(getPosicion().getFila() + pasos, (char) (getPosicion().getColumna() -pasos)));
                case NORESTE -> this.setPosicion(new Posicion(getPosicion().getFila() +pasos, (char) (getPosicion().getColumna() + pasos)));
                case SURESTE -> this.setPosicion(new Posicion(getPosicion().getFila() - pasos, (char) (getPosicion().getColumna() + pasos)));
                case SUROESTE -> this.setPosicion(new Posicion(getPosicion().getFila() -pasos, (char) (getPosicion().getColumna() -pasos)));
            }
        }


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

    @Override
    public String toString() {
        return "color=" +color+ ", posicion=(fila="+ posicion.getFila() + ", columna="+ posicion.getColumna()+")";
    }
}
