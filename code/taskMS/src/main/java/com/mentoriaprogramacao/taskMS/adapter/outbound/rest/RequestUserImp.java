package com.mentoriaprogramacao.taskMS.adapter.outbound.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



import com.mentoriaprogramacao.taskMS.adapter.dto.UserDTO;
import com.mentoriaprogramacao.taskMS.port.outbound.rest.RequestUser;



@Component
public class RequestUserImp implements RequestUser{

    @Override
    public UserDTO getUser(String baseUrl, String userEmail) {
        
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<UserDTO> resp = restTemplate.getForEntity(baseUrl.concat(userEmail), UserDTO.class);
        return resp.getBody();
    }
    
}
