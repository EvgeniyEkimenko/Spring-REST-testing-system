package com.ekimenko.spring.rest.SpringRESTtestingsystem;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.LessonRestControllerV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/*@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceTestConfig.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:init.sql"})*/

@SpringBootTest
class SpringRestMonitoringDrillingRigsApplicationTests {

    @Autowired
    private LessonRestControllerV1 lessonRestControllerV1;

    @Test
    void contextLoads() throws Exception{
        assertThat(lessonRestControllerV1).isNotNull();
    }

}
