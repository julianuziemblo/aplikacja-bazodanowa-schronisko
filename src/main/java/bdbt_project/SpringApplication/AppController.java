package bdbt_project.SpringApplication;

import bdbt_project.SpringApplication.dbDAO.*;
import bdbt_project.SpringApplication.dbtables.*;
import bdbt_project.SpringApplication.dto.KlientPassword;

import bdbt_project.SpringApplication.filters.GatunekFilter;
import bdbt_project.SpringApplication.utility.RandomUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Controller
public class AppController implements WebMvcConfigurer {

    @Autowired
    private final AdresDAO adresDAO = new AdresDAO(new JdbcTemplate());

    @Autowired
    private final UmowaDAO umowaDAO = new UmowaDAO(new JdbcTemplate());

    @Autowired
    private final KlientDAO klientDAO = new KlientDAO(new JdbcTemplate());

    @Autowired
    private final ZwierzeDAO zwierzeDAO = new ZwierzeDAO(new JdbcTemplate());

    @Autowired
    private final PracownikDAO pracownikDAO = new PracownikDAO(new JdbcTemplate());

    private final KlientPasswordDAO klientPasswordDAO = new KlientPasswordDAO();

    private Integer currentAnimal = null;
    private GatunekFilter gatunekFilter = new GatunekFilter();
    private Umowa currUmowaParams = null;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/adresy").setViewName("adresy");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/navbar").setViewName("navbar");
        registry.addViewController("/zwierzeta").setViewName("zwierzeta");
        registry.addViewController("/navbar-logged-user").setViewName("user/navbar-logged-user");
        registry.addViewController("/umowy").setViewName("user/umowy");
        registry.addViewController("/podpisz").setViewName("user/podpisz");
    }

    @Controller
    public class DashboardController {
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            var userRole = request.getRemoteUser();
            var userRolesRedirect = Application.getUserRedirect();
            return userRolesRedirect.getOrDefault(userRole, "redirect:/index");
        }
    }

    @RequestMapping("/adresy")
    public String showAdresyPage(Model model) {
        List<Adres> listAdres = adresDAO.list();
        // System.out.println(listAdres);
        model.addAttribute("listAdres", listAdres);
        return "adresy";
    }

    @RequestMapping(value={"selectAnimal"}, method=RequestMethod.POST)
    public String getCurrentAnimal(@ModelAttribute("selected") String selected) {
        currentAnimal = Integer.parseInt(selected);
        // System.out.println("animal="+currentAnimal);
        return "redirect:/user/podpisz";
    }

    @RequestMapping("/user/umowy")
    public void showUmowy(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(email);
        var user = klientDAO.getByEmail(email);
        var umowy = umowaDAO.listWhereId(user.getNr_klienta());
        var zwierzeta = zwierzeDAO.getZwierzetaOfIds(
                (ArrayList<Integer>)umowaDAO.listZwierzetaIdOfKlientId(umowy, user.getNr_klienta()));
        model.addAttribute("zwierzeta", zwierzeta);
        model.addAttribute("umowy", umowy);
        var pracownicy = pracownikDAO.getByUmowy(umowy);
        model.addAttribute("pracownicyConcat", pracownicy);
    }

    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }

    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }

    @RequestMapping(value={"/register"})
    public String showRegisterForm(Model model) {
        var klient = new Klient();
        var klientHaslo = new KlientPassword();
        var adres = new Adres();
        model.addAttribute("klientDAO", klient);
        model.addAttribute("klientHaslo", klientHaslo);
        model.addAttribute("adresDAO", adres);
        return "register";
    }

    @RequestMapping(value="/save_klient_data", method=RequestMethod.POST)
    public String saveKlientData(@ModelAttribute("klientDAO") Klient klient,
                                 @ModelAttribute("adresDAO") Adres adres,
                                 @ModelAttribute("klientHaslo") KlientPassword kh) throws Exception {
        adresDAO.save(adres);
        var nr_adresu = adresDAO.getHighestIdAddress().getNr_adresu();
        klient.setNr_adresu(nr_adresu);
        var email = klient.getEmail();
        kh.setEmail(email);
        klientDAO.save(klient);
        klientPasswordDAO.save(kh);
        return "redirect:/main_user";
    }

    @RequestMapping(value={"/getFilter"}, method=RequestMethod.POST)
    public String changeFilter(@ModelAttribute("gatunekFilter") GatunekFilter gatunekFilter) {
        this.gatunekFilter = gatunekFilter;
        return "redirect:/zwierzeta";
    }

    @RequestMapping("/zwierzeta")
    public String showZwierzeta(Model model) {
        List<Zwierze> listZwierzeta;
        var params = gatunekFilter.getSelected();
        listZwierzeta = zwierzeDAO.listWhereGatunek(params);
        model.addAttribute("gatunekFilter", gatunekFilter);
        model.addAttribute("listZwierzeta", listZwierzeta);
        return "/zwierzeta";
    }

    @RequestMapping("/user/podpisz")
    public void showPodpiszUmowe(Model model) {
        var animalIds = new ArrayList<Integer>();
        animalIds.add(currentAnimal);
        var zwierze = zwierzeDAO.getZwierzetaOfIds(animalIds).get(0);
        var dostepniPracownicy = pracownikDAO.getPracownikByStanowisko(Pracownik.ZWYKLY_PRACOWNIK);
        var randomPracownik = RandomUtility.choice(dostepniPracownicy);
        model.addAttribute("zwierze", zwierze);
        model.addAttribute("pracownik", randomPracownik);
        System.out.println(zwierze);
        System.out.println(randomPracownik);
        currUmowaParams = new Umowa(0,'P',"","",zwierze.getNr_zwerzecia(),0,randomPracownik.getNr_pracownika());
    }



}
