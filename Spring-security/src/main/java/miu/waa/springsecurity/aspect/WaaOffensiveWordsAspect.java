package miu.waa.springsecurity.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
public class WaaOffensiveWordsAspect {
    Logger logger = Logger.getLogger("filter word : ");

    @Pointcut("@annotation(miu.waa.springsecurity.annotation.WaaOffensiveWords)")
    public void allMethods(){}

    @Before("allMethods()")
    public void filterWord(JoinPoint joinPoint){
        logger.info("inside filter word advice" );
    }
}
