package com.mentoriaprogramacao.taskMS.port.outbound.rest;

import java.io.IOException;
import java.net.URISyntaxException;

import com.mentoriaprogramacao.taskMS.adapter.dto.UserDTO;

public interface RequestUser {

    UserDTO getUser(String baseUrl, String userEmail) throws IOException, URISyntaxException;
    
}
