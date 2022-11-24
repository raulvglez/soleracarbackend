package com.solera.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.solera.methods.ModifiedMaze;

@Controller
public class CarController {
	
	String highestPlayer = "";
	int highestPoints = 0;
	
	@GetMapping("/")
	@ResponseBody
	public int[][] getArrayMap() {
		ModifiedMaze mz = new ModifiedMaze();
		int[][] sendArray = mz.modified();
		return sendArray;
	}
	
	@GetMapping("/points/{player}/{points}")
	public String sendPlayerPoints(@PathVariable String player, @PathVariable int points) {
		if (points > highestPoints) {
			highestPlayer = player;
			highestPoints = points;
		}
		
		return "redirect:/maxpoints";
	}
	
	@GetMapping("/maxpoints")
	@ResponseBody
	public String getMaxPoints() {
		return "The player with the highest points is: '" + highestPlayer + "' with " + highestPoints + " points";
	}

}
