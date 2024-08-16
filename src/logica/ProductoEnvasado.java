package logica;

public class ProductoEnvasado extends Producto {
    private String tipoEnvase;
    private boolean esImportado;

    public ProductoEnvasado() {};

    public ProductoEnvasado(String id, String descripcion, int stock, double precioUnidad, double porcGanancia, boolean disponibleParaVenta, String tipoEnvase, boolean esImportado) {
        super(id,descripcion, stock, precioUnidad,porcGanancia, disponibleParaVenta );
        this.tipoEnvase = tipoEnvase;
        this.esImportado = esImportado;
    }


}
