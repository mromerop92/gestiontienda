package gestiontienda;
import java.math.BigDecimal;
import java.util.*;

public class Productos {
    //propiedades 
    private String nombreProducto;
    private String descCategoria;
    private int cveCategoria;
    private Date fechaAdquisicion; // dd/mm/yyyy
    private BigDecimal precio;    
    private BigDecimal puntosCompra = BigDecimal.valueOf(0);
    private boolean compraEfectivo;
    private boolean compraPuntos;
    private boolean devolucion = true; // bandera para cuando se puede hacer la devolucion
    public static int dimesionArray;

    //constructor    
    public Productos(){}
    public Productos(String nombreProducto, String descCategoria, int cveCategoria, Date fechaAdquisicion, BigDecimal precio, BigDecimal puntosCompra,
    boolean compraEfectivo, boolean compraPuntos, boolean devolucion){
        this.nombreProducto = nombreProducto;
        this.descCategoria = descCategoria;
        this.cveCategoria = cveCategoria;
        this.fechaAdquisicion = fechaAdquisicion;
        this.precio = precio;
        this.puntosCompra = puntosCompra;
        this.compraEfectivo = compraEfectivo;
        this.compraPuntos = compraPuntos;
        this.devolucion = devolucion;

        dimesionArray++;

    }

    //metodos
    @Override
    public String toString(){
        return "Producto " + this.nombreProducto + "\n" + "Categoria " + this.descCategoria + "\n" + "Fecha adquisición " 
        + this.fechaAdquisicion + "\n" + "Precio " + this.precio + "\n" +  "Puntos de Compra " + this.puntosCompra +"\n"
        + "Compra en efectio " + this.compraEfectivo + "\n" + "Compra por puntos" + this.compraPuntos + "\n" + "Devolucion " + this.devolucion;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }    
    public String getDescCategoria() {
        return descCategoria;
    }
    public int getCveCategoria() {
        return cveCategoria;
    }
    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public BigDecimal getPuntosCompra() {
        return puntosCompra;
    }
    public boolean isCompraEfectivo() {
        return compraEfectivo;
    }
    public boolean isCompraPuntos() {
        return compraPuntos;
    }
    public boolean isDevolucion() {
        return devolucion;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }    
    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }
    public void setCveCategoria(int cveCategoria) {
        this.cveCategoria = cveCategoria;
    }
    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public void setPuntosCompra(BigDecimal puntosCompra) {
        this.puntosCompra = puntosCompra;
    }
    public void setCompraEfectivo(boolean compraEfectivo) {
        this.compraEfectivo = compraEfectivo;
    }
    public void setCompraPuntos(boolean compraPuntos) {
        this.compraPuntos = compraPuntos;
    }
    public void setDevolucion(boolean devolucion) {
        this.devolucion = devolucion;
    }

    


    
}
