package br.com.postechfiap.carrinhocompra.infrastructure.security;

import java.util.Optional;

public interface RemoteSecurityContextService<T> {

    Optional<T> getPrincipal(String token);

}
