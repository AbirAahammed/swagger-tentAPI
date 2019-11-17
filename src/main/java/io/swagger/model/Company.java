package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Company
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-17T03:58:24.979-06:00")

public class Company   {
  @JsonProperty("companyID")
  private Integer companyID = null;

  @JsonProperty("companyName")
  private String companyName = null;

  public Company companyID(Integer companyID) {
    this.companyID = companyID;
    return this;
  }

  /**
   * Get companyID
   * @return companyID
  **/
  @ApiModelProperty(value = "")


  public Integer getCompanyID() {
    return companyID;
  }

  public void setCompanyID(Integer companyID) {
    this.companyID = companyID;
  }

  public Company companyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  /**
   * Get companyName
   * @return companyName
  **/
  @ApiModelProperty(value = "")


  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Company company = (Company) o;
    return Objects.equals(this.companyID, company.companyID) &&
        Objects.equals(this.companyName, company.companyName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyID, companyName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Company {\n");
    
    sb.append("    companyID: ").append(toIndentedString(companyID)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
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

