import logica.*;

public class TestTienda {
    public static void main(String[] args) {

//        ProductoEnvasado productoEnvasado = new ProductoEnvasado("AB123", "desc", 5, 3, 15, true, "plastico", true, 100);
//
//        System.out.println(productoEnvasado.toString());
//
//        System.out.println(productoEnvasado.getPorcentajeGanancia());

        ProductoLimpieza pl = new ProductoLimpieza("AZ444", "desc", 5, 3.5, 27, true, "multiuso");
        System.out.println(pl.getTipoAplicacion());
//        System.out.println(pl.validarTipo());

        System.out.println(pl.getPorcentajeGanancia());

//        ProductoBebida productoBebida = new ProductoBebida("AC123", "Gancia", 6, 50, 2.3, true, 2.1, true, 100);
//
//        System.out.println(productoBebida.getCalorias());
//        Tienda t = new Tienda("Shop", 100, 100);
//
//        ProductoEnvasado pe = new ProductoEnvasado("AB123", "Fideos", 60, 20, 2.5, true, "Plastico", true);
//
//        System.out.println(pe);
//
//        System.out.println("El costo total del producto es: " + pe.costoTotal());
//
//        System.out.println("El estado actual de la tienda es: " + t.toString());
//
//        t.realizarCompra(pe);
//
//        System.out.println("El estado de la tienda luego de la compra es: " + t.toString());

    }


}
