package hello.core.scan.filter;

import java.lang.annotation.*;

// 이 세개는 @Configuration에서 가져올 수 있다.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
