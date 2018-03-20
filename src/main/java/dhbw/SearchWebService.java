/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw;

import dhbw.spotify.RequestCategory;
import dhbw.spotify.RequestType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import dhbw.spotify.SpotifyRequest;
import dhbw.spotify.WrongRequestTypeException;
import java.io.IOException;
import java.util.Optional;
import static dhbw.SearchResultBuilder.buildResult;
import dhbw.pojo.result.search.SearchResult;
import dhbw.pojo.result.search.SearchResultList;
import java.util.List;
/**
 *
 * @author Nicole
 */

@RestController
public class SearchWebService {
    
    SpotifyRequest sprequest = new SpotifyRequest(RequestType.SEARCH);
    
    @RequestMapping("/search")
    public SearchResult search(@RequestParam("query")String query, @RequestParam("type")RequestCategory category) throws WrongRequestTypeException, IOException {
        
        Optional <String> optional = sprequest.performeRequestSearch(category,query);
        String requestString= null;
        
        
        //Prüfen, ob der String null ist und das Auslesen des Strings im Optional
        if (optional.isPresent()){     
            requestString = optional.get();         
        }
        
        return buildResult(category, requestString, query);
    
    }
}
