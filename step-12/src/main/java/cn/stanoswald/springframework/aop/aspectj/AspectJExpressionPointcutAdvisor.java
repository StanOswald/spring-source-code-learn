package cn.stanoswald.springframework.aop.aspectj;

import cn.stanoswald.springframework.aop.Pointcut;
import cn.stanoswald.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    //切面
    private AspectJExpressionPointcut pointcut;

    //具体拦截方法
    private Advice advice;

    //表达式
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut)
            pointcut = new AspectJExpressionPointcut(expression);
        return pointcut;
    }
}
