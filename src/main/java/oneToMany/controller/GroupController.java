package oneToMany.controller;

import oneToMany.entity.Group;
import oneToMany.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Admin on 22.04.2017.
 */
@Controller
public class GroupController {

    @Autowired
    private ServiceInterface serviceInterface;

    @RequestMapping(value = "/groupList", method = RequestMethod.GET)
    public String getGroupList(ModelMap map) {
        List<Group> groupList = serviceInterface.getAll(Group.class);
        map.put("groupList", groupList);
        /*map.addAttribute("groupList", groupList);*/
        return "groupList";
    }

}
