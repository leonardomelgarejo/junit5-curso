import br.rs.leonardomelgarejo.barriga.domain.Usuario;
import br.rs.leonardomelgarejo.barriga.domain.exceptions.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static builders.UsuarioBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Domínio: Usuário")
public class UsuarioTest {

    @Test
    @DisplayName("Deve criar um usuário válido")
    public void deveCriarUsuarioValido(){
        Usuario usuario = umUsuario().agora();
        assertAll("Usuario",
                () -> assertEquals(1L, usuario.id()),
                () -> assertEquals("Usuário Válido", usuario.nome()),
                () -> assertEquals("user@mail.com", usuario.email()),
                () -> assertEquals("12345678", usuario.senha())
        );
    }

    @Test
    public void deveRejeitarUsuarioSemNome(){
        ValidationException exception = assertThrows(ValidationException.class, () ->
                umUsuario().comNome(null).agora()
        );
        assertEquals("Nome é obrigatório", exception.getMessage());
    }

    @Test
    public void deveRejeitarUsuarioSemEmail(){
        ValidationException exception = assertThrows(ValidationException.class, () ->
                umUsuario().comEmail(null).agora()
        );
        assertEquals("Email é obrigatório", exception.getMessage());
    }

    @Test
    public void deveRejeitarUsuarioSemSenha(){
        ValidationException exception = assertThrows(ValidationException.class, () ->
                umUsuario().comSenha(null).agora()
        );
        assertEquals("Senha é obrigatória", exception.getMessage());
    }

//    @ParameterizedTest(name = "[{index}] - {4}")
//    @CsvFileSource(files = "src/test/resources/camposObrigatoriosUsuario.csv", nullValues = "NULL", numLinesToSkip = 1)
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/camposObrigatoriosUsuario.csv", nullValues = "NULL", useHeadersInDisplayName = true)
    public void deveValidarCamposObrigatorios(Long id, String nome, String email, String senha, String mensagem){
        ValidationException exception = assertThrows(ValidationException.class, () ->
        umUsuario().comId(id).comNome(nome).comEmail(email).comSenha(senha).agora());
        assertEquals(mensagem, exception.getMessage());
    }
}
