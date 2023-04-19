package com.archerprop.peja;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.archerprop.peja.dto.UsuarioRegistroDTO;
import com.archerprop.peja.service.UsuarioService;

@SpringBootTest
class PejaApplicationTests {

	@Autowired
	private UsuarioService usuarioService;

	@Test
	void testServiceSave() {
		UsuarioRegistroDTO usuarioRegistroDTO = new UsuarioRegistroDTO();
		usuarioRegistroDTO.setCedula(Long.parseLong("334455"));
		usuarioRegistroDTO.setNombre("TestUno");
		usuarioRegistroDTO.setApellido("TestUno");
		usuarioRegistroDTO.setCorreo("TesUno@gmail.com");
		usuarioRegistroDTO.setClave("12345678");
		String rol = "ADMIN";
		assertTrue(usuarioService.guardar(usuarioRegistroDTO, rol) != null);
	}

	@Test
	void testServiceSaveYaExiste() {
		UsuarioRegistroDTO usuarioRegistroDTO = new UsuarioRegistroDTO();
		usuarioRegistroDTO.setCedula(Long.parseLong("1234567890"));
		usuarioRegistroDTO.setNombre("TestDos");
		usuarioRegistroDTO.setApellido("TestDos");
		usuarioRegistroDTO.setCorreo("TestDos@gmail.com");
		usuarioRegistroDTO.setClave("12345678");
		String rol = "ADMIN";
		usuarioService.guardar(usuarioRegistroDTO, rol);
		assertFalse(usuarioService.guardar(usuarioRegistroDTO, rol) != null);

	}

	@Test
	void testServiceSaveValidaCedula() {
		UsuarioRegistroDTO usuarioRegistroDTO = new UsuarioRegistroDTO();
		usuarioRegistroDTO.setCedula(Long.parseLong("1234567891212"));
		usuarioRegistroDTO.setNombre("TestTres");
		usuarioRegistroDTO.setApellido("TestTres");
		usuarioRegistroDTO.setCorreo("testTres@gmail.com");
		usuarioRegistroDTO.setClave("12345678");
		String rol = "ADMIN";
		assertFalse(usuarioService.guardar(usuarioRegistroDTO, rol) != null);
	}

	@Test
	void testServiceSaveYaExisteCedula() {
		UsuarioRegistroDTO usuarioRegistroDTO = new UsuarioRegistroDTO();
		usuarioRegistroDTO.setCedula(Long.parseLong("1234567123"));
		usuarioRegistroDTO.setNombre("TestCuatro");
		usuarioRegistroDTO.setApellido("TestCuatro");
		usuarioRegistroDTO.setCorreo("testCuatro@gmail.com");
		usuarioRegistroDTO.setClave("12345678");

		usuarioService.guardar(usuarioRegistroDTO, "ADMIN");

		UsuarioRegistroDTO usuarioRegistroDTO2 = new UsuarioRegistroDTO();
		usuarioRegistroDTO2.setCedula(Long.parseLong("1234567123"));
		usuarioRegistroDTO2.setNombre("TestCinco");
		usuarioRegistroDTO2.setApellido("TestCinco");
		usuarioRegistroDTO2.setCorreo("Test5@gmail.com");
		usuarioRegistroDTO2.setClave("12345678");
		String rol = "ADMIN";
		assertFalse(usuarioService.guardar(usuarioRegistroDTO2, rol) != null);
	}

	@Test
	void testServiceSaveValidaNombreyApellido() {
		UsuarioRegistroDTO usuarioRegistroDTO = new UsuarioRegistroDTO();
		usuarioRegistroDTO.setCedula(Long.parseLong("1234567891"));
		usuarioRegistroDTO.setNombre("Test6");
		usuarioRegistroDTO.setApellido("Test6");
		usuarioRegistroDTO.setCorreo("Test6@gmail.com");
		usuarioRegistroDTO.setClave("12345678");

		assertFalse(usuarioService.guardar(usuarioRegistroDTO, "ADMIN") != null);
	}

	@Test
	void testServiceSaveValidaCorreo() {
		UsuarioRegistroDTO usuarioRegistroDTO = new UsuarioRegistroDTO();
		usuarioRegistroDTO.setCedula(Long.parseLong("1234567891"));
		usuarioRegistroDTO.setNombre("TestSiete");
		usuarioRegistroDTO.setApellido("TestSiete");
		usuarioRegistroDTO.setCorreo("Test7gmail.com");
		usuarioRegistroDTO.setClave("12345678");

		assertFalse(usuarioService.guardar(usuarioRegistroDTO, "ADMIN") != null);
	}

	@Test
	void testServiceSaveClave() {
		UsuarioRegistroDTO usuarioRegistroDTO = new UsuarioRegistroDTO();
		usuarioRegistroDTO.setCedula(Long.parseLong("1234567891"));
		usuarioRegistroDTO.setNombre("TestOcho");
		usuarioRegistroDTO.setApellido("TestOcho");
		usuarioRegistroDTO.setCorreo("Test8@gmail.com");
		usuarioRegistroDTO.setClave("1234567");

		assertFalse(usuarioService.guardar(usuarioRegistroDTO, "ADMIN") != null);
	}

}
