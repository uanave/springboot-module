package academy.everyonecodes.todos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ToDosEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    ToDoManager toDoManager;

    String url = "/todos";

    @Test
    void get() {
        testRestTemplate.getForObject(url, ToDo[].class);
        verify(toDoManager).getAll();
    }

    @Test
    void getById() {
        String id = "test";
        testRestTemplate.getForObject(url + "/" + id, ToDo.class);
        verify(toDoManager).findById(id);
    }

    @Test
    void postOne() {
        ToDo todo = new ToDo("test", false);
        testRestTemplate.postForObject(url, todo, ToDo.class);
        verify(toDoManager).post(todo);
    }

    @Test
    void mark() {
        String id = "test";
        ToDo todo = new ToDo("test", false);
        testRestTemplate.put(url + "/" + id + "/done", todo);
        verify(toDoManager).mark(id);

    }

    @Test
    void delete() {
        String id = "test";
        testRestTemplate.delete(url + "/" + id);
        verify(toDoManager).delete(id);
    }
}