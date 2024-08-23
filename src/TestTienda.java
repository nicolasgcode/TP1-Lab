import logica.*;
import modelos.*;

public class TestTienda {
    public static void main(String[] args) {

        //Instanciación del carro de compra y venta
        Carro c = new Carro();

//      Instanciación de productos varios para realizar las operaciones de la tienda (CU 4, CU 5, CU 6)

        ProductoEnvasado p1 = new ProductoEnvasado("AB123", "Fideos", 9, 2, 2.3, "plastico", false, "19/8/2024", 100, 6);
        ProductoEnvasado p2 = new ProductoEnvasado("AB124", "Arroz", 20, 1, 2.3, "plastico", true, "12/13/12", 150, 3);
        ProductoEnvasado p3 = new ProductoEnvasado("AB126", "Vino", 9, 5, 2.3, "plastico", false, "19/8/2024", 100, 4);
        ProductoEnvasado p4 = new ProductoEnvasado("AB127", "Lentejas", 20, 1, 2.3, "plastico", false, "12/13/12", 150, 13);
        ProductoLimpieza p5 = new ProductoLimpieza("AZ456", "Lavandina", 3, 7.6, 2.1, "banio", 3.2);

        //CU 1: Intento de instanciar producto envasado con identificador invalido (Debe ser ABXXX)
//        ProductoEnvasado envasado = new ProductoEnvasado("NA123", "Fideos", 9, 2, 2.3, "plastico", false, "19/8/2024", 100, 6);

        //CU 2: Intento de instanciar producto bebida con identificador invalido (Debe ser ACXXX)
//        ProductoBebida bebida = new ProductoBebida("AN123", "Fideos", 9, 2, 2.3, 0, false, 100, "26/05/18", 6);

        //CU 3: Intento de instanciar producto limpieza con identificador invalido (Debe ser AZXXX)
//        ProductoLimpieza limpieza = new ProductoLimpieza("AN123", "Fideos", 9, 2, 2.3, "banio", 3);

        //CU 4: Compra exitosa
        Tienda t = new Tienda("GenericShop", 100, 1000);
        c.agregarAlCarrito(p1, 15);
        c.agregarAlCarrito(p2, 15);
        c.agregarAlCarrito(p3, 15);
        c.agregarAlCarrito(p4, 15);
        c.agregarAlCarrito(p5, 15);
        OperacionTienda.Compra(t, c);

        //CU 4.a: Intento de compra con saldo insuficiente
//        Tienda t = new Tienda("GenericShop", 100, 10);
//        c.agregarAlCarrito(p2, 15);
//        c.agregarAlCarrito(p1, 15);
//        OperacionTienda.Compra(t, c);

        //CU 4.b: Intento de compra cuando se ha alcanzado el stock máximo de la tienda
//        Tienda t = new Tienda("GenericShop", 5, 1000);
//        c.agregarAlCarrito(p2, 15);
//        OperacionTienda.Compra(t, c);


//----------------------------------------------------------------------------------------------------------------------


        //NOTA: PARA REALIZAR LOS CASOS DE USO DE VENTA Y OBTENER PRODUCTOS CON MENOR DESCUENTO,
        // PRIMERO SE DEBE REALIZAR UNA COMPRA EXITOSA (CU 4)
        // PARA USAR LOS PRODUCTOS DE LA TIENDA

        //CU 5: Venta exitosa
        c.agregarAlCarrito(p1, 10);
        c.agregarAlCarrito(p2, 10);
        OperacionTienda.Venta(t, c);

        //CU 5.a: Intento de venta con más de 3 productos
//        c.agregarAlCarrito(p1, 13);
//        c.agregarAlCarrito(p2, 15);
//        c.agregarAlCarrito(p3, 13);
//        c.agregarAlCarrito(p4, 13);
//        OperacionTienda.Venta(t, c);

        //CU 5.b: Intento de venta con más de 12 unidades por producto
//        c.agregarAlCarrito(p1, 15);
//        c.agregarAlCarrito(p3, 13);
//        c.agregarAlCarrito(p4, 15);
//        OperacionTienda.Venta(t, c);

        //CU 5.c: Intento de venta con producto no disponible
//        c.agregarAlCarrito(p2, 15);
//        OperacionTienda.Venta(t, c);
//        c.agregarAlCarrito(p2, 15);
//        OperacionTienda.Venta(t, c);

        //CU 6:Obtener comestibles con menor descuento
//        System.out.println(OperacionTienda.obtenerComestiblesConMenorDescuento(t, 7));

    }

}