package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.dbtables.Pracownik;

import bdbt_project.SpringApplication.dbtables.Umowa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PracownikDAO {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public PracownikDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownik> list(){
        String sql = "SELECT * FROM PRACOWNICY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
    }

    public List<Pracownik> getByUmowy(List<Umowa> umowy) {
        var pracownicy = new ArrayList<Pracownik>();
        for(var umowa: umowy) {
            var nr_pracownika = umowa.getNr_pracownika();
            String sql = "SELECT * FROM PRACOWNICY WHERE nr_pracownika="+nr_pracownika+"' ORDER BY nr_pracownika ASC";
            var pracownik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
            pracownicy.addAll(pracownik);
        }
        return pracownicy;
    }

    public List<Pracownik> getPracownikByStanowisko(int nr_stanowiska) {
        String sql = "SELECT * FROM PRACOWNICY WHERE nr_stanowiska='"+nr_stanowiska+"'";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
    }

}
