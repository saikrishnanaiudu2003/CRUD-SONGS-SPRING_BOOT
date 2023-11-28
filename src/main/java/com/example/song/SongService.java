package com.example.song;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.example.song.Song;
import com.example.song.SongRepository;

public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    int uniqueId = 6;

    @Override
    public ArrayList<Song> getSongs() {
        Collection<Song> songCollection = playlist.values();
        ArrayList<Song> allSongs = new ArrayList<>(songCollection);
        return allSongs;
    }

    @Override
    public Song addSongs(Song songs) {
        songs.setSongId(uniqueId);
        playlist.put(uniqueId, songs);
        uniqueId += 1;
        return songs;
    }

    @Override
    public Song getSongById(int songId) {
        Song alreadyExist = playlist.get(songId);
        if (alreadyExist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return alreadyExist;
    }

    @Override
    public Song updateSinger(int songId, Song singer) {
        Song alreadyExitSong = playlist.get(songId);
        if (alreadyExitSong == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (alreadyExitSong != null) {
            alreadyExitSong.setSinger(singer.getSinger());
        }
        return alreadyExitSong;
    }

    @Override
    public void deleteId(int songId) {
        Song alreadySong = playlist.get(songId);
        if (alreadySong == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}