package io.github.notsyncing.smsservices.mengwang;

class MessageInfo {
     private String userMessageId;           /*用户自定义的消息编号*/
     private String spNumber;            /*通道,可填完整,可不填,可填*,可只填扩展*/
     private String mobile;              /*手机号*/
     private String base64Message;           /*短信内容,需为base64编码,编码前为GBK*/

     public String getUserMessageId() {
          return userMessageId;
     }

     public void setUserMessageId(String userMessageId) {
          this.userMessageId = userMessageId;
     }

     public String getSpNumber() {
          return spNumber;
     }

     public void setSpNumber(String spNumber) {
          this.spNumber = spNumber;
     }

     public String getMobile() {
          return mobile;
     }

     public void setMobile(String mobile) {
          this.mobile = mobile;
     }

     public String getBase64Message() {
          return base64Message;
     }

     public void setBase64Message(String base64Message) {
          this.base64Message = base64Message;
     }
}