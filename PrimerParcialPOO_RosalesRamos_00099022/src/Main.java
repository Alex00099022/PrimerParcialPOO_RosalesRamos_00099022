import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<ElectronicItem> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar articulo");
            System.out.println("2. Modificar articulo");
            System.out.println("3. Consultar articulo");
            System.out.println("4. Salir");
            System.out.print("Ingrese su eleccion: ");
            choice = readIntInput();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addElectronicItem();
                    break;
                case 2:
                    modifyElectronicItem();
                    break;
                case 3:
                    displayInventory();
                    break;
                case 4:
                    System.out.println("Adios...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (choice != 4);
    }

    private static int readIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada invalida.  ");
            }
        }
    }

    private static void addElectronicItem() {
        System.out.println("\nAgregar articulo:");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Modelo: ");
        String model = scanner.nextLine();
        System.out.print("Descripcion: ");
        String description = scanner.nextLine();
        System.out.print("Precio: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.println("Seleccione el tipo de artículo:");
        System.out.println("1. Telefono movil");
        System.out.println("2. Laptop");
        int itemType = readIntInput();

        switch (itemType) {
            case 1:
                System.out.print("red (4G, 5G): "); //extra personalizado
                String networkType = scanner.nextLine();
                inventory.add(new MobilePhone(name, model, description, price, networkType));
                break;
            case 2:
                System.out.print("Procesador: "); //extra personalizado
                String processor = scanner.nextLine();
                inventory.add(new Laptop(name, model, description, price, processor));
                break;
            default:
                System.out.println("Tipo de articulo no valido.");
        }
        System.out.println("Articulo agregado.");
    }

    private static void modifyElectronicItem() {
        System.out.println("\nModificar articulo:");
        System.out.print("Ingrese el numero de registro del articulo que desea modificar: ");
        int index = readIntInput();

        if (index >= 1 && index <= inventory.size()) {
            ElectronicItem item = inventory.get(index - 1);
            System.out.println("¿Que quiere modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Modelo");
            System.out.println("3. Descripcion");
            System.out.println("4. Precio");
            System.out.println("5. Cancelar");
            int choice = readIntInput();

            switch (choice) {
                case 1:
                    System.out.print("Nuevo nombre: ");
                    String newName = scanner.nextLine();
                    ((AbstractElectronicItem) item).setName(newName);
                    break;
                case 2:
                    System.out.print("Nuevo modelo: ");
                    String newModel = scanner.nextLine();
                    ((AbstractElectronicItem) item).setModel(newModel);
                    break;
                case 3:
                    System.out.print("Nueva descripcion: ");
                    String newDescription = scanner.nextLine();
                    ((AbstractElectronicItem) item).setDescription(newDescription);
                    break;
                case 4:
                    System.out.print("Nuevo precio: ");
                    double newPrice = Double.parseDouble(scanner.nextLine());
                    ((AbstractElectronicItem) item).setPrice(newPrice);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println("Artículo modificado con exito.");
        } else {
            System.out.println("Numero invalido.");
        }
    }

    private static void displayInventory() {
        System.out.println("\nInventario:");
        for (int i = 0; i < inventory.size(); i++) {
            ElectronicItem item = inventory.get(i);
            System.out.println("\nRegistro " + (i+1) + ":");
            System.out.println("Nombre: " + item.getDescription());
            System.out.println("Modelo: " + item.getModel());
            System.out.println("Descripcion: " + item.getDescription());
            System.out.println("Precio: " + item.getPrice());
            if (item instanceof MobilePhone) {
                MobilePhone mobilePhone = (MobilePhone) item;
                System.out.println("red: " + mobilePhone.getNetworkType());
            } else if (item instanceof Laptop) {
                Laptop laptop = (Laptop) item;
                System.out.println("Procesador: " + laptop.getProcessor());
            }
        }
    }
}
