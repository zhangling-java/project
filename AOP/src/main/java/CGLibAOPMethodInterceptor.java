import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibAOPMethodInterceptor<T> implements MethodInterceptor {
    private T target;

    public CGLibAOPMethodInterceptor(){

    }

    public Object createProxyObject(T target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    public CGLibAOPMethodInterceptor(T target){
        this.target = target;
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        UserAction userAction = (UserAction)target;
        //打印方法名称
        System.err.println("执行方法:"+method.getName()+"n参数类型为:");
        //打印参数
        for(Class type:method.getParameterTypes())
            System.err.println(type.getName());
        //打印返回类型
        System.err.println("返回数据类型:"+method.getReturnType().getName());
        //反射调用方法
        Object result = null;
        result = method.invoke(target, args);
        System.err.println("方法执行结束");
        return result;
    }
}
