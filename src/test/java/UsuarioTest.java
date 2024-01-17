import br.rs.leonardomelgarejo.barriga.domain.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Domínio: Usuário")
public class UsuarioTest {

    @Test
    @DisplayName("Deve criar um usuário válido")
    public void deveCriarUsuarioValido(){
        Usuario usuario = new Usuario(1L, "Usuario Valido", "user@mail.com", "123456");
        Assertions.assertAll("Usuario",
                () -> Assertions.assertEquals(1L, usuario.id()),
                () -> Assertions.assertEquals("Usuario Valido", usuario.nome()),
                () -> Assertions.assertEquals("user@mail.com", usuario.email()),
                () -> Assertions.assertEquals("123456", usuario.senha())
        );
    }
}
