package com.example.proyecto_final_ada_gui.Modelo;

public class Task {
    public int id; // el identificados unico
    public int priority;
    public String description;

    public Task(int id, int priority, String description) {
        this.id = id;
        this.priority = priority;
        this.description = description;
    }

    @Override
    public String toString() {
        return  "id: " + id + " prioridad: " + priority + " descripcion='" + description + '\'';
    }
}
