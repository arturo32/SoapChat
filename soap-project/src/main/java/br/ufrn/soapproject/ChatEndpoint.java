package br.ufrn.soapproject;

import br.ufrn.soapproject.wsdl_generated.TalkRequest;
import br.ufrn.soapproject.wsdl_generated.TalkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ChatEndpoint {

    private static final String NAMESPACE_URI = "http://ufrn.br/soapproject/wsdl_generated";

    private ChatRepository chatRepository;

    @Autowired
    public ChatEndpoint(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "talkRequest")
    @ResponsePayload
    public TalkResponse answer(@RequestPayload TalkRequest request) {
        TalkResponse response = new TalkResponse();
        response.setMessage(chatRepository.answer(request.getMessage()));

        return response;
    }
}
