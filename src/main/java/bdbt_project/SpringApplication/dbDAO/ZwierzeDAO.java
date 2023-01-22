package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.dbtables.Zwierze;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ZwierzeDAO {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public ZwierzeDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zwierze> list(){
        String sql = "SELECT * FROM ZWIERZETA";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zwierze.class));
    }

    public List<Zwierze> getZwierzetaOfIds(ArrayList<Integer> ids) {
        var lista = new ArrayList<Zwierze>();
        for(var id: ids) {
            String sql = "SELECT * FROM ZWIERZETA WHERE nr_zwerzecia='"+id+"'";
            lista.addAll(jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zwierze.class)));
        }
        return lista;
    }
}
