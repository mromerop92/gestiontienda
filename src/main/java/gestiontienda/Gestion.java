package gestiontienda;
import java.math.BigDecimal;
import java.util.*;

public class Gestion {
    // propiedades
    private Productos productos[] = null;
    private Vendedor vendedor[] =  null;

    //leer datos ingresados
    Scanner leer = new Scanner(System.in);
    Date date = new Date();
    
    //variable de cambio de valor por puntos de compra 10% adicional
    BigDecimal valorPuntosCompra = BigDecimal.valueOf(1.10);
    //variable saldo minimo en caja 1000
    BigDecimal minimoCaja = BigDecimal.valueOf(1000);
    // varibale caja fuerte
    BigDecimal cajaFuerte;
    // variable de valor a comparar para guardar a caja fuerte
    BigDecimal aCajafuerte = BigDecimal.valueOf(3000);
    //variable bandera de compra o venta para gestoin de caja
    boolean compraVenta;

    //constructor
    public Gestion(){}
    public Gestion(Productos[] productos, Vendedor[] vendedor){
        this.productos = productos;
        this.vendedor = vendedor;
    }

    //metodos
    public void comprar(){
        compraVenta = true;

        Vendedor vendedor = new Vendedor();
        Productos productos = new Productos();        

        System.out.println("Compras.");
        // detalle vendedor
        System.out.println("> Nombre del vendedor");
        vendedor.setNombreVendedor(leer.nextLine());
        System.out.println("> Identificación (DNI/NIE/CIF)");
        vendedor.setIdentificacion(leer.nextLine());

        // detalles producto
        System.out.println("> Nombre del producto");
        productos.setNombreProducto(leer.nextLine());
        System.out.println("> Categoria \n1. Electrodomesticos \n2. Técnologia \n3. Otros");
        productos.setCveCategoria(leer.nextInt());
        productos.setDescCategoria((productos.getCveCategoria() == 1) ? "Electrodomestico" : "Tècnologia");
        productos.setFechaAdquisicion(date); // verificar formato
        System.out.println("> Precio");
        productos.setPrecio(leer.nextBigDecimal());
        System.out.println("Compra en \n1. Efectivo \n2. Puntos de compra");
        productos.setCompraEfectivo((leer.nextInt() == 1) ? true : false);
        // convertir precio a puntos de compra si|no
        if (!productos.isCompraEfectivo())
        productos.setPuntosCompra(productos.getPrecio().multiply(valorPuntosCompra));
        System.out.println("****** productos *********");
        System.out.println(productos);
        System.out.println("********* caja **************");
        gestionCaja(compraVenta, productos.getPrecio());

    }

    public Productos[] buscaProductos(){        
        return productos;
    }
    //45% mas en precio    
    public void vender(){}

    // buscar por nombre y por identificacion
    public Vendedor[] buscaVendedor(){
        return vendedor;
    }

    public void recuperacionProducto(){}
    // espera bandera de compraVenta, precio para gestion
    public void gestionCaja(boolean prCompraOVenta, BigDecimal prPrecio){
        if(prCompraOVenta){
            if(minimoCaja.compareTo(prPrecio)==1){
                minimoCaja.subtract(prPrecio);
                System.out.println("Compra OK");
            } else {
                System.out.println("ADVERTENCIA \nSaldo de caja menor");
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

    }

    public void movimientosCaja(){}
    
}
