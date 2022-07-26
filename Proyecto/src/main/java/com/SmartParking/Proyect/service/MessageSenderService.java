package com.SmartParking.Proyect.service;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {

    public static final String ACCOUNT_SID = "AC86bb487fb0daa7e379a750522385bb1e";
    public static final String AUTH_TOKEN = "510026f47035727bde984e39c19f219d";

    public void sendMessage(String number, String messagePar){

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+506"+number),
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                        messagePar)
                .create();

        System.out.println(message.getSid());
    }
}
