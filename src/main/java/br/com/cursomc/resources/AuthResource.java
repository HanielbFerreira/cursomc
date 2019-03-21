package br.com.cursomc.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursomc.dto.EmailDTO;
import br.com.cursomc.security.JWTUtil;
import br.com.cursomc.security.UserSS;
import br.com.cursomc.services.AuthService;
import br.com.cursomc.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthResource {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("/refresh_token")
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/forgot")
	public ResponseEntity<Void> forgot(@RequestBody EmailDTO emailDto) {
		authService.sendNewPassword(emailDto.getEmail());
		return ResponseEntity.noContent().build();
	}
	

}
