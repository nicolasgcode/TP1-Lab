package logica;

public class ProductoBebida extends Producto {
    private double gradAlcohol;
    private boolean esImportado;

    public ProductoBebida() {};

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

    public ProductoBebida(String id, String descripcion, int stock, double precioUnidad, double porcGanancia, boolean disponibleParaVenta, double gradAlcohol, boolean esImportado) {
        super(id, descripcion, stock, precioUnidad, porcGanancia, disponibleParaVenta);
        if (this.idValido(id)) {
            this.id = id;
        } else {
            System.out.println("Id invalido");
        }
        this.gradAlcohol = gradAlcohol;
        this.esImportado = esImportado;


    }
        @Override
        public boolean idValido(String id){
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
                ", porcGanancia=" + porcGanancia +
                ", disponibleParaVenta=" + disponibleParaVenta +
                '}';
    }
};

