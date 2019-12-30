package com.hm.rms.controller;

import com.hm.rms.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value="/wx_01")
public class Wx2019VersionController {
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
    @RequestMapping(value = "/getPersonalData", method = RequestMethod.POST)
    public Map<String,Object> getPersonalData(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Map<String,Object> map = new HashMap<>();
        map.put("firstName","黄**");//名字
        map.put("photoFilePath","/image/hzh_meitu_1.jpg");//头像
        map.put("nickName","黄先生");//昵称
        map.put("lastName","黄");//姓氏
        map.put("middleName","**");//中间名
        map.put("mobilePhoneNumber","183****8218");//电话号
        map.put("weChatNumber","H*******");//微信号
        map.put("addressCounty","中国");//联系地址国家
        map.put("addressState","吉林省");//联系地址省份
        map.put("addressCity","长春市");//联系地址城市
        map.put("addressStreet","宽城区");//联系地址街道
        map.put("addressPostalCode","133000");//联系地址邮政编码
        map.put("organization","**");//公司
        map.put("title","程序员");//职位
        map.put("email","1060924435@qq.com");//邮箱
        map.put("url","www.hzh.ink");//网站
        map.put("nowTime",new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));//网站
        map.put("loveUrl","http://www.hzh.ink:18188/db");//网站
        map.put("qrcord","/image/qrcord.jpg");//网站
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> maps = new HashMap<>();
        maps.put("k","QQ");
        maps.put("items","1060924435");
        list.add(maps);
        Map<String,Object> maps1 = new HashMap<>();
        maps1.put("k","邮箱");
        maps1.put("items","1060924435@qq.com");
        list.add(maps1);
        Map<String,Object> maps2 = new HashMap<>();
        maps2.put("k","微信");
        maps2.put("items","H*******");
        list.add(maps2);
        Map<String,Object> maps3 = new HashMap<>();
        maps3.put("k","职位");
        maps3.put("items","JAVA");
        list.add(maps3);
        map.put("categoryList",list);
        return map;

    }
    /**
     * 获取数据
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/getNewsData", method = RequestMethod.POST)
    public List<Map<String,Object>>  getNewsData(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> maps = new HashMap<>();
        maps.put("id","1");
        maps.put("descript","谁在贩卖人脸识别的焦虑？");
        maps.put("title","你的脸安全吗？");
        maps.put("pic","/image/060946svppyx.jpg");
        list.add(maps);
        Map<String,Object> maps1 = new HashMap<>();
        maps1.put("id","2");
        maps1.put("descript","AI在识别物体上往往会过度依赖颜色，纹理和背景线索来“认识”它所看到的东西。");
        maps1.put("title","难敌对抗性图像的“愚弄”，被欺骗的AI可能会“做出”危险举动");
        maps1.put("pic","/image/201544hrazg5.jpg");
        list.add(maps1);
        Map<String,Object> maps2 = new HashMap<>();
        maps2.put("id","3");
        maps2.put("descript","目前，MobileIron处于无密码理念的前沿。");
        maps2.put("title","是时候和密码说byebye了");
        maps2.put("pic","/image/0816505bbevw.jpg");
        list.add(maps2);
        Map<String,Object> maps3 = new HashMap<>();
        maps3.put("id","4");
        maps3.put("descript","就连福特公司一向乐观的未来主义者Sheryl Connelly也对未来感到担忧。");
        maps3.put("title","大数据经济堪比人间《黑镜》，一文打尽九大科技趋势");
        maps3.put("pic","/image/15153235e99u.jpg");
        list.add(maps3);
        return list;

    }
    /**
     * 获取数据
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/getNewsDataDetail", method = RequestMethod.POST)
    public String getNewsDataDetail(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String param = request.getParameter("param");
        String url = "";
        switch (param){
            case "1" : url = "https://www.jianshu.com/p/3817026fb893";break;
            case "2" : url = "https://www.sohu.com/a/328842680_99970711";break;
            case "3" : url = "https://mini.eastday.com/mobile/190510074000797.html#";break;
            case "4" : url = "https://www.qianjia.com/html/2019-01/16_320208.html";break;
            default:url = "https://www.baidu.com";

        }

        return url;

    }
    /**
     * 获取数据
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/getProductionData", method = RequestMethod.POST)
    public List<Map<String,Object>> getProductionData(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> maps = new HashMap<>();
        maps.put("id","1");
        maps.put("descript","JVM说明、配置，GC的过程和具体配置值。？");
        maps.put("title","JVM调优");
        maps.put("pic","/image/2287481c6f396db25df2ddd.jpg");
        list.add(maps);
        Map<String,Object> maps1 = new HashMap<>();
        maps1.put("id","2");
        maps1.put("descript","CPU 的处理能力越强，系统运行速度越快");
        maps1.put("title","TOMCAT调优");
        maps1.put("pic","/image/1446271963871899.jpg");
        list.add(maps1);
        Map<String,Object> maps2 = new HashMap<>();
        maps2.put("id","3");
        maps2.put("descript","阿里云——阿里巴巴集团旗下公司，是全球领先的云计算及人工智能科技公司。提供云服务器、云数据库、云安全、企业应用等云计算服务，以及大数据、人工智能解决方案，精准定制基于场景的行业解决方案。专业快速备案，7x24小时售后支持，助企业无忧上云。");
        maps2.put("title","阿里云");
        maps2.put("pic","/image/TB1AQX3mND1gK0jSZFyXXciOVXa-1880-640.jpg");
        list.add(maps2);
        return list;

    }
    /**
     * 获取数据
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/getProductionDataDetail", method = RequestMethod.POST)
    public String getProductionDataDetail(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String param = request.getParameter("param");
        String url = "";
        switch (param){
            case "1" : url = "https://www.jianshu.com/p/30e8ff0f7dd9";break;
            case "2" : url = "https://www.jianshu.com/p/ab0dc694ca2e";break;
            case "3" : url = "https://www.jianshu.com/p/c0402047f6db";break;
            default:url = "https://www.baidu.com";

        }

        return url;

    }
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
    /**
     * 获取基础数据
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/findBasicList")
    public Map<String,Object> findBasicList(String rows,String page,HttpServletRequest request, HttpServletResponse response) throws IOException{
        //行数
        int row = (rows == null || "".equals(rows)) ? 10 : Integer.parseInt(rows);
        //页数
        int pages = (page == null || "".equals(page)) ? 1 : Integer.parseInt(page);
        Map<String,Object> map = new HashMap<>();
        try {
            map.put("rows", null);
            map.put("total", 0);
        }catch(Exception e){
            map.put("rows", null);
            map.put("total", 0);
        }
        return map;

    }
}
