package logica;

import interfaces.IComestible;

public class ProductoBebida extends Producto implements IComestible {
    private double gradAlcohol;
    private boolean esImportado;
    //private Date fechaVencimiento;
    //private double calorias.

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

    public ProductoBebida(String id, String descripcion, int stock, double precioUnidad, double porcentajeGanancia, boolean disponibleParaVenta, double gradAlcohol, boolean esImportado) {
        super(id, descripcion, stock, precioUnidad, porcentajeGanancia, disponibleParaVenta);
        if (!this.idValido(id)) {
            System.out.println("Id invalido");
            return;
        }
        this.id = id;
        this.gradAlcohol = gradAlcohol;
        this.esImportado = esImportado;
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
                ", id='" + id + '\'' +
                ", stock=" + stock +
                ", descripcion='" + descripcion + '\'' +
                ", precioUnidad=" + precioUnidad +
                ", porcentajeGanancia=" + porcentajeGanancia +
                ", disponibleParaVenta=" + disponibleParaVenta +
                '}';
    }
};

