package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload form");
	}
	
	@PostMapping("/uploadFormAcrion")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		
		String uploadFolder = "C:\\upload";
		
		for(MultipartFile multipartFile :  uploadFile) {
			log.info("------------------------------------");
			log.info("Upload File Name : " + multipartFile.getOriginalFilename());
			log.info("Upload File Size : " + multipartFile.getSize());
			
			// 파일 경로 설정
			File saveFile = new File(uploadFolder,multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile); // 파일 저장
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("uploadAjax");
	}
	
	
	
	/*
	 * @PostMapping("/uploadAjaxAction") public void
	 * uploadAjaxAction(MultipartFile[] uploadFile, Model model) {
	 * 
	 * String uploadFolder = "C:\\upload";
	 * 
	 * 
	 * //make folder ............. File uploadPath = new File(uploadFolder,
	 * getFolder()); log.info("upload Path : " + uploadPath); //
	 * c\\upload\2024\11\19
	 * 
	 * 
	 * if(uploadPath.exists() == false ) { uploadPath.mkdirs(); // make yyyy/MM/dd
	 * folder 생성.. }
	 * 
	 * for(MultipartFile multipartFile : uploadFile) {
	 * log.info("------------------------------------");
	 * log.info("Upload File Name : " + multipartFile.getOriginalFilename());
	 * log.info("Upload File Size : " + multipartFile.getSize());
	 * 
	 * 
	 * String uploadFileName = multipartFile.getOriginalFilename();
	 * 
	 * uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
	 * 
	 * log.info("only file name : " + uploadFileName);
	 * 
	 * 
	 * //중복 방지 식별자 생성 UUID UUID uuid = UUID.randomUUID();
	 * 
	 * // -> "934657b2-15d1-4541-9868-b99ec1a33627_파일명" uploadFileName =
	 * uuid.toString() + "_" + uploadFileName;
	 * log.info("-------------------------"); //-반한되는 객체가 UUID 객체이므로 문자열 표현을 얻기 위해
	 * toString() 메소드로 출력 log.info(uuid.toString());
	 * 
	 * 
	 * // 파일 경로 설정 c\\upload\2024\11\19 File saveFile = new
	 * File(uploadPath,uploadFileName); // File saveFile = new
	 * File(uploadFolder,multipartFile.getOriginalFilename());
	 * 
	 * try { multipartFile.transferTo(saveFile); // 파일 저장 완료
	 * if(checkImageType(saveFile)) { // 이미지 파일이면 썸네일 만들어야 함
	 * 
	 * FileOutputStream thumbnail = new FileOutputStream(new File( uploadPath, "s_"
	 * + uploadFileName)); //이미지 파일명에 s_ 추가
	 * 
	 * Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 200,
	 * 200); //썸네일 이미지 생성 thumbnail.close(); } } catch (Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * }
	 */
	
	// 메서드 - 파일 업로드 처리
	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
		

		List<AttachFileDTO> list = new ArrayList<AttachFileDTO>();
		
		String uploadFolder = "C:\\upload";

		// make folder ............. 2024/11/19 
		// getFolder 메서드 - 오늘날짜로 폴더 경로 생성해서 값 전달
		String uploadFolderPath = getFolder(); 
		log.info("upload Path : " + uploadFolderPath); // c\\upload\2024\11\19
		

		// uploadPath 값 --> c:\\upload\2014\11\19
		File uploadPath = new File(uploadFolder, uploadFolderPath);

		// make yyyy/MM/dd folder 생성.. (해당 경로가 생성되어있지 않으면)
		if(uploadPath.exists() == false ) {
			uploadPath.mkdirs(); 
		}
		

		// 업로드 한 파일 건수만큼 반복
		for(MultipartFile multipartFile :  uploadFile) {
			
			AttachFileDTO attachDTO = new AttachFileDTO(); //파일DTO생성
			String uploadFileName = multipartFile.getOriginalFilename();
			uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			log.info("only file name : " + uploadFileName); 
			
			attachDTO.setFileName(uploadFileName);
			attachDTO.setUploadPath(uploadFolderPath);
			
			
			//중복 방지 식별자 생성 UUID
			UUID uuid = UUID.randomUUID();
			
			// -> "934657b2-15d1-4541-9868-b99ec1a33627_파일명"
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			//-반한되는 객체가 UUID 객체이므로 문자열 표현을 얻기 위해 toString() 메소드로 출력
			attachDTO.setUuid(uuid.toString()); 			
			
			// 파일 경로 설정 c\\upload\2024\11\19
			File saveFile = new File(uploadPath,uploadFileName);
//			File saveFile = new File(uploadFolder,multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile); // 파일 저장 완료
				
				if(checkImageType(saveFile)) { // 이미지 파일이면 썸네일 만들어야 함
					
					FileOutputStream thumbnail = new FileOutputStream(new File(
							uploadPath, "s_" + uploadFileName)); //이미지 파일명에 s_ 추가
					
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 200, 200); //썸네일 이미지 생성
					thumbnail.close();
					
					attachDTO.setImage(true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			list.add(attachDTO); //반복 후 DTO 반환
		}//end for
		
		return new ResponseEntity<>(list, HttpStatus.OK); //ResponseEntity 객체 반환
	}
	
	
	// 메서드 - 오늘날짜로 폴더 경로 생성
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
	
	
	// 메서드 - 이미지 파일 여부 판단
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			
			log.info("contentType : " + contentType);
			return contentType.startsWith("image");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName){
		log.info("fileName : " + fileName);
		
		File file = new File("c:\\upload\\" + fileName);
		
		log.info("file : " + file);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	@GetMapping(value = "/download", produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(String fileName){
		log.info("download file : " + fileName);
		
		Resource resource = new FileSystemResource("c:\\upload\\"+fileName);
		log.info("resource : " + resource);
		
		if(resource.exists() == false) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		String resourceName = resource.getFilename();
		
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1)
;		
		log.info("resourceName : " + resourceName);
		
		HttpHeaders header = new HttpHeaders();
		
		try {
//			header.add("Content-Disposition", "attachment; filename="
//					+ new String(resourceName.getBytes("utf-8"), "ISO-8859-1"));
			
			header.add("Content-Disposition", "attachment; filename="
					+ URLEncoder.encode(resourceOriginalName, "utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	
	

}
