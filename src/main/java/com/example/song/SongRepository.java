package com.example.song;

import com.example.song.Song;

import java.util.*;

public interface SongRepository {

    ArrayList<Song> getSongs();

    Song addSongs(Song songs);

    Song getSongById(int songId);

    Song updateSinger(int songId, Song singer);

    void deleteId(int songId);

}