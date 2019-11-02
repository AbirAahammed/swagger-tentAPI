package io.swagger.api;

import io.swagger.api.company.Company_PE;
import io.swagger.model.Companies;
import io.swagger.model.Company;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-02T13:12:24.446-05:00")

@Controller
public class CompanyApiController implements CompanyApi {

    private static final Logger log = LoggerFactory.getLogger(CompanyApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CompanyApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Company> companyCompanyIDGet(@ApiParam(value = "Numeric ID of the user to get",required=true) @PathVariable("companyID") Integer companyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
           return new ResponseEntity<>(Company_PE.getCompanyByID(companyID), HttpStatus.OK);
        }

        return new ResponseEntity<Company>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Companies> companyGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(Company_PE.getAllCompanies(), HttpStatus.OK);
        }

        return new ResponseEntity<Companies>(HttpStatus.NOT_IMPLEMENTED);
    }

}
