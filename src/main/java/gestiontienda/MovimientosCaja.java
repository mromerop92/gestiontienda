package gestiontienda;

import java.math.BigDecimal;
import java.util.*;

public class MovimientosCaja{
    //propiedades
    private int id;
    private String tipoGestion;
    private String nombreProducto;
    private BigDecimal precioProducto;
    private Date fechaAdquisicio;
    private BigDecimal saldoInicial;
    private BigDecimal saldoFinal;
    private BigDecimal saldoCajaFuerte = BigDecimal.valueOf(0);
    public static int dimesionArrayCaja = 10;    
    
    //contructor
    public MovimientosCaja(){}
    public MovimientosCaja(int id, String tipoGestion, String nombreProducto, BigDecimal precioProducto,
     Date fechaAdquisicio, BigDecimal saldoInicial, BigDecimal saldoFinal, BigDecimal saldoCajaFuerte){
        super();
        this.id = id;
        this.tipoGestion = tipoGestion;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.fechaAdquisicio = fechaAdquisicio;
        this.saldoInicial = saldoInicial;
        this.saldoFinal = saldoFinal;
        this.saldoCajaFuerte = saldoCajaFuerte;

        dimesionArrayCaja++;
    }

     //metodo
     @Override
     public String toString(){
        return "> Movimientos de caja <" + "\n" +"Id " + this.id +"\n"+ "Tipo de gestión \n" + this.tipoGestion + "\n" + "Saldo Inicial "
        + this.saldoInicial + "\n" + "Nombre de Producto " + this.nombreProducto + "\n" + "Fecha " + this.fechaAdquisicio 
        + "\n" + "Precio " + this.precioProducto + "\n" + "Saldo Final " + this.saldoFinal + "\n"+ "Saldo caja fuerte " + this.saldoCajaFuerte
        + "\n" + "----------- \n";
    }

    public int getId() {
        return id;
    }
    public String getTipoGestion() {
        return tipoGestion;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }
    public Date getFechaAdquisicio() {
        return fechaAdquisicio;
    }
    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }
    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }    
    public BigDecimal getSaldoCajaFuerte() {
        return saldoCajaFuerte;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTipoGestion(String tipoGestion) {
        this.tipoGestion = tipoGestion;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }
    public void setFechaAdquisicio(Date fechaAdquisicio) {
        this.fechaAdquisicio = fechaAdquisicio;
    }
    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
    public void setSaldoFinal(BigDecimal saldoFinal) {
        this.saldoFinal = saldoFinal;
    }
    public void setSaldoCajaFuerte(BigDecimal saldoCajaFuerte) {
        this.saldoCajaFuerte = saldoCajaFuerte;
    }     

}
