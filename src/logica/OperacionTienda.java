package logica;

import java.util.HashMap;

import java.util.Map;

public class OperacionTienda {

    private static final int MAX_PRODUCTOS = 3;

    private static final int MAX_CANTIDAD = 12;

    private static double total = 0;

    private static Map<Integer, Producto> miVenta = new HashMap<Integer, Producto>();

    public static void realizarCompra(Tienda tienda, Producto producto) {

        if (!saldoSuficiente(producto, tienda)) {
            System.out.println("El producto no podrá ser agregado a la tienda por saldo insuficiente en la caja.");
            return;
        }

        Stock.actualizarStock(producto, tienda);

        if (producto instanceof ProductoEnvasado) {
            tienda.getProductosEnvasados().add((ProductoEnvasado) producto);
        } else if (producto instanceof ProductoBebida) {
            tienda.getBebidas().add((ProductoBebida) producto);
        } else {
            tienda.getProductosLimpieza().add((ProductoLimpieza) producto);
        }

        actualizarSaldo(producto, tienda);
    }

    public static Map<Integer, Producto> getMiVenta() {
        return miVenta;
    }

    public static void setMiVenta(int cantidad, Producto producto) {
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
//        miVenta.forEach((c, p) -> { p.getId()});
    }

    public static boolean saldoSuficiente(Producto producto, Tienda tienda) {
        return tienda.getSaldoCaja() >= producto.costoTotal();
    }

    public static void actualizarSaldo(Producto producto, Tienda tienda) {
        if (saldoSuficiente(producto, tienda)) {
            tienda.setSaldoCaja(tienda.getSaldoCaja() - producto.costoTotal());
        }
    }

}
