package logica;

import modelos.Producto;
import modelos.Tienda;

public class Stock {

    public static boolean validarStockMax(Tienda tienda) {
        return tienda.getProductos().stream().mapToInt(Producto::getStock).sum() <= tienda.getStockMax();
    }

    public static void eliminarStock(Tienda tienda, Carro c) {
        c.getCarrito().forEach((p, cant) -> {
            Producto prod = OperacionTienda.getProductoFromStock(tienda, p);
            if (cant > prod.getStock()) {
                System.out.println("Hay productos con stock disponible menor al solicitado.");
                prod.setDisponibleParaVenta(false);
                c.getCarrito().put(p, prod.getStock());
                prod.setStock(0);
                return;
            }
            if (OperacionTienda.validarCantidadMaximaPorProductos(cant)) {
                System.out.println("Solo 12");
                c.getCarrito().put(p, 12);
                prod.setStock(prod.getStock() - 12);
                return;
            }
            if (prod.getStock() > cant) {
                prod.setStock(prod.getStock() - cant);
                return;
            }
            if (prod.getStock() == cant) {
                prod.setDisponibleParaVenta(false);
                prod.setStock(0);
                return;
            }

        });
    }

    public static void agregarStock(Tienda tienda, Carro c) {
        if (!validarStockMax(tienda)) {
            System.out
                    .println("No se pueden agregar nuevos productos a la tienda ya que se alcanzó el máximo de stock.");
            return;
        }
        c.getCarrito().forEach((p, cant) -> {
            if (OperacionTienda.getProductoFromStock(tienda, p) == null) {
                p.setStock(cant);
                tienda.getProductos().add(p);
                return;
            }
            p.setStock(OperacionTienda.getProductoFromStock(tienda, p).getStock() + cant);
            tienda.getProductos().set(tienda.getProductos().indexOf(p), p);
        });
    }
}

