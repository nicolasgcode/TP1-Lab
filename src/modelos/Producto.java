package modelos;

public abstract class Producto {

    protected String id;
    protected String descripcion;
    protected int stock;
    protected double precioUnidad;
    protected double porcentajeGanancia;
    protected boolean disponibleParaVenta = true;
    protected double porcentajeDto;
    protected boolean esImportado;

    protected Producto(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia, boolean esImportado, double porcentajeDto) {
        if (idValido(id)) {
            this.descripcion = descripcion;
            this.stock = stock;
            this.precioUnidad = precioUnidad;
            this.porcentajeGanancia = porcentajeGanancia;
            this.esImportado = esImportado;
            this.porcentajeDto = porcentajeDto;
        }
    }

    protected Producto(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia, double porcentajeDto) {
        if (idValido(id)) {
            this.descripcion = descripcion;
            this.stock = stock;
            this.precioUnidad = precioUnidad;
            this.porcentajeGanancia = porcentajeGanancia;
            this.porcentajeDto = porcentajeDto;
        }
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
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

    public boolean esImportado() {
        return esImportado;
    }

    public void setDisponibleParaVenta(boolean disponibleParaVenta) {
        this.disponibleParaVenta = disponibleParaVenta;
    }

    public boolean DisponibleParaVenta() {

        return disponibleParaVenta;
    }

    public double getPorcentajeDto() {
        return porcentajeDto;
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
