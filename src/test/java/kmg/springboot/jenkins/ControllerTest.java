package kmg.springboot.jenkins;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import kmg.springboot.jenkins.BasicController;


@RunWith(SpringRunner.class)
@WebMvcTest(BasicController.class)
public class ControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void test() throws Exception{
		final ResultActions actions = mvc.perform(get("/")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print());
		
		actions
		.andExpect(status().isOk())
		.andExpect(content().string("This is Maven Jenkins Web Test"));
	}
}
