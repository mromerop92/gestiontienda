package gestiontienda;
import java.math.BigDecimal;
import java.util.*;

public class Productos {
    //propiedades 
    private int id;
    private String nombreProducto;
    private String descCategoria;
    private int cveCategoria;
    private Date fechaAdquisicion;
    private BigDecimal precio;
    private BigDecimal precioVenta;    
    private BigDecimal puntosCompra = BigDecimal.valueOf(0);
    private boolean compraEfectivo;
    private boolean devolucion = true; // bandera para cuando se puede hacer la devolucion, menos de 30 dias
    public static int dimesionArray = 10;

    //constructor    
    public Productos(){}
    public Productos(int id, String nombreProducto, String descCategoria, int cveCategoria, Date fechaAdquisicion, BigDecimal precio,BigDecimal precioVenta,
     BigDecimal puntosCompra, boolean compraEfectivo, boolean devolucion){
        super();
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.descCategoria = descCategoria;
        this.cveCategoria = cveCategoria;
        this.fechaAdquisicion = fechaAdquisicion;
        this.precio = precio;
        this.precioVenta = precioVenta;
        this.puntosCompra = puntosCompra;
        this.compraEfectivo = compraEfectivo;
        this.devolucion = devolucion;

        dimesionArray++;

    }

    //metodos
    @Override
    public String toString(){
        return "id " + this.id + "\n" + "Producto " + this.nombreProducto + "\n" + "Categoria " + this.descCategoria + "\n" + "Fecha adquisición "  + this.fechaAdquisicion +"\n"
        + "Compra en efectio " + ((this.compraEfectivo)? "SI" : "NO")+ "\n"
        + "Precio compra " + this.precio + "\n" + "Precio Venta " + this.precioVenta + "\n" + "Puntos por Compra " + this.puntosCompra +"\n"
        + "Devolución " + ((this.devolucion = true) ? "SI" : "NO");
    }
    public int getId() {
        return id;
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
    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }
    public BigDecimal getPuntosCompra() {
        return puntosCompra;
    }
    public boolean isCompraEfectivo() {
        return compraEfectivo;
    }
    public boolean isDevolucion() {
        return devolucion;
    }

    public void setId(int id) {
        this.id = id;
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
    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }
    public void setPuntosCompra(BigDecimal puntosCompra) {
        this.puntosCompra = puntosCompra;
    }
    public void setCompraEfectivo(boolean compraEfectivo) {
        this.compraEfectivo = compraEfectivo;
    }
    public void setDevolucion(boolean devolucion) {
        this.devolucion = devolucion;
    }

    


    
}
