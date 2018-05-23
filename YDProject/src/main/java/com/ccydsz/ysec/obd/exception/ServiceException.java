package com.ccydsz.ysec.obd.exception;

import com.ccydsz.ysec.obd.model.ex.EXServerModel;
//
//见下图:
//
//                      Throwable
//        /                                \
//        Error                       Exception
//        /                   /                     \
//        xxxxxx             xxxxxx          RuntimeException
//        /                                         /
//        xxxxxx                           ArithmeticException
//
//
//
//        上图的所有对象都是类.
//
//        Throwable 代表是可抛出的.
//        Error            代表的是严重错误,  这种错误程序员无法进行处理, 例如操作系统崩溃, jvm出错, 动态链接库失败等.  Error并不是异常, 不是本文的重点.
//
//        Exception    代表的就是异常了.  它下面很多派生类,   其中它的派生类也分两种, 一种是RuntimeException(运行时异常), 其他的都是非运行时异常
//
//        RuntimeException    包括除数为0, 数组下标超界等. 运行时异常的派生类有很多, 其产生频率较高.  它的派生类可以由程序处理或者抛给(throw) 给jvm处理. 例如上面的例子就是抛给了jvm处理, jvm把程序中断执行, 并把错误信息输出到终端上.
//
//        非RuntimeExcption   这种异常属于Excepion的派生类(上面红色的xxx), 但是不是RuntimeException的派生类,  这种异常必须由程序员手动处理,否则不通过编译.
//
//        ArithmeticExcpetion   算术异常, 它是RuntimeException的派生类, 所以程序员不手动处理也通过编译, 只不过出错时会被jvm处理.

public class ServiceException extends Exception{
    public EXServerModel getServerErrorModel() {
        return serverErrorModel;
    }

    public void setServerErrorModel(EXServerModel serverErrorModel) {
        this.serverErrorModel = serverErrorModel;
    }

    private EXServerModel serverErrorModel;
    public ServiceException(){

    }
    public ServiceException(EXServerModel serverErrorModel){
        this.serverErrorModel = serverErrorModel;
    }
}
