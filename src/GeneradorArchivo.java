import java.io.*;

public class GeneradorArchivo {
    int lines = 0;

    public void crearRegistro(Monedas monedas, String fecha, double cantidad) throws IOException {
       if (lines == 0){
           obtenerLineas();
       }
        lines++;

        double result = redondeo(monedas.conversion_result());

        String registro = lines + ". From: " + monedas.base_code() + ", to: " + monedas.target_code() + ", qty: " +
                cantidad + ", conversion: " + result + ", Date: " + fecha+"\n";
        FileWriter fw = new FileWriter("registro.txt", true);
        fw.write(registro);
        fw.close();
    }

    public void obtenerLineas() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("registro.txt"));
            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (Exception _) {
        }

    }

    public double redondeo(double monto){
        double result1 = monto * 1000;
        double result2 = Math.round(result1);
        return result2 / 1000;
    }

}