/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Driver;
import io.swagger.model.Drivers;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-02T13:30:43.620-05:00")

@Api(value = "driver", description = "the driver API")
public interface DriverApi {

    @ApiOperation(value = "Get a driver by ID", nickname = "driverDriverIDGet", notes = "Numeric ID of Driver", response = Driver.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Driver.class) })
    @RequestMapping(value = "/driver/{driverID}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Driver> driverDriverIDGet(@ApiParam(value = "Numeric ID of the user to get",required=true) @PathVariable("driverID") Integer driverID);


    @ApiOperation(value = "Get all the drivers", nickname = "driverGet", notes = "", response = Drivers.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "get all the drivers on successful execution", response = Drivers.class) })
    @RequestMapping(value = "/driver",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Drivers> driverGet();

}
