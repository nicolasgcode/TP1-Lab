package logica;

import interfaces.IComestible;

public class ProductoEnvasado extends Producto implements IComestible {
    private String tipoEnvase;
    private boolean esImportado;
    //private Date fechaVencimiento;
    private double calorias;

    public ProductoEnvasado() {
    }

    public ProductoEnvasado(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia, boolean disponibleParaVenta, String tipoEnvase, boolean esImportado, double calorias) {
        super(id, descripcion, stock, precioUnidad, porcentajeGanancia, disponibleParaVenta);
        if (!this.idValido(id)) {
            System.out.println("Id invalido");
        } else {
            this.id = id;
            this.tipoEnvase = tipoEnvase;
            this.esImportado = esImportado;
            this.porcentajeGanancia = calcularPorcentajeGanancia(porcentajeGanancia);
        }
    }

    public double getCalorias() {
        return calorias;
    }

    public double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public boolean isEsImportado() {
        return esImportado;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }

    public double calcularPorcentajeGanancia(double porcentajeGanancia) {
        if (!(0 <= porcentajeGanancia && porcentajeGanancia <= 20)) {
            System.out.println("El porcentaje de ganancia debe estar entre 0 y 20");
        }
        return porcentajeGanancia;
    }

    public boolean validarDesc() {
        return 0 <= porcentajeDto && porcentajeDto <= 15;
    }

    @Override
    public void aplicarDescuento(double porcentajeDto) {
        if (!validarDesc()) {
            System.out.println("El porcentaje de descuento descuento debe estar entre 0 y 15");
        }
        this.porcentajeDto = porcentajeDto;

    }

    @Override
    public boolean idValido(String id) {
        return super.idValido(id) && id.matches("AB\\d{3}");
    }

    @Override
    public String toString() {
        return "ProductoEnvasado{" +
                "tipoEnvase='" + tipoEnvase + '\'' +
                ", esImportado=" + esImportado +
                ", id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", precioUnidad=" + precioUnidad +
                ", porcGanancia=" + porcentajeGanancia +
                ", disponibleParaVenta=" + disponibleParaVenta +
                '}';
    }
}
