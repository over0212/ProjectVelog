package com.velog.web.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.velog.domain.border.Border;
import com.velog.domain.border.BorderRepository;
import com.velog.web.model.dto.border.BorderDto;

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
		System.out.println(borderDto);
		int insertFlag = 0;
		StringBuilder tagName = new StringBuilder();

		Border border = borderDto.toEntity();
		System.out.println(border);
		String[] tagValues = borderDto.getMain_tags();
		for (String str : tagValues) {

			tagName.append(str);
			tagName.append(",");
		}
		tagName.delete(tagName.length() - 1, tagName.length());
		border.setMain_tags(tagName.toString());
		System.out.println(tagName);

		if (insertFlag == 1) {
			return borderRepository.insertBorder(border);
		} else {
			return insertFlag;
		}
	}
}
