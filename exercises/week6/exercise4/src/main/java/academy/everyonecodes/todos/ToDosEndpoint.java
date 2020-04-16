package academy.everyonecodes.todos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDosEndpoint {
    private final ToDoManager toDoManager;

    public ToDosEndpoint(ToDoManager toDoManager) {
        this.toDoManager = toDoManager;
    }

    @GetMapping
    List<ToDo> get() {
        return toDoManager.getAll();
    }

    @GetMapping("/{id}")
    ToDo getById(@PathVariable String id) {
        return toDoManager.findById(id).orElse(null);
    }

    @PostMapping
    ToDo postOne(@RequestBody ToDo toDo) {
        return toDoManager.post(toDo);
    }

    @PutMapping("/{id}/done")
    ToDo mark(@PathVariable String id) {
        return toDoManager.mark(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        toDoManager.delete(id);
    }
}
