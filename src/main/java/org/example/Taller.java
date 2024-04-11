package org.example; // Declaración del paquete

import java.util.ArrayList;
import java.util.Scanner;

// Definición de la clase base Vehiculo
class Vehiculo {
    protected String matricula;
    protected String color;
    protected String marca;
    protected String reparacion; // Atributo adicional para indicar la reparación que necesita el vehículo

    // Constructor de la clase Vehiculo
    public Vehiculo(String matricula, String color, String marca) {
        this.matricula = matricula;
        this.color = color;
        this.marca = marca;
    }

    // Métodos para obtener los atributos del vehículo
    public String getMatricula() {
        return matricula;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getReparacion() {
        return reparacion;
    }

    // Método para establecer la reparación necesaria del vehículo
    public void setReparacion(String reparacion) {
        this.reparacion = reparacion;
    }

    // Método para representar el vehículo como una cadena de texto
    public String toString() {
        return "Clase: " + this.getClass().getSimpleName() + ", Matricula: " + matricula + ", Color: " + color + ", Marca: " + marca + ", Reparación: " + reparacion;
    }
}

// Clases específicas de cada tipo de vehículo, que heredan de la clase Vehiculo
class Coche extends Vehiculo {
    public Coche(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }
}

class Moto extends Vehiculo {
    public Moto(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }
}

class Camion extends Vehiculo {
    public Camion(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }
}

class Tractor extends Vehiculo {
    public Tractor(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }
}

class Grua extends Vehiculo {
    public Grua(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }
}

// Clase principal Taller
public class Taller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Objeto Scanner para entrada de datos
        ArrayList<Vehiculo> vehiculos = new ArrayList<>(); // Lista para almacenar vehículos

        int opcion; // Variable para almacenar la opción del usuario
        do {
            // Menú de opciones
            System.out.println("Menú:");
            System.out.println("1. ¿Qué vehículo entra?");
            System.out.println("2. ¿Qué hay que reparar?");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt(); // Leer la opción del usuario

            switch (opcion) {
                case 1: // Opción para añadir un vehículo al taller
                    System.out.println("¿Qué tipo de vehículo entra?");
                    System.out.println("1. Coche");
                    System.out.println("2. Moto");
                    System.out.println("3. Camión");
                    System.out.println("4. Tractor");
                    System.out.println("5. Grua");
                    int tipoVehiculo = scanner.nextInt(); // Leer el tipo de vehículo
                    scanner.nextLine(); // Limpiar el buffer del scanner

                    // Solicitar información del vehículo al usuario
                    System.out.print("Ingrese la matrícula del vehículo: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Ingrese el color del vehículo: ");
                    String color = scanner.nextLine();
                    System.out.print("Ingrese la marca del vehículo: ");
                    String marca = scanner.nextLine();

                    // Crear el vehículo correspondiente según el tipo seleccionado
                    switch (tipoVehiculo) {
                        case 1:
                            vehiculos.add(new Coche(matricula, color, marca));
                            break;
                        case 2:
                            vehiculos.add(new Moto(matricula, color, marca));
                            break;
                        case 3:
                            vehiculos.add(new Camion(matricula, color, marca));
                            break;
                        case 4:
                            vehiculos.add(new Tractor(matricula, color, marca));
                            break;
                        case 5:
                            vehiculos.add(new Grua(matricula, color, marca));
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;
                case 2: // Opción para especificar la reparación de un vehículo
                    System.out.println("Seleccione el vehículo que necesita reparación:");
                    for (int i = 0; i < vehiculos.size(); i++) {
                        System.out.println((i + 1) + ". " + vehiculos.get(i));
                    }
                    int seleccion = scanner.nextInt(); // Leer la selección del usuario
                    scanner.nextLine(); // Limpiar el buffer del scanner

                    if (seleccion > 0 && seleccion <= vehiculos.size()) {
                        System.out.print("¿Qué hay que reparar en el vehículo seleccionado?: ");
                        String reparacion = scanner.nextLine(); // Leer la reparación necesaria
                        vehiculos.get(seleccion - 1).setReparacion(reparacion); // Establecer la reparación en el vehículo seleccionado
                    } else {
                        System.out.println("Selección inválida.");
                    }
                    break;
                case 3: // Opción para salir del programa
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3); // Continuar mostrando el menú hasta que el usuario seleccione la opción de salir
        scanner.close(); // Cerrar el objeto Scanner
    }
}
