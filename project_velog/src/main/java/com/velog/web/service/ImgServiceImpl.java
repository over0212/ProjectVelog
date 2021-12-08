package com.velog.web.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.velog.domain.user.User;
import com.velog.domain.user.UserRepository;
import com.velog.web.model.dto.mypage.MypageDto;

@Service
public class ImgServiceImpl implements ImgService {

	@Value("${file.path}")
	private String filePath;

	@Autowired
	private UserRepository userRepository;
	
	private User user;

	@Override
	public String updateProfileImg(int id, MypageDto mypageDto) {
		String originFileName = mypageDto.getFile().getOriginalFilename();
		String originFileExtension = originFileName.substring(originFileName.lastIndexOf("."));
		String tempfilename = UUID.randomUUID().toString().replaceAll("-", "") + originFileExtension;
		String userFolder = "profile/" + id + "/";
		String imageFilePath = filePath + userFolder + tempfilename;
		
		String oldFileName = user.getProfile_img_url();
		String oldFileFolder = filePath + userFolder ;
		File oldFile = new File(oldFileFolder);
		
		File file = new File(imageFilePath);
		if (!file.exists()) {
			file.mkdirs(); // 폴더경로 생성
		}
		
		try {
			if (mypageDto.getFile() != null) {
				file.delete();// 괄호안에 현재 db에 저장되어있는 파일 이름을 지정
			}
			mypageDto.getFile().transferTo(file); // 파일을 복붙느낌
			User userntt = mypageDto.toEntity(mypageDto.getId());
			userntt.setProfile_img_url(tempfilename);
			userRepository.updateProfileImg(userntt);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return tempfilename;
	}

	@Override
	public int deleteProfileImg(int id) {

		return userRepository.deleteProfileImg(id);
	}

}

//	@Transactional public void imgUpload(MypageDto mypageDto, MultipartFile multipartFile) {
//  
//  User user = new User(); BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
// 
//  String imgFileName = user.getId() + "-" +
//  multipartFile.getOriginalFilename(); Path imgFilePath =
//  Paths.get(uploadFolder + imgFileName);
//  
//  if (multipartFile.getSize() != 0) { // 파일이 업로드 되었는지 확인 try 
//		{  if (user.getProfile_img_origin_name() != null) { // 프로필 사진이 있을경우 
// File file = new File(uploadFolder + user.getProfile_img_origin_name()); file.delete(); // 원래파일 삭제 
//	} Files.write(imgFilePath, multipartFile.getBytes()); } catch
//  (Exception e) { e.printStackTrace(); }
//  user.setProfile_img_origin_name(imgFileName); }
//}
