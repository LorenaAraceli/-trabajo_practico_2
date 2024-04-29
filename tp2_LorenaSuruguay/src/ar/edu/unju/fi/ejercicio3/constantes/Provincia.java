package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
    JUJUY(672260, 673307, 53219),
    SALTA(1333365, 1214441, 155488),
    TUCUMAN(1694659, 1687305, 22524),
    CATAMARCA(367828, 367828, 102606),
    LA_RIOJA(331847, 331847, 89680),
    SANTIAGO_DEL_ESTERO(874006, 874006, 136351);

    private int cantidadPoblacion;
    private int superficie;

    Provincia(int cantidadPoblacion, int superficie, int i) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
    }

    public int getCantidadPoblacion() {
        return cantidadPoblacion;
    }

    public void setCantidadPoblacion(int cantidadPoblacion) {
        this.cantidadPoblacion = cantidadPoblacion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public double calcularDensidadPoblacional() {
        return (double) cantidadPoblacion / superficie;
    }
}