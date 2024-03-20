package platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Album;

@Mapper
public interface AlbumMapper {
    @Insert("INSERT INTO mybatis.album " +
            "name, year, artist, song")
    void insertNewAlbum(Album album);

}
