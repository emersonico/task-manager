package com.example.proyecto_final_ada_gui;

import com.example.proyecto_final_ada_gui.Modelo.Task;
import com.example.proyecto_final_ada_gui.Modelo.TreeAVL;

public class Main {
    public static void main(String[] args) {
        pruebaIndexacion();
        pruebaEquilibrio();
    }

    public static void pruebaIndexacion() {
        TreeAVL avl = new TreeAVL();
        for (int i = 1; i <= 1000; i++) {
            avl.insert(new Task(i, i, "Tarea " + i));
        }

        long inicio = System.nanoTime();
        Task t = avl.search(750);
        long fin = System.nanoTime();

        if (t != null) {
            System.out.println("✔ Encontrada: " + t.description + " | Tiempo: " + (fin - inicio) + " ns");
        } else {
            System.out.println("✘ No se encontró la tarea.");
        }

    }
    //
//    public static void pruebaEquilibrio() {
//        TreeAVL avl = new TreeAVL();
//        for (int i = 1; i <= 10; i++) {
//            avl.insert(new Task(i, i, "Tarea " + i));
//        }
//
//        System.out.println("✔ Altura del árbol tras inserciones ordenadas: " + avl.altura());
//        System.out.print("✔ Recorrido inorden: ");
//        avl.inOrden();
//    }
    public static void pruebaEquilibrio() {
        TreeAVL avl = new TreeAVL();
        for (int i = 1; i <= 1000; i++) {
            avl.insert(new Task(i, i, "Tarea " + i));
        }

        int altura = avl.altura();
        System.out.println("✔ Prueba de equilibrio:");
        System.out.println("Altura del árbol tras inserciones ordenadas: " + altura);
    }
}
