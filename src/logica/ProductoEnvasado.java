package logica;

import interfaces.IComestible;

public class ProductoEnvasado extends Producto implements IComestible {
    private String tipoEnvase;
    private String fechaVencimiento;
    private double calorias;

    public ProductoEnvasado(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia, String tipoEnvase, boolean esImportado, String fechaVencimiento, double calorias) {
        super(id, descripcion, stock, precioUnidad, porcentajeGanancia, esImportado);
        if (!this.idValido(id)) {
            System.out.println("Id invalido");
        } else {
            this.id = id;
            this.tipoEnvase = tipoEnvase;
            this.esImportado = esImportado;
            this.fechaVencimiento = fechaVencimiento;
            this.porcentajeGanancia = calcularPorcentajeGanancia();
            this.calorias = calorias;
        }
    }

    @Override
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public double getCalorias() {
        return calorias;
    }

    public boolean getEsImportado() {
        return esImportado;
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

    public double calcularPorcentajeGanancia() {
        return IComestible.super.calcularPorcentajeGanancia(this.porcentajeGanancia);
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
