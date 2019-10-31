package com.Playlists;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Playlists.RockPlaylists;
import com.Playlists.RockPlaylistsRepo;

@RestController
@CrossOrigin("*")
public class DBFController {
	
	@Autowired
	private RockPlaylistsRepo repo;
		
	@GetMapping("/showAllLists")
	public ArrayList<RockPlaylists> findAll() {
			return repo.findAll();
}
	@GetMapping("/findByUrl/{u}")
	public ArrayList<RockPlaylists> findByUrl(@PathVariable String u) {
		return repo.findByurl(u);
	}
	@GetMapping("/findByPlayListName/{pn}")
	public ArrayList<RockPlaylists> findByPlaylistName(@PathVariable String pn) {
		return repo.findByplaylistName(pn);
	}
	@GetMapping("/findBySubGenre/{sg}")
	public ArrayList<RockPlaylists> findBySubGenre(@PathVariable String sg) {
		return repo.findBysubGenre(sg);	
	}
	@GetMapping("/findByFeaturedArtist/{a}")
	public ArrayList<RockPlaylists> findByFeaturedArtist(@PathVariable String a) {
		return repo.findByfeaturedArtist(a);
	}
	@GetMapping("/findBySubGenreandFeaturedArtist/{s}/{ar}")
	public ArrayList<RockPlaylists> findBysubGenreAndFeaturedArtist(@PathVariable String sg, @PathVariable String a) {
		return repo.findBysubGenreAndFeaturedArtist(sg, a);
	}
		
	@PostMapping("/RockPlaylists")
	public String save(@RequestBody RockPlaylists rp) {
		repo.save(rp);
		return "added";
	}
	
	@RequestMapping("/save")
	public String SaveData (@RequestBody RockPlaylists Ref) {
		if (Ref.getfeaturedArtist()=="Nickelback") {
			return "Save unsuccessful";
		} else {
			repo.save(Ref);
			return "Record saved";
		}
	}
	 @PutMapping("/update/{id}")
	public String UpdateData (@RequestBody RockPlaylists Ref) {
		repo.save(Ref);
		return "updated";

		}
	
	@DeleteMapping("/Deleteby/{pn}")
	public String deletebyPlaylistName (@PathVariable String pn) {
		repo.deleteByPlaylistName(pn);
		return "Delete Successful";
		
	}
}
