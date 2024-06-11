package gestiontienda;
import  java.util.*;


/**
 * Sistemas de Gestión de tienda de senguda manno.
 * @author Moises Antonio Romero Pereira
 * @version 10/06/2024  1.0 
 */
public class App {
    
    public static Scanner leerOpcion = new Scanner(System.in);
    public static int opcion;
    
    /*
     * Metodos
     */
    public static void main( String[] args ) {

        System.out.println( " Sistemas de Gestión " );
        System.out.println("Seleccion la operación: \n1. Comprar.\n2. Vender.\n3. Recuperación de producto.\n4. Movimientos de caja.");
        opcion = leerOpcion.nextInt();

    }

}
