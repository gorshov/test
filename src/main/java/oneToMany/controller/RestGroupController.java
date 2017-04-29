package oneToMany.controller;

import oneToMany.entity.Group;
import oneToMany.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Admin on 29.04.2017.
 */
@Controller
@RequestMapping("/list")
public class RestGroupController {

    @Autowired
    private ServiceInterface service;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> group = service.getAll(Group.class);
        if (group.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<List<Group>>(group, HttpStatus.OK);
    }

}
