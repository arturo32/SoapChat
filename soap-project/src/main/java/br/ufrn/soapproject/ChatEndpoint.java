package br.ufrn.soapproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ChatEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private ChatRepository chatRepository;

    @Autowired
    public ChatEndpoint(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "chatAnswer")
//    @ResponsePayload
//    public String answer(@RequestPayload GetCountryRequest request) {
//        GetCountryResponse response = new GetCountryResponse();
//        response.setCountry(chatRepository.answer(request.));
//
//        return response;
//    }
}
