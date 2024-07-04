package com.giftyU.gift_recommendation_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giftyU.gift_recommendation_service.model.RecommendationDetails;

import io.micrometer.common.util.StringUtils;

@RestController
public class GiftyUController {
	
	
	@PostMapping("/getReccomendation")
	ResponseEntity<String>  newEmployee(@RequestBody RecommendationDetails recommendationDetails) {
		
		if(StringUtils.isNotBlank(recommendationDetails.getOccasion())) {
			if(recommendationDetails.getOccasion().equalsIgnoreCase("Anniversary")) {
				return  ResponseEntity.ok("Couples Watch");
			}else if(recommendationDetails.getOccasion().equalsIgnoreCase("Birthday")) {
				return ResponseEntity.ok("Flowers with Cake");
			}else if(recommendationDetails.getOccasion().equalsIgnoreCase("Farewell")) {
				return ResponseEntity.ok("Amazon Gift Card");
			}
		}
		return ResponseEntity.ok("Sorry couldn't find the gift for this occasion :-(");
	  }


}
