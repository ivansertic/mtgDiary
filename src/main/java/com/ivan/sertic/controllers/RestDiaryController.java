package com.ivan.sertic.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class RestDiaryController {
    public static final Logger logger = LoggerFactory.getLogger(RestDiaryController.class);

    String test = "Sve 6";
    String createTest = "Diary created";
    String deleteTest = "Deleted";

    // Retrieve All Diaries of a User

    @RequestMapping(value = "/{externalUserId}/diary", method = RequestMethod.GET)
    public ResponseEntity<String> listAllDiaries(@PathVariable("externalUserId") UUID externalUserId){
        return new ResponseEntity<String>(this.test, HttpStatus.OK);
    }

    // Retrieve single diary

    @RequestMapping(value = "/{externalUserId}/diary/{externalDiaryId}", method = RequestMethod.GET)
    public ResponseEntity<String> getDiaryEntry(@PathVariable("externalUserId") UUID externalUserId, @PathVariable("externalDiaryId") UUID externalDiaryId){
        return new ResponseEntity<String>(this.test,HttpStatus.OK);
    }

    //Create diary
    @RequestMapping(value = "/{externalUserId}/diary", method = RequestMethod.POST)
    public ResponseEntity<String> createDiary(@PathVariable("externalUserId") UUID externalUserId){
        logger.info("Creating user");
        return new ResponseEntity<String>(this.createTest,HttpStatus.OK);
    }

    // Delete Diary
    @RequestMapping(value = "/user/{externalUserId}/diary/{externalDiaryId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDiary(@PathVariable("externalUserId")UUID externalUserID, @PathVariable("externalDiaryId")UUID externalDiaryId){
        logger.info("Deleting Diary");
        return new ResponseEntity<String>(deleteTest, HttpStatus.OK);
    }

    @RequestMapping(value = "/{externalUserId}/diary", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAllDiaries(@PathVariable("externalUserId")UUID externalUserId){
        logger.info("Deleting All Diaries");
        return new ResponseEntity<String>(deleteTest,HttpStatus.OK);
    }
}
