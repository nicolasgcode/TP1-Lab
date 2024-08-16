package logica;

public class Producto {

    protected String id;
    protected String descripcion;
    protected int stock;
    protected double precioUnidad;
    protected double porcentajeGanancia;
    protected boolean disponibleParaVenta;
    protected double porcentajeDto;

    public Producto() {
    }

    ;

    public Producto(String id, String descripcion, int stock, double precioUnidad, double porcGanancia, boolean disponibleParaVenta) {
        this.descripcion = descripcion;
        this.stock = stock;
        this.precioUnidad = precioUnidad;
        this.porcentajeGanancia = porcentajeGanancia;
        this.disponibleParaVenta = disponibleParaVenta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public double getPorcGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcGanancia(double porcGanancia) {
        this.porcentajeGanancia = porcGanancia;
    }

    public boolean isDisponibleParaVenta() {
        return disponibleParaVenta;
    }

    public void setDisponibleParaVenta(boolean disponibleParaVenta) {
        this.disponibleParaVenta = disponibleParaVenta;
    }

    public void aplicarDescuento(double porcentajeDto) {

        this.porcentajeDto = porcentajeDto;

    };

    public double costoTotal () {
        double costoTotal = precioUnidad * stock;
        return costoTotal;
    };

    public double calcularPrecioFinal() {
        return 0;
    }

    ;

    public boolean idValido(String id) {

        return id.matches("^[a-zA-Z0-9]{5}$");

    };
}
