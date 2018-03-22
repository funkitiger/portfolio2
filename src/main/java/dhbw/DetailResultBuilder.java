/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw;


import com.fasterxml.jackson.databind.ObjectMapper;
import dhbw.pojo.detail.album.DetailsAlbum;
import dhbw.pojo.detail.artist.DetailsArtist;
import dhbw.pojo.detail.track.DetailsTrack;
import dhbw.pojo.result.detail.DetailResult;
import dhbw.spotify.RequestCategory;
import java.io.IOException;

/**
 *
 * @author Nicole
 */
public class DetailResultBuilder {

    static ObjectMapper mapper = new ObjectMapper();

    public static DetailResult buildResult(RequestCategory category, String id, String json) throws IOException {

        DetailResult result = new DetailResult();

        switch (category) {
            case TRACK:
                DetailsTrack detailsTrack = mapper.readValue(json, DetailsTrack.class);
                DetailResult trackDetailResult = new DetailResult();

                trackDetailResult.setInfo(detailsTrack.getType());
                trackDetailResult.setTitle(detailsTrack.getName());
                result = trackDetailResult;
                break;

            case ALBUM:
                DetailsAlbum detailsAlbum = mapper.readValue(json, DetailsAlbum.class);
                DetailResult albumDetailResult = new DetailResult();

                albumDetailResult.setInfo(detailsAlbum.getType());
                albumDetailResult.setTitle(detailsAlbum.getName());
                result = albumDetailResult;
                break;

            case ARTIST:
                DetailsArtist detailsArtist = mapper.readValue(json, DetailsArtist.class);
                DetailResult artistDetailResult = new DetailResult();
                
                artistDetailResult.setInfo(detailsArtist.getType());
                artistDetailResult.setTitle(detailsArtist.getName());
                artistDetailResult.setPopularity(detailsArtist.getPopularity());
                result = artistDetailResult;
                break;
        }

        return result;

    }

}
