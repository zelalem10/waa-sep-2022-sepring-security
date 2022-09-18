package miu.waa.springsecurity.aspect;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Component
public class WaaRequestFilter extends OncePerRequestFilter {
    Logger logger = Logger.getLogger("filter : ");

    List<String> offensiveWordsDictionary  = Arrays.asList("spring", "fat", "short");
    int count = 0;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String word = request.getParameter("word");
        boolean isOffensive = offensiveWordsDictionary.contains(word);
        if(count <= 5){
            if (isOffensive){
                logger.info("The word is offensive");
                count++;
            }
            else {
                logger.info("The word is not offensive");
                filterChain.doFilter(request, response);
            }
        }
        else logger.info("Max Bad Words Requests Limit has been Reached. You need wait for 15 minutes");

    }
}
