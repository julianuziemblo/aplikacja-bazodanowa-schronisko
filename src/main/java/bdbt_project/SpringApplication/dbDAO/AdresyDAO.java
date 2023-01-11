package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.dbtables.Adres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List (zawiera info z bazy danych) */
    public List<Adres> list(){
        String sql = "SELECT * FROM ADRESY";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Adres adres) {
    }
    /* Read – odczytywanie danych z bazy */
    public Adres get(int nr_adresu) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Adres adres) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int nr_adresu) {
    }

}
