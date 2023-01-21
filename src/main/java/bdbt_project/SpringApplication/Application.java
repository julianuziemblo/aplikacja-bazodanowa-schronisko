package bdbt_project.SpringApplication;

import bdbt_project.SpringApplication.utility.JSONUtility;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.parser.JSONParser;


@SpringBootApplication
public class Application {
	private static HashMap<Integer, String> errorCodes;
	private static HashMap<String, String> rolesRedirect;
	private static HashMap<String, String> users;
	private static final String userAuthPath = "resources/authentication/users.json";

	public static void main(String[] args) {
		setup();
		SpringApplication.run(Application.class, args);
	}

	private static void setup() {
		setupErrorCodes();
		setupRolesRedirect();
		loadUserAuthentication();
	}

	private static void setupErrorCodes() {
		errorCodes = new HashMap<>();
		errorCodes.put(HttpStatus.FORBIDDEN.value(), "errors/403");
		errorCodes.put(HttpStatus.NOT_FOUND.value(), "errors/404");
		errorCodes.put(HttpStatus.INTERNAL_SERVER_ERROR.value(), "errors/500");
		errorCodes.put(HttpStatus.GATEWAY_TIMEOUT.value(), "errors/504");
	}

	private static void setupRolesRedirect() {
		rolesRedirect = new HashMap<>();
		rolesRedirect.put("ADMIN", "redirect:/main_admin");
		rolesRedirect.put("USER", "redirect:/main_user");
	}

	private static void loadUserAuthentication() {
		var parser = new JSONParser();
		try {
			var auth = (JSONObject)parser.parse(new FileReader(userAuthPath));
			users = JSONUtility.toMap(auth);
		} catch(IOException | ParseException e) {
			e.printStackTrace();
		}
	}


	public static HashMap<Integer, String> getErrorCodes() {
		return errorCodes;
	}
	public static HashMap<String, String> getRolesRedirect() {
		return rolesRedirect;
	}
	public static HashMap<String, String> getUsers() {
		return users;
	}

}
