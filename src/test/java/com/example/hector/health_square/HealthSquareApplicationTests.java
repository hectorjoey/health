package com.example.hector.health_square;

import com.example.healthSquare.health_square.HealthSquareApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.Application;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HealthSquareApplication.class)
@AutoConfigureMockMvc
public class HealthSquareApplicationTests {

	@Test
	public void contextLoads() {
	}

}
