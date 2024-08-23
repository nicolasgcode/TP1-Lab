package interfaces;

public interface IComestible {
    String getFechaVencimiento();

    double getCalorias();

    default double calcularPorcentajeGanancia(double porcentajeGanancia) {
        if (!(0 <= porcentajeGanancia && porcentajeGanancia <= 20)) {
            System.out.println("El porcentaje de ganancia debe estar entre 0 y 20");
            return 0;
        }
        return porcentajeGanancia;
    }

}
