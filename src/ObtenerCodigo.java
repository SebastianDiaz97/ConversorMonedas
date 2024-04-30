public class ObtenerCodigo {
    //        1. ARS - Peso argentino\n" +
//        "2. BOB - Boliviano boliviano\n" +
//                "3. BRL - Real brasileño\n" +
//                "4. CLP - Peso chileno\n" +
//                "5. COP - Peso colombiano\n" +
//                "6. USD - Dólar estadounidense\n" +
//                "7. Salir";
    public String obtenerCodigo(int numeroCodigo) {
        return switch (numeroCodigo) {
            case 1 -> "ARS";
            case 2 -> "BOB";
            case 3 -> "BRL";
            case 4 -> "CLP";
            case 5 -> "COP";
            case 6 -> "USD";
            default -> "";
        };
    }
}
