package com.bjblackhole.bj_activiti_test.bj_activiti_test;

import com.bjblackhole.bj_activiti_test.bj_activiti_test.dao.CompRepository;
import com.bjblackhole.bj_activiti_test.bj_activiti_test.dao.PersonRepository;
import com.bjblackhole.bj_activiti_test.bj_activiti_test.model.Comp;
import com.bjblackhole.bj_activiti_test.bj_activiti_test.model.Person;
import com.bjblackhole.bj_activiti_test.bj_activiti_test.service.ActivitiService;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.bjblackhole.bj_activiti_test.bj_activiti_test.service")
@EnableJpaRepositories("com.bjblackhole.bj_activiti_test.bj_activiti_test.dao")
@EntityScan("com.bjblackhole.bj_activiti_test.bj_activiti_test.model")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BjActivitiTestApplication {
    @Autowired
    private CompRepository compRepository;
    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(BjActivitiTestApplication.class,args);
    }

    //初始化模拟数据
    @Bean
    public CommandLineRunner init(final ActivitiService activitiService) {
        return new CommandLineRunner() {
            public void run(String... strings) throws Exception {
                if (personRepository.findAll().size() == 0) {
                    personRepository.save(new Person("abc"));
                    personRepository.save(new Person("efg"));
                    personRepository.save(new Person("admin"));
                }
                if (compRepository.findAll().size() == 0) {
                    Comp group = new Comp("great company");
                    compRepository.save(group);
                    Person efg = personRepository.findByPersonName("efg");
                    Person abc = personRepository.findByPersonName("abc");
                    efg.setComp(group);
                    abc.setComp(group);
                    personRepository.save(efg);
                    personRepository.save(abc);
                }
            }
        };
    }
}
