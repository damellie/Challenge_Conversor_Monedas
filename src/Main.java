import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("CHALLENGE - CONVERSOR DE MONEDAS");
        var opcion=0;
        String cantidad;
        
        while(opcion != 7) {
            System.out.println("""
                    **********************************************************************
                                    Bienvenido Al Conversor de Monedas
                    **********************************************************************
                    1) Dolar --> Peso Mexicano
                    2) Pesos Mexicano --> Dolar
                    3) Dolar --> Euro
                    4) Euro --> Peso Mexicano
                    5) Dolar --> Yen Japones
                    6) Pesos Mexicanos --> Yen Japones
                    7) SALIR""");
            try { // Leemos la opcion del usuario
                  opcion = teclado.nextInt();
                  teclado.nextLine();
            }catch (InputMismatchException e) { // En caso de encontrar un error, finalizamos el programa
                System.out.println("Opcion no valida, Intenta de nuevo ");
                teclado.nextLine();
                continue;

            }
            // Si la opcion es valida entonces seguimos el flujo del programa

            if (opcion == 1) { // Opcion 1 -- DOLARES A PESOS MEXICANOS ( USD --> MXN)
                System.out.println("Ingresa la cantidad a convertir");
                cantidad = teclado.nextLine();
               if ( mostrarConversion(cantidad,"USD","MXN")){ // Si devuelve TRUE es que hubo un error en la funci[on
                   break;
               }

            } else if (opcion == 2) { // OPCION 2 -- DOLARES A PESOS (USD -- > MXN )
                System.out.println("Ingresa la cantidad a convertir");
                cantidad = teclado.nextLine();
                if ( mostrarConversion(cantidad,"MXN","USD")){ // Si devuelve TRUE es que hubo un error en la funci[on
                    break;
                }
            } else if (opcion == 3) { // Opcion 3 -- DOLARES A EUROS ( USD --> EUR)
                System.out.println("Ingresa la cantidad a convertir");
                cantidad = teclado.nextLine();
                if ( mostrarConversion(cantidad,"USD","EUR")){ // Si devuelve TRUE es que hubo un error en la funci[on
                    break;
                }
            } else if (opcion == 4) { // Opcion 4 -- EUROS A PESOS ( EUR --> MXN)
                System.out.println("Ingresa la cantidad a convertir");
                cantidad = teclado.nextLine();
                if ( mostrarConversion(cantidad,"EUR","MXN")){ // Si devuelve TRUE es que hubo un error en la funci[on
                    break;
                }
            } else if (opcion == 5) { // Opcion 5 -- DOLARES A YENES JAPONESES ( USD --> JPY)
                System.out.println("Ingresa la cantidad a convertir");
                cantidad = teclado.nextLine();
                if ( mostrarConversion(cantidad,"USD","JPY")){ // Si devuelve TRUE es que hubo un error en la funci[on
                    break;
                }
            } else if (opcion == 6) { // Opcion 6 -- YEMES JAPONESES A PESOS MEXICANOS ( MXN --> JPY)
                System.out.println("Ingresa la cantidad a convertir");
                cantidad = teclado.nextLine();
                if ( mostrarConversion(cantidad,"MXN","JPY")){ // Si devuelve TRUE es que hubo un error en la funci[on
                    break;
                }
            }


        }


        

    }

    // FUncion utilizada para realizar la conversion y mostrar la conversion
    public static boolean mostrarConversion(String cantidad, String base, String target) {
        try {
            // CASO 1 -- DOLARES A PESOS (USD -- > MXN )
            Float.valueOf(cantidad);
            ConsultaMoneda moneda = new ConsultaMoneda(base, target);
            Moneda monedaTarget = moneda.convierteMoneda(Float.valueOf(cantidad));
            var conversion = moneda.getConversion(monedaTarget);
            moneda.mostrarConversion(Float.valueOf(cantidad), moneda, monedaTarget);
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
