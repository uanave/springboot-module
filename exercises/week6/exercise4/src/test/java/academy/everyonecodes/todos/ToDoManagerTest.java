package academy.everyonecodes.todos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager toDoManager;

    @MockBean
    ToDoRepository toDoRepository;

    String id = "test";
    ToDo toDo = new ToDo("test", false);

    @Test
    void getAll() {
        toDoManager.getAll();
        verify(toDoRepository).findAll();
    }

    @Test
    void findById() {
        toDoManager.findById(id);
        verify(toDoRepository).findById(id);
    }

    @Test
    void post() {
        assertNull(toDo.getId());
        toDoManager.post(toDo);
        verify(toDoRepository).save(toDo);
    }

    @Test
    void mark() {
        ToDo done = new ToDo("test", true);
        when(toDoManager.mark(id)).thenReturn(Optional.of(toDo));
        when(toDoRepository.save(done)).thenReturn(done);

        Optional<ToDo> oResult = toDoManager.mark(id);
        Optional<ToDo> oExpected = Optional.of(done);

        assertEquals(oExpected, oResult);

        verify(toDoRepository).findById(id);
        verify(toDoRepository).save(done);
    }

    @Test
    void delete() {
        toDoManager.delete(id);
        verify(toDoRepository).deleteById(id);
    }
}