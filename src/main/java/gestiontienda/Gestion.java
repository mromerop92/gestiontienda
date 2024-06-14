package gestiontienda;
import java.math.BigDecimal;
import java.util.*;

public class Gestion {
    private Productos productos[] = null;
    private Vendedor vendedor[] =  null;
    private MovimientosCaja movimientosCaja[] = null;

    //leer datos ingresados
    private Scanner leer = new Scanner(System.in);
    private Date date = new Date();
    // varibale caja fuerte
    private BigDecimal cajaFuerte = BigDecimal.valueOf(0);
    // variable de valor a comparar para guardar a caja fuerte
    private BigDecimal aCajafuerte = BigDecimal.valueOf(3000);
    //variable bandera de compra o venta para gestoin de caja
    private boolean compraVenta;
    //variable productos recuperar adicional 10% y se suma al valor
    private BigDecimal recuperarAdicionalTotal = BigDecimal.valueOf(1.10);
    //variable productos recuperar adicional 10%
    private BigDecimal recuperarSoloAdicional = BigDecimal.valueOf(0.10);

    // variables movimieto caja
    //catalogo movimientos
    public  MovimientosCaja catalogoMovCaja[] = new MovimientosCaja[MovimientosCaja.dimesionArrayCaja];

    //constructor
    public Gestion(){}
    public Gestion(Productos[] productos, Vendedor[] vendedor, MovimientosCaja[] movimientosCajas){        
        this.productos = productos;
        this.vendedor = vendedor;
        this.movimientosCaja = movimientosCajas;
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
        System.out.println("\n Selección por id, producto a vender");
        int prId = leer.nextInt();
        for (int i = 0; i < producto.length; i++){
            if (producto[i].getId() == prId){
                System.out.println("Producto seleccionado ");                
                System.out.println(producto[i]);  
                gestionCaja(compraVenta, producto[i].getPrecio() ,producto[i].getPrecioVenta(), producto[i].getNombreProducto(), producto[i].getFechaAdquisicion());                
                break;             
            } else {
                System.out.println("Id incorrecto");
            }        
        }
    }

    // buscar todo
    public void buscaVendedor(Vendedor[] vende){
        for (int i = 0; i < vende.length; i++){
            System.out.println("\n Todos los vendedores \n **********"+ "\n" + vende[i]);
        }
        
    }
    //devolucion de producto de compra
    //pago adicional de 10% precio
    public void recuperacionProducto(Productos[] producto){
        buscaProductos(producto);
        System.out.println("\n Selección por id, producto a recuperar");
        int prId = leer.nextInt();
        for (int i = 0; i < producto.length; i++){
            if (producto[i].getId() == prId){
                System.out.println("Producto seleccionado ");                
                System.out.println(producto[i]);
                compraVenta = false;
                BigDecimal pagoPorDevolucion = producto[i].getPrecio().multiply(recuperarAdicionalTotal);
                System.out.println("\nPago adicional " + producto[i].getPrecio().multiply(recuperarSoloAdicional) 
                + "\nPago por devolucion total " + pagoPorDevolucion);
                System.out.println("\nRealizar operacion \n1. Si 2. No");
                if(leer.nextInt() == 1)
                gestionCaja(compraVenta, producto[i].getPrecio() , pagoPorDevolucion, producto[i].getNombreProducto(), producto[i].getFechaAdquisicion());                
                break;             
            } else {
                System.out.println("Id incorrecto");
            }        
        }
    }

    // espera bandera de compraVenta, precio para gestion
    public void gestionCaja(boolean prCompraOVenta, BigDecimal prPrecioCompra, BigDecimal prPrecioVenta, String prNombreProducto, Date prFechcompra){
        //variable saldo minimo 
        BigDecimal minimoCaja = BigDecimal.valueOf(0);
        //varibale contador moviemtos
        int numMovimientos = 0;
        if(prCompraOVenta){
            // compra
            minimoCaja = new BigDecimal(1000);
            if(minimoCaja.compareTo(prPrecioCompra)==1){                       
                minimoCaja = minimoCaja.subtract(prPrecioCompra);
                System.out.println(" OK ");
                numMovimientos++;
                MovimientosCaja mov1 = new MovimientosCaja(numMovimientos,"Compra", prNombreProducto, prPrecioCompra,
                 prFechcompra,minimoCaja,minimoCaja, cajaFuerte);
                 catalogoMovCaja[(int)numMovimientos] = mov1;                
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
                numMovimientos++;
                MovimientosCaja mov1 = new MovimientosCaja(numMovimientos,"Venta", prNombreProducto, prPrecioCompra,
                 prFechcompra,minimoCaja,minimoCaja, cajaFuerte);
                catalogoMovCaja[(int)numMovimientos] = mov1;               
                System.out.println("OK");


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

    public void movimientosCaja(){
       movimientosCaja(catalogoMovCaja);
    }

    public void movimientosCaja(MovimientosCaja[] movimientosCajas){
        for (int  i = 0; i < movimientosCajas.length; i++){
            if(!movimientosCajas[i].equals(null))
            System.out.println("\n"+ movimientosCajas[i]);
            break;
        }
    }
    
}
