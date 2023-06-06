import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("----- Parqueadero -----");
            System.out.println("1. Ingresar un carro al parqueadero");
            System.out.println("2. Dar salida a un carro del parqueadero");
            System.out.println("3. Informar los ingresos del parqueadero");
            System.out.println("4. Consultar la cantidad de puestos disponibles");
            System.out.println("5. Avanzar el reloj del parqueadero");
            System.out.println("6. Cambiar la tarifa del parqueadero");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del carro: ");
                    String placa = sc.next();
                    int resultado = parqueadero.entrarCarro(placa);
                    if (resultado == Parqueadero.NO_HAY_PUESTO) {
                        System.out.println("El parqueadero está lleno");
                    } else if (resultado == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero está cerrado");
                    } else if (resultado == Parqueadero.CARRO_YA_EXISTE) {
                        System.out.println("Ya hay un carro con esa placa en el parqueadero");
                    } else {
                        System.out.println("Carro ingresado correctamente. Puesto asignado: " + resultado);
                    }
                    break;

                case 2:
                    System.out.print("Ingrese la placa del carro a sacar: ");
                    String placaSacar = sc.next();
                    int valorPagar = parqueadero.sacarCarro(placaSacar);
                    if (valorPagar == Parqueadero.CARRO_NO_EXISTE) {
                        System.out.println("El carro no se encuentra en el parqueadero");
                    } else if (valorPagar == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero está cerrado");
                    } else {
                        System.out.println("Carro sacado del parqueadero. Valor a pagar: " + valorPagar);
                    }
                    break;

                case 3:
                    int montoCaja = parqueadero.darTarifa() * parqueadero.darHoraActual();
                    System.out.println("Ingresos del parqueadero: " + montoCaja);
                    break;

                case 4:
                    int puestosLibres = parqueadero.calcularPuestosLibres();
                    System.out.println("Puestos disponibles: " + puestosLibres);
                    break;

                case 5:
                    parqueadero.avanzarHora();
                    System.out.println("Reloj avanzado");
                    break;

                case 6:
                    System.out.print("Ingrese la nueva tarifa: ");
                    int nuevaTarifa = sc.nextInt();
                    parqueadero.cambiarTarifa(nuevaTarifa);
                    System.out.println("Tarifa cambiada");
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                }
            }
        }
    }