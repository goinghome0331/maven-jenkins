package kmg.springboot.jenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
	
	@GetMapping("/")
	public String root() {
		return "This is Maven Jenkins Web Test";
	}
}
