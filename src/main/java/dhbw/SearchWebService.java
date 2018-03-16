/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw;

import dhbw.pojo.search.track.SearchTrack;
import dhbw.spotify.RequestCategory;
import dhbw.spotify.RequestType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dhbw.spotify.SpotifyRequest;
import dhbw.spotify.WrongRequestTypeException;
import java.io.IOException;
import java.util.Optional;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Nicole
 */

@RestController
public class SearchWebService {
    
    @PostMapping("/search")
    public String search(@RequestParam(value="query")String query, @RequestParam(value="Type")RequestCategory type) throws WrongRequestTypeException, IOException {
        SpotifyRequest sprequest = new SpotifyRequest(RequestType.SEARCH);
        
       
        Optional <String> optional = sprequest.performeRequestSearch(type,query);
        String requestString="";
        if (optional.isPresent()){//Prüfen, ob der String null ist     
            requestString = optional.get(); //Auslesen des String im Optional        
        }
        
        ObjectMapper mapper = new ObjectMapper();
        
        SearchTrack searchTrack = null;
        
        switch(type){
            case TRACK:
                searchTrack = mapper.readValue(requestString, SearchTrack.class);
                break;
            case ALBUM:
                searchTrack = mapper.readValue(requestString, SearchTrack.class);
                break;
            case ARTIST:
                searchTrack = mapper.readValue(requestString, SearchTrack.class);
                break;
            default:
                break;
        }
        
       ObjectMapper mapper2 = new ObjectMapper();
       String json = mapper2.writeValueAsString(searchTrack);
       
       return json;
    
    }
}
