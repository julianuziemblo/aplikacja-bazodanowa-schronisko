package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.dbtables.Adres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AdresyDAO {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adres> list(){
        String sql = "SELECT * FROM ADRESY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
    }

    public void save(Adres adres) {
    }

    public Adres get(int nr_adresu) {
        var sql = "SELECT * FROM ADRESY WHERE NR_KLIENTA="+nr_adresu;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));
    }

    public void update(Adres adres) {
    }

    public void delete(int nr_adresu) {
    }

}
