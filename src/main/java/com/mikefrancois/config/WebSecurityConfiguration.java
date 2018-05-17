package com.mikefrancois.config;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
              .withUser("user").password("user123").roles("USER");
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
              .and()
              .authorizeRequests().antMatchers("/login**").permitAll()
              .and()
              .authorizeRequests().antMatchers("/ingatm/api/**").permitAll()
              .and()
              .authorizeRequests().antMatchers("/ingatm/ui/**").hasRole("USER")
              .and()
              .formLogin()
              .loginPage("/ingatm/ui") // Specifies the login page URL
              .loginProcessingUrl("/signin") // Specifies the URL,which is used
              .usernameParameter("userid")  // Username parameter, used in name attribute
              .passwordParameter("passwd")  // Password parameter, used in name attribute
              .successHandler((req,res,auth)->{    //Success handler invoked after successful authentication
                 for (GrantedAuthority authority : auth.getAuthorities()) {
                    System.out.println(authority.getAuthority());
                 }
                 System.out.println(auth.getName());
                 res.sendRedirect("/ingatm/ui/user"); // Redirect user to index/home page
              })
              .failureHandler((req,res,exp)->{  // Failure handler invoked after authentication failure
                 String errMsg="";
                 if(exp.getClass().isAssignableFrom(BadCredentialsException.class)){
                    errMsg="Invalid username or password.";
                 }else{
                    errMsg="Unknown error - "+exp.getMessage();
                 }
                 req.getSession().setAttribute("message", errMsg);
                 res.sendRedirect("/login"); // Redirect user to login page with error message.
              })
              .permitAll() // Allow access to any URL associate to formLogin()
              .and()
              .logout()
              .logoutUrl("/signout")   // Specifies the logout URL, default URL is '/logout'
              .logoutSuccessHandler((req,res,auth)->{   // Logout handler called after successful logout
                 req.getSession().setAttribute("message", "You are logged out successfully.");
                 res.sendRedirect("/login"); // Redirect user to login page with message.
              })
              .permitAll() // Allow access to any URL associate to logout()
              .and()
              .csrf().disable(); // Disable CSRF support
   }

}