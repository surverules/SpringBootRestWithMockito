import com.parth.sachin.Application;
import com.parth.sachin.controller.Controller;
import com.parth.sachin.model.Student;
import com.parth.sachin.model.StudentClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = Application.class)
public class ControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentClass studentClass;

    List<Student> allstudents = new ArrayList<>();

    String newStudent = "{\"name\": \"upendra\"}";

    @Test
    public void TestMethod() throws Exception {
        Mockito.when(studentClass.addStudent(Mockito.anyObject())).thenReturn(true);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:8080/add")
                .accept(MediaType.APPLICATION_JSON)
                .content(newStudent)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        System.out.println("Response: " + response.getStatus());

        assertEquals("http://localhost:8080/add",
                response.getHeader(HttpHeaders.LOCATION));
    }


}
