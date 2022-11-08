public class Pasatiempo extends Articulo {
    public Pasatiempo(String codigo, String titulo, int year) {
        super(codigo, titulo, year);
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "---Pasatiempo---" + System.lineSeparator() + "Código: " + this.getCodigo() + System.lineSeparator() + "Título: " + this.getTitulo() + System.lineSeparator() + "Año: " + this.getYear() + System.lineSeparator();
    }

    @Override
    public boolean isReservado() {
        return false;
    }

    @Override
    public void reservar(String numSocio) {
    }

    @Override
    public void quitarReserva() {
    }
}
