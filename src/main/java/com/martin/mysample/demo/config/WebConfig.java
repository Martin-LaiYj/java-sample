package com.martin.mysample.demo.config;

// import com.martin.myserver.demo.converter.DemoHttpMessageConverter;
// import com.martin.myserver.demo.interceptor.LoginInterceptor;
import com.martin.mysample.demo.model.DogDTO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 *
 * @author Martin
 * @since 2023-10-29 08:10
 **/

// @EnableWebMvc
@Configuration(proxyBeanMethods = false)
public class WebConfig {

    @Order(5)
    @ConditionalOnBean(name = "webMvcConfigurer")
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, DogDTO>() {
                    @Override
                    public DogDTO convert(String source) {
                        DogDTO dog = new DogDTO();
                        if (!source.isEmpty()) {
                            String[] target = source.split(",");
                            String name = target[0];
                            Integer age = Integer.valueOf(target[1]);

                            dog.setName(name);
                            dog.setAge(age);
                        }
                        return dog;
                    }
                });
            }

            // @Override
            // public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
            //     converters.add(new DemoHttpMessageConverter());
            // }

            // @Override
            // public void addInterceptors(InterceptorRegistry registry) {
            //     // registry.addInterceptor(new LoginInterceptor())
            //     //         .addPathPatterns("/**") // 所有请求都被拦截
            //     //         .excludePathPatterns("/", "/login"); // 除/和/login之外的资源都被拦截，包括静态资源
            // }
        };
    }
}
