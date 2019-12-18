package io.swagger.api;

import io.swagger.api.company.Company_PE;
import io.swagger.model.Companies;
import io.swagger.model.Company;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-02T13:12:24.446-05:00")

@Controller
public class CompanyApiController implements CompanyApi {

    org.apache.log4j.Logger logger = Logger.getLogger(CompanyApiController.class);

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
            logger.info("Company retrieved by ID at "+ Calendar.getInstance().getTime());
            return new ResponseEntity<>(Company_PE.getCompanyByID(companyID), HttpStatus.OK);
        }
        logger.info("Failed to retrieve Company by ID at "+ Calendar.getInstance().getTime());

        return new ResponseEntity<Company>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Companies> companyGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            logger.info("Companies retrieved at "+ Calendar.getInstance().getTime());
            return new ResponseEntity<>(Company_PE.getAllCompanies(), HttpStatus.OK);
        }
        logger.info("Failed to retrieve Companies at "+ Calendar.getInstance().getTime());
        return new ResponseEntity<Companies>(HttpStatus.NOT_IMPLEMENTED);
    }

}
