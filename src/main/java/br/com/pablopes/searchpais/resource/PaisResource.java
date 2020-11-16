package br.com.pablopes.searchpais.resource;

import java.time.ZonedDateTime;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.pablopes.searchpais.model.Pais;
import br.com.pablopes.searchpais.model.Token;
import br.com.pablopes.searchpais.repository.PaisRepository;
import br.com.pablopes.searchpais.repository.TokenRepository;
import br.com.pablopes.searchpais.repository.spec.PaisSpec;
import br.com.pablopes.searchpais.repository.spec.TokenSpec;

@RestController
@RequestMapping("/pais")
public class PaisResource {
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private TokenRepository tokenRepository;
	
	
	@GetMapping("/listar")
	public List<Pais> getPaises(String token){
		List<Token> lista = tokenRepository.findAll(TokenSpec.porToken(token));
		Token tokenClass = null;
		
		if(lista.size() == 1) {
			tokenClass = lista.get(0);
		}
		List<Pais> listPais = null;
		if(tokenClass != null && (tokenClass.getExpiracao().toInstant().getNano() - ZonedDateTime.now().toInstant().getNano() > 0)) {
			listPais = paisRepository.findAll();	
		}
		return listPais;	

	}
	
	@GetMapping("/pesquisar")
	public List<Pais> pesquisarPaises(String filtro, String token){
		List<Token> lista = tokenRepository.findAll(TokenSpec.porToken(token));
		Token tokenClass = null;
		
		if(lista.size() == 1) {
			tokenClass = lista.get(0);
		}
		List<Pais> listPais = null;
		if(tokenClass != null && (tokenClass.getExpiracao().toInstant().getNano() - ZonedDateTime.now().toInstant().getNano() > 0)) {
			listPais = paisRepository.findAll(PaisSpec.porNome(filtro));	
		}
		return listPais;
	}
	
	@PostMapping("/salvar")
	public Pais salvarPais(@RequestBody Pais pais, String token) {
		List<Token> lista = tokenRepository.findAll(TokenSpec.porToken(token));
		Token tokenClass = null;
		
		if(lista.size() == 1) {
			tokenClass = lista.get(0);
		}
		Pais paisSalvo = null;
		if(tokenClass != null && (tokenClass.getExpiracao().toInstant().getNano() - ZonedDateTime.now().toInstant().getNano() > 0)) {
			paisSalvo = paisRepository.save(pais);	
		}
		return paisSalvo;
	}
	
}
