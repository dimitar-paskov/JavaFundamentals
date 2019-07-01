package onlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        SongDatabase songDatabase = new SongDatabase();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int expectedNumberOfSongs = Integer.parseInt(br.readLine());

        for (int i = 0; i < expectedNumberOfSongs; i++) {
            String[] tokens = br.readLine().split(";");
            String artistName = tokens[0];
            String songName = tokens[1];
            String length = tokens[2];

            try {
                Song song = new Song(artistName, songName, length);
                System.out.println("Song added.");
                songDatabase.addSong(song);

            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println(songDatabase.getTotalLengthOfSongs());


    }
}
