package logica;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class OperacionTienda {

    private static final int MAX_PRODUCTOS = 3;

    private static final int MAX_CANTIDAD = 12;

    private static double total = 0;

    private static List<Producto> miCompra = new ArrayList<Producto>();

    private static Map<Integer, Producto> miVenta = new HashMap<Integer, Producto>();

    public static void realizarCompra(Tienda tienda) {

        if (!saldoSuficiente(tienda)) {
            System.out.println("El producto no podrá ser agregado a la tienda por saldo insuficiente en la caja.");
            return;
        }
        Stock.actualizarStock(tienda);
        tienda.setProductos(miCompra);
        actualizarSaldo(tienda);
    }

    public static List<Producto> getMiCompra() {
        return miCompra;
    }

    public static void agregarParaCompra(Producto producto) {
        OperacionTienda.miCompra.add(producto);
    }

    public static Map<Integer, Producto> getMiVenta() {
        return miVenta;
    }

    public static void agregarParaVenta(int cantidad, Producto producto) {
        OperacionTienda.miVenta.put(cantidad, producto);
    }

    public static void realizarVenta() {
        validarVenta();
        imprimirDetalle();
    }

    public static void imprimirDetalle() {
        System.out.println("===========TICKET===========");
        miVenta.forEach((i, p) -> {
            System.out.println(
                    String.format("%s %s %d x %f", p.getId(), p.getDescripcion(), i, p.getPrecioUnidad()));
            total += i * p.getPrecioUnidad();
            if (p.esImportado) {
                total += (i * p.getPrecioUnidad()) * 0.12;
            }
        });
        System.out.println(String.format("Total venta $%f", total));
        System.out.println("============================");
    }

    public static void validarVenta() {

        if (MAX_PRODUCTOS < miVenta.size()) {
            System.out.println("Se ha alcanzado el máximo de productos posibles para una venta.");
            return;
        }

        miVenta.forEach((c, p) -> {
            if (c > MAX_CANTIDAD) {
                System.out.println("No se pueden vender más de 12 unidades por producto.");
                return;
            }
            Stock.validarStockVenta(p, c);
        });
    }

    public static boolean saldoSuficiente(Tienda tienda) {
        return tienda.getSaldoCaja() >= miCompra.stream().mapToDouble(Producto::costoTotal).sum();
    }

    public static void actualizarSaldoVenta(Tienda tienda) {
        tienda.setSaldoCaja(tienda.getSaldoCaja() + miCompra.stream().mapToDouble(Producto::costoTotal).sum());

    }

    public static void actualizarSaldo(Tienda tienda) {
        if (saldoSuficiente(tienda)) {
            tienda.setSaldoCaja(tienda.getSaldoCaja() - miCompra.stream().mapToDouble(Producto::costoTotal).sum());
        }
    }

}
