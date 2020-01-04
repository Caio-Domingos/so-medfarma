package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.UserDao;
import model.User;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean extends GenericBean {
	private String username;
	private String password;

	public boolean login() {
		if (!loginValidation()) {
			return false;
		}

		User user = new UserDao().findByUsername(username);

		if (user.getIdUser() == null) {
			menssagemErro("Usuário não existe!");
			return false;
		}
		
		if (user.getPassword() != password) {
			menssagemErro("Usuário/Senha não coincidem!");
			return false;
		}
		redirecionarPagina("pages/index.xhmtl");
		return true;
	}

	public boolean loginValidation() {
		if (username.isEmpty() || username == null) {
			menssagemAviso("Usuário obirgatório!");
			return false;
		} else if (password.isEmpty() || password == null) {
			menssagemAviso("Senha obirgatório!");
			return false;
		} else {
			return true;
		}
	}

	// Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
