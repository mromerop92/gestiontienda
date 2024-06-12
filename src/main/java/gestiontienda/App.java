/**
 * Sistemas de Gestión de tienda de senguda manno.
 * @author Moises Antonio Romero Pereira.
 * @version 10/06/2024  1.0 
 */
package gestiontienda;
import  java.util.*;

public class App {
    
    public static Scanner leerOpcion = new Scanner(System.in);
    public static int opcion;    
    /*
     * Metodos
     */
    public static void main( String[] args ) {

        Gestion gestion = new Gestion();

        System.out.println( " Sistemas de Gestión " );
        System.out.println("Seleccion la operación: \n1. Comprar.\n2. Vender.\n3. Buscar productos. \n4. Buscar vendedores. \n5. Recuperación de producto.\n6. Movimientos de caja.");
        opcion = leerOpcion.nextInt();

        switch (opcion) {
            case 1:
                gestion.comprar();                
                break;
            case 2:
                gestion.vender();
                break;
            case 3:
                gestion.buscaProductos();
                break;
            case 4:
                gestion.buscaVendedor();
                break;
            case 5:
                gestion.recuperacionProducto();
                break;
            case 6:
                gestion.movimientosCaja();
                break;        
            default:
                System.out.println("Opción incorrecta");
                break;
        }

    }

}
