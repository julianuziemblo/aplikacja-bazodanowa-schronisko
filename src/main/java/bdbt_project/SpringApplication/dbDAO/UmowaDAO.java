package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.dbtables.Pracownik;
import bdbt_project.SpringApplication.dbtables.Umowa;
import bdbt_project.SpringApplication.dbtables.UmowaInfo;
import bdbt_project.SpringApplication.dbtables.Zwierze;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
        String sql = "SELECT * FROM UMOWY WHERE nr_klienta='"+id+"' ORDER BY nr_pracownika ASC";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Umowa.class));
    }

    public List<Integer> listZwierzetaIdOfCurrentKlient(List<Umowa> umowy) {
        var out = new ArrayList<Integer>();
        for(var umowa: umowy) {
            out.add(umowa.getNr_zwerzecia());
        }
        return out;
    }

    public void save(Umowa umowa) {
        var insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("UMOWY")
                .usingColumns("nr_umowy", "rodzaj", "data_podpisu",
                      "data_waznosci", "nr_zwerzecia", "nr_klienta",
                      "nr_pracownika");
        var param = new BeanPropertySqlParameterSource(umowa);
        insert.execute(param);
    }

    public List<UmowaInfo> listUmowaInfo(List<Umowa> umowy,
                                           List<Pracownik> pracownicy,
                                           List<Zwierze> zwierzeta) {
        var umowyInfo = new ArrayList<UmowaInfo>();
        for(int i=0; i<umowy.size(); ++i) {
            umowyInfo.add(new UmowaInfo(umowy.get(i),
                    zwierzeta.get(i).getImie(),
                    pracownicy.get(i).getImie_nazwisko()));
        }
        return umowyInfo;
    }

}
