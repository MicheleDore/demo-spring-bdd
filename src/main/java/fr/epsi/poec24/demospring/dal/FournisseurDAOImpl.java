package fr.epsi.poec24.demospring.dal;

import fr.epsi.poec24.demospring.domain.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FournisseurDAOImpl implements FournisseurDAO{
    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    private static final String FIND_ALL_QUERY = "SELECT ID, NOM AS RAISONSOCIALE FROM fournisseur";
    private static final String FIND_BY_ID_QUERY = "SELECT ID, NOM AS RAISONSOCIALE FROM fournisseur WHERE ID = :id";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM fournisseur WHERE ID = :id";
    private static final String UPDATE_QUERY = "UPDATE fournisseur SET NOM = :nom WHERE ID = :id";
    private static final String INSERT_QUERY = "INSERT INTO fournisseur (NOM) VALUES (:nom)";
    @Autowired
    public FournisseurDAOImpl(NamedParameterJdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("fournisseur").usingGeneratedKeyColumns("ID");
    }

    @Override
    public Fournisseur create(Fournisseur fournisseur) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("nom", fournisseur.getRaisonSociale());
        fournisseur.setId(simpleJdbcInsert.executeAndReturnKey(parameterSource).intValue());
        return fournisseur;
    }

    @Override
    public List<Fournisseur> findAll() {
        return jdbcTemplate.query(FIND_ALL_QUERY, new BeanPropertyRowMapper<>(Fournisseur.class));
    }

    @Override
    public Fournisseur findById(int id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, parameterSource, new BeanPropertyRowMapper<>(Fournisseur.class));
    }

    @Override
    public Fournisseur update(Fournisseur fournisseur) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", fournisseur.getId());
        parameterSource.addValue("nom", fournisseur.getRaisonSociale());
        jdbcTemplate.update(UPDATE_QUERY, parameterSource);
        return fournisseur;
    }

    @Override
    public void deleteById(int id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        jdbcTemplate.update(DELETE_BY_ID_QUERY, parameterSource);
    }
}
