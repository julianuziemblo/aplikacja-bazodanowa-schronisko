package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.dbtables.Klient;
import bdbt_project.SpringApplication.utility.SQLInputChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class KlientDAO {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public KlientDAO(JdbcTemplate jdbcTemplate) {
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
        var sql = "SELECT * FROM KLIENCI WHERE NR_KLIENTA='"+nr_klienta+"'";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klient.class));
    }

    public Klient getByEmail(String email) {
        System.out.println(email);
        if(!SQLInputChecker.check(email)) {
            throw new RuntimeException("Provided client email is invalid!");
        }
        var sql = "SELECT * FROM KLIENCI WHERE EMAIL='"+email+"' ORDER BY nr_klienta DESC";
        var found = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));
        if(found.size() == 0) {
            throw new RuntimeException("Nie znaleziono użytkownika");
        }
        return found.get(0);
    }

    public void save(Klient k) {
        var insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("klienci").usingColumns("nr_klienta", "imie", "nazwisko", "data_urodzenia", "pesel", "plec", "email", "nr_telefonu", "nr_adresu", "nr_schroniska");
        var param = new BeanPropertySqlParameterSource(k);
        insert.execute(param);
    }

}
