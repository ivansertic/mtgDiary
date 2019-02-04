package com.ivan.sertic.controllers;

import com.ivan.sertic.dto.EntryDto;
import com.ivan.sertic.mapper.EntryMapper;
import com.ivan.sertic.model.Diary;
import com.ivan.sertic.model.Entry;
import com.ivan.sertic.services.DiaryService;
import com.ivan.sertic.services.EntryService;
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
public class RestEntryController {

    @Autowired
    private DiaryService diaryService;

    @Autowired
    private EntryService entryService;

    @Autowired
    private EntryMapper entryMapper;

    public static final Logger logger = LoggerFactory.getLogger(RestDiaryController.class);

    //Return all entries of a diary
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value ="/{externalUserId}/diary/{externalDiaryId}/entry", method = RequestMethod.GET)
    public ResponseEntity<List<EntryDto>> getAllEntriesOfDiary(@PathVariable("externalUserId") UUID externalUserId,
                                                               @PathVariable("externalDiaryId") UUID externalDiaryId){
        final Diary userDiary = diaryService.getDiaryFromUser(externalDiaryId,externalUserId);
        final List<Entry> entries = new LinkedList<>();

        if(userDiary == null){
            return ResponseEntity.notFound().build();
        }else{
            entries.addAll(entryService.getAllEntries(externalDiaryId));
        }

        final List<EntryDto> response = entries.stream().map(entry -> entryMapper.toDto(entry)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    //Returns entry of a diary

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/diary/{externalDiaryId}/entry/{externalEntryId}", method = RequestMethod.GET)
    public ResponseEntity<EntryDto> getDiaryEntry(@PathVariable("externalUserId") UUID externalUserId,
                                                        @PathVariable("externalDiaryId") UUID externalDiaryId,
                                                        @PathVariable("externalEntryId") UUID externalEntryId){
        final Entry diaryEntry = entryService.getSingleEntry(externalDiaryId,externalUserId,externalEntryId);
        if(diaryEntry == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(entryMapper.toDto(diaryEntry));
        }

    }

    //Create Diary entry

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/diary/{externalDiaryId}/entry", method = RequestMethod.POST)
    public ResponseEntity<String> createDiaryEntry(@PathVariable("externalUserId") UUID externalUserId,
                                                   @PathVariable("externalDiaryId") UUID externalDiaryId,
                                                   @Valid @RequestBody EntryDto dto){
        final Diary userDiary = diaryService.getDiaryFromUser(externalDiaryId,externalUserId);

        if(userDiary == null){
            return ResponseEntity.notFound().build();
        }else{
            final Entry entry = entryMapper.createEntity(dto);
            entry.setDiary(userDiary);
            userDiary.getEntries().add(entry);

            entryService.create(entry);

            return ResponseEntity.ok().build();
        }
    }

    //Update Diary

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/diary/{externalDiaryId}/entry/{externalEntryId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateEntry(@PathVariable("externalUserId")UUID externalUserId,
                                              @PathVariable("externalDiaryId")UUID externalDiaryId,
                                              @PathVariable("externalEntryId")UUID externalEntryId,
                                              @RequestBody EntryDto dto){
        final Entry diaryEntry = entryService.getSingleEntry(externalDiaryId,externalUserId,externalEntryId);

        if(diaryEntry == null){
            return ResponseEntity.notFound().build();
        }else{
            entryMapper.update(diaryEntry,dto);
            entryService.update(externalEntryId, diaryEntry);
            return ResponseEntity.ok().build();
        }
    }

    //Delete entry

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/diary/{externalDiaryId}/entry/{externalEntryId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEntry(@PathVariable("externalUserId")UUID externalUserId,
                                              @PathVariable("externalDiaryId")UUID externalDiaryId,
                                              @PathVariable("externalEntryId")UUID externalEntryId){
        final Entry diaryEntry = entryService.getSingleEntry(externalDiaryId,externalUserId,externalEntryId);

        if(diaryEntry == null){
            return ResponseEntity.notFound().build();
        }else{
            entryService.deleteByExternalId(externalEntryId);
            return ResponseEntity.ok().build();
        }
    }
}
