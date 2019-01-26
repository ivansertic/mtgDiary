package com.ivan.sertic.controllers;


import com.ivan.sertic.dto.DiaryDto;
import com.ivan.sertic.mapper.DiaryMapper;
import com.ivan.sertic.model.Diary;
import com.ivan.sertic.model.Users;
import com.ivan.sertic.services.DiaryService;
import com.ivan.sertic.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class RestDiaryController {

    @Autowired
    private DiaryService diaryService;

    @Autowired
    private UserService userService;

    @Autowired
    private DiaryMapper diaryMapper;
    public static final Logger logger = LoggerFactory.getLogger(RestDiaryController.class);

    // Retrieve All Diaries of a Users
    @RequestMapping(value = "/{externalUserId}/diary", method = RequestMethod.GET)
    public ResponseEntity<List<DiaryDto>> listAllDiaries(@PathVariable("externalUserId") UUID externalUserId){
        final List<Diary> userDiary = new LinkedList<>();

        if(userDiary == null){
            return ResponseEntity.notFound().build();
        }else{
            userDiary.addAll(diaryService.getAllDiaries(externalUserId));
        }

        final List<DiaryDto> response = userDiary.stream().map(diary -> diaryMapper.toDto(diary)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    // Retrieve single diary

    @RequestMapping(value = "/{externalUserId}/diary/{externalDiaryId}", method = RequestMethod.GET)
    public ResponseEntity<DiaryDto> getDiaryEntry(@PathVariable("externalUserId") UUID externalUserId, @PathVariable("externalDiaryId") UUID externalDiaryId){
        final Diary userDiary = diaryService.getDiaryFromUser(externalDiaryId,externalUserId);

        if(userDiary == null){
            return  ResponseEntity.notFound().build();
        }else{
          return ResponseEntity.ok().body(diaryMapper.toDto(userDiary));
        }
    }

    //Create diary
    @RequestMapping(value = "/{externalUserId}/diary", method = RequestMethod.POST)
    public ResponseEntity<String> createDiary(@PathVariable("externalUserId") UUID externalUserId,
                                              @Valid @RequestBody DiaryDto dto){
        final Users user = userService.getUserByExternalId(externalUserId);

        if(user == null){
            return ResponseEntity.notFound().build();
        }else{
            final Diary diary = diaryMapper.createEntity(dto);

            diary.setUser(user);
            user.addDiary(diary);

            diaryService.create(diary);

            return ResponseEntity.ok().build();
        }
    }

    // Delete Diary
    @RequestMapping(value = "/{externalUserId}/diary/{externalDiaryId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDiary(@PathVariable("externalUserId")UUID externalUserID, @PathVariable("externalDiaryId")UUID externalDiaryId){
        final Diary userDiary = diaryService.getDiaryFromUser(externalDiaryId,externalUserID);

        if(userDiary == null){
            return ResponseEntity.notFound().build();
        }else{
            diaryService.delete(externalDiaryId);
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/{externalUserId}/diary", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAllDiaries(@PathVariable("externalUserId")UUID externalUserId){
        final Users user = userService.getUserByExternalId(externalUserId);

        if(user == null){
            return ResponseEntity.ok().build();
        }else{
            diaryService.deleteAll(externalUserId);
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{externalUserId}/diary/{externalDiaryId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateDiary(@PathVariable("externalUserId") UUID externalUserId,
                                              @PathVariable("externalDiaryId") UUID externalDiaryId,
                                              @RequestBody DiaryDto dto){
        final Diary userDiary = diaryService.getDiaryFromUser(externalDiaryId,externalUserId);

        if(userDiary == null){
            return ResponseEntity.notFound().build();
        }else{
            diaryMapper.update(userDiary,dto);
            diaryService.update(externalDiaryId,userDiary);

            return ResponseEntity.ok().build();
        }
    }
}
