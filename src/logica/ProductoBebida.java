package logica;

import interfaces.IComestible;
import interfaces.IImportado;

import java.time.LocalDate;

public class ProductoBebida extends Producto implements IComestible, IImportado {
    private double gradAlcohol;
    private boolean esImportado;
    private String fechaVencimiento;
    private double calorias;

    public ProductoBebida() {
    }

    public ProductoBebida(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia, double gradAlcohol, boolean esImportado, double calorias, String fechaVencimiento) {
        super(id, descripcion, stock, precioUnidad, porcentajeGanancia);
        if (!this.idValido(id)) {
            System.out.println("Id invalido");
            return;
        }
        this.id = id;
        this.gradAlcohol = gradAlcohol;
        this.esImportado = esImportado;
        this.calorias = calcularCalorias(calorias);
        this.fechaVencimiento = fechaVencimiento;
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

    public void setGradAlcohol(double gradAlcohol) {
        this.gradAlcohol = gradAlcohol;
    }

    @Override
    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }

    @Override
    public double aplicarImpuesto() {
        return 0;
    }

    @Override
    public boolean getEsImportado() {
        return false;
    }

    @Override
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public void setFechaVencimiento(String fechaVencimiento) {

    }

    @Override
    public double getCalorias() {
        return calorias;
    }

    @Override
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }


    @Override
    public boolean idValido(String id) {
        return super.idValido(id) && id.matches("AC\\d{3}");
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

