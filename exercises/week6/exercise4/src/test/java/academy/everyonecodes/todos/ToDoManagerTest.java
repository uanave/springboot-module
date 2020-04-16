package academy.everyonecodes.todos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager toDoManager;

    @MockBean
    ToDoRepository toDoRepository;

    @Test
    void getAll() {
        toDoManager.getAll();
        verify(toDoRepository).findAll();
    }

    @Test
    void findById() {
        String id = "test";
        toDoManager.findById(id);
        verify(toDoRepository).findById(id);
    }

    @Test
    void post() {
        ToDo toDo = new ToDo("do", false);
        toDoManager.post(toDo);
        verify(toDoRepository).save(toDo);
    }

    @Test
    void mark() {
        String id = "test";
        when(toDoManager.mark(id)).thenReturn(Optional.of(new ToDo("test", true)));

        Optional<ToDo> oResult = toDoManager.mark(id);
        Optional<ToDo> oExpected = Optional.of(new ToDo("test", true));

        assertEquals(oExpected, oResult);

        verify(toDoRepository).findById(id);
        verify(toDoRepository).save(oResult.get());
    }

    @Test
    void delete() {
        String id = "test";
        toDoManager.delete(id);
        verify(toDoRepository).findById(id);
        assertFalse(toDoRepository.findById(id).isPresent());
    }
}