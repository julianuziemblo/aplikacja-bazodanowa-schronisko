package bdbt_project.SpringApplication;

import bdbt_project.SpringApplication.dbDAO.AdresyDAO;
import bdbt_project.SpringApplication.dbtables.Adres;
import bdbt_project.SpringApplication.dto.KlientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
@Controller
public class AppController implements WebMvcConfigurer {

    @Autowired
    private final AdresyDAO adresyDAO = new AdresyDAO(new JdbcTemplate());

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/adresy").setViewName("adresy");
    }

    @Controller
    public class DashboardController {
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            var userRole = request.getRemoteUser().toUpperCase();
            var userRolesRedirect = Application.getRolesRedirect();
            return userRolesRedirect.getOrDefault(userRole, "redirect:/index");
        }
    }

    @RequestMapping("/adresy")
    public String showAdresyPage(Model model) {
        List<Adres> listAdres = adresyDAO.list();
        model.addAttribute("listAdres", listAdres);
        return "adresy";
    }

    @RequestMapping(value = {"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }

    @RequestMapping(value = {"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }

    @RequestMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        KlientDTO klientDTO = new KlientDTO();
        model.addAttribute("klient", klientDTO);
        return "registration";
    }

}
