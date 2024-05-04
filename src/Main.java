import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("CHALLENGE - CONVERSOR DE MONEDAS");
        var opcion=0;
        String cantidad;
        float conversion;

        while(opcion != 7) {
            System.out.println("""
                    **********************************************************************
                                    Bienvenido Al Conversor de Monedas
                    **********************************************************************
                    1) Dolar --> Peso Mexicano
                    2) Pesos Mexicano --> Dolar
                    3) Dolar --> Euro
                    4) Euro --> Peso Mexicano
                    5) Dolar --> Yen
                    6) Yen --> Pesos Mexicano
                    7) SALIR
                    """);
            try { // Leemos la opcion del usuario
                  opcion = teclado.nextInt();
                  teclado.nextLine();
            }catch (InputMismatchException e) { // En caso de encontrar un error, finalizamos el programa
                System.out.println("Opcion no valida, Finalizando el programa");
                break;
            }
            // Si la opcion es valida entonces seguimos el flujo del programa

            if (opcion == 1) {
                System.out.println("Ingresa la cantidad a convertir");
                try{
                    // CASO 1 -- DOLARES A PESOS (USD -- > MXN )
                    cantidad = teclado.nextLine();
                    ConsultaMoneda moneda = new ConsultaMoneda("USD","MXN");
                    Moneda monedaTarget = moneda.convierteMoneda(Float.valueOf(cantidad));
                    conversion = moneda.getConversion(monedaTarget);
                    moneda.mostrarConversion(Float.valueOf(cantidad),moneda,monedaTarget);
                }catch(NumberFormatException e ){
                    System.out.println("CANTIDAD NO VALIDA, PRUEBE CON VALORES REALES");
                }catch (RuntimeException e ){
                    System.out.println(e.getMessage());
                    System.out.println("FINALIZANDO PROGRAMA");
                    break;
                }

            } else if (opcion == 2) { // CASO 1 -- DOLARES A PESOS (USD -- > MXN )

            } else if (opcion == 3) {
            } else if (opcion == 4) {
            } else if (opcion == 5) {
            } else if (opcion == 6) {
            }


        }


        

    }
}
