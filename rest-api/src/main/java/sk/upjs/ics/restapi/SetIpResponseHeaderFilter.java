package sk.upjs.ics.restapi;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SetIpResponseHeaderFilter extends OncePerRequestFilter {
    public static final int DEFAULT_PORT = 8080;

    private final ServerProperties serverProperties;

    public SetIpResponseHeaderFilter(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Integer port = serverProperties.getPort();
        if (port == null) {
            port = DEFAULT_PORT;
        }
        response.setHeader("X-Server-Port", port.toString());
        filterChain.doFilter(request, response);
    }
}
