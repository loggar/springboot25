# view url mapping

### jsp

```java
@Configuration
@EnableWebMvc // <mvc:annotation-driven />
@ComponentScan(basePackages = "com.loggar.springboot25.controller") // <context:component-scan base-package="com.loggar.springboot25.controller" />
public class WebAppConfig implements WebMvcConfigurer {
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		return bean;
	}
}
```

```
index page localhost:26080/springboot25/
other page localhost:26080/springboot25/other
```
