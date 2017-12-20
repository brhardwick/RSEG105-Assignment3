package rseg105.project3.part2.web.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//This was written almost entirely from the book code
public class UrlUtil {
    private static Logger logger = LoggerFactory.getLogger(UrlUtil.class);
    public static String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();

        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException ex) {
            logger.info(ex.getMessage());
        }
        return pathSegment;
    }
}
