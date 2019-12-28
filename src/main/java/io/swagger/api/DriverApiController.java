package io.swagger.api;

import io.swagger.api.driver.Driver_PE;
import io.swagger.model.Driver;
import io.swagger.model.Drivers;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Calendar;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-02T11:47:34.041-05:00")

@Controller
public class DriverApiController implements DriverApi {
    Logger logger = org.apache.log4j.Logger.getLogger(DriverApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DriverApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Driver> driverDriverIDGet(@ApiParam(value = "Numeric ID of the user to get",required=true) @PathVariable("driverID") Integer driverID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            logger.info("Driver retrieved by ID at "+ Calendar.getInstance().getTime());
            return new ResponseEntity<Driver>(Driver_PE.getDriverByID(driverID), HttpStatus.OK);
        }
        logger.info("Failed to retrieve driver by ID");

        return new ResponseEntity<Driver>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Drivers> driverGet() {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {
            logger.info("Drivers retrieved at "+ Calendar.getInstance().getTime());
            return new ResponseEntity<Drivers>(Driver_PE.getAllDrivers(), HttpStatus.OK);
        }
        logger.info("Failed to retrieve drivers");

        return new ResponseEntity<Drivers>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Integer> driverPost(@ApiParam(value = "The user to create."  )  @Valid @RequestBody Driver user) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            logger.info("A new driver created");
            try {
                return new ResponseEntity<Integer>(Driver_PE.createDriver(user), HttpStatus.OK);
            } catch (SQLException e) {
                logger.info("Driver creation failed");
                return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        logger.info("Driver creation failed due to a bad request.");

        return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
    }

}



