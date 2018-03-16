/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author Nicole
 */

@RestController
public class SearchWebService {
    
    @RequestMapping("/search")
    public SpotifyRequest search(@RequestParam(value="query")String query, @RequestParam(value="Type")String Type){
        
        
    }
    
    
    
}
