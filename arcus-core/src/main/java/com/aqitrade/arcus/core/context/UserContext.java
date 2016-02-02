package com.aqitrade.arcus.core.context;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Preconditions;

/**
 * User context thread local, which carries user information on every request.
 * 
 * @author pani
 *
 */
public class UserContext {

  private static ThreadLocal<UserContext> tlHolder = new InheritableThreadLocal<UserContext>();
  private Map<String, String> properties;
  private Long userId;
  private String firstName;
  private String lastName;
  private Long phoneNumber;
  private String emailId;

  public static UserContext get() {
    return tlHolder.get();
  }

  public static void set(UserContext ctx) {
    tlHolder.set(ctx);
  }

  public static void remove() {
    tlHolder.remove();
  }

  public UserContext(Long userId, String firstName, String lastName, Long phoneNumber,
      String emailId) {
    Preconditions.checkArgument(userId != null, "User ID must be not null");

    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.emailId = emailId;
  }

  public String getProperty(String name) {
    if (properties != null) {
      return properties.get(name);
    }
    return null;
  }

  public void setProperty(String name, String value) {
    if (properties == null) {
      properties = new HashMap<String, String>();
    }
    properties.put(name, value);
  }

  /**
   * @return the properties
   */
  public Map<String, String> getProperties() {
    return properties;
  }

  /**
   * @return the userId
   */
  public Long getUserId() {
    return userId;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @return the phoneNumber
   */
  public Long getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @return the emailId
   */
  public String getEmailId() {
    return emailId;
  }
}
