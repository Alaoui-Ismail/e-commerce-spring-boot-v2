package com.shop.ecommercev2.services;

import com.shop.ecommercev2.shared.dto.ArticleCommandDTO;
import com.shop.ecommercev2.shared.dto.CommandDto;

import java.util.List;

public interface ICommandService {



    List<CommandDto> getAllCommands();

    CommandDto addCommand ();

    CommandDto updateCommand (CommandDto commandDto, Long id);

    void deleteCommand (Long id);

    CommandDto findByIdCommand( Long id);

    ArticleCommandDTO addToBox (ArticleCommandDTO articleCommandDTO);

    void CommandPayed (CommandDto commandDto);


}
