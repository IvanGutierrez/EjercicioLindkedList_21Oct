import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> productos = new LinkedList<>();
        LinkedList<Integer> cantidades = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("\n1. Agregar Producto y Cantidad");
            System.out.println("2. Verificar si un Producto existe");
            System.out.println("3. Actualizar Cantidad de un Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Mostrar Productos y Cantidades");
            System.out.println("6. Verificar si la lista de productos está vacía");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1: // Agregar producto y cantidad
                    System.out.print("Ingrese el nombre del producto: ");
                    String producto = scanner.nextLine();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = scanner.nextInt();
                    agregarElementos(productos, producto, cantidades, cantidad);
                    break;

                case 2: // Verificar si el producto existe
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    producto = scanner.nextLine();
                    if (contieneElemento(productos, producto)) {
                        System.out.println("El producto " + producto + " está en la lista.");
                    } else {
                        System.out.println("El producto " + producto + " NO está en la lista.");
                    }
                    break;

                case 3: // Actualizar cantidad de producto
                    System.out.print("Ingrese el nombre del producto a actualizar: ");
                    producto = scanner.nextLine();
                    System.out.print("Ingrese la nueva cantidad: ");
                    cantidad = scanner.nextInt();
                    if (actualizarCantidadProducto(productos, cantidades, producto, cantidad)) {
                        System.out.println("La cantidad del producto " + producto + " ha sido actualizada.");
                    } else {
                        System.out.println("El producto " + producto + " no se encontró.");
                    }
                    break;

                case 4: // Eliminar producto
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    producto = scanner.nextLine();
                    eliminarProducto(productos, cantidades, producto);
                    System.out.println("Producto eliminado.");
                    break;

                case 5: // Mostrar productos y cantidades
                    mostrarElementosListas(productos, cantidades);
                    break;

                case 6: // Verificar si la lista está vacía
                    if (listaVacia(productos)) {
                        System.out.println("La lista de productos está vacía.");
                    } else {
                        System.out.println("La lista de productos no está vacía.");
                    }
                    break;

                case 7: // Salir
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }
        } while (opcion != 7);

        scanner.close();
    }

    public static <T, U> void agregarElementos(LinkedList<T> listaProducto, T elementoProducto,
                                            LinkedList<U> listaCantidad, U cantidadElementos){
        listaProducto.add(elementoProducto);
        listaCantidad.add(cantidadElementos);
    }

    public static <T> boolean contieneElemento(LinkedList<T> lista, T elemento){
        return lista.contains(elemento);
    }

    public static <T, U> boolean actualizarCantidadProducto(LinkedList<T> listaProductos,
                                              LinkedList<U> listaCantidad,
                                              T elementoProducto, U cantidadElementos){
        int indice = listaProductos.indexOf(elementoProducto);//Busca el indice del elemento a actualizar
        if (indice != -1) {  // Si el elemento existe en la lista
            listaCantidad.set(indice, cantidadElementos);  // Actualiza el elemento en la posición encontrada
            return true;  // Indica que la actualización fue exitosa
        }
        return false;  // Si no se encontró el elemento, devuelve false
    }

    public static <T, U> void eliminarProducto(LinkedList<T> listaProductos,
                                              LinkedList<U> listaCantidad,
                                              T elementoProducto){
        int indice = listaProductos.indexOf(elementoProducto);
        listaProductos.remove(elementoProducto);
        listaCantidad.remove(indice);
    }

    public static <T, U> void mostrarElementosListas(LinkedList<T> listaProductos,
                                                    LinkedList<U> listaCantidad){
        for (int i=0; i<listaProductos.size(); i++){
            System.out.print("Producto: " + listaProductos.get(i) + " --> ");
            System.out.println("Cantidad " + listaCantidad.get(i));
        }
    }

    public static<T> boolean listaVacia(LinkedList<T> listaProductos){
        return listaProductos.isEmpty();
    }
}