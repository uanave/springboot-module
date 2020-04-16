package academy.everyonecodes.todos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoManager {
    private ToDoRepository toDoRepository;

    public ToDoManager(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> findById(String id) {
        return toDoRepository.findById(id);
    }

    public ToDo post(ToDo toDo) {
        toDoRepository.save(toDo);
        return toDo;
    }

    public Optional<ToDo> mark(String id) {
        Optional<ToDo> task = toDoRepository.findById(id);
        task.ifPresent(toDo -> toDo.setDone(true));
        task.ifPresent(toDo -> toDoRepository.save(task.get()));
        return task;
    }

    public void delete(String id) {
        toDoRepository.deleteById(id);
    }
}
