package com.giftyU.gift_recommendation_service.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.giftyU.gift_recommendation_service.model.RecommendationDetails;

import io.micrometer.common.util.StringUtils;

@RestController
public class GiftyUController {
	
	@PostMapping("/getReccomendation")
	ResponseEntity<String>  newEmployee(@RequestBody RecommendationDetails recommendationDetails) {
		
		if(StringUtils.isNotBlank(recommendationDetails.getOccasion())) {
			if(recommendationDetails.getOccasion().equalsIgnoreCase("Anniversary")) {
				
				return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Couples Watch");
			}else if(recommendationDetails.getOccasion().equalsIgnoreCase("Birthday")) {
				return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Flowers with Cake");
			}else if(recommendationDetails.getOccasion().equalsIgnoreCase("Farewell")) {
				return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Amazon Gift Card");
			}
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Sorry couldn't find the gift for this occasion :-(");
	  }


}
