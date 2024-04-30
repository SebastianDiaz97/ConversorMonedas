public record Monedas(double conversion_rate,
                      double conversion_result,
                      String base_code,
                      String target_code) {

    static GeneradorArchivo generadorArchivo = new GeneradorArchivo();

    @Override
    public String toString() {
        return "El valor "+generadorArchivo.redondeo(conversion_result() / conversion_rate())+" ["+base_code+
                "] corresponde al valor final de =>>> "+conversion_result+" ["+target_code+"]";
    }
}
