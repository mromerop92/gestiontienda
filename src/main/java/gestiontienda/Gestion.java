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

    //constructor
    public Gestion(){}
    public Gestion(Productos[] productos, Vendedor[] vendedor){
        this.productos = productos;
        this.vendedor = vendedor;
    }

    //metodos
    public void comprar(){
        Vendedor vendedor = new Vendedor();
        Productos productos = new Productos();        
        //variable de cambio de valor por puntos de compra
        BigDecimal valorPuntosCompra = BigDecimal.valueOf(1.10);

        System.out.println("Compras.");
        // detalle vendedor
        System.out.println("Nombre del vendedor");
        vendedor.setNombreVendedor(leer.nextLine());
        System.out.println("Identificación (DNI/NIE/CIF)");
        vendedor.setIdentificacion(leer.nextLine());

        // detalles producto
        System.out.println("> Nombre del producto");
        productos.setNombreProducto(leer.nextLine());
        System.out.println("> Categoria \n1. Electrodomesticos \n2. Técnologia \n3. Ropa");
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


        
        
        System.out.println("********** retorno **********");
        System.out.println("prueba de descripcoin   " + productos.getDescCategoria());
        System.out.println(productos.getPuntosCompra());
        System.out.println(productos);

        buscaProductos();

    }

    public Productos[] buscaProductos(){        
        return productos;
    }

    public void vender(){}

    public Vendedor[] buscaVendedor(){
        return vendedor;
    }

    public void recuperacionProducto(){}

    public void gestionCaja(){}

    public void movimientosCaja(){}
    
}
