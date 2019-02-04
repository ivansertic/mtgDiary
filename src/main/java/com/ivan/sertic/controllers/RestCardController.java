package com.ivan.sertic.controllers;

import com.ivan.sertic.dto.CardDto;
import com.ivan.sertic.mapper.CardMapper;
import com.ivan.sertic.model.Card;
import com.ivan.sertic.model.Library;
import com.ivan.sertic.services.CardService;
import com.ivan.sertic.services.LibraryService;
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
public class RestCardController {
    @Autowired
    private LibraryService libraryService;

    @Autowired
    private CardService cardService;

    @Autowired
    private CardMapper cardMapper;

    public static final Logger logger = LoggerFactory.getLogger(RestDiaryController.class);



    //Return Cards of a library
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}/card", method = RequestMethod.GET)
    public ResponseEntity<List<CardDto>> getAllCards(@PathVariable("externalUserId")UUID externalUserId,
                                                     @PathVariable("externalLibraryId")UUID externalLibraryId){
            final Library userLibrary = libraryService.getLibraryFromUser(externalUserId,externalLibraryId);
            final List<Card> cards = new LinkedList<>();

            if(userLibrary == null) {
                return ResponseEntity.notFound().build();
            }else {
                cards.addAll(cardService.getAllCards(externalLibraryId));

            }

        final List<CardDto> response = cards.stream().map(card -> cardMapper.cardDto(card)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value ="/{externalUserId}/library/{externalLibraryId}/card/{externalCardId}", method = RequestMethod.GET)
    public ResponseEntity<CardDto> getCard(@PathVariable("externalUserId")UUID externalUserId,
                                        @PathVariable("externalLibraryId")UUID externalLibraryId,
                                        @PathVariable("externalCardId")UUID externalCardId){
        final Card card = cardService.getCardFromUserAndLibrary(externalLibraryId,externalUserId,externalCardId);

        if(card == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(cardMapper.cardDto(card));
        }
    }

    //Create Card
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}/card", method = RequestMethod.POST)
    public ResponseEntity<String> createCard(@PathVariable("externalUserId")UUID externalUserId,
                                             @PathVariable("externalLibraryId")UUID externalLibraryId,
                                             @RequestBody CardDto dto ){
        final Library userLibrary = libraryService.getLibraryFromUser(externalUserId,externalLibraryId);

        if(userLibrary == null) {
            return ResponseEntity.notFound().build();
        }else {
            final Card card = cardMapper.createEntity(dto);

            card.setLibrary(userLibrary);
            userLibrary.getCards().add(card);

            cardService.create(card);

            return ResponseEntity.ok().build();
        }
    }

    //Put a card into a library
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}/card/{externalCardId}", method = RequestMethod.PUT)
    public ResponseEntity<String> putCard(@PathVariable("externalUserId")UUID externalUserId,
                                          @PathVariable("externalLibraryId")UUID externalLibraryId,
                                          @PathVariable("externalCardId")UUID externalCardId,
                                          @RequestBody CardDto dto){
        final Card userCard = cardService.getCardFromUserAndLibrary(externalLibraryId,externalUserId,externalCardId);

        if(userCard == null){
            return ResponseEntity.notFound().build();
        }else{
            cardMapper.update(userCard,dto);
            cardService.update(externalCardId,userCard);
            return ResponseEntity.ok().build();
        }
    }

    //Delete Card
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}/card/{externalCardId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCard(@PathVariable("externalUserId")UUID externalUserId,
                                          @PathVariable("externalLibraryId")UUID externalLibraryId,
                                          @PathVariable("externalCardId")UUID externalCardId){

        final Card userCard = cardService.getCardFromUserAndLibrary(externalLibraryId,externalUserId,externalCardId);

        if(userCard == null){
            return ResponseEntity.notFound().build();
        }else{
            cardService.deleteByExternalId(externalCardId);
            return ResponseEntity.ok().build();
        }
    }
}
