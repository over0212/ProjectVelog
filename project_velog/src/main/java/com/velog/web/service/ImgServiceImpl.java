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

	@Override
	public String fileUpload(String username,MypageDto mypageDto) {
		String imageFileName = mypageDto.getMypageImg().getOriginalFilename();
		String userFolder = "/profile/"+username + UUID.randomUUID().toString().replaceAll("-", "");
		String imageFilePath = filePath + userFolder;
		File file = new File(imageFilePath,imageFileName);
		if (!file.exists()) {
			file.mkdirs();
		}
		try {
			mypageDto.getMypageImg().transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return userFolder + "/" + imageFileName;
	}
	
	@Override
	public int mypageinsert(MypageDto mypageDto) {
		
		int insertFlag = 0;
		if(insertFlag == 1) {
			
		}

		int mstInsertFlag = userRepository.profileImgInsert(user);
		return mstInsertFlag;
	}


}

/*
 * @Transactional public void imgUpload(MypageDto mypageDto, MultipartFile
 * multipartFile) {
 * 
 * User user = new User(); BCryptPasswordEncoder encoder = new
 * BCryptPasswordEncoder();
 * 
 * String imgFileName = user.getId() + "-" +
 * multipartFile.getOriginalFilename(); Path imgFilePath =
 * Paths.get(uploadFolder + imgFileName);
 * 
 * if (multipartFile.getSize() != 0) { // 파일이 업로드 되었는지 확인 try { if
 * (user.getProfile_img_origin_name() != null) { // 프로필 사진이 있을경우 File file = new
 * File(uploadFolder + user.getProfile_img_origin_name()); file.delete(); //
 * 원래파일 삭제 } Files.write(imgFilePath, multipartFile.getBytes()); } catch
 * (Exception e) { e.printStackTrace(); }
 * user.setProfile_img_origin_name(imgFileName); } }
 */
