package com.velog.web.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.velog.config.auth.PrincipalDetails;
import com.velog.domain.border.Border;
import com.velog.domain.border.BorderRepository;
import com.velog.domain.user.Mypage;
import com.velog.web.model.dto.border.BorderDto;
import com.velog.web.model.dto.border.BorderListDto;
import com.velog.web.model.dto.border.BorderUpdateDto;
import com.velog.web.model.dto.border.IndexBorderDto;
import com.velog.web.model.dto.border.LikeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BorderServiceImpl implements BorderService {

	private final BorderRepository borderRepository;

	@Value("${file.path}")
	private String filePath;

	@Override
	public String imageUpload(int id, MultipartFile multipartFile) {
		String imageFileName = multipartFile.getOriginalFilename(); // 파일의 이름을 불러온다.
		String originFileExtension = imageFileName.substring(imageFileName.lastIndexOf(".")); // 확장자까지 자른다.
		// 경로 지정
		String userFolder = id + "/post"; // 폴더의 경로
		String imageName = UUID.randomUUID().toString().replaceAll("-", "") + originFileExtension;
		String imageFilePath = filePath + userFolder;
		File file = new File(imageFilePath, imageName);
		if (!file.exists()) {
			file.mkdirs();
		}
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return userFolder + "/" + imageName;
	}

	@Override
	public int insertBorder(BorderDto borderDto) {
		StringBuilder tagName = new StringBuilder();

		Border border = borderDto.toEntity();
		String[] tagValues = borderDto.getMain_tags();
		if(tagValues != null) {
			for (String str : tagValues) {

				tagName.append(str);
				tagName.append(",");
			}
			tagName.delete(tagName.length() - 1, tagName.length());
			border.setMain_tags(tagName.toString());
		}
		
		return borderRepository.insertBorder(border);
	}
	
	// border_dtl에 대한 정보들을 들고온다.
	@Override
	public Border getDtlBorderIndex(String url, PrincipalDetails principalDetails) {
		Border border = borderRepository.getDtlBorderIndex(url);
		// 로그인시 자신의 게시물의 조회수는 +1 되지 않도록 하는 방어적 코드
		if(principalDetails != null) {
			if(!principalDetails.getUser().getUsername().equals(border.getUsername())) {
				plusBorderCount(url);			
			}
			border.setLikeFlag(getLikeUser(url, principalDetails.getUser().getId()));
			System.out.println(getLikeUser(url, principalDetails.getUser().getId()));
		}else{
			// 로그인이 안되어있을 경우 모든 게시글 조회수 +1
			plusBorderCount(url);	
		}
		return border;
	}
	
	@Override
	public void plusBorderCount(String url) {
		borderRepository.plusBorderCount(url);
	}
	
	// 태그 들고오기
	@Override
	public List<BorderListDto> getBorderList(String username) {
		List<Border> borderList = borderRepository.getBorderList(username);
		List<BorderListDto> borderListDtos = new ArrayList<BorderListDto>();
		for (Border border : borderList) {
			BorderListDto borderListDto = border.toDto();
			if(border.getMain_tags() != null) {
				StringTokenizer st = new StringTokenizer(border.getMain_tags(), ",");
				List<String> tags = new ArrayList<String>();
				
				while(st.hasMoreTokens()) {
					tags.add(st.nextToken()); 
				}
				borderListDto.setMain_tags(tags);
			}
			borderListDtos.add(borderListDto);
		}
		
		return borderListDtos;
	}
	
@Override
	public int updateBorder(BorderUpdateDto borderUpdateDto) {
		StringBuilder tagName = new StringBuilder();

		Border border = borderUpdateDto.toEntity();
		System.out.println(border);
		String[] tagValues = borderUpdateDto.getMain_tags();
		if(tagValues != null) {
			for (String str : tagValues) {

				tagName.append(str);
				tagName.append(",");
			}
			tagName.delete(tagName.length() - 1, tagName.length());
			border.setMain_tags(tagName.toString());
		}
		return borderRepository.updateBorder(border);
	}
	
	@Override
	public int deleteBorder(String url) {
		int result = 0;
		result += borderRepository.deleteBorder(url);
		return result;
	}

	@Override
	public int updateMyborder(Mypage mypage) {
		int result = 0;
		result = borderRepository.updateMyborder(mypage.getId());
		System.out.println(result);
		return result;
	}
	
	@Override
	public int insertLike(int id, String url) {
		int result = 0;
		result = borderRepository.insertLike(id, url); // 성공이면 1
		if(result == 1) {
			result = borderRepository.plusLike(url); // 성공이면 1
			
		}
		return result;			
	}

	@Override
	public int deleteLike(int id, String url) {
		int result = 0; 
		result = borderRepository.deleteLike(id, url); // 성공이면 1
		if(result == 1) {
			result = borderRepository.minusLike(url);
		}
		return result;	
	}
	
	@Override
	public int getLikeUser(String url, int id) {
		int result = borderRepository.getLikeUser(url, id);		
		System.out.println("Repository return : " + result);
		return result;
	}
	
	@Override
	public int getLikeCount(String url) {
		return borderRepository.getLikeCount(url);
	}
}
