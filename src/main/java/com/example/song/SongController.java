package com.example.song;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.song.Song;
import com.example.song.SongService;
import java.util.*;

@RestController

public class SongController {
    SongService songService = new SongService();

    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return songService.getSongs();
    }

    @PostMapping("/songs")
    public Song addSongs(@RequestBody Song songs) {
        return songService.addSongs(songs);
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId") int songId) {
        return songService.getSongById(songId);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSinger(@PathVariable("songId") int songId, @RequestBody Song singer) {
        return songService.updateSinger(songId, singer);
    }

    @DeleteMapping("/songs/{songId}")

    public void deleteId(@PathVariable("songId") int songId) {
        songService.deleteId(songId);
    }

}