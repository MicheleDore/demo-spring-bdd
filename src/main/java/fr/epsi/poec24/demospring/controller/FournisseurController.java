package fr.epsi.poec24.demospring.controller;

import fr.epsi.poec24.demospring.domain.Fournisseur;
import fr.epsi.poec24.demospring.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fournisseurs")
public class FournisseurController {

    //Dans le développement multi-couche et notamment le MVC, le controller s'appuie sur d'autres briques
    // pour réaliser ces traitements... c'est la raison pour laquelle, nous avons besoin ici d'un objet service dont la création est déléguée à Spring Core
    private FournisseurService service;

    @Autowired
    public FournisseurController(FournisseurService service) {
        this.service = service;
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/fournisseurs")
    @GetMapping
    public String afficherListeFournisseurs(Model model) {

        //On charge la liste des fournisseurs pour affichage dans la vue
        List<Fournisseur> mesFournisseurs = service.findAll();
        //On envoie la liste à la vue à travers le modèle du MVC
        model.addAttribute("fournisseurs", mesFournisseurs);
        return "view-fournisseurs-list";
    }
    @GetMapping("/creer")
    public String creerFournisseur(Model model) {
        //On envoie à la vue l'objet vide à remplir depuis le formulaire
        model.addAttribute("fournisseur", new Fournisseur());
        return "view-fournisseur-form-creation";
    }
    @PostMapping("/creer")
    public String creerFournisseur(@ModelAttribute Fournisseur fournisseur) {
        //A la validation du formulaire sur l'action "/formateurs/creer" c'est cette méthode qui est activée!
        //Elle permet grâce, là encore, à l'injection de récupérer l'objet initilisé dans le formulaire "view-formateur-form-creation"
        //Il ne reste plus qu'à essayer de sauvegarder cet objet en s'appuyant sur le service fournisseur
        service.create(fournisseur);
        return "redirect:/fournisseurs";
    }
    @GetMapping("/{id}/edition")
    public String modifierFournisseur(@PathVariable int id, Model model) {
        //Ici, on récupère l'id dans l'URL et on l'injecte dans la variable id de type "int"
        //On envoie ensuite à la vue l'objet fournisseur dont l'id est passé à modifier depuis le formulaire
        model.addAttribute("fournisseur", service.findById(id));
        return "view-fournisseur-form-edition";
    }
    @PostMapping("/{id}/edition")
    public String modifierFournisseur(@PathVariable int id, @ModelAttribute Fournisseur fournisseur) {
        //Comme sur la validation du formulaire de création, ici on fait à peu près la même chose
        fournisseur.setId(id);
        service.update(fournisseur);
        return "redirect:/fournisseurs";
    }

    @GetMapping("/{id}/suppression")
    public String supprimerFournisseur(@PathVariable int id) {
        //TODO il faut faire toutes les vérifications nécessaires ici
        service.deleteById(id);
        return "redirect:/fournisseurs";
    }
}
