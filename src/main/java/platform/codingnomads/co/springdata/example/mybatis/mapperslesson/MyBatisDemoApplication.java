package platform.codingnomads.co.springdata.example.mybatis.mapperslesson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MyBatisDemoApplication {

    /* Before running this app, be sure to:

        * create a new empty schema in the mysql database named "mybatis"

        * execute the SQL found "songs_table.sql" on the mybatis schema

        * update the "spring.datasource.url" property in your application.properties file to
          jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

     */

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            Song song3 = new Song();
            song3.setName("Tik Tok");
            song3.setAlbum_name("Animal");
            song3.setArtist_name("Kesha");
            song3.setSong_length(320);

            Song song4 = new Song();
            song4.setName("Take It Off");
            song4.setAlbum_name("Animal");
            song4.setArtist_name("Kesha");
            song4.setSong_length(335);

            Song song5 = new Song();
            song5.setName("Kiss n Tell");
            song5.setAlbum_name("Animal");
            song5.setArtist_name("Kesha");
            song5.setSong_length(328);

            Song song6 = new Song();
            song6.setName("Girlfriend");
            song6.setAlbum_name("The Best Dam Thing");
            song6.setArtist_name("Avril Laving");
            song6.setSong_length(237);

            Song song7 = new Song();
            song7.setName("Runaway");
            song7.setAlbum_name("The Best Dam Thing");
            song7.setArtist_name("Avril Laving");
            song7.setSong_length(309);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);
            songMapper.insertNewSong(song3);
            songMapper.insertNewSong(song4);
            songMapper.insertNewSong(song5);
            songMapper.insertNewSong(song6);
            songMapper.insertNewSong(song7);

            Song songNumber1 = songMapper.getSongById(1L);
            System.out.print("The song with id 1 is:");
            System.out.println(songNumber1.toString());

            ArrayList<Song> longSongs = songMapper.getSongsWithLengthGreaterThan(250);
            System.out.println("Songs with more than 2 mins 50 secs are: ");
            longSongs.forEach(System.out::println);


            //getSongsByName
            ArrayList<Song> songName = songMapper.getSongsByName("Runaway");
            System.out.println("The song name is: ");
            songName.forEach(System.out::println);

            //getSongsByAlbumAndArtist
            ArrayList<Song> songsByArtistAndName = songMapper.getSongsByAlbumAndArtist("Avril Laving", "The Best Dam Thing");
            System.out.println("Songs by Avril Laving in the album of the best dam thing:");
            songsByArtistAndName.forEach(System.out::println);

            //getSongsByArtist
            ArrayList<Song> songsByArtist = songMapper.getSongsByArtist("Kesha");
            System.out.println("Songs By Artist Kesha:");
            songsByArtist.forEach(System.out::println);

            //updateSong
//            Song songUpdate = songMapper.updateSong();

            //getSongByAlbum
            ArrayList<Song> songsByAlbum = songMapper.getSongByAlbum("Orca");
            System.out.println("Songs in the album of Orca:");
            songsByAlbum.forEach(System.out::println);

            //getSongsWithLengthLessThan
            ArrayList<Song> shortSongs = songMapper.getSongsWithLengthLessThan(310);
            System.out.println("Songs with length less than 3 mins 10 seconds: ");
            shortSongs.forEach(System.out::println);

            //deleteSongById
//            Song deleteSongById = songMapper.deleteSongById(3L);

            //deleteSongsByAlbumAndArtist

//            ArrayList<Song> deleteSongByAlbumAndArtist = songMapper.deleteSongsByAlbumAndArtist("Kesha", "Animal");
        };
    }
}
