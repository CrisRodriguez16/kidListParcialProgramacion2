package co.edu.umanizales.kids_list.controller;

import co.edu.umanizales.kids_list.model.Kid;
import co.edu.umanizales.kids_list.model.NodeDE;
import co.edu.umanizales.kids_list.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listde")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;

    // Obtener todos los niños de la lista
    @GetMapping
    public NodeDE getListChildren() {
        return listDEService.showKids();
    }

    // Agregar un niño al final de la lista
    @PostMapping
    public String addKidToFinal(@RequestBody Kid kid) {
        listDEService.getListDE().add(kid);
        return "Adicionado exitosamente";
    }

    // Agregar un niño al inicio de la lista
    @PostMapping("/tostart")
    public String addKidToStart(@RequestBody Kid kid) {
        listDEService.getListDE().addToStart(kid);
        return "Adicionado exitosamente";
    }

    // Agregar un niño en una posición específica de la lista
    @PostMapping("/addatposition")
    public String addKidAtPosition(@RequestBody Kid kid, @RequestParam int position) {
        try {
            listDEService.getListDE().addAtPosition(kid, position);
            return "Adicionado exitosamente en la posición " + position;
        } catch (IndexOutOfBoundsException e) {
            return "Error: " + e.getMessage();
        }
    }

    // Eliminar un niño por su ID
    @DeleteMapping("/removebyid")
    public String removeKidById(@RequestParam int id) {
        listDEService.getListDE().removeById(id);
        return "Niño con ID " + id + " ha sido eliminado";
    }

    // Eliminar un niño en una posición específica
    @DeleteMapping("/removeatposition")
    public String removeKidAtPosition(@RequestParam int position) {
        try {
            listDEService.getListDE().removeAtPosition(position);
            return "Niño eliminado exitosamente en la posición " + position;
        } catch (IndexOutOfBoundsException e) {
            return "Error: " + e.getMessage();
        }
    }

    // Invertir la lista de niños
    @PutMapping("/invert")
    public String invertList() {
        listDEService.getListDE().invert();
        return "La lista ha sido invertida";
    }

    // Intercalar la lista por género
    @PutMapping("/interleave")
    public String interleaveByGender() {
        listDEService.getListDE().interleaveByGender();
        return "La lista ha sido intercalada por género";
    }

    // Intercambiar el primer y último niño de la lista
    @PutMapping("/swapextremes")
    public String swapExtremes() {
        listDEService.getListDE().swapExtremes();
        return "Se han intercambiado los extremos de la lista";
    }
}
