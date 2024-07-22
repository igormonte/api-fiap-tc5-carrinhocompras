package br.com.postechfiap.carrinhocompra_gateway.application.routes;



import br.com.postechfiap.carrinhocompra_gateway.infrastructure.carrinhocompra.CarrinhoCompraConfig;
import br.com.postechfiap.carrinhocompra_gateway.infrastructure.itens.ItensConfig;
import br.com.postechfiap.carrinhocompra_gateway.infrastructure.login.LoginConfig;
import br.com.postechfiap.carrinhocompra_gateway.infrastructure.pagamento.PagamentoConfig;
import br.com.postechfiap.carrinhocompra_gateway.infrastructure.security.route.RouteGuardFilter;
import br.com.postechfiap.carrinhocompra_gateway.infrastructure.security.route.UserPermissionsFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

    private final CarrinhoCompraConfig carrinhoCompraConfig;
    private final LoginConfig loginConfig;
    private final ItensConfig itensConfig;
    private final PagamentoConfig pagamentoConfig;
    private final RouteGuardFilter routeGuardFilter;
    private final UserPermissionsFilter userPermissionsFilter;

    public RouteLocatorConfig(CarrinhoCompraConfig carrinhoCompraConfig,
                              LoginConfig loginConfig,
                              ItensConfig itensConfig,
                              PagamentoConfig pagamentoConfig,
                              RouteGuardFilter routeGuardFilter,
                              UserPermissionsFilter userPermissionsFilter) {
        this.carrinhoCompraConfig = carrinhoCompraConfig;
        this.loginConfig = loginConfig;
        this.itensConfig = itensConfig;
        this.pagamentoConfig = pagamentoConfig;
        this.routeGuardFilter = routeGuardFilter;
        this.userPermissionsFilter = userPermissionsFilter;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("carrinhocompra", r -> r.path("/carrinhocompra/**")
                        .filters(f -> {
                            f.filter(routeGuardFilter);
                            f.filter(userPermissionsFilter);
                            return f.stripPrefix(1);
                        })
                        .uri(carrinhoCompraConfig.getUrl()))
                .route("conta", r -> r.path("/conta/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri(loginConfig.getUrl()))
                .route("itens", r -> r.path("/itens/**")
                        .filters(f -> {
                            f.filter(routeGuardFilter);
                            f.filter(userPermissionsFilter);
                            return f.stripPrefix(1);
                        })
                        .uri(itensConfig.getUrl()))
                .route("checkout", r -> r.path("/pagamento/**")
                        .filters(f -> {
                            f.filter(routeGuardFilter);
                            f.filter(userPermissionsFilter);
                            return f.stripPrefix(1);
                        })
                        .uri(this.pagamentoConfig.getUrl()))
                .build();
    }
}
