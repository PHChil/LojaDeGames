package org.generation.lojadegames1.security;

import java.util.Collection;
import java.util.List;

import org.generation.lojadegames1.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private List<GrantedAuthority> authorities; //informar o tipo de autorização que o usuário tem. Usuário adm

	public UserDetailsImpl(Usuario usuario) {//método construtor
		this.userName = usuario.getUsuario(); // this busca a variavel criada aqui = getusuario indo para model usuário
		this.password = usuario.getSenha();

	}
	
	public UserDetailsImpl() {
	} // método construtor vazio para que não precise colocar todas as informações.

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}


}