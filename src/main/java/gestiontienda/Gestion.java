package gestiontienda;
import java.math.BigDecimal;
import java.util.*;

public class Gestion {
    private Productos productos[] = null;
    private Vendedor vendedor[] =  null;

    //leer datos ingresados
    private Scanner leer = new Scanner(System.in);
    private Date date = new Date();
    // varibale caja fuerte
    private BigDecimal cajaFuerte = BigDecimal.valueOf(0);
    // variable de valor a comparar para guardar a caja fuerte
    private BigDecimal aCajafuerte = BigDecimal.valueOf(3000);
    //variable bandera de compra o venta para gestoin de caja
    private boolean compraVenta;
    //constructor
    public Gestion(){}
    public Gestion(Productos[] productos, Vendedor[] vendedor){
        this.productos = productos;
        this.vendedor = vendedor;
    }

    //metodos   
    public void buscaProductos(Productos[] producto){      
        for (int  i = 0; i < producto.length; i++){
            if(!producto[i].equals(null))
            System.out.println("\n Todos los Productos \n *********** "+ "\n"  + producto[i]);
            break;
        }
    }
    public void buscarPorId(int id, Productos[] producto){
        System.out.println("producto");

    }
    //45% mas en precio    
    public void vender(Productos[] producto){ 
        compraVenta = false;       
        buscaProductos(producto);
        System.out.println("\n Ingresa id de productio a vender");
        int prId = leer.nextInt();
        for (int i = 0; i < producto.length; i++){
            if (producto[i].getId() == prId){
                System.out.println("Producto seleccionado ");                
                System.out.println(producto[i]);  
                gestionCaja(compraVenta, producto[i].getPrecio() ,producto[i].getPrecioVenta());                
                break;             
            } else {
                System.out.println("Id incorrecto");
            }        
        }

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
    public void gestionCaja(boolean prCompraOVenta, BigDecimal prPrecioCompra, BigDecimal prPrecioVenta){
        //variable saldo minimo 
        BigDecimal minimoCaja = BigDecimal.valueOf(0);
        if(prCompraOVenta){
            // compra
            minimoCaja = new BigDecimal(1000);
            if(minimoCaja.compareTo(prPrecioCompra)==1){                       
                minimoCaja = minimoCaja.subtract(prPrecioCompra);
                System.out.println("Compra OK " + minimoCaja);
                
            } else {
                System.out.println("***************");
                System.out.println("* ADVERTENCIA *");
                System.out.println("***************");
                System.out.println("Saldo super a saldo de caja");
            }

        }else{
            // vender
            minimoCaja = minimoCaja.add(prPrecioVenta);
            if(minimoCaja.compareTo(aCajafuerte)==1){
                BigDecimal diferencia = minimoCaja.subtract(new BigDecimal(1000));
                cajaFuerte = cajaFuerte.add(diferencia);
                minimoCaja = minimoCaja.subtract(diferencia);        
                System.out.println("Se salvo en caja fuerte");
                System.out.println("Venta OK " + minimoCaja);

                // retorno prueba
                System.out.println("com caja fuerte");
                System.out.println("*******" + minimoCaja + " " + cajaFuerte);

            } else {
                System.out.println("Venta OK " + minimoCaja);
                // retorno pruebas
                System.out.println("sin caja fuerte");
                System.out.println(minimoCaja + "*****" + cajaFuerte );
            }
        }
    }

    public void movimientosCaja(){}
    
}
