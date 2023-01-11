package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.dbtables.Adresy;
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

    public List<Adresy> list(){
        String sql = "SELECT * FROM ADRESY";
        var ans = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
        System.out.println(ans);
        return ans;
    }

    public void save(Adresy adres) {
    }

    public Adresy get(int nr_adresu) {
        return null;
    }

    public void update(Adresy adres) {
    }

    public void delete(int nr_adresu) {
    }

}
