package com.web.home.seckill;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.biz.share.seckill.service.SecKillService;
import org.comm.dal.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecKillController {
	 private static Logger log = LoggerFactory.getLogger(SecKillController.class); 
	 
	 @Resource(name="secKillService")
	 private SecKillService     secKillService;
	      @RequestMapping(value="/seckill",method={RequestMethod.GET})
	      @ResponseBody
	      public void    secKill(HttpServletRequest request){
	    	  log.info(" seckill start");
	    	  User user = new User();
	    	  user.setName(request.getParameter("userName"));
	    	  String resp =  secKillService.secKill(user, request.getParameter("pType"));
	    	  log.info(" seckill "+resp);
	      }

}
