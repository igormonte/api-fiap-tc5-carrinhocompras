package br.com.postechfiap.carrinhocompra_gateway.infrastructure.security.route.properties;

import br.com.postechfiap.carrinhocompra_gateway.infrastructure.security.user.Role;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

public class Route {
    @NotNull
    private String path;
    @Nullable
    private Role role;
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
