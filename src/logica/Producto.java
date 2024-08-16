package logica;

public class Producto {

    private String id;
    private String descripcion;
    private int stock;
    private double precioUnidad;
    private double porcGanancia;
    private boolean disponibleParaVenta;

    public Producto() {};

    public Producto(String id, String descripcion, int stock, double precioUnidad,double porcGanancia, boolean disponibleParaVenta) {
        this.id = id;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precioUnidad = precioUnidad;
        this.porcGanancia = porcGanancia;
        this.disponibleParaVenta = disponibleParaVenta;
    }

    public double aplicarDescuento () {

        return 0;

    };

    public double calcularPrecioFinal () {

        return 0;
    };

    public void validarId(){

    };
}
