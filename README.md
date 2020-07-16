# PaymentDemo
Asiabill三方支付接口demo-java版本

###项目简介
  该项目主要功能为模拟商户发送支付请求，得到支付结果并将结果展示，以及查询订单实现勾兑。
  
###环境依赖
  项目中有部分注解需要依赖于**Lombok**插件，所以idea需要在setting里面安装**Lombok**插件，否则部分注解将会报错。jdk需要1.8版本。tomcat版本为8.0。
 
###注意事项
  resources目录下的sysConfig文件中的queryOrderUrl需要联系管理员添加勾兑ip地址。
