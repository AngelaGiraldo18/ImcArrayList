package paquetearralist;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProcesosArrayList {
    Double imc, peso, talla;
    String nombre = "";
    ArrayList<String> nombreList;
    ArrayList<String> resultList;
 
    int cant;
    String result = "";
    String nombrebuscar = "";

    public void iniciar() {
        System.out.println("entra a iniciar");

        resultList = new ArrayList<String>();
        nombreList = new ArrayList<String>();
       
        registrar();
    }

    public void menu() {
        System.out.println("entra a menu");
        String menu = "LISTA DE OPCIONES\n";
        menu += "1. Registrar otra persona\n";
        menu += "2. Buscar por nombre\n";
        menu += "3. Imprimir lista\n";
        menu += "4. Actualizar los datos\n";
        menu += "5. Eliminar datos\n";
        menu += "6. Salir\n";

        int opc = 0;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
            validarOpcion(opc);
        } while (opc != 6);

    }

    public void validarOpcion(int opc) {
        System.out.println("entra a validar opcion");
        switch (opc) {
            case 1:
                registrar();
                break;
            case 2:
                buscarNombre();
                break;

            case 3:
                imprimir();
                break;
            case 4:
                actualizar();
                break;

            case 5:
                eliminar();
                break;

            case 6:
                JOptionPane.showMessageDialog(null, "Chao!", "Gracias por usar el sistema", JOptionPane.CLOSED_OPTION);
                break;

            default:
                JOptionPane.showMessageDialog(null, "¡No existe el código! " + opc, "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                break;
        }
        
    }

    public void registrar() {
        cant = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas personas desea registrar?"));

        String resp = "";

        for (int i = 0; i < cant; i++) {
            System.out.println("Ingresa a registrar");
            nombre = JOptionPane.showInputDialog("Ingrese su nombre");
            peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su peso"));
            talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su talla"));

            nombreList.add(nombre);
            
            
            resultadoIMC();
        }

        resp = JOptionPane.showInputDialog("¿Desea registrar otra persona? (si/no)");

        if (resp.equalsIgnoreCase("si")) {
            registrar();
        } else {
            menu();
        }
    }

    public void resultadoIMC() {
    	
        imc = peso / (talla * talla);
        
        if (imc < 18) {
            resultList.add("Tiene anorexia");
        } else if (imc >= 18 && imc < 20) {
            resultList.add("Tiene delgadez");
        } else if (imc >= 20 && imc < 27) {
            resultList.add("Normalidad");
        } else if (imc <= 27 && imc < 30) {
            resultList.add("Obesidad (grado uno)");
        } else if (imc >= 30 && imc < 35) {
            resultList.add("Tiene obesidad (grado dos)");
        } else if (imc >= 35 && imc < 40) {
            resultList.add("Tiene obesidad (grado tres)");
        } else {
            resultList.add("Tiene obesidad");
        }
    }
         
            public void buscarNombre() {
                System.out.println("entra a buscar persona");
                String resp = "";
                do {
                    nombrebuscar = JOptionPane.showInputDialog("Ingrese el nombre de la persona a buscar");

                    if (nombreList.contains(nombrebuscar)) {
                        int pos = nombreList.indexOf(nombrebuscar);
                       String resultado = resultList.get(pos);

                        System.out.println("La persona " + nombrebuscar + " tiene: " +resultado);
                        
                    } else {
                        System.out.println("La persona no se encuentra registrada y/o intente de nuevo");
                    }

                    resp = JOptionPane.showInputDialog("¿Desea consultar otra persona? (si/no)");
                } while (resp.equalsIgnoreCase("si"));
            }

            public void imprimir() {
                System.out.println("Lista de registros:\n");
                for (int i = 0; i < nombreList.size(); i++) {
                    String nombre = nombreList.get(i);
                    String resultado = resultList.get(i);

                    System.out.println("Persona " + (i + 1) + ":");
                    System.out.println("Nombre: " + nombre);
                    System.out.println( resultado);
                    System.out.println("---------------------");
                }
            }

            public void actualizar() {
                System.out.println("entra a actualizar datos");

                String nombreActualizar = JOptionPane.showInputDialog("Ingrese el nombre de la persona a actualizar");

                if (nombreList.contains(nombreActualizar)) {
                    int pos = nombreList.indexOf(nombreActualizar);

                    nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                    peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo peso"));
                    talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva talla"));

                    nombreList.set(pos, nombre);
                    resultadoIMC();

                    System.out.println("Los datos de la persona han sido actualizados.");
                } else {
                    System.out.println("La persona no se encuentra registrada.");
                }
            }

            public void eliminar() {
                System.out.println("entra a eliminar datos");

                String nombreEliminar = JOptionPane.showInputDialog("Ingrese el nombre de la persona a eliminar");

                if (nombreList.contains(nombreEliminar)) {
                    int pos = nombreList.indexOf(nombreEliminar);

                    nombreList.remove(pos);
                    resultList.remove(pos);

                    System.out.println("Los datos de la persona han sido eliminados.");
                } else {
                    System.out.println("La persona no se encuentra registrada.");
                }
            }
        }