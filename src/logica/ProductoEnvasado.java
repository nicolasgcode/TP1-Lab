package logica;

import interfaces.IComestible;

public class ProductoEnvasado extends Producto implements IComestible {
    private String tipoEnvase;
    private String fechaVencimiento;
    private double calorias;

    public ProductoEnvasado() {
    }

    public ProductoEnvasado(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia, String tipoEnvase, boolean esImportado, String fechaVencimiento, double calorias) {
        super(id, descripcion, stock, precioUnidad, porcentajeGanancia, esImportado);
        if (!this.idValido(id)) {
            System.out.println("Id invalido");
        } else {
            this.id = id;
            this.tipoEnvase = tipoEnvase;
            this.esImportado = esImportado;
            this.fechaVencimiento = fechaVencimiento;
            this.porcentajeGanancia = calcularPorcentajeGanancia(porcentajeGanancia);
            this.calorias = calorias;
        }
    }


    @Override
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public double getCalorias() {
        return calorias;
    }

    @Override
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }


    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public boolean getEsImportado() {
        return esImportado;
    }


    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }

    public double aplicarImpuesto() {
        return 0;
    }

    public double calcularPorcentajeGanancia(double porcentajeGanancia) {
        if (!(0 <= porcentajeGanancia && porcentajeGanancia <= 20)) {
            System.out.println("El porcentaje de ganancia debe estar entre 0 y 20");
            return 0;
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
