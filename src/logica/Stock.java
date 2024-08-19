package logica;

public class Stock {

    public static int calcularStockTotal(Tienda tienda) {
        int stockTotal = 0;
        stockTotal += tienda.getProductosEnvasados().stream().mapToInt(Producto::getStock).sum();
        stockTotal += tienda.getBebidas().stream().mapToInt(Producto::getStock).sum();
        stockTotal += tienda.getProductosLimpieza().stream().mapToInt(Producto::getStock).sum();
        return stockTotal;
    }

    public static boolean validarStockMax(Producto producto, Tienda tienda) {
        return calcularStockTotal(tienda) + producto.getStock() <= tienda.getStockMax();
    }

    public static void validarStockVenta(Producto producto, Tienda tienda, int cantidad) {

        if (producto.getStock() < cantidad) {
            producto.setStock(producto.getStock() - cantidad);
        } else {
            producto.setStock(0);
            producto.setDisponibleParaVenta(false);
        }

    }

    public static void actualizarStockCompra(Producto producto, Tienda tienda) {

        if (!validarStockMax(producto, tienda)) {
            return;
        }

        if (!tienda.saldoSuficiente(producto)) {
            return;
        }

        if (producto instanceof ProductoEnvasado) {
            tienda.getProductosEnvasados().add((ProductoEnvasado) producto);
        } else if (producto instanceof ProductoBebida) {
            tienda.getBebidas().add((ProductoBebida) producto);
        } else {
            tienda.getProductosLimpieza().add((ProductoLimpieza) producto);
        }

    }

    public static void actualizarStockVenta(Producto producto, Tienda tienda) {


    }

}
