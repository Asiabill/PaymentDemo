<%--
  Created by IntelliJ IDEA.
  User: 14112
  Date: 2020/6/30
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=utf-8" %>
<html>
<head>
  <title>payment result</title>
  <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no" />
  <style type="text/css">
    *{
      margin: 0 auto;
      padding: 0;
    }
    header{
      height: 70px;
      background: rgba(255, 255, 255, 0.9);
      border-bottom: 1px solid rgb(238, 238, 238);
    }
    header div{
      display: inline-block;
      width: 135px;
      height: 35px;
      position: relative;
      left: 20%;
      top: 15px;
    }
    header div svg {
      position: relative;
      top: 50%;
      transform: translateY(-50%);
      -moz-transform: translateY(-50%);
      -ms-transform: translateY(-50%);
      -o-transform: translateY(-50%);
    }
    header div svg.blue .cls-2 {
      fill: #1b4ca8;
    }
    .maincontent{
      padding: 20px 40px;
    }
    .modal-title{
      padding: 10px 0 30px 0;
      font-size: 20px;
      color: #333;
      font-weight: 600;
      text-align: center;
    }
    .modal-part{
      padding: 20px;
      box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
      width: 52%;
      box-sizing: border-box;
    }
    li{
      list-style: none;
    }
    .modal-part > div{
      font-size: 16px;
      color: #303133;
      padding-bottom: 15px;
      border-bottom: 1px solid #ebeef5;
      text-align: left;
    }
    td {
      font-size: 14px;
      color: #555;
      padding-top: 12px;
      white-space: nowrap;
    }
  </style>
</head>
<body>
<header>
  <div>
    <svg id="logo" class="blue" data-name="logo" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 453.54 104.63">
      <defs>
        <style>#logo .cls-1{fill:#e7242e;fill-rule:evenodd;}</style>
      </defs>
      <title>Asiabill</title>
      <polygon class="cls-1" points="64.83 25.14 67.83 51.7 88.64 51.7 81.84 4.37 55.13 4.37 0 102.9 22.79 102.9 64.83 25.14"></polygon>
      <path class="cls-2" d="M119.14,103.19c6.92,3.43,25.77,5.87,32.26.74a6.66,6.66,0,0,0-1-11c-3.85-2-9.55-3.91-14.79-6.3-16.1-7.2-16.39-27.77-1.82-36.36,10.86-6.41,29.34-6.92,42.07-2.61l-2,14.2c-6.12-1.76-18.31-3.83-25.34-1.59a6.7,6.7,0,0,0-1.44,12.33A13.27,13.27,0,0,0,150.6,74c14.91,3.62,23.65,9.29,22.6,23-1.51,10.8-8.59,17.18-17.38,20.5-11.54,4.39-27.1,3.91-38.55-.71Z" transform="translate(-16.87 -16)"></path>
      <polygon class="cls-2" points="44.78 62.22 90.17 62.22 96.01 102.9 73.22 102.9 70.7 80.33 34.99 80.33 44.78 62.22"></polygon>
      <polygon class="cls-2" points="347.53 102.9 357.56 32.74 378.06 32.74 367.99 102.9 347.53 102.9"></polygon>
      <polygon class="cls-2" points="358.89 23.22 361.59 4.37 382.05 4.37 379.36 23.22 358.89 23.22"></polygon>
      <path class="cls-2" d="M242.53,84.51c-7.59,0-12.24,5.22-12.56,12.56-.53,12.67,22.37,13.41,25.4-6.72l.88-5.84Zm34.24-8.11-6.06,42.49h-19.5l1.24-8.87h-.25c-5.93,8-13.32,10.6-22.57,10.6-30,0-23.61-47.33,8.45-47.33h19.73c1.13-7.94-3.09-11.51-7-12.56-7.26-1.93-23.7,1-28.88,3l1.92-14.63c13.67-4,36.68-8.27,48.39,6.89,5.13,6.72,5.56,13.38,4.56,20.38Z" transform="translate(-16.87 -16)"></path>
      <path class="cls-2" d="M314.59,36,311.1,60.39h10q7.18,0,11.82-3.46a13.8,13.8,0,0,0,5.5-9.61Q340,36,323.49,36ZM308.86,76.2,305,103.25h12.44c5.33,0,9.64-1.22,13-3.69a14.75,14.75,0,0,0,6-10.23c.59-4.17-.46-7.37-3.06-9.7s-6.72-3.43-12.19-3.43Zm-27.1,42.69,14.06-98.53h35q16.08,0,23.93,6.1t6.32,16.92c-1.25,8.79-10.49,20-19.28,22.42l0,.23c11.17,1.42,18.23,12.36,16.64,23.61A31,31,0,0,1,345.83,111q-10.68,7.91-27.22,7.9Z" transform="translate(-16.87 -16)"></path><polygon class="cls-2" points="382.88 102.9 396.96 4.37 418.05 0 403.37 102.9 382.88 102.9"></polygon><polygon class="cls-2" points="161.41 102.9 171.47 32.74 191.93 32.74 181.87 102.9 161.41 102.9"></polygon>
      <polygon class="cls-2" points="172.77 23.22 175.46 4.37 195.93 4.37 193.24 23.22 172.77 23.22"></polygon>
      <polygon class="cls-2" points="418.34 102.9 432.45 4.37 453.54 0 438.83 102.9 418.34 102.9"></polygon></svg>
  </div>
</header>
<div id="box">
  <div id="footer">
    <ul>
      <li class="footer_line"></li>
    </ul>
  </div>
  <div class="maincontent">
    <div class="modal-title">测试交易结果</div>
    <div class="modal-part">
        <div>返回信息</div>
        <ul>
          <li>
            <table width="100%" border="0">
              <tbody>
              <tr>
                <td width="25%" class="tright">网关接入号：</td>
                <td>${trForm.accountId}</td>
              </tr>
              <tr>
                <td width="280" class="tright">交易金额：</td>
                <td>${trForm.amount}</td>
              </tr>
              <tr>
                <td width="280" class="tright">订单币种：</td>
                <td>${trForm.currency}</td>
              </tr>
              <tr>
                <td width="280" class="tright">流水订单号：</td>
                <td>${trForm.gatewayReference}</td>
              </tr>
              <tr>
                <td width="280" class="tright">商户订单号：</td>
                <td>${trForm.reference}</td>
              </tr>
              <tr>
                <td width="280" class="tright">交易结果：</td>
                <td>${trForm.result }</td>
              </tr>
              <tr>
                <td width="280" class="tright">时间：</td>
                <td>${trForm.timestamp}</td>
              </tr>
              <tr>
                <td width="280" class="tright">签名信息：</td>
                <td>${trForm.signature}</td>
              </tr>
              </tbody>
            </table>
          </li>
        </ul>
      </div>
  </div>
</div>
</body>
</html>
