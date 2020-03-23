package academy.everyonecodes.musicstation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("music")
public class MusicStation {
    private List<Song> songs;

    void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> findAll() {
        return songs;
    }

    public List<Song> findBy(String name) {
        return songs.stream()
                .filter(song -> song.getGenre().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
