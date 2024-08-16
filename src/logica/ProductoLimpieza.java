package logica;

public class ProductoLimpieza extends Producto{

    private enum tipoAplicacion {COCINA, BANIO, ROPA, MULTIUSO}

    public ProductoLimpieza() {};

    public ProductoLimpieza(String id, String descripcion, int stock, double precioUnidad, double porcGanancia, boolean disponibleParaVenta, String tipoAplicacion) {
        super(id, descripcion, stock, precioUnidad, porcGanancia, disponibleParaVenta);

    }

}
