package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private Consola(){

    }

    public static void mostrarMenu(){
        System.out.println("1. Crear dama por defecto.");
        System.out.println("2. Crear dama eligiendo el color.");
        System.out.println("3. Mover.");
        System.out.println("4. Salir.");
    }


    public static int elegirOpcionMenu(){
        int opcion;
        do{
            System.out.println("Elije opción: ");
            opcion= Entrada.entero();
        }while (opcion<1 || opcion>4);

        return opcion;
    }

    public static Color elegirColor(){
        int colorElegido;
        do{
            System.out.println("Elija un color: ");
            System.out.println("1 para blanco, 2 para negro.");
            colorElegido=Entrada.entero();
        }while(colorElegido<1 || colorElegido>2);

        if(colorElegido==1){
            return Color.BLANCO;
        }else
            return Color.NEGRO;

    }

    public static void mostrarMenuDirecciones(){
        System.out.println("1. Noreste.");
        System.out.println("2. Sureste.");
        System.out.println("3. Noroeste.");
        System.out.println("4. Suroeste.");


    }

    public static Direccion elegirDireccion(){
        int direccionElegida;
        do{
            System.out.println("Elija una opción entre 1 y 4.");
            direccionElegida=Entrada.entero();
        }while(direccionElegida<1 || direccionElegida>4);

        switch (direccionElegida){
            case 1:
                return Direccion.NORESTE;
            case 2:
                return Direccion.SURESTE;
            case 3:
                return Direccion.NOROESTE;
            case 4:
                return Direccion.SUROESTE;
        }
        return null;
    }

    public static void elegirPasos(){
        int numeroCasillasAMover;
        do{
            System.out.println("Introduce el número de casillas a desplazarse: ");
            numeroCasillasAMover=Entrada.entero();
        }while (numeroCasillasAMover<1);
    }

    public static void despedirse(){
        System.out.println("Saliendo del programa.");
    }
}
