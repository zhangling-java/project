import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AOPInvocationHandler<T> implements InvocationHandler {
    private T target;

    public AOPInvocationHandler(){

    }
    public AOPInvocationHandler(T target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //打印方法名称
        System.err.println("执行方法:"+method.getName()+"n参数类型为:");
        //打印参数
        for(Class type:method.getParameterTypes())
            System.err.println(type.getName());
        //打印返回类型
        System.err.println("返回数据类型:"+method.getReturnType().getName());
        //反射调用方法
        Object ret = method.invoke(target,args);
        System.err.println("方法执行结束");
        return ret;
    }
}
