public class Libro extends Articulo {
    private boolean reservado;
    private boolean alquilado;
    private String numSocio;

    public Libro(String codigo, String titulo, int year) {
        super(codigo, titulo, year);
        this.reservado = false;
        this.alquilado = false;
        this.numSocio = null;
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "---Libro---" + System.lineSeparator() + "Código: " + this.getCodigo() + System.lineSeparator() + "Título: " + this.getTitulo() + System.lineSeparator() + "Año: " + this.getYear() + System.lineSeparator() + "Está alquilado: " + this.alquilado + System.lineSeparator() + "Está reservada: " + this.reservado + System.lineSeparator() + "Número de socio: " + this.numSocio + System.lineSeparator();
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void alquilar(String numSocio) {
        this.alquilado = true;
        this.numSocio = numSocio;
    }

    public void quitarAlquiler() {
        this.alquilado = false;
        this.numSocio = null;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void reservar(String numSocio) {
        this.reservado = true;
        this.numSocio = numSocio;
    }

    public void quitarReserva() {
        this.reservado = false;
        this.numSocio = null;
    }
}
