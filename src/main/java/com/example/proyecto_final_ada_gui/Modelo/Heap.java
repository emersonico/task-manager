package com.example.proyecto_final_ada_gui.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private ArrayList<Task> heaps;
    public Heap() {
        heaps = new ArrayList<>();
    }

    public void insert(Task task) {
        heaps.add(task);
        heapifyUp(heaps.size() - 1);

    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heaps.get(index).priority < heaps.get(parent).priority) {
                exchange(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void exchange(int index1, int index2) {
        Task temp = heaps.get(index1);
        heaps.set(index1, heaps.get(index2));
        heaps.set(index2, temp);
    }

    private void heapifyDown(int index) {
        int size = heaps.size();

        while (true) {
            int left = index * 2 + 1;
            int right = left + 1;
            int lowest = index;

            if (left < size && heaps.get(left).priority < heaps.get(lowest).priority) {
                lowest = left;
            }
            if (right < size && heaps.get(right).priority < heaps.get(lowest).priority) {
                lowest = right;
            }
            if (lowest != index) {
                exchange(index, lowest);
                index = lowest;
            } else {
                break;
            }


        }
    }

    public Task extractMin() {
        if (heaps.isEmpty()) {
            return null;
        }

        Task min = heaps.get(0);
        Task last = heaps.remove(heaps.size() - 1);

        if (!heaps.isEmpty()) {
            heaps.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    public boolean isEmpty() {
        return heaps.isEmpty();
    }

    public Task getMin() {
        return heaps.isEmpty() ? null : heaps.get(0);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(heaps);
    }

}
