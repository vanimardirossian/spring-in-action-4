package org.springinaction.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springinaction.spittr.data.SpittleRepository;
import org.springinaction.spittr.domain.Spittle;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String showSpittle(@PathVariable long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    /*
     Alternate implementations

     public String spittles(Model model) {
         model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
         return "spittles";
     }

     public String spittles(Map<Object, Object> model) {
         model.put("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
         return "spittles";
     }

     * for this implementation, the logical view name is inferred from the request path

     public List<Spittle> spittles() {
         return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
     }
     */
}
