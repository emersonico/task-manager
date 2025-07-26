package com.example.proyecto_final_ada_gui;

import com.example.proyecto_final_ada_gui.Modelo.Sistema;
import com.example.proyecto_final_ada_gui.Modelo.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SistemaController {

    private Sistema sistema = new Sistema();

    @FXML
    private TextField idField, descripcionField, prioridadField, buscarIdField;

    @FXML
    private TextArea outputArea, pendingTasksArea;

    @FXML
    protected void onAgregarTarea() {
        try {
            int id = Integer.parseInt(idField.getText());
            String descripcion = descripcionField.getText();
            int prioridad = Integer.parseInt(prioridadField.getText());

            Task nueva = new Task(id, prioridad, descripcion);
            sistema.addTask(nueva);

            outputArea.setText("✔ Tarea agregada:\n" + nueva + "\n");
            updatePendingTasks(); // Actualiza la lista de tareas pendientes

            idField.clear();
            descripcionField.clear();
            prioridadField.clear();
        } catch (NumberFormatException e) {
            outputArea.setText("❌ ID y prioridad deben ser enteros.\n");
        }
    }

    @FXML
    protected void onBuscarTarea() {
        try {
            int id = Integer.parseInt(buscarIdField.getText());
            Task t = sistema.tree.search(id); // Buscamos en el AVL
            outputArea.setText(""); // Limpiamos el área antes de mostrar

            if (t != null) {
                outputArea.setText("🔍 Tarea encontrada:\n" + formatTask(t));
            } else {
                outputArea.setText("❌ No se encontró la tarea con ID: " + id);
            }
        } catch (NumberFormatException e) {
            outputArea.setText("❌ El ID debe ser un número entero.\n");
        }
    }

    @FXML
    protected void onProcesarTarea() {
        sistema.processTask();
        updatePendingTasks(); // Refresca tareas pendientes
    }

    /** Refresca el área de tareas pendientes */
    private void updatePendingTasks() {
        pendingTasksArea.clear();
        sistema.heap.getTasks().forEach(task ->
                pendingTasksArea.appendText(formatTask(task) + "\n-----------------------\n")
        );
    }

    /** Devuelve una representación formateada de una tarea */
    private String formatTask(Task t) {
        return "ID: " + t.id + "\n" +
                "Prioridad: " + t.priority + "\n" +
                "Descripción: " + t.description;
    }
}
