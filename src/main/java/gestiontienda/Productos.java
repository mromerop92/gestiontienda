package gestiontienda;
import java.util.*;

public class Productos {
    //propiedades 
    private String nombreProducto;
    private String descCategoria;
    private int cveCategoria;
    private Date fechaAdquisicion;
    private float precio;    
    private float puntosCompra;
    private boolean compraEfectivo;
    private boolean compraPuntos;
    private boolean devolucion = true; // bandera para cuando se puede hacer la devolucion
    public static int dimesionArray;

    //constructor
    public Productos(){}
    public Productos(String nombreProducto, int cveCategoria, Date fechaAdquisicion, float precio, float puntosCompra,
    boolean compraEfectivo, boolean compraPuntos, boolean devolucion){
        this.nombreProducto = nombreProducto;
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
        return "Producto: " + this.nombreProducto + "n" + "Categoria" + this.cveCategoria + "Fecha adquisición" 
        + this.fechaAdquisicion + "Precion" + this.precio +  "Puntos de Compra " + this.puntosCompra
        + "Compra en efectio" + this.compraEfectivo + "Compra por puntos" + this.compraPuntos + "Devolucion" + this.devolucion;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public int getCveCategoria() {
        return cveCategoria;
    }
    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }
    public float getPrecio() {
        return precio;
    }
    public float getPuntosCompra() {
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
    public void setCveCategoria(int cveCategoria) {
        this.cveCategoria = cveCategoria;
    }
    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public void setPuntosCompra(float puntosCompra) {
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
