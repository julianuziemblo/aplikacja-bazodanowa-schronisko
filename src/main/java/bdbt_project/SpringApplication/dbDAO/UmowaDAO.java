package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.dbtables.*;
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

    public List<UmowaInfo> listUmowaKlient(List<Umowa> umowy, List<Zwierze> zwierzeta, List<Klient> klienci) {
        var umowyInfo = new ArrayList<UmowaInfo>();
        for(int i=0; i<umowy.size(); ++i) {
            umowyInfo.add(new UmowaInfo(umowy.get(i), zwierzeta.get(i).getImie(),
                        klienci.get(i).getImie() + " " + klienci.get(i).getNazwisko()));
        }
        return umowyInfo;
    }

    public List<UmowaInfo> listUmowaKlientNotSigned(List<Umowa> umowy, List<Zwierze> zwierzeta, List<Klient> klienci) {

        var umowyInfo = new ArrayList<UmowaInfo>();
        for(int i=0; i<umowy.size(); ++i) {
            if(umowy.get(i).getRodzaj() == 'P')
                umowyInfo.add(new UmowaInfo(umowy.get(i), zwierzeta.get(i).getImie(),
                        klienci.get(i).getImie() + " " + klienci.get(i).getNazwisko()));
        }
        return umowyInfo;
    }

    public Umowa getUmowaById(int id) {
        String sql = "SELECT * FROM UMOWY WHERE nr_umowy='"+id+"'";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Umowa.class));
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM UMOWY WHERE nr_umowy='"+id+"'";
        System.out.println(sql);
        jdbcTemplate.update(sql);
    }

    public void updateRodzaj(Integer id, char rodzaj) {
        String sql = "UPDATE UMOWY SET rodzaj='"+rodzaj+"' WHERE nr_umowy='"+id+"'";
        jdbcTemplate.update(sql);
    }

}
