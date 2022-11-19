package cn.zach.lab01springtest;

import cn.zach.lab01springtest.entity.User;
import cn.zach.lab01springtest.service.UserService;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
//@AutoConfigureMockMvc
class Lab01SpringTestApplicationTests {
    @Autowired
    UserService userservice;

//    @Autowired
//    MockMvc mockMvc;


    @Test
//    @Rollback
//    @Transactional
    void contextLoads() {
        userservice.addUser("zach", 18);
        User zach = userservice.getUser("zach");
        MatcherAssert.assertThat(zach.getName(), Matchers.is("zach"));
        MatcherAssert.assertThat(zach.getAge(), Matchers.is(18));
    }

    @Test
    void test() {
        List<Object> objects = Collections.emptyList();
        List<String> collect = objects.stream().map(o -> o.toString()).collect(Collectors.toList());
        collect.add("1");
    }

//    @Test
//    void get() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/user/getUser")
//                        .param("name", "22")
//                        .header("Authorization", "BearerXXX")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)
//                        .accept(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Hello, 22"))
//                .andDo(result -> {
//                    System.out.println(result.getResponse().getContentAsString());
//                });
//    }

    @Test
    void gete() {
        System.out.println("aa".matches(""));
    }


}
