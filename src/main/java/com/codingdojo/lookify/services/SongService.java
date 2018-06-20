package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	public List<Song> allSongs(){
		System.out.println(":)");
		return songRepository.findAll();
	}
	public List<Song> search(String artist){
		return songRepository.findByArtist(artist);
	}
	public Song findSong(Long id){
		Optional<Song> song = songRepository.findById(id);
		if(song.isPresent()) {
			return song.get();
	     } else {
	         return null;
	     }
	}
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	 public Song createSong(Song b) {
	     return songRepository.save(b);
	 }
	 public List<Song> top() {
		 return songRepository.findTop10ByOrderByRatingDesc();
	 }
}
