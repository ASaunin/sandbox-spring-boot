package com.asaunin.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@ToString
public class Weather {

	private int temp;
	private String description;
	private Location location;
	
}
