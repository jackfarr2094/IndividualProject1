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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
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
	public RockPlaylists showUrl(@PathVariable String u) {
		return repo.findByurl(u);
	}
	@GetMapping("/findByPlayListName/{pn}")
	public ArrayList<RockPlaylists> findByPlaylistName (@PathVariable String pn) {
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
	public ArrayList<RockPlaylists> findBysubGenreAndFeaturedArtist(@PathVariable String s, @PathVariable String ar) {
		return repo.findBysubGenreAndFeaturedArtist(s, ar);
	}
	@PostMapping("/RockPlaylists")
	public ResponseEntity<Object> createSRockPlaylists(@RequestBody RockPlaylists rockplaylists) {
		RockPlaylists savedRockPlaylists = repo.save(rockplaylists);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{playlistName}")
				.buildAndExpand(savedRockPlaylists.getId()).toUri();

		return ResponseEntity.created(location).build();
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
	 /*@PutMapping("/update/{id}/{url}/{playlist}/{subGenre}/{featuredArtist}")
	public void UpdateData (@PathVariable int id, @PathVariable String url, @PathVariable String playlistName, @PathVariable String subGenre, @PathVariable String featuredArtist) {
		RockPlaylists Ref = new RockPlaylists();
		Ref.setId(id);
		Ref.setUrl(url);
		Ref.setplaylistName(playlistName);
		Ref.setsubGenre(subGenre);
		Ref.setfeaturedArtist(featuredArtist);
		repo.update(Ref);
		}*/
	
	@DeleteMapping("/Deleteby/{pn}")
	public String deletebyplaylistName (@PathVariable String playlistName) {
		//RockPlaylists Ref = new RockPlaylists();
		//Ref.getplaylistName();
		repo.deleteByPlaylistName(playlistName);
		return "Delete Successful";
		
	}
}
