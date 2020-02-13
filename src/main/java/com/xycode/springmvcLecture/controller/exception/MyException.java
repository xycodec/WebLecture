package com.xycode.springmvcLecture.controller.exception;

/**
 * ClassName: MyException
 *
 * @Author: xycode
 * @Date: 2020/2/12
 * @Description: this is description of the MyException class
 **/
public class MyException extends Exception {
    private String myMsg;

    public MyException(String myMsg) {
        this.myMsg = myMsg;
    }

    public String getMyMsg() {
        return myMsg;
    }

    public void setMyMsg(String myMsg) {
        this.myMsg = myMsg;
    }
}
