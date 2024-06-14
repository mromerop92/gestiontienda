/**
 * Sistemas de Gestión de tienda de senguda mano.
 * @author Moises Antonio Romero Pereira.
 * @version 10/06/2024  1.0 
 */
package gestiontienda;
import java.math.BigDecimal;
import  java.util.*;

public class App {
    
    public static Scanner leerOpcion = new Scanner(System.in);
    public static int inicio;
    //leer datos de teclado
    public static Scanner leer = new Scanner(System.in);

    public static Date date = new Date();
    //variable vendedor
    public static String nombreVende;
    public static String numIdentificacion;
    //variable detalles productos
    public static int id = 0;
    public static String nombrePro;
    public static String descCategoria;
    public static int cveCategoria;
    public static Date fechaAdquisicio;
    public static BigDecimal precio;
    public static BigDecimal precioVenta;    
    public static BigDecimal puntosCompra = BigDecimal.valueOf(0);
    public static boolean compraEnEfectivo;
    public static boolean devolucion = true;
    //variable bandera de compra o venta para gestoin de caja
    public static boolean compraVenta;
    //variable de cambio de valor por puntos de compra 10% adicional, suma total
    private static BigDecimal valorPuntosCompra = BigDecimal.valueOf(1.10);    
    //porcentaje adicinal de venta 45%, suma total 
    private static BigDecimal porcentajeDeVenta = BigDecimal.valueOf(1.45);
    //catalogo productos
    public static Productos catalogo[] = new Productos[Productos.dimesionArray];
    //catalogo vendedor
    public static Vendedor catalogoVende[] = new Vendedor[Vendedor.dimesionArray];

    public static void main( String[] args ) {  
        Gestion gestion = new Gestion();      
               
        System.out.println("Gestión de tienda \n Bienvenido \n1. Continuar. \n2. Salir");
        inicio = leerOpcion.nextInt();    
                            
        while (inicio == 1) { 
            System.out.println("");
            System.out.println( "Sistemas de Gestión" );
            System.out.println("Seleccion la operación: \n1. Comprar.\n2. Vender.\n3. Buscar productos. \n4. Buscar vendedores. \n5. Recuperación de producto.\n6. Movimientos de caja.");
        
            switch (leerOpcion.nextInt()) {
                case 1:
                    comprar();                
                    break;
                case 2:
                    gestion.vender(catalogo);
                    break;
                case 3:
                    gestion.buscaProductos(catalogo);
                    break;
                case 4:
                    gestion.buscaVendedor(catalogoVende);
                    break;
                case 5:
                    gestion.recuperacionProducto(catalogo);
                    break;
                case 6:
                    gestion.movimientosCaja();
                    break;        
                default:
                    System.out.println("-> Opción incorrecta. <- \n");
                    break;
            }
            System.out.println("\n Otra operación \n1. Si \n2. Salir");
            inicio = leerOpcion.nextInt();
        }   
    }

     //comprar
     public static void comprar(){
        Gestion gestion = new Gestion();
        compraVenta = true;   

        System.out.println("\n Compra.");  
        // detalle vendedor
        System.out.println("> Nombre del vendedor");
        nombreVende = leer.nextLine();
        System.out.println("> Identificación (DNI/NIE/CIF)");
        numIdentificacion = leer.nextLine();

        // detalles producto 
        System.out.println("> Nombre del producto");
        nombrePro =leer.nextLine();
        System.out.println("> Categorias \n1. Electrodomesticos \n2. Técnologia \n3. Otros");
        cveCategoria = leer.nextInt();
        descCategoria = ((cveCategoria == 1) ? "Electrodomestico" : "Tècnologia");
        fechaAdquisicio = date; // verificar formato
        System.out.println("> Precio");
        precio = leer.nextBigDecimal();
        precioVenta = precio.multiply(porcentajeDeVenta);
        System.out.println("> Compra en \n1. Efectivo \n2. Puntos de compra");
        compraEnEfectivo = ((leer.nextInt() == 1) ? true : false);
        // convertir precio a puntos de compra si|no
        if (!compraEnEfectivo)
        puntosCompra = (precio.multiply(valorPuntosCompra));
        gestion.gestionCaja(compraVenta, precio, precioVenta, nombrePro, fechaAdquisicio);

        //cargar producto
        Productos pro1 = new Productos(id,nombrePro,descCategoria,cveCategoria,fechaAdquisicio,precio,precioVenta,puntosCompra, compraEnEfectivo, devolucion);
        //cargar vendedor
        Vendedor ven1 = new Vendedor(id,nombrePro,descCategoria,cveCategoria,fechaAdquisicio,precio,precioVenta,puntosCompra,compraEnEfectivo,devolucion,id,nombreVende,numIdentificacion);
        
        catalogo[((int)id)] = pro1;
        catalogoVende[((int)id)] = ven1;
        id++;
        limparVaribles();
    }

    public static void limparVaribles(){                
        inicio = 0;       
        nombreVende = "";
        numIdentificacion = "";
        nombrePro = "";
        descCategoria = "";
        cveCategoria = 0;
        precio = BigDecimal.valueOf(0);    
        puntosCompra = BigDecimal.valueOf(0);
    }
}
