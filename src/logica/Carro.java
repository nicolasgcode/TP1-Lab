package logica;

import modelos.*;

import java.util.*;

public class Carro {

    private Map<Producto, Integer> carritoList = new HashMap<Producto, Integer>();
    private int total_carrito = 0;

    public Map<Producto, Integer> getCarrito() {
        return carritoList;
    }

    public void agregarAlCarrito(Producto p, int cantidad) {
        // int stock_prod = p.getStock();
        // if(stock_prod < cantidad){
        //     System.out.println(String.format("Cantidad de productos mayor a la cantidad de productos disponibles, se agregan solo %d al carrito", p.getStock()));
        //     cantidad = stock_prod;
        // }
        Producto temp = getProductoFromCarrito(p);
        if (temp == null) {
            carritoList.put(p, cantidad);
            return;
        }
        carritoList.put(p, carritoList.get(p) + cantidad);
        System.out.printf("Se agrega %d%n", cantidad);
    }

    private Producto getProductoFromCarrito(Producto p) {
        return carritoList.entrySet().stream().filter(prod -> prod.getKey().getId().equals(p.getId()))
                .map(Map.Entry::getKey).findFirst().orElse(null);
    }

    public List<Producto> getAllProducts() {
        return carritoList.entrySet().stream().map(Map.Entry::getKey).toList();
    }

    public int getCostoTotal() {
        carritoList.forEach((prod, cant) -> {
            total_carrito += prod.getPrecioUnidad() * cant;
        });
        return total_carrito;
    }

    public void emptyCarrito() {
        carritoList.clear();
    }
}
