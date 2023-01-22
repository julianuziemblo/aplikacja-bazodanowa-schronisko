package bdbt_project.SpringApplication;

import bdbt_project.SpringApplication.utility.JSONUtility;

import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.HashMap;


@SpringBootApplication
public class Application {
	private static HashMap<Integer, String> errorCodes;
	private static HashMap<String, String> userRedirect;
	private static HashMap<String, String> users;
	public static final String userAuthPath = "src/main/resources/authentication/users.json";

	public static void main(String[] args) {
		setup();
		SpringApplication.run(Application.class, args);
	}

	private static void setup() {
		try {
			loadUserAuthentication();
			setupRolesRedirect();
			setupErrorCodes();
		} catch(IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	private static void setupErrorCodes() {
		errorCodes = new HashMap<>();
		errorCodes.put(HttpStatus.FORBIDDEN.value(), "errors/403");
		errorCodes.put(HttpStatus.NOT_FOUND.value(), "errors/404");
		errorCodes.put(HttpStatus.INTERNAL_SERVER_ERROR.value(), "errors/500");
		errorCodes.put(HttpStatus.GATEWAY_TIMEOUT.value(), "errors/504");
	}

	private static void setupRolesRedirect() {
		userRedirect = new HashMap<>();
		userRedirect.put("admin", "redirect:/main_admin");
		userRedirect.put("user", "redirect:/main_user");
		var usernames = users.keySet();
		for(var user: usernames) {
			userRedirect.put(user, "redirect:/main_user");
		}
	}

	private static void loadUserAuthentication() throws IOException, ParseException {
		users = JSONUtility.read(userAuthPath);
	}

	public static HashMap<Integer, String> getErrorCodes() {
		return errorCodes;
	}
	public static HashMap<String, String> getUserRedirect() {
		return userRedirect;
	}
	public static HashMap<String, String> getUsers() {
		return users;
	}

}
