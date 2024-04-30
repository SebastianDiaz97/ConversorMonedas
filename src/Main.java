import com.google.gson.Gson;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        Scanner lectura = new Scanner(System.in);
        int salir = 0;
        String opcionDesde = "" , opcionHacia = "", monto = "";
        GeneradorArchivo archivo = new GeneradorArchivo();


        String opcionesMonedas = "1. ARS - Peso argentino\n" +
                "2. BOB - Boliviano boliviano\n" +
                "3. BRL - Real brasileño\n" +
                "4. CLP - Peso chileno\n" +
                "5. COP - Peso colombiano\n" +
                "6. USD - Dólar estadounidense\n" +
                "7. Salir";

        while (salir != 7) {
            do {
                System.out.println("Elija una divisa desde la cual convertir: ");
                System.out.println(opcionesMonedas);
                opcionDesde = lectura.nextLine();
                try{
                    if (Integer.parseInt(opcionDesde) > 0 && Integer.parseInt(opcionDesde) <8) {
                        if (Integer.parseInt(opcionDesde) == 7){
                            salir = 7;
                            break;
                        }
                    }else {
                        throw new Exception("Exception thrown");
                    }
                }catch (Exception e){
                    System.out.println("ingrese un valor valido");
                    opcionDesde = "";
                }

            } while (opcionDesde.isEmpty());
            if (salir == 7) {
                break;
            }

            do {
                System.out.println("Elija una divisa a la cual convertir: ");
                System.out.println(opcionesMonedas);
                opcionHacia = lectura.nextLine();
                try {
                    if (Integer.parseInt(opcionHacia) > 0 && Integer.parseInt(opcionHacia) < 8) {
                        if (Integer.parseInt(opcionHacia) == 7) {
                            salir = 7;
                            break;
                        }
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("ingrese un valor valido");
                    opcionHacia = "";
                }
            } while (opcionHacia.isEmpty());
            if (salir == 7) {
                break;
            }

            do {
                System.out.println("Ingrese la cantidad a convertir: ");
                monto = lectura.nextLine();
                try {
                    Double.parseDouble(monto);
                } catch (Exception e) {
                    System.out.println("Ingrese un valor valido");
                    monto = "";
                }
            } while (monto.isEmpty());

            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            String formattedDate = date.format(myFormatObj);

            ConexionApi connexion = new ConexionApi();


            Monedas monedas = connexion.obtenerDatos(Integer.parseInt(opcionDesde),
                    Integer.parseInt(opcionHacia),
                    Double.parseDouble(monto));
            archivo.crearRegistro(monedas, formattedDate, Double.parseDouble(monto));
            System.out.println(monedas);



        }
    }
}