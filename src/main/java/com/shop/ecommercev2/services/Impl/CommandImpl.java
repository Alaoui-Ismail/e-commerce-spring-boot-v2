package com.shop.ecommercev2.services.Impl;

import com.shop.ecommercev2.entities.Article;
import com.shop.ecommercev2.entities.Command;
import com.shop.ecommercev2.entities.CommandArticle;
import com.shop.ecommercev2.entities.Payment;
import com.shop.ecommercev2.repositories.*;
import com.shop.ecommercev2.services.ICommandService;
import com.shop.ecommercev2.services.IUserService;
import com.shop.ecommercev2.shared.dto.ArticleCommandDTO;
import com.shop.ecommercev2.shared.dto.ArticleDto;
import com.shop.ecommercev2.shared.dto.CommandDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CommandImpl implements ICommandService {

    @Autowired
    CommandRepository commandRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IUserService iUserService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ArticleCommandRepository articleCommandRepository;

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<CommandDto> getAllCommands() {

        System.out.println("new article" + commandRepository.findAll());
        return commandRepository.findAll().stream().map(command -> modelMapper.map(command, CommandDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public CommandDto addCommand() {

        CommandDto commandDto = new CommandDto();

        String currentUserName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();


            // System.out.println("name connect " + iUserService.getUser(currentUserName).getId());
        }
        commandDto.setCustomer(userRepository.findByEmail(currentUserName));
        commandDto.setCommandDate(new Date());
        commandDto.setValid(true);
        Command commandRequest = modelMapper.map(commandDto, Command.class);


        Command command = commandRepository.save(commandRequest);

        // convert entity to dto

        CommandDto commandResponse = modelMapper.map(command, CommandDto.class);

        return commandResponse;

    }

    @Override
    public CommandDto updateCommand(CommandDto commandDto, Long id) {
        return null;
    }

    @Override
    public void deleteCommand(Long id) {

    }

    @Override
    public CommandDto findByIdCommand(Long id) {
        return null;
    }

    @Override
    public ArticleCommandDTO addToBox(ArticleCommandDTO articleCommandDTO) {
        System.out.println("TEST " + articleCommandDTO.toString());

        Command command = commandRepository.checkCommand();
        long idCmd = 0;
        if (command == null) {
            System.out.println("id 1");

            idCmd = this.addCommand().getCommandId();
        } else {

            System.out.println("id 2 " + articleCommandDTO.getArticleQte());
            idCmd = command.getCommandId();

        }

        int qteArticle = articleCommandDTO.getArticleQte();
        articleCommandDTO.setCommand_id(idCmd);
        CommandArticle commandArticleRequest = new CommandArticle();

        commandArticleRequest.setCommand(commandRepository.getById(idCmd));
        commandArticleRequest.setArticle(articleRepository.findByArticleId(articleCommandDTO.getArticle_id()));

        commandArticleRequest.setArticleQuantity(qteArticle);
        System.out.println("test test +" + qteArticle);


        CommandArticle commandArticle = articleCommandRepository.save(commandArticleRequest);

        ArticleCommandDTO commandArticleResponse = modelMapper.map(commandArticle, ArticleCommandDTO.class);


        return commandArticleResponse;

    }

    @Override
    public void CommandPayed(CommandDto commandDto) {



        List<CommandArticle> commandArticles = articleCommandRepository.findByCommandId(commandDto.getCommandId());

        double totalCmd = commandArticles.stream().mapToDouble(x -> x.getArticleQuantity() * x.getArticle().getArticlePrice()).sum();

        Payment p = new Payment();
        p.setPaymentDate(new Date());

        Payment new_p = paymentRepository.save(p);
        Command cmd = commandRepository.findById(commandDto.getCommandId()).get();
        cmd.setCommandTotal(totalCmd);
        cmd.setValid(false);
        cmd.setPayment(new_p);

        Command new_cmd  = commandRepository.save(cmd);


        //CommandDto cmdResponse = modelMapper.map(new_cmd, CommandDto.class);


    }
}
