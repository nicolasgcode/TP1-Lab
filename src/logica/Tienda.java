package logica;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private int stockMax;
    private double saldoCaja;
    private List<ProductoEnvasado> productosEnvasados;
    private List<ProductoBebida> bebidas;
    private List<ProductoLimpieza> productosLimpieza;

    public Tienda(String nombre, int stockMax, double saldoCaja) {
        this.nombre = nombre;
        this.stockMax = stockMax;
        this.saldoCaja = saldoCaja;
        productosEnvasados = new ArrayList<ProductoEnvasado>();
        productosLimpieza = new ArrayList<ProductoLimpieza>();
        bebidas = new ArrayList<ProductoBebida>();
    }

    public void realizarCompra(Producto producto) {
        agregarProducto(producto);
        actualizarSaldo(producto);
        actualizarStock(producto);
    }

    public void agregarProducto(Producto producto) {
        if (!validarStock(producto)) {
            System.out.println("No se pueden agregar nuevos productos a la tienda ya que se alcanzó el máximo de stock.");
            return;
        }
        if (!saldoSuficiente(producto)) {
            System.out.println("El producto no podrá ser agregado a la tienda por saldo insuficiente en la caja.");
            return;
        }
        if (producto instanceof ProductoEnvasado) {
            productosEnvasados.add((ProductoEnvasado) producto);
        } else if (producto instanceof ProductoBebida) {
            bebidas.add((ProductoBebida) producto);
        } else if (producto instanceof ProductoLimpieza) {
            productosLimpieza.add((ProductoLimpieza) producto);
        }
    }

    public boolean saldoSuficiente(Producto producto) {
        return saldoCaja >= producto.costoTotal();
    }

    public void actualizarSaldo(Producto producto) {
        if (saldoSuficiente(producto)) {
            saldoCaja -= producto.costoTotal();
        }
    }

    public int calcularStockTotal() {
        int stockTotal = 0;
        stockTotal += productosEnvasados.stream().mapToInt(Producto::getStock).sum();
        stockTotal += bebidas.stream().mapToInt(Producto::getStock).sum();
        stockTotal += productosLimpieza.stream().mapToInt(Producto::getStock).sum();
        return stockTotal;
    }

    public boolean validarStock(Producto producto) {
        return calcularStockTotal() + producto.getStock() <= stockMax;
    }

    public void actualizarStock(Producto producto) {
        stockMax -= producto.getStock();
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

//    public boolean validarProducto(Producto producto) {
//
//        return producto.getId() != null;
//    }

    public void realizarVenta(Producto producto, int cantidad) {

//        venderProducto();
//        imprimirDetalle();

    }
}
