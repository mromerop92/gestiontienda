package gestiontienda;

public class Gestion {
    // propiedades
    private Productos productos[] = null;
    private Vendedor vendedor[] =  null;

    //constructor
    public Gestion(){}
    public Gestion(Productos[] productos, Vendedor[] vendedor){
        this.productos = productos;
        this.vendedor = vendedor;
    }

    //metodos
    public void comprar(){}

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
