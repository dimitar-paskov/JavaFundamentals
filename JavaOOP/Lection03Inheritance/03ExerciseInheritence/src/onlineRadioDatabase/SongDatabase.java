package onlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

public class SongDatabase {
    private List<Song> songs;

    public SongDatabase() {
        this.songs = new ArrayList<>();
    }

    public void addSong (Song song){
        songs.add(song);
    }

    public String getTotalLengthOfSongs (){
        
        int totalSeconds = 0;

        for (Song song :
                this.songs) {
            totalSeconds += song.getDurationInSeconds();

        }

        int hours = totalSeconds/3600;
        totalSeconds = totalSeconds%3600;
        int minutes = totalSeconds/60;
        totalSeconds = totalSeconds%60;



        return String.format("Songs added: %d%nPlaylist length: %dh %dm %ds",this.songs.size(),hours, minutes, totalSeconds );



    }
}
