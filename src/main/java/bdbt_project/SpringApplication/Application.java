package bdbt_project.SpringApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

@SpringBootApplication
public class Application {
	private static HashMap<Integer, String> errorCodes;
	public static void main(String[] args) {
		setupErrorCodes();
		SpringApplication.run(Application.class, args);
	}

	private static void setupErrorCodes() {
		errorCodes = new HashMap<>();
		errorCodes.put(HttpStatus.FORBIDDEN.value(), "errors/403");
		errorCodes.put(HttpStatus.NOT_FOUND.value(), "errors/404");
		errorCodes.put(HttpStatus.INTERNAL_SERVER_ERROR.value(), "errors/500");
		errorCodes.put(HttpStatus.GATEWAY_TIMEOUT.value(), "errors/504");
	}

	public static HashMap<Integer, String> getErrorCodes() {
		return errorCodes;
	}

}
