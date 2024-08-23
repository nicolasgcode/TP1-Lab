package logica;

import modelos.Producto;
import modelos.Tienda;

import java.util.List;

public class Stock {

    public static boolean validarStockMax(Tienda tienda, Carro c) {
        return c.getCarrito().values().stream()
                .mapToInt(v -> v)
                .sum() <= tienda.getStockMax() &&
                tienda.getProductos().stream()
                        .mapToInt(Producto::getStock)
                        .sum() <= tienda.getStockMax();
    }

    public static void eliminarStock(Tienda tienda, Carro c) {
        c.getCarrito().forEach((p, cant) -> {
            Producto prod = OperacionTienda.getProductoDelStock(tienda, p);
            if (cant > prod.getStock()) {
                prod.setDisponibleParaVenta(false);
                c.getCarrito().put(p, prod.getStock());
                prod.setStock(0);
                return;
            }
            if (OperacionTienda.validarCantidadMaximaPorProductos(cant)) {
                System.out.println("Solo se pueden vender 12 unidades por producto");
                prod.setStock(prod.getStock() - 12);
                c.getCarrito().put(p, 12);
                return;
            }
            if (prod.getStock() > cant) {
                prod.setStock(prod.getStock() - cant);
                return;
            }
            if (prod.getStock() == cant) {
                prod.setDisponibleParaVenta(false);
                c.getCarrito().remove(p);
                prod.setStock(0);
                return;
            }
        });
        for (Producto productos : tienda.getProductos()) {
            if (!productos.disponibleParaVenta()) {
                System.out.println(String.format("El producto %s %s no esta disponible", productos.getId(),
                        productos.getDescripcion()));
                c.getCarrito().remove(productos);
            }
        }
    }

    public static boolean agregarStock(Tienda tienda, Carro c) {
        if (!validarStockMax(tienda, c)) {
            System.out
                    .println("No se pueden agregar nuevos productos a la tienda ya que se alcanzó el máximo de stock.");
            return false;
        }
        c.getCarrito().forEach((p, cant) -> {
            if (OperacionTienda.getProductoDelStock(tienda, p) == null) {
                p.setStock(cant);
                tienda.getProductos().add(p);
                return;
            }
            p.setStock(OperacionTienda.getProductoDelStock(tienda, p).getStock() + cant);
            tienda.getProductos().set(tienda.getProductos().indexOf(p), p);
        });
        return true;
    }
}