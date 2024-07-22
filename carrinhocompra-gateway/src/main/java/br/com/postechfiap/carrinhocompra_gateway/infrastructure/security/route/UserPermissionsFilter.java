package br.com.postechfiap.carrinhocompra_gateway.infrastructure.security.route;

import br.com.postechfiap.carrinhocompra_gateway.infrastructure.login.LoginMessagingGateway;
import br.com.postechfiap.carrinhocompra_gateway.infrastructure.login.dto.CheckDto;
import br.com.postechfiap.carrinhocompra_gateway.infrastructure.security.route.properties.RouteConfig;
import br.com.postechfiap.carrinhocompra_gateway.infrastructure.security.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class UserPermissionsFilter implements GatewayFilter {
    private final LoginMessagingGateway loginMessagingGateway;
    private final RouteConfig routeConfig;

    public UserPermissionsFilter(LoginMessagingGateway loginMessagingGateway, RouteConfig routeConfig) {
        this.loginMessagingGateway = loginMessagingGateway;
        this.routeConfig = routeConfig;
    }

    private boolean isPermited(ServerHttpRequest request) {

        String authorizationHeader = request.getHeaders().get("Authorization").get(0);

        ResponseEntity<User> response = this.loginMessagingGateway.me(
                authorizationHeader, MessageBuilder.withPayload("").build());

        if(response.getStatusCode().isError()) {
            return false;
        }

        String url = request.getURI().getPath();
        User user = response.getBody();

        return this.routeConfig.isPermited(url, user.getRole());

    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (!this.isPermited(request)) {
            return this.onError(exchange, "User not permited header", HttpStatus.UNAUTHORIZED);
        }

        return chain.filter(exchange);
    }
    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus)  {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);

        return response.setComplete();
    }

}