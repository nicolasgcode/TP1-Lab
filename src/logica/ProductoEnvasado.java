package logica;

public class ProductoEnvasado extends Producto {
    private String tipoEnvase;
    private boolean esImportado;

    public ProductoEnvasado() {};

    public ProductoEnvasado(String id, String descripcion, int stock, double precioUnidad, double porcGanancia, boolean disponibleParaVenta, String tipoEnvase, boolean esImportado) {
        super(id,descripcion, stock, precioUnidad,porcGanancia, disponibleParaVenta );
        if (this.idValido(id)) {
            this.id = id;
        } else {
            System.out.println("Id invalido");
        }
        this.tipoEnvase = tipoEnvase;
        this.esImportado = esImportado;
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

    @Override
    public boolean idValido(String id){
        return super.idValido(id) && id.matches("AB\\d{3}");
    };

    @Override
    public String toString() {
        return "ProductoEnvasado{" +
                "tipoEnvase='" + tipoEnvase + '\'' +
                ", esImportado=" + esImportado +
                ", id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", precioUnidad=" + precioUnidad +
                ", porcGanancia=" + porcGanancia +
                ", disponibleParaVenta=" + disponibleParaVenta +
                '}';
    }
}
