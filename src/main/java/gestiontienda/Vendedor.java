package gestiontienda;
import java.math.BigDecimal;
import java.util.*;

public class Vendedor extends Productos {
    //propiedades
    private String nombreVendedor;
    private String identificacion;

    //constructor
    public Vendedor(){}
    public Vendedor(String nombreProducto, String descCategoria, int cveCategoria, Date fechaAdquisicion, BigDecimal precio, BigDecimal puntosCompra,
    boolean compraEfectivo, boolean compraPuntos, boolean devolucion, String nombreVendedor, String identificacion){
        super(nombreProducto, descCategoria, cveCategoria, fechaAdquisicion, precio, puntosCompra, compraEfectivo, compraPuntos, devolucion);
        this.nombreVendedor = nombreVendedor;
        this.identificacion = identificacion;        
    }

    //metodos
    @Override
    public String toString(){
        return "Nombre Vendedor " + this.nombreVendedor + "\n" + "Identificacion" + this.identificacion;
    }
    public String getNombreVendedor() {
        return nombreVendedor;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    

}
