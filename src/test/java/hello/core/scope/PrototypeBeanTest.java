package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeBeanTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(prototypeBean.class);
        System.out.println("find prototypeBean1");
        prototypeBean prototypeBean1 = ac.getBean(prototypeBean.class);
        System.out.println("find prototypeBean2");
        prototypeBean prototypeBean2 = ac.getBean(prototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
//        prototypeBean1.destroy();
//        prototypeBean2.destroy();
    }

    @Scope("prototype")
    static class prototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("prototypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("prototypeBean.destroy");
        }
    }
}
