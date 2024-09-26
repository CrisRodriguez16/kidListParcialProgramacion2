package co.edu.umanizales.kids_list.service;

import co.edu.umanizales.kids_list.model.Kid;
import co.edu.umanizales.kids_list.model.ListDE;
import co.edu.umanizales.kids_list.model.NodeDE;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListDEService {
    private ListDE listDE;

    @PostConstruct
    public void init() {
        listDE = new ListDE();
    }

    // Mostrar todos los niños de la lista
    public NodeDE showKids() {
        return listDE.getHead();
    }

    // Agregar un niño al final de la lista
    public void addKidToFinal(Kid kid) {
        listDE.add(kid);
    }

    // Agregar un niño al inicio de la lista
    public void addKidToStart(Kid kid) {
        listDE.addToStart(kid);
    }

    // Agregar un niño en una posición específica
    public void addKidAtPosition(Kid kid, int position) {
        listDE.addAtPosition(kid, position);
    }

    // Eliminar un niño por ID
    public void removeKidById(int id) {
        listDE.removeById(id);
    }

    // Eliminar un niño en una posición específica
    public void removeKidAtPosition(int position) {
        listDE.removeAtPosition(position);
    }

    // Invertir la lista
    public void invertList() {
        listDE.invert();
    }

    // Intercalar la lista por género
    public void interleaveByGender() {
        listDE.interleaveByGender();
    }

    // Intercambiar el primer y último niño
    public void swapExtremes() {
        listDE.swapExtremes();
    }
}
