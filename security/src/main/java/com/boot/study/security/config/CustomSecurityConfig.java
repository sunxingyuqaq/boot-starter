package com.boot.study.security.config;

import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.PrintWriter;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/11/25 14:54
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Configuration
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_admin > ROLE_user");
        return roleHierarchy;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("admin")
                .and()
                .withUser("user").password(passwordEncoder().encode("123456")).roles("user")
                .and()
                .withUser("sxy").password(passwordEncoder().encode("123456")).roles("admin", "user");
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-ui.html", "/assets/**", "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();
        http.headers().frameOptions().disable();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        registry.antMatchers("/admin/**").hasRole("admin");
        registry.antMatchers("/user/**").hasRole("user");
        registry.antMatchers("/login", "/logout", "/").permitAll();
        registry.anyRequest().authenticated();
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/index")
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    PrintWriter writer = httpServletResponse.getWriter();
                    Object principal = authentication.getPrincipal();
                    writer.write(new ObjectMapper().writeValueAsString(principal));
                    httpServletResponse.setContentType("application/json");
                    writer.flush();
                    writer.close();
                })
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    JSONObject respBean = new JSONObject();
                    if (e instanceof LockedException) {
                        respBean.set("msg", "账户被锁定，请联系管理员!");
                    }
                    else if (e instanceof CredentialsExpiredException) {
                        respBean.set("msg", "密码过期，请联系管理员!");
                    }
                    else if (e instanceof AccountExpiredException) {
                        respBean.set("msg", "账户过期，请联系管理员!");
                    }
                    else if (e instanceof DisabledException) {
                        respBean.set("msg", "账户被禁用，请联系管理员!");
                    }
                    else if (e instanceof BadCredentialsException) {
                        respBean.set("msg", "用户名或者密码输入错误，请重新输入!");
                    }
                    PrintWriter writer = httpServletResponse.getWriter();
                    writer.write(respBean.toString());
                    httpServletResponse.setContentType("application/json;utf-8");
                    writer.flush();
                    writer.close();
                })
                .permitAll();
        http.exceptionHandling().authenticationEntryPoint((httpServletRequest, httpServletResponse, e) -> {
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write("{\"error\":\"login failed\"}");
            httpServletResponse.setContentType("application/json");
            writer.flush();
            writer.close();
        });
        http.exceptionHandling().accessDeniedHandler((httpServletRequest, httpServletResponse, e) -> {
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write("{\"error\":\"" + e.getMessage() + "\"}");
            httpServletResponse.setContentType("application/json");
            writer.flush();
            writer.close();
        });
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", HttpMethod.GET.name()))
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    PrintWriter writer = httpServletResponse.getWriter();
                    writer.write("{\"error\":\"注销成功\"}");
                    httpServletResponse.setContentType("application/json");
                    writer.flush();
                    writer.close();
                })
                .clearAuthentication(true)
                .deleteCookies()
                .invalidateHttpSession(true)
                .permitAll();
    }
}
