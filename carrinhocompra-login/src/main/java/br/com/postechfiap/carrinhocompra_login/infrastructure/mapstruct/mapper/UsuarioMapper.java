package br.com.postechfiap.carrinhocompra_login.infrastructure.mapstruct.mapper;

import br.com.postechfiap.carrinhocompra_login.application.dto.request.CriarUsuarioDto;
import br.com.postechfiap.carrinhocompra_login.application.dto.response.UsuarioDto;
import br.com.postechfiap.carrinhocompra_login.domain.entity.Usuario;
import br.com.postechfiap.carrinhocompra_login.infrastructure.db.entity.UsuarioDbEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface UsuarioMapper {
    Usuario toUsuario(UsuarioDbEntity usuarioDbEntity);
    Usuario toUsuario(CriarUsuarioDto criarUsuarioDto);
    UsuarioDto toUsuarioDto(Usuario usuario);
    UsuarioDbEntity toUsuarioDbEntity(Usuario usuario);
    List<Usuario> toUsuarioList(List<UsuarioDbEntity> usuarioDbEntityList);
    List<UsuarioDbEntity> toUsuarioDbEntityList(List<Usuario> usuarioList);
}
