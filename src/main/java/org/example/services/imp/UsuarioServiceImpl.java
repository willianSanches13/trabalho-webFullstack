package org.example.services.imp;

import org.example.domain.entity.Usuario;
import org.example.domain.respository.UsuarioRepositry;
import org.example.exception.SenhaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioRepositry usuarioRepositry;

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRepositry.save(usuario);
    }

    public void authenticar(Usuario usuario){
       UserDetails user = loadUserByUsername(usuario.getLogin());
       boolean senhasBatem = encoder.matches(usuario.getSenha(), user.getPassword());
       if(!senhasBatem) {
           throw new SenhaInvalidaException();
       }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositry.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));

        String[] roles = {"USER"};
        return User
                .builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(roles)
                .build();
    }
}
