package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.dbtables.Adres;
import bdbt_project.SpringApplication.dbtables.Schronisko;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SchroniskoDAO {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public SchroniskoDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Schronisko> list(){
        String sql = "SELECT * FROM SCHRONISKA";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Schronisko.class));
    }

    public List<Integer> listIds(List<Schronisko> schroniska) {
        var lista = new ArrayList<Integer>();
        for(var s: schroniska) {
            lista.add(s.getNr_schroniska());
        }
        return lista;
    }
}
