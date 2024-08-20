package logica;

public abstract class Producto {

    protected String id;
    protected String descripcion;
    protected int stock;
    protected double precioUnidad;
    protected double porcentajeGanancia;
    protected boolean disponibleParaVenta = true;
    protected double porcentajeDto;
    protected boolean esImportado;

    protected Producto(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia, boolean esImportado) {
        if (idValido(id)) {
            this.descripcion = descripcion;
            this.stock = stock;
            this.precioUnidad = precioUnidad;
            this.porcentajeGanancia = porcentajeGanancia;
            this.esImportado = esImportado;
        }
    }

    protected Producto(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia) {
        if (idValido(id)) {
            this.descripcion = descripcion;
            this.stock = stock;
            this.precioUnidad = precioUnidad;
            this.porcentajeGanancia = porcentajeGanancia;
        }
    }

    protected String getId() {
        return id;
    }

    protected String getDescripcion() {
        return descripcion;
    }

    protected int getStock() {
        return stock;
    }

    protected void setStock(int stock) {

        this.stock = stock;
    }

    public double getPrecioUnidad() {

        return precioUnidad;
    }

    public boolean esImportado() {
        return esImportado;
    }

    public void setDisponibleParaVenta(boolean disponibleParaVenta) {
        this.disponibleParaVenta = disponibleParaVenta;
    }

    public boolean DisponibleParaVenta() {

        return disponibleParaVenta;
    }

    protected void aplicarDescuento(double porcentajeDto) {

        this.porcentajeDto = porcentajeDto;

    }

    public double costoTotal() {
        return precioUnidad * stock;
    }

    protected double calcularPrecioFinal() {
        return costoTotal() - porcentajeDto;
    }

    protected boolean idValido(String id) {

        return id.matches("^[a-zA-Z0-9]{5}$");

    }

}
