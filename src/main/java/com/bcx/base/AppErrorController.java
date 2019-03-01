package com.bcx.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class AppErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes){
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    /**
     * Web页面错误处理
     */
    @RequestMapping(value = ERROR_PATH,produces = "text/html")
    public String errorHandler(HttpServletRequest request, HttpServletResponse response){
        int code = response.getStatus();
        switch (code){
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }
        return "index";
    }

    /**
     * 除web页面外的错误处理  比如 json xml
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ApiResponse errorApiHandler(HttpServletRequest request){
        WebRequest webRequest = new ServletWebRequest(request);
        Map<String,Object> attr = this.errorAttributes
                .getErrorAttributes(webRequest,false);
        int status = getStatus(request);
        return ApiResponse.ofMessage(status,
                String.valueOf(attr.getOrDefault("message","error")));
    }

    private int getStatus(HttpServletRequest request){
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status != null){
            return status;
        }
        return 500;
    }
}
