package logica;

import interfaces.IComestible;
import modelos.*;

import java.util.*;

public class OperacionTienda {

    private static final int MAX_PRODUCTOS = 3;

    private static final int MAX_CANTIDAD = 12;

    private static double total = 0;

    public static void Compra(Tienda tienda, Carro c) {
        int costo_total = c.getCostoTotal();
        if (!saldoSuficiente(tienda, costo_total)) {
            System.out.println("El producto no podrá ser agregado a la tienda por saldo insuficiente en la caja.");
            return;
        }
        Stock.agregarStock(tienda, c);
        double costo = calcularTotal(c, false);
        actualizarSaldo(tienda, -costo);
        imprimirTicket("COMPRA", c, tienda);
        clean(c);
    }

    public static void Venta(Tienda tienda, Carro c) {

        if (validarCantidadProductos(c)) {
            System.out.println("No se pueden vender más 3 productos.");
            return;
        }
        if (tienda.getProductos().size() == 0) {
            System.out.println("No hay productos en stock");
            return;
        }
        // c.getCarrito().forEach((prod, cant) -> {
        // if (validarCantidadMaximaPorProductos(cant)) {
        // c.getCarrito().put(prod, MAX_CANTIDAD);
        // Stock.validarStockVenta(tienda, prod, MAX_CANTIDAD);
        // return;
        // }
        // Stock.validarStockVenta(tienda, prod, cant);
        // });
        Stock.eliminarStock(tienda, c);
        double costo = calcularTotal(c, true);
        actualizarSaldo(tienda, costo);
        imprimirTicket("VENTA", c, tienda);
        clean(c);
    }

    public static void detalleTicket(Carro c) {
        c.getCarrito().forEach((prod, cant) -> {
            System.out.println(
                    String.format("%s %s %d x %.2f", prod.getId(), prod.getDescripcion(), cant,
                            prod.getPrecioUnidad()));
        });
    }

    public static void imprimirTicket(String detalle, Carro c, Tienda tienda) {
        System.out.println(String.format("===========TICKET %s===========", detalle));
        detalleTicket(c);
        System.out.println(String.format("Total $%.2f", total));
        System.out.println(String.format("Saldo en caja $%.2f", tienda.getSaldoCaja()));
        System.out.println("===================================");
    }

    private static boolean validarCantidadProductos(Carro c) {
        return c.getCarrito().size() > MAX_PRODUCTOS;
    }

    public static boolean validarCantidadMaximaPorProductos(int cant) {
        return cant > MAX_CANTIDAD;
    }

    public static boolean saldoSuficiente(Tienda tienda, int c) {
        return tienda.getSaldoCaja() >= c;
    }

    private static double calcularTotal(Carro c, boolean venta) {
        c.getCarrito().forEach((prod, cant) -> {
            total += cant * prod.getPrecioUnidad();
            if (venta) {
                total += (cant * prod.getPrecioUnidad()) * 0.12;
            }
        });
        return total;
    }

    public static void actualizarSaldo(Tienda tienda, double costo) {
        tienda.setSaldoCaja(tienda.getSaldoCaja() + costo);
    }

    private static void clean(Carro c) {
        total = 0;
        c.emptyCarrito();
    }

    public static Producto getProductoFromStock(Tienda tienda, Producto producto) {
        return tienda.getProductos().stream().filter(prod -> prod.getId().equals(producto.getId()))
                .findFirst()
                .orElse(null);
    }

    public static void obtenerComestiblesConMenorDescuento(Tienda tienda, double desc) {

        tienda.getProductos().stream()
                .filter(prod -> prod instanceof IComestible && prod.esImportado() == false
                        && prod.getPorcentajeDto() < desc)
                .sorted(Comparator.comparing(Producto::getPrecioUnidad)).forEach(p -> {
                    System.out.println(p.getDescripcion().toUpperCase());
                });
    }
}
