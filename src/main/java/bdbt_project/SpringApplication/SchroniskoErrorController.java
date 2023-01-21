package bdbt_project.SpringApplication;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;


@Controller
public class SchroniskoErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        var status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
        var statusCode = Integer.parseInt(status);
        var errorCodes = Application.getErrorCodes();
        return errorCodes.getOrDefault(statusCode, "errors/other");
    }
}
