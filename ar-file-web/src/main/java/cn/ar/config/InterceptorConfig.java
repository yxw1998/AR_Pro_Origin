package cn.ar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author YangXw
 * @date 2021/11/19 0019 10:22
 * @description
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

//    private String[] excludePathPatterns = {"/**/login","/**/register","/test/**","/wx/**","/**/appletsRegister","/bd/**","/huawei/**"};
//    private String[] addPathPatterns = {"/**"};
//
//    private MyInterceptor myInterceptor;
//
//    @Autowired
//    public void setMyInterceptor(MyInterceptor myInterceptor) {
//        this.myInterceptor = myInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myInterceptor)
//                .addPathPatterns(addPathPatterns)
//                .excludePathPatterns(excludePathPatterns);
//    }
//

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .exposedHeaders("access-control-allow-headers",
                                        "access-control-allow-methods",
                                        "access-control-allow-origin",
                                        "access-control-max-age",
                                        "X-Frame-Options",
                                        "access-control-request-headers")
                .maxAge(3600)
                .allowCredentials(false);
    }

}
