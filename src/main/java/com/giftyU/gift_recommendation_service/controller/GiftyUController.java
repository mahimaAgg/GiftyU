package com.giftyU.gift_recommendation_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giftyU.gift_recommendation_service.model.RecommendationDetails;

import io.micrometer.common.util.StringUtils;

@RestController
public class GiftyUController {
	
	
	@PostMapping("/getReccomendation")
	String newEmployee(@RequestBody RecommendationDetails recommendationDetails) {
		
		if(StringUtils.isNotBlank(recommendationDetails.getOccasion())) {
			if(recommendationDetails.getOccasion().equalsIgnoreCase("Anniversary")) {
				return "Couples Watch";
			}else if(recommendationDetails.getOccasion().equalsIgnoreCase("Birthday")) {
				return "Flowers with Cake";
			}else if(recommendationDetails.getOccasion().equalsIgnoreCase("Farewell")) {
				return "Amazon Gift Card";
			}
		}
		return "Sorry couldn't find the gift for this occasion :-(";
	  }


}
