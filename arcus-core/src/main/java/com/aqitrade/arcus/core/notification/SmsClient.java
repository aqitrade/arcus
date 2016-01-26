package com.aqitrade.arcus.core.notification;

import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aqitrade.arcus.core.ErrorCodes;
import com.aqitrade.arcus.core.exception.ServiceException;
import com.google.common.collect.Maps;
import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.message.MessageResponse;
import com.plivo.helper.exception.PlivoException;

@Component
public class SmsClient {
  private static final String TEXT = "text";

  private static final String DST = "dst";

  private static final String SRC = "src";

  private final static Logger LOG = LoggerFactory.getLogger(SmsClient.class);

  @Value("${sms.src.phone.number}")
  private String sourcePhoneNumber;

  @Value("${sms.authId}")
  private String authId;

  @Value("${sms.authToken}")
  private String authToken;

  public void sendTextMessage(long destPhoneNumber, String textMessage) {
    RestAPI restAPI = new RestAPI(authId, authToken, "v1");
    LinkedHashMap<String, String> parameters = Maps.newLinkedHashMap();
    parameters.put(SRC, sourcePhoneNumber);
    parameters.put(DST, Long.toString(destPhoneNumber));
    parameters.put(TEXT, textMessage);

    try {
      // Send the message
      MessageResponse msgResponse = restAPI.sendMessage(parameters);

      LOG.info("SMS message response: {}", msgResponse);

      if (msgResponse.serverCode == 202) {
        LOG.info("SMS message UUID : " + msgResponse.messageUuids.get(0).toString());
      } else {
        LOG.error("Failed to send notification to dest number: {}. The cause was: {}",
            destPhoneNumber, msgResponse.error);
        throw new ServiceException.NotificationException(ErrorCodes.NOTIFICATION_FAILED.message());
      }
    } catch (PlivoException e) {
      throw new ServiceException.NotificationException(e.getLocalizedMessage(), e);
    }
  }
}
