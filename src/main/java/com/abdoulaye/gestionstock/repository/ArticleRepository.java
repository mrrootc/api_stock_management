package com.abdoulaye.gestionstock.repository;

import com.abdoulaye.gestionstock.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {


//    /**
//     * Cette annotation est utilisé pour ecrire t'es propre requete
//     * et spring va traduire cette requete en fonction du sgbdr utilisé
//     */
//    @Query("SELECT * from article where codearticle = :code")
//    List<Article> findByCustomQuery(@Param("code") String c);
//
//    /**
//     * La meme chose que la precedente mais cette fois avec l'attribut nativeQuery = true
//     * spring ne pas va traduire cette requete il va l'executer ainsi
//     * spring c'est cool
//     */
//
//    @Query( value = "SELECT * from article where codearticle = :code", nativeQuery = true) //Cette annotation est utilisé pour ecrire t'es propre requete
//    List<Article> findByCustomNativeQuery(@Param("code") String c);
//
//    /**
//     *Avec cette methode findBy avec mes deux champs spring va analyser si j'ai codeArticle et Description dans mon entity et
//     * il va rechercher en fonction de ses deux champ.
//     * IgnoreCase sa veut dire spring va ignoré la case en maj ou min il comprend n'est pas incroyable de developper avec spring
//     */
//
//    Article findByCodeArticleIgnoreCaseAndDescription(String code, String description);


}
