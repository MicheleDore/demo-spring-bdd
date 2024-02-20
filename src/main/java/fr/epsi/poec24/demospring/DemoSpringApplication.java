package fr.epsi.poec24.demospring;

import fr.epsi.poec24.demospring.controller.HelloController;
import fr.epsi.poec24.demospring.domain.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoSpringApplication implements CommandLineRunner {

    private HelloController controller;

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate npjt;

    Scanner sc = new Scanner(System.in);

    @Autowired
    public DemoSpringApplication(HelloController controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(controller.getGreeting());


        //Création d'une table utilisateur
        /*String createQuery = """
            CREATE TABLE IF NOT EXISTS utilisateur (
                id INT PRIMARY KEY AUTO_INCREMENT, 
                login VARCHAR(50), 
                mdp VARCHAR(50)
            )
        """;
        jdbcTemplate.execute(createQuery);*/

        //Insertion dans notre table utilisateur
        /*String insertQuery = """
                INSERT INTO utilisateur (login, mdp) VALUES ('sega', 'ssy')
                """;
        int nb = jdbcTemplate.update(insertQuery);*/

        //Update dans notre table utilisateur
       /* String updateQuery = """
                UPDATE utilisateur SET mdp = 'ruth2' WHERE id = 2
                """;
        int nb = jdbcTemplate.update(updateQuery);
        System.out.println("Stat : "+nb);*/

        /*String deleteQuery = """
                DELETE FROM utilisateur WHERE id = 3
                """;
        int nb = jdbcTemplate.update(deleteQuery);
        System.out.println("STAT : "+nb);*/

        System.out.println("**************************************");
        System.out.println("****Bienvenue dans notre super App****");
        System.out.println("**************************************");
        System.out.println("* Merci de vous loguer...");
        System.out.print("* Login : ");
        String login = sc.nextLine();
        System.out.print("* Mot de passe : ");
        String pwd = sc.nextLine();

        //Requête non sécurisée
//        String loginQuery = "SELECT login FROM utilisateur WHERE login = '%s' AND mdp = '%s'";
//        List<String> logins = jdbcTemplate.queryForList(String.format(loginQuery, login, pwd), String.class);
        //Requête sécurisée
//        String securedLoginQuery = "SELECT login FROM utilisateur WHERE login = ? AND mdp = ?";
//        List<String> logins = jdbcTemplate.queryForList(securedLoginQuery, String.class, login, pwd);

        //Requête sécurisée avec des paramètres nommés à la place des ?
        /*String loginQuery = "SELECT login FROM utilisateur WHERE login = :login AND mdp = :password";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("password", pwd);
        parameterSource.addValue("login", login);
        List<String> logins = npjt.queryForList(loginQuery, parameterSource, String.class);

        if (logins.size() > 0) {
            System.out.println("* Bienvenue à toi : "+logins.get(0));
        } else {
            System.out.println("* Erreur d'authentification... merci de recommencer !");
        }*/

        String countQuery = "SELECT count(*) FROM utilisateur";
        System.out.println("Le nombre d'utilisateurs dans la table est :" +
                jdbcTemplate.queryForObject(countQuery, Integer.class));


        String findAllFournisseursQuery = "SELECT * FROM fournisseur";
        List<Fournisseur> mesFournisseurs = jdbcTemplate.query(findAllFournisseursQuery,
                new BeanPropertyRowMapper<>(Fournisseur.class));
        mesFournisseurs.forEach(System.out::println);
        for(Fournisseur item : mesFournisseurs) {
            System.out.println(item);
        }
    }
}
