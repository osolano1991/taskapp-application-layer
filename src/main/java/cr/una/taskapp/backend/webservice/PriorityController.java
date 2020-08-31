/*
 *
 *  *
 *  *
 *  * Universidad Nacional de Costa Rica  2020
 *  *
 *  * mike@guzmanalan.com
 *  *
 *  *
 *
 *
 */

package cr.una.taskapp.backend.webservice;

import cr.una.taskapp.backend.dto.PriorityDto;
import cr.una.taskapp.backend.model.Priority;
import cr.una.taskapp.backend.service.IPriorityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Webservice Controller for Priority
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/api/priorities")
public class PriorityController {

    @Autowired
    private IPriorityService service;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Find all Roles
     * @return List of DTO Roles
     */
    @GetMapping()
    @ResponseBody
    public List<PriorityDto> findAll() {
        List<Priority> roleList = service.findAll();
        return roleList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Convert from Entity to DTO
     * @param priority entity
     * @return the DTO
     */
    private PriorityDto convertToDto(Priority priority) {
        PriorityDto priorityDto = modelMapper.map(priority, PriorityDto.class);
        return priorityDto;
    }

    /**
     * Convert from DTO to Entity
     * @param priorityDto the DTO
     * @return the entity
     */
    private Priority convertToEntity(PriorityDto priorityDto) {
        Priority priority = modelMapper.map(priorityDto, Priority.class);
        return priority;
    }
}
