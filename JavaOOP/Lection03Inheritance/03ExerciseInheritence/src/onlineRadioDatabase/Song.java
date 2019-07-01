package onlineRadioDatabase;

public class Song {
    private String artistName;
    private String songName;
    private String length;
    private int durationInSeconds;

    public Song(String artistName, String songName, String length) throws InvalidSongException {
        this.durationInSeconds = 0;
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(length);
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName.length() < 3 || 20 < artistName.length() ){
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length() < 3 || 30 < songName.length() ){
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setLength(String length) throws InvalidSongMinutesException, InvalidSongSecondsException {
        String[] tokens = length.split(":");
        int minutes = Integer.parseInt(tokens[0]);
        int seconds = Integer.parseInt(tokens[1]);

        if (minutes < 0 || 14 < minutes){
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        if (seconds < 0 || 59 < seconds){
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }

        this.durationInSeconds += seconds;
        this.durationInSeconds += minutes*60;




        this.length = length;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    private String getLength() {
        return length;
    }
}
