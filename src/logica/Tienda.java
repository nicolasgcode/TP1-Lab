package logica;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private final int stockMax;
    private double saldoCaja;
    private List<ProductoEnvasado> productosEnvasados = new ArrayList<ProductoEnvasado>();
    private List<ProductoBebida> bebidas = new ArrayList<ProductoBebida>();
    private List<ProductoLimpieza> productosLimpieza = new ArrayList<ProductoLimpieza>();

    public Tienda(String nombre, int stockMax, double saldoCaja) {
        this.nombre = nombre;
        this.stockMax = stockMax;
        this.saldoCaja = saldoCaja;
    }

    public List<ProductoLimpieza> getProductosLimpieza() {
        return productosLimpieza;
    }

    public void setProductosLimpieza(List<ProductoLimpieza> productosLimpieza) {
        this.productosLimpieza = productosLimpieza;
    }

    public List<ProductoBebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<ProductoBebida> bebidas) {
        this.bebidas = bebidas;
    }

    public List<ProductoEnvasado> getProductosEnvasados() {
        return productosEnvasados;
    }

    public void setProductosEnvasados(List<ProductoEnvasado> productosEnvasados) {
        this.productosEnvasados = productosEnvasados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockMax() {
        return stockMax;
    }


    public double getSaldoCaja() {
        return saldoCaja;
    }

    public void setSaldoCaja(double saldoCaja) {
        this.saldoCaja = saldoCaja;
    }


    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", stockMax=" + stockMax +
                ", saldoCaja=" + saldoCaja +
                ", productosEnvasados=" + productosEnvasados +
                ", bebidas=" + bebidas +
                ", productosLimpieza=" + productosLimpieza +
                '}';
    }

}
