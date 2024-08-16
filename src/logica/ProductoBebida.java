package logica;

public class ProductoBebida extends Producto {
    private double gradAlcohol;
    private boolean esImportado;

    public ProductoBebida() {};

    public ProductoBebida(String id, String descripcion, int stock, double precioUnidad, double porcGanancia, boolean disponibleParaVenta, double gradAlcohol, boolean esImportado) {
        super(id, descripcion, stock, precioUnidad, porcGanancia, disponibleParaVenta);
        this.gradAlcohol = gradAlcohol;
        this.esImportado = esImportado;
    }
}
