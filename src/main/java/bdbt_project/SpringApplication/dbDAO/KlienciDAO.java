package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.dbtables.Klient;
import bdbt_project.SpringApplication.utility.SQLInputChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class KlienciDAO {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public KlienciDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klient> list(){
        String sql = "SELECT * FROM KLIENCI";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));
    }

    public Klient getByNrKlienta(int nr_klienta) {
        if(!SQLInputChecker.check(String.valueOf(nr_klienta))) {
            throw new RuntimeException("Provided client number is invalid!");
        }
        var sql = "SELECT * FROM KLIENCI WHERE NR_KLIENTA="+nr_klienta;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klient.class));
    }

    public Klient getByEmail(String email) {
        if(!SQLInputChecker.check(email)) {
            throw new RuntimeException("Provided client number is invalid!");
        }
        var sql = "SELECT * FROM KLIENCI WHERE EMAIL="+email;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klient.class));
    }

    public void save(Klient k) {
        var sql = "INSERT INTO KLIENCI(nr_klienta, imie, " +
                "nazwisko, data_urodzenia, pesel, plec, " +
                "email, nr_telefonu, nr_adresu, nr_schroniska) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, k.getNr_klienta(), k.getImie(),
                k.getNazwisko(), k.getData_urodzenia(), k.getPesel(),
                k.getPlec(), k.getEmail(), k.getNr_telefonu(), k.getNr_adresu(),
                k.getNr_schroniska());
    }

}
