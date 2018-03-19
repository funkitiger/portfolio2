/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw;

import dhbw.pojo.search.album.SearchAlbum;
import dhbw.pojo.search.artist.SearchArtist;
import dhbw.pojo.search.track.SearchTrack;
import dhbw.spotify.RequestCategory;
import dhbw.spotify.RequestType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import dhbw.spotify.SpotifyRequest;
import dhbw.spotify.WrongRequestTypeException;
import java.io.IOException;
import java.util.Optional;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Nicole
 */

@RestController
public class SearchWebService {
    //@GET
    @RequestMapping("/search")
    //@GetMapping("/search")
    public String search(@RequestParam(value="query")String query, @RequestParam(value="type")RequestCategory type) throws WrongRequestTypeException, IOException {
        
        SpotifyRequest sprequest = new SpotifyRequest(RequestType.SEARCH);
               
        Optional <String> optional = sprequest.performeRequestSearch(type,query);
        String requestString="";
        
        if (optional.isPresent()){//Prüfen, ob der String null ist     
            requestString = optional.get(); //Auslesen des String im Optional        
        }
        
        ObjectMapper mapper = new ObjectMapper();
        
        SearchTrack searchTrack = null;
        SearchAlbum searchAlbum = null;
        SearchArtist searchArtist = null;
        
        
        ObjectMapper mapper2 = new ObjectMapper();
        String json="";
        
        
        switch(type){
            case TRACK:
                searchTrack = mapper.readValue(requestString, SearchTrack.class);
                json = mapper2.writeValueAsString(searchTrack);
                break;
            case ALBUM:
                searchAlbum = mapper.readValue(requestString, SearchAlbum.class);
                json = mapper2.writeValueAsString(searchAlbum);
                break;
            case ARTIST:
                searchArtist = mapper.readValue(requestString, SearchArtist.class);
                json = mapper2.writeValueAsString(searchArtist);
                break;
            default:
                break;
        }
        
       
       return json;
    
    }
}
