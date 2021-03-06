package com.shop.ecommercev2.restControllers;


import com.shop.ecommercev2.services.ICommandService;
import com.shop.ecommercev2.services.IUserService;
import com.shop.ecommercev2.shared.dto.ArticleCommandDTO;
import com.shop.ecommercev2.shared.dto.CommandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/commands")
@CrossOrigin(origins = "*")
@RestController
public class CommandController {

    @Autowired
    ICommandService commandService;

    @Autowired
    IUserService iUserService;



    @GetMapping("/getAll")
    public ResponseEntity<List<CommandDto>> getAll() {
        List<CommandDto> listOfCommands = commandService.getAllCommands();

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("auth " +auth);

        return new ResponseEntity<List<CommandDto>>(listOfCommands, HttpStatus.OK);
    }

    @GetMapping("/getValid")
    public ResponseEntity<CommandDto> getValid() {
        CommandDto command = commandService.getCommandValid();

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("auth " +auth);

        return new ResponseEntity<CommandDto>(command, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addArticleToCommand(@RequestBody ArticleCommandDTO articleCommandDTO) {
        commandService.addToBox(articleCommandDTO);
        return new ResponseEntity<String>("New article has been added successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/payed")
    public ResponseEntity<String> commandPayed(@RequestBody CommandDto commandDto) {
        commandService.CommandPayed(commandDto);
        return new ResponseEntity<String>("Command Payed with success", HttpStatus.CREATED);
    }

}
