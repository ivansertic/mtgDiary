package com.ivan.sertic.controllers;

import com.ivan.sertic.dto.LibraryDto;
import com.ivan.sertic.mapper.LibraryMapper;
import com.ivan.sertic.model.Library;
import com.ivan.sertic.model.Users;
import com.ivan.sertic.services.LibraryService;
import com.ivan.sertic.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class RestLibraryController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private UserService userService;

    @Autowired
    private LibraryMapper libraryMapper;


    public static final Logger logger = LoggerFactory.getLogger(RestDiaryController.class);

    //Retrieve all libraries
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/library", method = RequestMethod.GET)
    public ResponseEntity<List<LibraryDto>> getAllLibraries(@PathVariable("externalUserId") UUID externalUserId){
        final List<Library> userLibraries = new LinkedList<>();

        if(userLibraries == null){
            return ResponseEntity.notFound().build();
        }else{
            userLibraries.addAll(libraryService.getAllLibraries(externalUserId));
        }

        final List<LibraryDto> response = userLibraries.stream().map(library -> libraryMapper.toDto(library)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    //Retrieve one Library
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}", method = RequestMethod.GET)
    public ResponseEntity<LibraryDto> getOneLibrary(@PathVariable("externalUserId")UUID externalUserId,
                                                @PathVariable("externalLibraryId")UUID externalLibraryId){
        final Library userLibrary = libraryService.getLibraryFromUser(externalUserId,externalLibraryId);

        if(userLibrary==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(libraryMapper.toDto(userLibrary));
        }
    }

    //Create library
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/library", method = RequestMethod.POST)
    public ResponseEntity<String> createLibrary(@PathVariable("externalUserId")UUID externalUserId,
                                                @RequestBody LibraryDto dto){
        final Users user = userService.getUserByExternalId(externalUserId);

        if(user == null){
            return ResponseEntity.notFound().build();
        }else{
            final Library library = libraryMapper.createEntity(dto);

            library.setUser(user);
            user.addLibrary(library);

            libraryService.create(library);

            return ResponseEntity.ok().build();
        }
    }

    //Delete library
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteLibrary(@PathVariable("externalUserId")UUID externalUserId,
                                                @PathVariable("externalLibraryId") UUID externalLibraryId){
        final Library userLibrary = libraryService.getLibraryFromUser(externalUserId,externalLibraryId);

        if(userLibrary == null){
            return ResponseEntity.notFound().build();
        }else{
            libraryService.deleteByExternalId(externalLibraryId);
            return ResponseEntity.ok().build();
        }
    }

    //Delete All Libraries
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/library", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAllLibraries(@PathVariable("externalUserId") UUID externalUserId){
        final Users user = userService.getUserByExternalId(externalUserId);

        if(user == null){
            return ResponseEntity.notFound().build();
        }else{
            libraryService.deleteByExternalId(externalUserId);

            return ResponseEntity.ok().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateLibrary (@PathVariable("externalUserId")UUID externalUserId,
                                                 @PathVariable("externalLibraryId") UUID externalLibraryId,
                                                 @RequestBody LibraryDto dto){
        final Library library = libraryService.getLibraryFromUser(externalUserId,externalLibraryId);

        if(library == null){
            return ResponseEntity.notFound().build();
        }else{
            libraryMapper.update(library, dto);
            libraryService.update(externalLibraryId, library);

            return ResponseEntity.ok().build();
        }
    }
}
