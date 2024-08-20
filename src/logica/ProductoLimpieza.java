package logica;

public class ProductoLimpieza extends Producto {

    private enum TipoAplicacion {COCINA, BANIO, ROPA, MULTIUSO}

    TipoAplicacion tipoAplicacion;

    public ProductoLimpieza(String id, String descripcion, int stock, double precioUnidad, double porcGanancia, String tipo) {
        super(id, descripcion, stock, precioUnidad, porcGanancia);
        if (!this.idValido(id)) {
            System.out.println("Id invalido");
            return;
        }
        if (!esTipoValido(tipo)) {
            System.out.println("Tipo invalido");
            return;
        }
        this.id = id;
        this.tipoAplicacion = TipoAplicacion.valueOf(tipo.toUpperCase());
        this.porcentajeGanancia = calcularPorcentajeGanancia(porcentajeGanancia);
    }

    @Override
    public boolean idValido(String id) {
        return super.idValido(id) && id.matches("AZ\\d{3}");
    }

    private boolean esTipoValido(String tipo) {
        if (tipo == null) {
            return false;
        }
        try {
            TipoAplicacion.valueOf(tipo.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public double calcularPorcentajeGanancia(double porcentajeGanancia) {

        if (!(tipoAplicacion.equals(TipoAplicacion.COCINA) || tipoAplicacion.equals(TipoAplicacion.MULTIUSO))) {
            return porcentajeGanancia;
        }
        if (!(10 <= porcentajeGanancia && porcentajeGanancia <= 25)) {
            System.out.println("El porcentaje de ganancia debe estar entre 0 y 20");
            return 0;
        }
        return porcentajeGanancia;
    }

    @Override
    public String toString() {
        return "ProductoLimpieza{" +
                "tipoAplicacion=" + tipoAplicacion +
                ", id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", precioUnidad=" + precioUnidad +
                ", porcGanancia=" + porcentajeGanancia +
                ", disponibleParaVenta=" + disponibleParaVenta +
                '}';
    }
}


