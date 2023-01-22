package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.dbtables.Umowa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class UmowaDAO {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public UmowaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Umowa> list(){
        String sql = "SELECT * FROM UMOWY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Umowa.class));
    }

    public List<Umowa> listWhereId(int id){
        String sql = "SELECT * FROM UMOWY WHERE nr_klienta='"+id+"' ORDER BY nr_zwerzecia ASC";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Umowa.class));
    }

    public List<Integer> listZwierzetaIdOfKlientId(List<Umowa> umowy, int id) {
        var out = new ArrayList<Integer>();
        for(var umowa: umowy) {
            out.add(umowa.getNr_zwierzecia());
        }
        return out;
    }

}
