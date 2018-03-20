/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw;

import com.fasterxml.jackson.databind.ObjectMapper;
import dhbw.pojo.result.search.SearchResult;
import dhbw.pojo.result.search.SearchResultList;
import dhbw.pojo.search.album.SearchAlbum;
import dhbw.pojo.search.artist.SearchArtist;
import dhbw.pojo.search.track.SearchTrack;
import dhbw.spotify.RequestCategory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Nicole
 */
public class SearchResultBuilder {

    static ObjectMapper mapper = new ObjectMapper();

    public static SearchResult buildResult(RequestCategory category, String json, String query) throws IOException {

        SearchResult result = new SearchResult();
        List<SearchResultList> resultListe;
        resultListe = new ArrayList<>();
        result.setResults(null);
        result.setSearchCategory(null);
        result.setSearchTerm(null);
        result.setSearchCategory(category.toString());
        result.setSearchTerm(query);

        switch (category) {
            case TRACK:
                SearchTrack searchTrack = mapper.readValue(json, SearchTrack.class);
                List<SearchResultList> trackHilfsListe;
                trackHilfsListe = new ArrayList<>();

                searchTrack.getTracks().getItems().stream().map((track) -> {
                    SearchResultList searchResultList = new SearchResultList();
                    searchResultList.setDescription(track.getType());
                    searchResultList.setId(track.getId());
                    searchResultList.setPlayLink(track.getUri());
                    searchResultList.setTitle(track.getName());
                    return searchResultList;
                }).forEachOrdered((searchResultList) -> {
                    trackHilfsListe.add(searchResultList);
                });
                resultListe = trackHilfsListe;
                break;
                
            case ALBUM:
                SearchAlbum searchAlbum = mapper.readValue(json, SearchAlbum.class);
                List<SearchResultList> albumHilfsListe;
                albumHilfsListe = new ArrayList<>();

                searchAlbum.getAlbums().getItems().stream().map((album) -> {
                    SearchResultList searchResultList = new SearchResultList();
                    searchResultList.setDescription(album.getType());
                    searchResultList.setId(album.getId());
                    searchResultList.setPlayLink(album.getUri());
                    searchResultList.setTitle(album.getName());
                    return searchResultList;
                }).forEachOrdered((searchResultList) -> {
                    albumHilfsListe.add(searchResultList);
                });

                resultListe = albumHilfsListe;
                break;
            case ARTIST:
                SearchArtist searchArtist = mapper.readValue(json, SearchArtist.class);
                List<SearchResultList> artistHilfsListe;
                artistHilfsListe = new ArrayList<>();
                

                searchArtist.getArtists().getItems().stream().map((artist) -> {
                    SearchResultList searchResultList = new SearchResultList();
                    searchResultList.setDescription(artist.getType());
                    searchResultList.setId(artist.getId());
                    searchResultList.setPlayLink(artist.getUri());
                    searchResultList.setTitle(artist.getName());
                    return searchResultList;
                }).forEachOrdered((searchResultList) -> {
                    artistHilfsListe.add(searchResultList);
                });

                resultListe = artistHilfsListe;
                break;
            default:
                break;

        }
        result.setResults(resultListe);
        return result;
        

    }

}
