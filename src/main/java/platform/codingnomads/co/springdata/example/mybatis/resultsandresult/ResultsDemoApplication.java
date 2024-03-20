package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResultsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultsDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            //notice the setter names have changed to match Java naming conventions
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbumName("Bon Iver");
            song1.setArtistName("Bon Iver");
            song1.setSongLength(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbumName("Orca");
            song2.setArtistName("Gus Dapperton");
            song2.setSongLength(279);

            Song song3 = new Song();
            song3.setName("Better Than Ever");
            song3.setAlbumName("A Side of Me");
            song3.setArtistName("Nikita Kering");
            song3.setSongLength(168);

            Song song4 = new Song();
            song3.setName("Never Let Me Go");
            song3.setAlbumName("A Side of Me");
            song3.setArtistName("Nikita Kering");
            song3.setSongLength(170);

            Song song5 = new Song();
            song3.setName("Ex");
            song3.setAlbumName("A Side of Me");
            song3.setArtistName("Nikita Kering");
            song3.setSongLength(249);

            Song song6 = new Song();
            song3.setName("Fly");
            song3.setAlbumName("Pink Friday");
            song3.setArtistName("Nicki Minaj");
            song3.setSongLength(320);

            Song song7 = new Song();
            song3.setName("Moment 4 Life");
            song3.setAlbumName("Pink Friday");
            song3.setArtistName("Nicki Minaj");
            song3.setSongLength(400);

            Song song8 = new Song();
            song3.setName("Right Through Me");
            song3.setAlbumName("Pink Friday");
            song3.setArtistName("Nicki Minaj");
            song3.setSongLength(220);

            Song song9 = new Song();
            song3.setName("Save Me");
            song3.setAlbumName("Pink Friday");
            song3.setArtistName("Nicki Minaj");
            song3.setSongLength(220);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);
            songMapper.insertNewSong(song3);
            songMapper.insertNewSong(song4);
            songMapper.insertNewSong(song5);
            songMapper.insertNewSong(song6);
            songMapper.insertNewSong(song7);
            songMapper.insertNewSong(song8);
            songMapper.insertNewSong(song9);

            Song getSongId = songMapper.getSongById(1L);
            System.out.println(getSongId.toString());
        };
    }
}
