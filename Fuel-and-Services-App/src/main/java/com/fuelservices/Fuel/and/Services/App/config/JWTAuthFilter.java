package com.fuelservices.Fuel.and.Services.App.config;


import com.fuelservices.Fuel.and.Services.App.excption.UserNotFoundException;
import com.fuelservices.Fuel.and.Services.App.service.auth.CustomUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.fuelservices.Fuel.and.Services.App.config.SecurityConfig.AUTH_PATH;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
public class JWTAuthFilter extends OncePerRequestFilter {

    private static final String BEARER = "Bearer ";

    private final JWTUtil jwtUtil;

    private final CustomUserDetailsService userDetailsService;

    public JWTAuthFilter(JWTUtil jwtUtil, CustomUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filter) throws ServletException, IOException {
        String authorizationHeader = httpServletRequest.getHeader(AUTHORIZATION);
        if(!httpServletRequest.getServletPath().equals(AUTH_PATH + "/signin") && authorizationHeader != null && authorizationHeader.startsWith(BEARER)){
            String token = authorizationHeader.substring(7);
            if(jwtUtil.isTokenValid(token)){
                String username = jwtUtil.getUsernameFromToken(token);
                if (username == null){
                    throw new UserNotFoundException("user not found");
                }
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filter.doFilter(httpServletRequest,httpServletResponse);

    }
}