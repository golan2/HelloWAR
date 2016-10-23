package golan.hello.war;

import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <pre>
 * <B>Copyright:</B>   HP Software IL
 * <B>Owner:</B>       <a href="mailto:izik.golan@hp.com">Izik Golan</a>
 * <B>Creation:</B>    04/06/2015 08:11
 * <B>Since:</B>       Neptune 1.0
 * <B>Description:</B>
 *
 * </pre>
 */
public class BaseController {
  private static int counter = 0;
  private static final String VIEW_INDEX = "index";
  private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String welcome(ModelMap model) {

    model.addAttribute("message", "Welcome");
    model.addAttribute("counter", ++counter);
    logger.debug("[welcome] counter : {}", counter);

    // Spring uses InternalResourceViewResolver and return back index.jsp
    return VIEW_INDEX;

  }

  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
  public String welcomeName(@PathVariable String name, ModelMap model) {

    model.addAttribute("message", "Welcome " + name);
    model.addAttribute("counter", ++counter);
    logger.debug("[welcomeName] counter : {}", counter);
    return VIEW_INDEX;

  }

}
