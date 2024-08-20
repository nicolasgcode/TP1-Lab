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

    public static void validarStockVenta(Producto producto, int cantidad) {

        if (producto.getStock() > cantidad) {
            producto.setStock(producto.getStock() - cantidad);
        } else if (producto.getStock() == cantidad) {
            producto.setStock(0);
            producto.setDisponibleParaVenta(false);
        } else {
            System.out.println("Hay productos con stock disponible menor al solicitado.");
            producto.setStock(0);
            producto.setDisponibleParaVenta(false);
        }

    }

    public static void actualizarStock(Producto producto, Tienda tienda) {

        if (!validarStockMax(producto, tienda)) {
            System.out.println("No se pueden agregar nuevos productos a la tienda ya que se alcanzó el máximo de stock.");
            return;
        }

    }


}
