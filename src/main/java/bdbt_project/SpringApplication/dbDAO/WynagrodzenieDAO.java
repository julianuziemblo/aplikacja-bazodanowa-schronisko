package bdbt_project.SpringApplication.dbDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class WynagrodzenieDAO {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public WynagrodzenieDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public void deleteByIdPracownik(int id) {
        String sql = "DELETE FROM WYNAGRODZENIA WHERE nr_pracownika='"+id+"'";
        jdbcTemplate.update(sql);
    }

}
