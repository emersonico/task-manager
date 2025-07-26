package com.example.proyecto_final_ada_gui;

import com.example.proyecto_final_ada_gui.Modelo.Task;
import com.example.proyecto_final_ada_gui.Modelo.Sistema;
public class TestSIstema {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.addTask(new Task(1,5,"Informe final"));
        sistema.addTask(new Task(2,2,"Revisión de código"));
        sistema.addTask(new Task(3,7,"Presentación"));
        sistema.addTask(new Task(4,1,"Reunión urgente"));
        sistema.addTask(new Task(5,4,"Diseño de interfaz"));

        System.out.println("Antes:");
        sistema.searchTask(2); // encontrado
        sistema.searchTask(4); // encontrado

        System.out.println("\nProcesando:");
        sistema.processTask(); // elimina id=4 (prioridad 1)

        System.out.println("\nDespués:");
        sistema.searchTask(4); // No encontrado
        sistema.searchTask(2); // Debe seguir encontrado

    }
}
