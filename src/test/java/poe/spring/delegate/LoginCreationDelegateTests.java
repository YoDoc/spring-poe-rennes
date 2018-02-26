package poe.spring.delegate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.delegate.LoginCreationDelegate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginCreationDelegateTests {

	// Methode de generation de String en 00... suivant la taille rentrée en paramètres (vérifiée)
	private String buildStringWithSizeBetween(int size) {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += "0";
		}
		return str;
	}

	@Test
	public void checkLoginOK() {
		String login = buildStringWithSizeBetween(LoginCreationDelegate.MIN_LOGIN_LENGTH);
		assertThat(LoginCreationDelegate.isSizeValid(login)).isTrue();

		login = buildStringWithSizeBetween(LoginCreationDelegate.MAX_LOGIN_LENGTH);
		assertThat(LoginCreationDelegate.isSizeValid(login)).isTrue();
	}
	
	 @Test
	    public void checkLoginSizeKO() {
	        String login = buildStringWithSizeBetween(LoginCreationDelegate.MIN_LOGIN_LENGTH - 1);
	        assertThat(LoginCreationDelegate.isSizeValid(login)).isFalse();

	        login = buildStringWithSizeBetween(LoginCreationDelegate.MAX_LOGIN_LENGTH + 1);
	        assertThat(LoginCreationDelegate.isSizeValid(login)).isFalse();
	    }

	 @Test
	 public void checkLoginAuthorizedOK() {
		 String loginOK = "hello";
		 assertThat(LoginCreationDelegate.isAuthorized(loginOK)).isTrue();
	 }
	 
	 @Test
	 public void checkLoginAuthorizedKO() {
		 String loginKO = "toto";
		 assertThat(LoginCreationDelegate.isAuthorized(loginKO)).isFalse();
	 }
}
