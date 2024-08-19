package logica;

public class OperacionesTienda {

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

    public static void realizarVenta() {
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
