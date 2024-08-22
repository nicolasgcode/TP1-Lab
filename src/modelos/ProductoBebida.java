package modelos;

import interfaces.IComestible;

public class ProductoBebida extends Producto implements IComestible {
    private double gradAlcohol;
    private String fechaVencimiento;
    private double calorias;

    public ProductoBebida(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia, double gradAlcohol, boolean esImportado, double calorias, String fechaVencimiento, double porcentajeDto) {
        super(id, descripcion, stock, precioUnidad, porcentajeGanancia, esImportado, porcentajeDto);
        if (!this.idValido(id)) {
            System.out.println("Id invalido");
            return;
        }
        this.id = id;
        this.gradAlcohol = gradAlcohol;
        this.esImportado = esImportado;
        this.calorias = calcularCalorias(calorias);
        this.fechaVencimiento = fechaVencimiento;
        this.porcentajeGanancia = calcularPorcentajeGanancia();
        aplicarDescuento(porcentajeDto);
    }

    public double calcularCalorias(double calorias) {
        if (gradAlcohol < 0) {
            System.out.println("Ingrese un número válido de calorías");
            return 0;
        }
        if (0 <= gradAlcohol && gradAlcohol <= 2) {
            return calorias;
        } else if (2.1 <= gradAlcohol && gradAlcohol <= 4.5) {
            return calorias * 1.25;
        } else if (gradAlcohol > 4.5) {
            return calorias * 1.5;
        }
        return calorias;
    }

    public double getGradAlcohol() {

        return gradAlcohol;
    }

    public boolean getEsImportado() {
        return esImportado;
    }

    @Override
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public double getCalorias() {
        return calorias;
    }

    @Override
    public boolean idValido(String id) {
        return super.idValido(id) && id.matches("AC\\d{3}");
    }

    public boolean validarDesc() {
        return 0 <= porcentajeDto && porcentajeDto <= 10;
    }

    public void aplicarDescuento(double porcentajeDto) {
        if (!validarDesc()) {
            System.out.println("El porcentaje de descuento descuento debe estar entre 0 y 10");
        }
        this.porcentajeDto = porcentajeDto;

    }

    public double calcularPorcentajeGanancia() {
        return IComestible.super.calcularPorcentajeGanancia(this.porcentajeGanancia);
    }

    @Override
    public String toString() {
        return "ProductoBebida{" +
                "gradAlcohol=" + gradAlcohol +
                ", esImportado=" + esImportado +
                ", fechaVencimiento=" + fechaVencimiento +
                ", calorias=" + calorias +
                '}';
    }
};

