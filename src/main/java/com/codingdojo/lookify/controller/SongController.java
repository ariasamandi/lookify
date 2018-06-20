package com.codingdojo.lookify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;


@Controller
public class SongController {
	private final SongService songService; 
	public SongController(SongService songService) {
		this.songService = songService;
	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute String artist, Model model) {
		List<Song> s = songService.allSongs();
		model.addAttribute("song", s);
		return "dashboard.jsp";
	}
	@RequestMapping(value="/search/{artist}")
	public String search(@PathVariable("artist") String artist,@ModelAttribute Song song, Model model) {
		List<Song> s = songService.search(artist);
		model.addAttribute("song", s);
		model.addAttribute("artist", artist);
		return "search.jsp";
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String startSearch(@RequestParam(value="artist") String artist) {
		return "redirect:/search/"+artist;
	}
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	@RequestMapping("/search/topTen")
	public String ten(Model model) {
		List<Song> s = songService.top();
		model.addAttribute("song", s);
		return "top.jsp";
	}
	@RequestMapping("/songs/{id}")
	public String song(@PathVariable("id") Long id, Model model) {
		Song s = songService.findSong(id);
		model.addAttribute("song", s);
		return "show.jsp";
	}
	@RequestMapping("/songs/new")
	public String newsong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	@RequestMapping("/create")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		 if (result.hasErrors()) {
	         return "redirect:/new";
	     } else {
	    	songService.createSong(song);
	         return "redirect:/dashboard";
	     } 
	}
	
}
