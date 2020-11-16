package br.com.pablopes.searchpais.resource;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pablopes.searchpais.model.Token;
import br.com.pablopes.searchpais.model.Usuario;
import br.com.pablopes.searchpais.model.UsuarioAutenticado;
import br.com.pablopes.searchpais.repository.TokenRepository;
import br.com.pablopes.searchpais.repository.UsuarioRepository;
import br.com.pablopes.searchpais.repository.spec.TokenSpec;
import br.com.pablopes.searchpais.repository.spec.UsuarioSpec;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private TokenRepository tokenRepository;

	private String secretkey = "35725c901c45f1c13f9e3fe8421a15dd26130118";

	@PostMapping("/autenticar")
	public UsuarioAutenticado autenticacao(String login, String senha) {
		Usuario usuario = null;
		UsuarioAutenticado user = new UsuarioAutenticado();
		List<Usuario> lista = usuarioRepository.findAll(UsuarioSpec.porLogin(login).and(UsuarioSpec.porSenha(senha)));

		if (lista.size() == 1) {
			usuario = lista.get(0);

			// GERAR TOKEN
			Token token = new Token();
			token.setAdministrador(true);
			token.setExpiracao(ZonedDateTime.now().plusMinutes(5));
			token.setLogin(usuario.getLogin());
			
			String tString = Jwts.builder().setSubject(token.getLogin())
			.setExpiration(Date.from(token.getExpiracao().toInstant()))
			.signWith(SignatureAlgorithm.HS512, secretkey).compact();
			
			tString = tString.replaceAll("\\.", "");
			
			token.setToken(tString); 

			tokenRepository.save(token);
			
			user.setAutenticado(true);
			user.setLogin(usuario.getLogin());
			user.setAdministrador(usuario.isAdministrador());
			user.setToken(tString);
			user.setNome(usuario.getNome());
		}
		return user;
	}

	@GetMapping("/renovar-ticket")
	public boolean renovarToken(String token) {
		List<Token> lista = tokenRepository.findAll(TokenSpec.porToken(token));
		Token tokenClass = null;
		if(lista.size() == 1) {
			tokenClass = lista.get(0);
		}
		
		if(tokenClass != null) {
			tokenClass.setExpiracao(ZonedDateTime.now().plusMinutes(5));
			tokenRepository.save(tokenClass);
			return true;
		}
		return false;
	}

}
