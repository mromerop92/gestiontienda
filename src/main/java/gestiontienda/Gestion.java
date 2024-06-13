package gestiontienda;
import java.math.BigDecimal;
import java.util.*;

public class Gestion {
    private Productos productos[] = null;
    private Vendedor vendedor[] =  null;

    //leer datos ingresados
    Scanner leer = new Scanner(System.in);
    Date date = new Date();    
    //variable de cambio de valor por puntos de compra 10% adicional
    BigDecimal valorPuntosCompra = BigDecimal.valueOf(1.10);
    //variable saldo minimo en caja
    BigDecimal minimoCaja;
    // varibale caja fuerte
    BigDecimal cajaFuerte;
    // variable de valor a comparar para guardar a caja fuerte
    BigDecimal aCajafuerte = BigDecimal.valueOf(3000);
    //variable bandera de compra o venta para gestoin de caja
    boolean compraVenta;

    //catalogo productos
    //Productos catalogo[] = new Productos[Productos.dimesionArray];


    //constructor
    public Gestion(){}
    public Gestion(Productos[] productos, Vendedor[] vendedor){
        this.productos = productos;
        this.vendedor = vendedor;
    }

    //metodos   
    public void buscaProductos(Productos[] producto){      
        for (int  i = 0; i < producto.length; i++){
            System.out.println("\n Todos los Productos \n *********** "+ "\n"  + producto[i]);
        }
    }
    public void buscarPorId(int id, Productos[] producto){
        System.out.println("producto");
    }
    //45% mas en precio    
    public void vender(Productos[] producto){
        buscaProductos(producto);
        System.out.println("ingresa id de productio a vender");

    }

    // buscar por nombre y por identificacion
    public void buscaVendedor(Vendedor[] vende){
        for (int i = 0; i < vende.length; i++){
            System.out.println("\n Todos los vendedores \n **********"+ "\n" + vende[i]);
        }
        
    }
    //devolucion de cproducto de compra
    public void recuperacionProducto(){}

    // espera bandera de compraVenta, precio para gestion
    public void gestionCaja(boolean prCompraOVenta, BigDecimal prPrecio){     
        minimoCaja = BigDecimal.valueOf(1000);   
        if(prCompraOVenta){
            if(minimoCaja.compareTo(prPrecio)==1){
                minimoCaja.subtract(prPrecio);
                System.out.println("Compra OK");                
            } else {
                System.out.println("***************");
                System.out.println("* ADVERTENCIA *");
                System.out.println("***************");
                System.out.println("Saldo de caja menor");
            }
        } else{
            minimoCaja.add(prPrecio);
            if(minimoCaja.compareTo(aCajafuerte)==1){
                BigDecimal diferencia = minimoCaja.subtract(new BigDecimal(1000));
                cajaFuerte.add(diferencia);
                minimoCaja.subtract(diferencia);        
                System.out.println("Se salvo en caja fuerte");
                System.out.println("Venta OK");
                System.out.println("*******" + minimoCaja + " " + cajaFuerte);
            } else {
                System.out.println("Venta OK");
            }
        }
        minimoCaja = minimoCaja.subtract(prPrecio);
    }

    public void movimientosCaja(){}
    
}
