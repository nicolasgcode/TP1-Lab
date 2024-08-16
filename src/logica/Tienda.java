package logica;

import java.util.List;

public class Tienda {
    private String nombre;
    private int stockMax;
    private double saldoCaja;
    private List<Producto> productos;
//    private List<ProductoEnvasado> productosEnvasados;
//    private List<ProductoBebida> productosBebidas;
//    private List<ProductoLimpieza> productosLimpiezas;

    public Tienda(String nombre, int stockMax, double saldoCaja) {};

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        stockMax--;
    };


    //actualizarSaldo

    //RealizarVenta
}
