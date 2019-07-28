package org.songzx.spbdemo01.adapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class WebSecurityConfig extends WebMvcConfigurationSupport {
    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "sessionId";
    public final static String CURR_USER = "currUser";

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor =registry.addInterceptor(getUserInterceptor());
        // 排除配置
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/login**/");
        addInterceptor.excludePathPatterns("/static/**");
        addInterceptor.excludePathPatterns("/pageLogin/");
        addInterceptor.excludePathPatterns("/saveUser/");

        // 拦截配置
        addInterceptor.addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public UserInterceptor getUserInterceptor() {
        return new UserInterceptor();
    }

    private class UserInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            boolean isLogin = false;
            HttpSession session = request.getSession();
            if (session.getAttribute(SESSION_KEY) != null) {
                isLogin = true;
            } else {
                response.sendRedirect("/pageLogin/");
            }
            return isLogin;
        }
    }

}
