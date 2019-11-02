package io.swagger.api;

import io.swagger.model.API;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-02T11:47:34.041-05:00")

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

    public ResponseEntity<API> companyCompanyIDGet(@ApiParam(value = "Numeric ID of the user to get",required=true) @PathVariable("companyID") Integer companyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<API>(objectMapper.readValue("{  \"message\" : \"{}\"}", API.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<API>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<API>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<API> companyGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<API>(objectMapper.readValue("{  \"message\" : \"{}\"}", API.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<API>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<API>(HttpStatus.NOT_IMPLEMENTED);
    }

}
