package org.zerock.domain;

import lombok.Data;

/*원본 파일의 이름, 업로드 경로, UUID, 이미지 여부 정보를 
하나로 묶어서 전달하는 용도로 사용*/

@Data	
public class AttachFileDTO {

	private String fileName; 	//원본파일명
	private String uploadPath; 	//업로드 경로
	private String uuid; 		//저장파일명(유일한 식별자)
	private boolean image; 		//이미지여부
	
}
