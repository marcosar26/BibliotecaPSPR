public abstract class Articulo {
    private final String codigo;
    private final String titulo;
    private final int year;

    public Articulo(String codigo, String titulo, int year) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.year = year;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getYear() {
        return year;
    }

    @Override
    public abstract String toString();

    public abstract boolean isReservado();
    public abstract void reservar(String numSocio);
    public abstract void quitarReserva();
}
