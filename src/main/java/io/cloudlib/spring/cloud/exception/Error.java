package io.cloudlib.spring.cloud.exception;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-23T21:03:44.891Z")
public class Error {
	  private Integer code = null;

	  private String message = null;

	  private String details = null;

	  public Error code(Integer code) {
	    this.code = code;
	    return this;
	  }

	   /**
	   * This is the  error code which is custom for the microservice
	   * @return code
	  **/
	  @ApiModelProperty(value = "This is the  error code which is custom for the microservice")
	  public Integer getCode() {
	    return code;
	  }

	  public void setCode(Integer code) {
	    this.code = code;
	  }

	  public Error message(String message) {
	    this.message = message;
	    return this;
	  }

	   /**
	   * Error message for the microservice
	   * @return message
	  **/
	  @ApiModelProperty(value = "Error message for the microservice")
	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }

	  public Error details(String details) {
	    this.details = details;
	    return this;
	  }

	   /**
	   * Additional information for the error
	   * @return details
	  **/
	  @ApiModelProperty(value = "Additional information for the error")
	  public String getDetails() {
	    return details;
	  }

	  public void setDetails(String details) {
	    this.details = details;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Error error = (Error) o;
	    return Objects.equals(this.code, error.code) &&
	        Objects.equals(this.message, error.message) &&
	        Objects.equals(this.details, error.details);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(code, message, details);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class Error {\n");
	    
	    sb.append("    code: ").append(toIndentedString(code)).append("\n");
	    sb.append("    message: ").append(toIndentedString(message)).append("\n");
	    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
