package ID1.classes;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


public class ViewResolverUtil {
    public ModelAndView renderModelAndView(String viewName, Map<String, Object> modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addAllObjects(modelMap);
        return modelAndView;
    }

}
