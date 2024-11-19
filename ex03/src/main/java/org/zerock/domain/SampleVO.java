package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {

	private Integer mno; // int타입의 객체 (NULL 허용)
	private String firstName;
	private String lastName;
}
