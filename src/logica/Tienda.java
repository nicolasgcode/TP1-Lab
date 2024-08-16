package logica;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private int stockMax;
    private double saldoCaja;
    //private List<Producto> productos;
    private List<ProductoEnvasado> productosEnvasados;
    private List<ProductoBebida> bebidas;
    private List<ProductoLimpieza> productosLimpieza;

    public Tienda(String nombre, int stockMax, double saldoCaja) {
        this.nombre = nombre;
        this.stockMax = stockMax;
        this.saldoCaja = saldoCaja;
        productosEnvasados = new ArrayList<>();
        bebidas = new ArrayList<>();
        productosLimpieza = new ArrayList<>();
    }


    public void realizarCompra(Producto producto, int cantidad) {
        agregarProducto(producto, cantidad);
        actualizarSaldo(producto);
    }


    public void agregarProducto(Producto producto, int cantidad) {
        if (validarStock(cantidad)) {
            if (producto instanceof ProductoEnvasado) {
                productosEnvasados.add((ProductoEnvasado) producto);
            } else if (producto instanceof ProductoBebida) {
                bebidas.add((ProductoBebida) producto);
            } else if (producto instanceof ProductoLimpieza) {
                productosLimpieza.add((ProductoLimpieza) producto);
            }
        } else {
            System.out.println("No se pueden agregar nuevos productos a la tienda ya que se alcanzó el máximo de stock.");
        }
    }

    public boolean saldoSuficiente(Producto producto) {
        return saldoCaja > producto.costoTotal();
    }


    public void actualizarSaldo(Producto producto) {
        if (saldoSuficiente(producto)) {
            saldoCaja -= producto.costoTotal();
        } else {
            System.out.println("El producto no podrá ser agregado a la tienda por saldo insuficiente en la caja.");
        }

    }


    public int calcularStockTotal() {
        int stockTotal = 0;
        stockTotal += productosEnvasados.stream().mapToInt(Producto::getStock).sum();
        stockTotal += bebidas.stream().mapToInt(Producto::getStock).sum();
        stockTotal += productosLimpieza.stream().mapToInt(Producto::getStock).sum();
        return stockTotal;
    }


    public boolean validarStock(int cantidad) {
        return calcularStockTotal() + cantidad <= stockMax;
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

    //RealizarVenta
}
