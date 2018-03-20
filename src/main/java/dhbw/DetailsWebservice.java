/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw;

import static dhbw.DetailResultBuilder.buildResult;
import dhbw.spotify.RequestCategory;
import dhbw.spotify.RequestType;
import dhbw.spotify.SpotifyRequest;
import dhbw.spotify.WrongRequestTypeException;
import java.io.IOException;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nicole
 */
@RestController
public class DetailsWebservice {
    
    SpotifyRequest sprequest = new SpotifyRequest(RequestType.DETAIL);
    
    @RequestMapping("/detail/{id}")
    public String detailSearch(@PathVariable String id,@RequestParam("type")RequestCategory category) throws WrongRequestTypeException, IOException{
        
        Optional <String> optional = sprequest.performeRequestDetail(category, id);
        String requestString = null;
        
        //Prüfen, ob der String null ist und das Auslesen des Strings im Optional
        if(optional.isPresent()){
            requestString = optional.get();
        }
        
        return buildResult(category, id, requestString);
    }
    
}
