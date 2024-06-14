package gestiontienda;
import java.math.BigDecimal;
import java.util.*;

public class Vendedor extends Productos {
    //propiedades
    private int idProducto;
    private String nombreVendedor;
    private String identificacion;
    public static int dimesionArray = 10;

    //constructor
    public Vendedor(){}
    public Vendedor(int id, String nombreProducto, String descCategoria, int cveCategoria, Date fechaAdquisicion, BigDecimal precio, BigDecimal precioVenta,
     BigDecimal puntosCompra, boolean compraEfectivo, boolean devolucion, int idProducto, String nombreVendedor, String identificacion){
        super(id, nombreProducto, descCategoria, cveCategoria, fechaAdquisicion, precio, precioVenta, puntosCompra, compraEfectivo, devolucion);
        this.idProducto = idProducto;
        this.nombreVendedor = nombreVendedor;
        this.identificacion = identificacion;
        
        dimesionArray++;
    }

    //metodos
    @Override
    public String toString(){
        return "id Vendedor "+ "\n" +"Nombre Vendedor " + this.nombreVendedor + "\n" + "Identificacion (DNI/NIE/CIF) " + this.identificacion;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public String getNombreVendedor() {
        return nombreVendedor;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    

}
