package logica;

public abstract class Producto {

    protected String id;
    protected String descripcion;
    protected int stock;
    protected double precioUnidad;
    protected double porcentajeGanancia;
    protected boolean disponibleParaVenta;
    protected double porcentajeDto;
    protected boolean esImportado;

    public Producto() {

    }

    public Producto(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia, boolean esImportado) {
        if (idValido(id)) {
            this.descripcion = descripcion;
            this.stock = stock;
            this.precioUnidad = precioUnidad;
            this.porcentajeGanancia = porcentajeGanancia;
            this.esImportado = esImportado;
        }
    }

    public Producto(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia) {
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

    protected void setId(String id) {
        this.id = id;
    }

    protected String getDescripcion() {
        return descripcion;
    }

    protected void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    protected int getStock() {
        return stock;
    }

    protected void setStock(int stock) {
        this.stock = stock;
    }

    protected double getPrecioUnidad() {
        return precioUnidad;
    }

    protected void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    protected double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    protected void setPorcentajeGanancia(double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    protected boolean isEsImportado() {
        return esImportado;
    }

    public boolean isDisponibleParaVenta() {
        return disponibleParaVenta;
    }

    public void setDisponibleParaVenta(boolean disponibleParaVenta) {
        this.disponibleParaVenta = disponibleParaVenta;
    }

    public void aplicarDescuento(double porcentajeDto) {

        this.porcentajeDto = porcentajeDto;

    }

    public double costoTotal() {
        return precioUnidad * stock;
    }

    public double calcularPrecioFinal() {
        return costoTotal() - porcentajeDto;
    }

    public boolean idValido(String id) {

        return id.matches("^[a-zA-Z0-9]{5}$");

    }

}
