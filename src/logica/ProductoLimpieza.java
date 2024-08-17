package logica;

public class ProductoLimpieza extends Producto {

    private enum TipoAplicacion {COCINA, BANIO, ROPA, MULTIUSO}

    TipoAplicacion tipoAplicacion;


    public ProductoLimpieza() {
    }

    public ProductoLimpieza(String id, String descripcion, int stock, double precioUnidad, double porcGanancia, boolean disponibleParaVenta, String tipo) {
        super(id, descripcion, stock, precioUnidad, porcGanancia, disponibleParaVenta);
        if (!this.idValido(id)) {
            System.out.println("Id invalido");
            return;
        }
        if (!esTipoValido(tipo)) {
            System.out.println("Tipo invalido");
            return;
        }
        this.id = id;
    }

    public TipoAplicacion getTipoAplicacion() {
        return tipoAplicacion;
    }

    public void setTipoAplicacion(TipoAplicacion tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
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


