package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Dama;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;

public class MainApp {
    private static Dama dama;


    public static void main(String[] args) {
        int opcionElegida;
        do{
            mostrarDama();
            Consola.mostrarMenu();
            opcionElegida=Consola.elegirOpcionMenu();
            ejecutarOpcion(opcionElegida);
        }while(opcionElegida!=4);


    }


    private static void ejecutarOpcion (int opcion){
        switch (opcion){
            case 1:
                crearDamaPorDefecto();
                break;
            case 2:
                crearDamaColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                Consola.despedirse();
        }
    }


    private static void crearDamaPorDefecto(){
        dama=new Dama();
    }



    private static void crearDamaColor(){

        dama=new Dama(Consola.elegirColor());

    }



    private static void mover(){
        /*
        System.out.println("1. Noreste.");
        System.out.println("2. Sureste.");
        System.out.println("3. Noroeste.");
        System.out.println("4. Suroeste.");
        int casillasAMover;

        if(dama.isEsDamaEspecial()==true){
            System.out.println("Cuántas casillas deseas mover?");
            casillasAMover= Entrada.entero();
            mover();
        }*/
        try {
            Consola.mostrarMenuDirecciones();
            dama.mover(Consola.elegirDireccion(), 1);
        }catch (IllegalArgumentException | NullPointerException|OperationNotSupportedException e){
            System.out.println(e.getMessage());
        }


    }


    private static void mostrarDama(){
        System.out.println(dama);;
    }

}
