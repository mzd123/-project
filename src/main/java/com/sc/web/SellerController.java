package com.sc.web;

import com.sc.service.SellerService;
import com.sc.utils.GetResult;
import com.sc.utils.JWT;
import com.sc.utils.Result;
import com.sc.utils.Token;
import com.sc.utils.pay.MD5;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * SellerController
 * Created by valora on 2017/5/8.
 */
@RestController
@Api("Seller")
public class SellerController {
    private final static String URL = "/api/Seller/";

    private final JWT jwt;

    private final SellerService sellerService;

    @Autowired
    public SellerController(JWT jwt, SellerService sellerService) {
        this.jwt = jwt;
        this.sellerService = sellerService;
    }

    @RequestMapping(value = URL + "QueryMySalesOrder", method = RequestMethod.GET)
    @ApiOperation("查询我的销售订单(注意，时间必传)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "秘钥", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "orderstate", value = "订单状态（1：全部，2：未发货，2：已发货，3：已结束）", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "starttime", value = "起始时间（必传）", required = true, dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "endtime", value = "截止时间", required = true, dataType = "DateTime", paramType = "query"),
            @ApiImplicitParam(name = "starttime", value = "起始时间（必传）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endtime", value = "截止时间", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pagenum", value = "页码", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "页面大小", required = true, dataType = "Integer", paramType = "query")
    })
    public Result queryMySalesOrder(@RequestParam("token") String token, @RequestParam("orderstate") Integer orderState, @RequestParam("starttime") String starttime, @RequestParam("endtime") String endtime, @RequestParam("pagenum") Integer pagenum, @RequestParam("pagesize") Integer pagesize) {
        Token tk = jwt.checkJWT(token);
        if (tk == null) {
            return GetResult.toJson(101, null, null, null, 0);
        }
        pagenum = pagenum < 1 ? 1 : pagenum;
        pagesize = pagesize < 1 ? 10 : pagesize;
        return sellerService.QueryMySalesOrderS(tk.getUserId(), orderState, starttime, endtime, pagenum, pagesize);
    }

    @RequestMapping(value = URL + "QuerySaleOrderDetails", method = RequestMethod.GET)
    @ApiOperation("查询销售订单详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "秘钥", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "orderdetailsid", value = "订单详情ID", required = true, dataType = "String", paramType = "query")
    })
    public Result querySaleOrderDetails(@RequestParam("token") String token, @RequestParam("orderdetailsid") String orderdetailsid) {
        if (orderdetailsid == null || orderdetailsid.isEmpty()) {
            return GetResult.toJson(24, null, null, null, 0);
        }
        Token tk = jwt.checkJWT(token);
        if (tk == null) {
            return GetResult.toJson(101, null, null, null, 0);
        }
        return sellerService.QuerySaleOrderDetails(orderdetailsid);
    }

    @RequestMapping(value = URL + "AgreeUserService", method = RequestMethod.GET)
    @ApiOperation("同意用户申请售后服务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "秘钥", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "afierserviceid", value = "售后服务ID", required = true, dataType = "String", paramType = "query")
    })
    public Result agreeUserService(@RequestParam("token") String token, @RequestParam("afierserviceid") String afierserviceid) {
        Token tk = jwt.checkJWT(token);
        if (tk == null) {
            return GetResult.toJson(101, null, null, null, 0);
        }
        return sellerService.AgreeUserService(tk.getUserId(), afierserviceid);
    }

    @RequestMapping(value = URL + "SendOutGoods_new", method = RequestMethod.GET)
    @ApiOperation("订单发货")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "秘钥", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "orderdetailid", value = "订单详情ID", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "logisticsid", value = "物流ID", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "logisticsnum", value = "物流单号", required = true, dataType = "String", paramType = "query")

    })
    public Result sendOutGoodsNew(@RequestParam("token") String token, @RequestParam("orderdetailid") String orderdetailid, @RequestParam("logisticsid") String logisticsid, @RequestParam("logisticsnum") String logisticsnum) {
        Token tk = jwt.checkJWT(token);
        if (tk == null) {
            return GetResult.toJson(101, null, null, null, 0);
        }
        return sellerService.sendOutGoodsNewS(tk.getUserId(), orderdetailid, logisticsid, logisticsnum);
    }

    @RequestMapping(value = URL + "QueryCustomerService", method = RequestMethod.GET)
    @ApiOperation("查询售后(注意，时间必传)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "秘钥", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "serverstate", value = "售后状态(0:全部,1:待审核，2：待用户发货，3：用户已发货，4：厂家未退换货，5：厂家已退换货,6：完成)", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "starttime", value = "起始时间（必传）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endtime", value = "截止时间（必传）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pagenum", value = "页码", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "页码大小", required = true, dataType = "Integer", paramType = "query")

    })
    public Result queryCustomerService(@RequestParam("token") String token, @RequestParam("serverstate") Integer serverstate, @RequestParam("starttime") String starttime, @RequestParam("endtime") String endtime, @RequestParam("pagenum") Integer pagenum, @RequestParam("pagesize") Integer pagesize) {
        Token tk = jwt.checkJWT(token);
        if (tk == null) {
            return GetResult.toJson(101, null, null, null, 0);
        }
        pagenum = pagenum < 1 ? 1 : pagenum;
        pagesize = pagesize > 1 ? 10 : pagesize;
        return sellerService.queryCustomerServiceS(tk.getUserId(), serverstate, starttime, endtime, pagenum, pagesize);
    }

    @RequestMapping(value = URL + "ConfirmReturnGoods", method = RequestMethod.GET)
    @ApiOperation("确认收到退/换的商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "秘钥", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "afierserviceid", value = "售后ID", required = true, dataType = "Long", paramType = "query"),
    })
    public Result confirmReturnGoods(@RequestParam("token") String token, @RequestParam("afierserviceid") Long afierserviceid) {
        Token tk = jwt.checkJWT(token);
        if (tk == null) {
            return GetResult.toJson(101, null, null, null, 0);
        }
        return sellerService.confirmReturnGoodsS(tk.getUserId(), afierserviceid.toString());
    }

    @RequestMapping(value = URL + "SendOutGoods_service", method = RequestMethod.GET)
    @ApiOperation("售后发货（换货）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "秘钥", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "afierserviceid", value = "售后服务ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "logisticsid", value = "物流ID", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "logisticsnum", value = "物流单号", required = true, dataType = "String", paramType = "query")
    })
    public Result sendOutGoodsService(@RequestParam("token") String token, @RequestParam("afierserviceid") Long afierserviceid, @RequestParam("logisticsid") Integer logisticsid, @RequestParam("logisticsnum") String logisticsnum) {
        Token tk = jwt.checkJWT(token);
        if (tk == null) {
            return GetResult.toJson(101, null, null, null, 0);
        }
        return sellerService.sendOutGoodsServiceS(tk.getUserId(), afierserviceid.toString(), logisticsid, logisticsnum);
    }

    @RequestMapping(value = URL + "Refund", method = RequestMethod.GET)
    @ApiOperation("退款(退款暂时退到账户余额，可能以后原路退回)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "秘钥", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "afierserviceid", value = "售后服务ID", required = true, dataType = "Long", paramType = "query")
    })
    public Result refund(@RequestParam("token") String token, @RequestParam("afierserviceid") Long afierserviceid) {
        Token tk = jwt.checkJWT(token);
        if (tk == null) {
            return GetResult.toJson(101, null, null, null, 0);
        }
        return sellerService.refundS(tk.getUserId(), afierserviceid.toString());
    }

    @RequestMapping(value = URL + "QueryMySaleGoods", method = RequestMethod.GET)
    @ApiOperation("查询我销售的商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "秘钥", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pagenum", value = "页码", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "页面大小", required = true, dataType = "Integer", paramType = "query")
    })
    public Result queryMySaleGoods(@RequestParam("token") String token, @RequestParam("pagenum") Integer pagenum, @RequestParam("pagesize") Integer pagesize) {
        Token tk = jwt.checkJWT(token);
        if (tk == null) {
            return GetResult.toJson(101, null, null, null, 0);
        }
        pagenum = pagenum < 1 ? 1 : pagenum;
        pagesize = pagesize < 1 ? 10 : pagesize;
        return sellerService.queryMySaleGoodsS(tk.getUserId(), pagenum, pagesize);
    }

    @RequestMapping(value = URL + "ModifyPassword", method = RequestMethod.GET)
    @ApiOperation("厂家修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "秘钥", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "oldpassword", value = "旧密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "newpassword", value = "新密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "confirmpassword", value = "确认密码", required = true, dataType = "String", paramType = "query")
    })
    public Result modifyPassword(@RequestParam("token") String token, @RequestParam("oldpassword") String oldpassword, @RequestParam("newpassword") String newpassword, @RequestParam("confirmpassword") String confirmpassword) {
        if (oldpassword.isEmpty() || newpassword.isEmpty() || confirmpassword.isEmpty()) {
            return GetResult.toJson(38, null, null, null, 0);
        }
        if (!newpassword.equals(confirmpassword)) {
            return GetResult.toJson(39, null, null, null, 0);
        }
        if (oldpassword == newpassword) {
            return GetResult.toJson(40, null, null, null, 0);
        }
        Token tk = jwt.checkJWT(token);
        if (tk == null) {
            return GetResult.toJson(101, null, null, null, 0);
        }
        return sellerService.modifyPasswordS(tk.getUserId(), MD5.MD5Encode(oldpassword,null),MD5.MD5Encode(newpassword,null) );
    }

    @RequestMapping(value = URL + "SendRetrieveCode", method = RequestMethod.GET)
    @ApiOperation("发送找回密码验证码（厂家）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "String", paramType = "query"),
    })
    public Result sendRetrieveCode(@RequestParam("phone") Long phone) {
        return sellerService.sendRetrieveCodeS(phone, 4);
    }

    @RequestMapping(value = URL + "ResettingPassword", method = RequestMethod.GET)
    @ApiOperation("设置密码(找回密码)（厂家）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "newpassword", value = "新密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "confirmpassword", value = "确认密码", required = true, dataType = "String", paramType = "query")
    })
    public Result resettingPassword(@RequestParam("phone") Long phone, @RequestParam("code") Integer code, @RequestParam("newpassword") String newpassword, @RequestParam("confirmpassword") String confirmpassword) {
        if (newpassword.isEmpty() || confirmpassword.isEmpty()) {
            return GetResult.toJson(38, null, null, null, 0);
        }
        if (!newpassword.equals(confirmpassword)) {
            return GetResult.toJson(39, null, null, null, 0);
        }
        return sellerService.resettingPassword(MD5.MD5Encode(newpassword,null), code, phone);
    }

    @RequestMapping(value = URL + "SendBackAccountCode", method = RequestMethod.GET)
    @ApiOperation("发送找回用户名验证码（厂家）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "Long", paramType = "query"),
    })
    public Result sendBackAccountCode(@RequestParam("phone") Long phone) {
        return sellerService.sendRetrieveCodeS(phone, 1);
    }

    @RequestMapping(value = URL + "BackAccount", method = RequestMethod.GET)
    @ApiOperation("找回账号（厂家）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, dataType = "Long", paramType = "query"),
    })
    public Result backAccount(@RequestParam("phone") Long phone, @RequestParam("code") Integer code) {
        return sellerService.BackAccountS(phone, code);
    }
}
