package org.develop.guru.game;

import org.develop.guru.entities.Historic;
import org.develop.guru.entities.Life;
import org.develop.guru.entities.Products;
import org.develop.guru.repository.HistoricRepository;
import org.develop.guru.repository.LifeRepository;
import org.develop.guru.repository.ProductsRepository;
import org.develop.guru.security.SystemUser;
import org.develop.guru.security.SystemUserRepository;
import org.develop.guru.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("play")
@ConfigurationProperties(prefix = "play")
public class GameController {

    @Autowired
    private SystemUserRepository userRepository;

    @Autowired
    private HistoricRepository historicRepository;

    @Autowired
    private LifeService lifeService;

    @Autowired
    private LifeRepository lifeRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private PagseguroService pagseguroService;

    @Autowired
    private GameService gameService;

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    private int numberOfCards;

    @RequestMapping(value = "message/{id}", method = RequestMethod.POST)
    public ResponseEntity<CardsResponse> cardMessageRequest(@PathVariable("id") Integer id, @RequestBody CardsRequest cards) {

        List<String> msgList = gameService.play(id, cards);
        return ResponseEntity.ok(new CardsResponse(msgList));
    }

    @RequestMapping(value = "historic/{id}/{offset}", method = RequestMethod.GET)
    public Page<Historic> getUserHistoric(@PathVariable("id") Integer id, @PathVariable("offset") int offset) {

        SystemUser u = userRepository.findById(id).orElseThrow(NotFoundException::new);
        return historicRepository.findByUser(u, new PageRequest(offset, 7));
    }

    @RequestMapping(value = "lifes/{id}", method = RequestMethod.GET)
    public ResponseEntity<LifeResponse> getUserLifes(@PathVariable("id") Integer id) {

        ArrayList<Life> lifes;
        SystemUser user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        lifes = lifeRepository.selectAvailableLives(user);
        return ResponseEntity.ok(new LifeResponse(lifes));
    }

    @RequestMapping(value = "uselife/{id}", method = RequestMethod.GET)
    public ResponseEntity<LifeResponse> useLifes(@PathVariable("id") Integer id) {

        lifeService.useLife(id);
        return ResponseEntity.ok(new LifeResponse());
    }

    @RequestMapping(value = "getlifes", method = RequestMethod.GET)
    public ResponseEntity<ProductsResponse> buylife() {

        ArrayList<Products> products = productsRepository.selectBuyLifes();
        return ResponseEntity.ok(new ProductsResponse(products));
    }

    @RequestMapping(value = "buylife/{id}", method = RequestMethod.POST)
    public ResponseEntity<PagseguroResponse> cardMessageRequest(@PathVariable("id") Integer id, @RequestBody UserRequest user) {

        System.out.println(user.getUserID());
        PagseguroResponse response = pagseguroService.addPagamentoLog(1, id);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "notification", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE )
    public ResponseEntity<String> getNotificationCode(@RequestParam Map<String, String> body) {

        System.out.println(body.get("notificationcode"));
        pagseguroService.anteraStatusPagamento(body.get("notificationcode"));
        return ResponseEntity.ok("");
    }
}
