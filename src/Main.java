import java.util.*;

public class Main {
    // Lista para almacenar las request
    private static List<Moneda> listaHistorialMonedas= new ArrayList<>();
    private static List<Float> listaHistorialDineroConvertido = new ArrayList<Float>();
    public static void main(String[] args) {
        //Scanner para lectura de teclado
        Scanner teclado = new Scanner(System.in);

        System.out.println("CHALLENGE - CONVERSOR DE MONEDAS");
        var opcion=0;
        int consultasRealizadas = 0;
        int i=0;
        String cantidad;

        //Ciclo while que permite realizazr varias consultas
        while(opcion != 7) {
            System.out.println("""
                    **********************************************************************
                                    Bienvenido Al Conversor de Monedas
                    **********************************************************************
                    1) Dolar --> Peso Mexicano
                    2) Peso Mexicano --> Dolar
                    3) Dolar --> Euro
                    4) Euro --> Peso Mexicano
                    5) Dolar --> Yen Japones
                    6) Peso Mexicanos --> Yen Japones
                    7) SALIR""");
            try { // Leemos la opcion del usuario
                  opcion = teclado.nextInt();
                  teclado.nextLine();
            }catch (InputMismatchException e) { // En caso de encontrar un error, finalizamos el programa
                System.out.println("Opcion no valida, Intenta de nuevo ");
                teclado.nextLine();
                continue; //Volvemos al inciio del while
            }
            // Si la opcion es valida entonces seguimos el flujo del programa
            if (opcion == 1) { // Opcion 1 -- DOLARES A PESOS MEXICANOS ( USD --> MXN)
                System.out.println("Ingresa la cantidad a convertir");
                cantidad = teclado.nextLine();
               if ( mostrarConversion(cantidad,"USD","MXN")){ // Si devuelve TRUE es que hubo un error en la funci[on
                   break;
               }
                consultasRealizadas++;
            } else if (opcion == 2) { // OPCION 2 -- DOLARES A PESOS (USD -- > MXN )
                System.out.println("Ingresa la cantidad a convertir");
                cantidad = teclado.nextLine();
                if ( mostrarConversion(cantidad,"MXN","USD")){ // Si devuelve TRUE es que hubo un error en la funci[on
                    break;
                }
                consultasRealizadas++;
            } else if (opcion == 3) { // Opcion 3 -- DOLARES A EUROS ( USD --> EUR)
                System.out.println("Ingresa la cantidad a convertir");
                cantidad = teclado.nextLine();
                if ( mostrarConversion(cantidad,"USD","EUR")){ // Si devuelve TRUE es que hubo un error en la funci[on
                    break;
                }
                consultasRealizadas++;
            } else if (opcion == 4) { // Opcion 4 -- EUROS A PESOS ( EUR --> MXN)
                System.out.println("Ingresa la cantidad a convertir");
                cantidad = teclado.nextLine();
                if ( mostrarConversion(cantidad,"EUR","MXN")){ // Si devuelve TRUE es que hubo un error en la funci[on
                    break;
                }
                consultasRealizadas++;
            } else if (opcion == 5) { // Opcion 5 -- DOLARES A YENES JAPONESES ( USD --> JPY)
                System.out.println("Ingresa la cantidad a convertir");
                cantidad = teclado.nextLine();
                if ( mostrarConversion(cantidad,"USD","JPY")){ // Si devuelve TRUE es que hubo un error en la funci[on
                    break;
                }
                consultasRealizadas++;
            } else if (opcion == 6) { // Opcion 6 -- YEMES JAPONESES A PESOS MEXICANOS ( MXN --> JPY)
                System.out.println("Ingresa la cantidad a convertir");
                cantidad = teclado.nextLine();
                if ( mostrarConversion(cantidad,"MXN","JPY")){ // Si devuelve TRUE es que hubo un error en la funci[on
                    break;
                }
                consultasRealizadas++;
            }
        }//Fin While
        // AL elegir la opcion 7 salimos del ciclo e imprimimos el historial
        System.out.println("------ Historial de conversiones --------");
        System.out.println("Consultas totales: "+consultasRealizadas);
        for (Moneda moneda : listaHistorialMonedas){ //Ciclo para imprimir el historial
            System.out.println("["+listaHistorialDineroConvertido.get(i)+"]"
                    +moneda.base_code()+"-->"+ moneda.target_code()+"["+moneda.conversion_result()+"]");
            i++;
        }
    }

    // FUncion utilizada para realizar la conversion y mostrar la conversion
    public static boolean mostrarConversion(String cantidad, String base, String target) {
        try {
            // CASO 1 -- DOLARES A PESOS (USD -- > MXN )
            var dineroParaCOnvertir = Float.valueOf(cantidad);
            listaHistorialDineroConvertido.add(Float.valueOf(dineroParaCOnvertir));
            ConsultaMoneda moneda = new ConsultaMoneda(base, target);
            Moneda monedaTarget = moneda.convierteMoneda(dineroParaCOnvertir);
            var conversion = moneda.getConversion(monedaTarget);
            moneda.mostrarConversion(dineroParaCOnvertir, moneda, monedaTarget);
            moneda.consultaTiempoRequest();
            listaHistorialMonedas.add(monedaTarget);
        } catch (NumberFormatException e) {
            System.out.println("CANTIDAD NO VALIDA, PRUEBE CON VALORES REALES");
            return true;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("FINALIZANDO PROGRAMA");
            return true;
        }
    return false;
    }


}
