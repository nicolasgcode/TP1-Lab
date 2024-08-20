package logica;

public class Stock {

    public static int calcularStockTotal(Tienda tienda) {

        return tienda.getProductos().stream().mapToInt(Producto::getStock).sum();

    }

    public static boolean validarStockMax(Tienda tienda) {
        return calcularStockTotal(tienda) + OperacionTienda.getMiCompra().stream().mapToDouble(Producto::getStock).sum() <= tienda.getStockMax();
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

    public static void actualizarStock(Tienda tienda) {

        if (!validarStockMax(tienda)) {
            System.out.println("No se pueden agregar nuevos productos a la tienda ya que se alcanzó el máximo de stock.");
            return;
        }

    }


}
