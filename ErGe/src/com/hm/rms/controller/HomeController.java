package com.hm.rms.controller;

import com.hm.rms.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/home")
public class HomeController {
    @Resource
    private MainService mainService;
    /**
     * 获取数据
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/findDataList")
    public Map<String,Object> findDataList(String rows,String page,HttpServletRequest request, HttpServletResponse response) throws IOException{
        //行数
        int row = (rows == null || "".equals(rows)) ? 10 : Integer.parseInt(rows);
        //页数
        int pages = (page == null || "".equals(page)) ? 1 : Integer.parseInt(page);
        Map<String,Object> map = new HashMap<>();
        try {
            map.put("rows", mainService.findDataList((pages - 1) * row, row));
            map.put("total", mainService.findDataListCounts());
        }catch(Exception e){
            map.put("rows", null);
            map.put("total", 0);
        }
        return map;

    }
}
