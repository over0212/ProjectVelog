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

import com.velog.domain.border.Border;
import com.velog.domain.border.BorderRepository;
import com.velog.web.model.dto.border.BorderDto;
import com.velog.web.model.dto.border.BorderListDto;

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
	public Border getDtlBorderIndex(String url) {
		return borderRepository.getDtlBorderIndex(url);
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
}
