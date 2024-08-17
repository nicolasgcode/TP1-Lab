package logica;

import interfaces.IComestible;

import java.time.LocalDate;

public class ProductoBebida extends Producto implements IComestible {
    private double gradAlcohol;
    private boolean esImportado;
    private LocalDate fechaVencimiento;
    private double calorias;

    public ProductoBebida() {
    }

    public double getGradAlcohol() {
        return gradAlcohol;
    }

    public void setGradAlcohol(double gradAlcohol) {
        this.gradAlcohol = gradAlcohol;
    }

    public boolean isEsImportado() {
        return esImportado;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }

    public ProductoBebida(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia, boolean disponibleParaVenta, double gradAlcohol, boolean esImportado, double calorias) {
        super(id, descripcion, stock, precioUnidad, porcentajeGanancia, disponibleParaVenta);
        if (!this.idValido(id)) {
            System.out.println("Id invalido");
            return;
        }
        this.id = id;
        this.gradAlcohol = gradAlcohol;
        this.esImportado = esImportado;
        this.calorias = calcularCalorias(calorias);
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

    public double getCalorias() {
        return calorias;
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

