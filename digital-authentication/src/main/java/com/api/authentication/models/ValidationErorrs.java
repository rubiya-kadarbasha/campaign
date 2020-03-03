/*
 * Authentication API
 * The signup module has an action API, which is used for the following reasons. 1) To initiate the login page, if authentication is applicable for the  user, during action authorize  granting access to the system . 2) To validate the login, along with the password of the user 3) To cancel the request  when authentication process is cancelled .4) To support the actions login and logout mechanism
 *
 * OpenAPI spec version: 1.0.0
 * Contact: rubiyakadarbasha@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.api.authentication.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ValidationErorrs
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-02-28T18:07:05.498+05:30")
public class ValidationErorrs {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("field")
  private String field = null;

  @JsonProperty("message")
  private String message = null;

  public ValidationErorrs code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Indicates error codes
   * @return code
  **/
  @ApiModelProperty(value = "Indicates error codes")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ValidationErorrs field(String field) {
    this.field = field;
    return this;
  }

   /**
   * Indicates field name
   * @return field
  **/
  @ApiModelProperty(value = "Indicates field name")
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public ValidationErorrs message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Indicates error message
   * @return message
  **/
  @ApiModelProperty(value = "Indicates error message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidationErorrs validationErorrs = (ValidationErorrs) o;
    return Objects.equals(this.code, validationErorrs.code) &&
        Objects.equals(this.field, validationErorrs.field) &&
        Objects.equals(this.message, validationErorrs.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, field, message);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidationErorrs {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}
