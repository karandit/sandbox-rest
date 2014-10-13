package hu.evosoft.statservice.endpoint;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Provides JSONP (JSON with Padding) for a REST request.
 * <p>
 * The request must contain a <code>?callback=function_name</code> part and the result will be a JSON wrapped in 
 * the following JavaScript call: <code>function_name(JSON);</code>
 * 
 * @author Karandi Tamas
 */
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonpAdvice() {
        super("callback");
    }

}