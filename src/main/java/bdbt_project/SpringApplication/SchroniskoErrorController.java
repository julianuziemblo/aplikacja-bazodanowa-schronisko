package bdbt_project.SpringApplication;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


@Controller
public class SchroniskoErrorController implements ErrorController {

    HashMap<Integer, String> errorCodes = Application.getErrorCodes();
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        var status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        int statusCode = Integer.parseInt(status.toString());
        return errorCodes.getOrDefault(statusCode, "errors/other");
    }
}
